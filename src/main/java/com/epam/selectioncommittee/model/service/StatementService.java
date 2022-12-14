package com.epam.selectioncommittee.model.service;

import com.epam.selectioncommittee.controller.util.AverageGrade;
import com.epam.selectioncommittee.model.builders.StatementBuilder;
import com.epam.selectioncommittee.model.dao.FacultyRepository;
import com.epam.selectioncommittee.model.dao.PositionRepository;
import com.epam.selectioncommittee.model.dao.StatementRepository;
import com.epam.selectioncommittee.model.dao.UserRepository;
import com.epam.selectioncommittee.model.dto.StatementForm;
import com.epam.selectioncommittee.model.entity.*;
import com.epam.selectioncommittee.model.exception.UserAlreadyRegisteredException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StatementService {

    private static final Logger log = LogManager.getLogger(StatementService.class);
    private final StatementRepository statementRepository;
    private final PositionRepository positionRepository;

    private final UserRepository userRepository;

    private final FacultyRepository facultyRepository;


    public StatementService(StatementRepository statementRepository, PositionRepository positionRepository,
                            UserRepository userRepository, FacultyRepository facultyRepository) {
        this.statementRepository = statementRepository;
        this.positionRepository = positionRepository;
        this.userRepository = userRepository;
        this.facultyRepository = facultyRepository;
    }

    public Statement createStatement(StatementForm statementForm) throws UserAlreadyRegisteredException {
        Long userId = Long.valueOf(statementForm.getUserId());
        Long facultyId = Long.valueOf(statementForm.getFacultyId());

        log.info("temp ms {}",statementForm.toString());

        checkIfRegistered(userId,facultyId);

        log.info("User '{}'  created statement", statementForm.getUserId());

        return statementRepository.save(StatementBuilder.builder()
                .userId(userRepository.findById(userId))
                .facultyId(facultyRepository.findById(facultyId))
                .positionId(positionRepository.findByPositionType(Position.PositionType.REGISTERED))
                .gradePointAverage(AverageGrade.counter(statementForm.getGrades()))
                .build());
    }

    public void deleteStatement (Long id){
        statementRepository.deleteById(id);
    }


    public List<Statement> findAllStatementsByUserId(User user) {

        return statementRepository.findAllByUserId(user);
    }

    public List<Statement> findAllStatementsByFaculty(Long facultyId) {

        return statementRepository.findAllByFacultyId(facultyId);
    }

    public List<Statement> findAllStatementsByFacultyPages(Long facultyId,Integer pageNumber) {
        Integer limit = 3;
        Integer offset = limit*(pageNumber -1);

        return statementRepository.findAllByFacultyIdPages(facultyId,limit,offset);
    }

//    public Page<Statement> findAllStatementsByFaculty(Faculty faculty, Pageable pageable) {
//                     //TODO
//        return statementRepository.findAllByFacultyId(faculty, pageable);
//    }

    public void finalizeStatements(Faculty faculty) {
        //?????????????? ?????? ?????????????????? ???? ??????????????????
        List<Statement> statements = findAllStatementsByFaculty(faculty.getId());
        // ?????????????????????????? ???????? ?????????????? REJECTED
        statements.stream()
                .forEach(statement -> statement.setPosition(
                        positionRepository.findByPositionType(Position.PositionType.REJECTED)));
        //?????????????????? ???? ???????????????? ?? ?????????????????????????? ?????????????? CONTRACT , ???????????????? ???????????????????? ???????? ???? ????????????????????
        sorter(statements).stream()
                .limit(faculty.getGeneralPlaces())
                .forEach(statement -> statement.setPosition(
                        positionRepository.findByPositionType(Position.PositionType.CONTRACT)));
        //?????????????????? ???? ???????????????? ?? ?????????????????????????? ?????????????? BUDGET , ???????????????? ???????????????????? ???????? ???? ????????????????????
        sorter(statements).stream()
                .limit(faculty.getBudgetPlaces())
                .forEach(statement -> statement.setPosition(
                        positionRepository.findByPositionType(Position.PositionType.BUDGET)));

        log.info("faculty '{}'  finalized results", faculty.getFacultyName());
        //???????? ?????????????????? ???????????? ?????????????????????? ?????????????????? ?? ?????????????? ????
        for (Statement statement : statements) {
            if (isOnFaculty(statement)) {

                log.info("all other statements of '{}' on '{}' will be delete"

                        , statement.getUserId().getUsername()
                        , statement.getFacultyId().getFacultyName());
                deleteOtherStatements(statement);
            }
        }
        statementRepository.updateAll(statements);
    }

    private void checkIfRegistered(Long userId , Long facultyId) throws UserAlreadyRegisteredException {

        if (statementRepository.existsByUserIdAndAndFacultyId(userId, facultyId)) {

            throw new UserAlreadyRegisteredException();
        }

    }

    public boolean isRegistered(Long userId , Long facultyId)  {

        return  statementRepository.existsByUserIdAndAndFacultyId(userId, facultyId) ;

    }

    public int getPages(Long id) {

        return (int) Math.ceil(statementRepository.getAllStatementsSize(id)  / (double) 3);
    }

    private boolean isOnFaculty(Statement statement) {
        return statement.getPosition().getPositionType().equals(Position.PositionType.BUDGET) ||
                statement.getPosition().getPositionType().equals(Position.PositionType.CONTRACT);
    }

    private void deleteOtherStatements(Statement statement) {

        statementRepository.deleteAll(statementRepository
                .findAllByUserId(statement.getUserId()).stream()
                .filter(i -> i.getFacultyId().getId() != statement.getFacultyId().getId())
                .collect(Collectors.toList()));

    }

    private List<Statement> sorter(List<Statement> list) {

        return list.stream()
                .sorted(Comparator.comparing(Statement::getGradePointAverage).reversed())
                .collect(Collectors.toList());

    }

    private List<Long> gradesAdapter(List<String> strings){
        List<Long> list = new ArrayList<>();
        for (String string: strings) {
            list.add(Long.valueOf(string));

        }
        return list;
    }
}
