package com.epam.selectioncommittee.model.service;

import com.epam.selectioncommittee.model.builders.FacultyBuilder;
import com.epam.selectioncommittee.model.builders.StatementBuilder;
import com.epam.selectioncommittee.model.builders.StatementFormBuilder;
import com.epam.selectioncommittee.model.builders.UserBuilder;
import com.epam.selectioncommittee.model.dao.FacultyRepository;
import com.epam.selectioncommittee.model.dao.PositionRepository;
import com.epam.selectioncommittee.model.dao.StatementRepository;
import com.epam.selectioncommittee.model.dao.UserRepository;
import com.epam.selectioncommittee.model.dto.StatementForm;
import com.epam.selectioncommittee.model.entity.Faculty;
import com.epam.selectioncommittee.model.entity.Position;
import com.epam.selectioncommittee.model.entity.Statement;
import com.epam.selectioncommittee.model.entity.User;
import com.epam.selectioncommittee.model.exception.UserAlreadyRegisteredException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class StatementServiceTest {





    StatementRepository statementRepository = mock(StatementRepository.class);

    PositionRepository positionRepository = mock(PositionRepository.class);

    private final UserRepository userRepository = mock(UserRepository.class);

    private final FacultyRepository facultyRepository =mock(FacultyRepository.class);

    StatementService statementService = new StatementService(
            statementRepository,
            positionRepository,
            userRepository,
            facultyRepository);

    private Statement STATEMENT;

    private Statement STATEMENT_TWO;

    private Statement STATEMENT_THREE;


    private List<Statement> STATEMENTS;

    private StatementForm STATEMENT_FORM;

    private final Long ID = 1l;

    private final Long GPA = 199L;

    private User USER;

    private Faculty FACULTY;

    private Position POSITION = new Position(1l,Position.PositionType.REGISTERED);

    private List<String> GRADES;

    @BeforeEach
    void setUp() {
        USER = UserBuilder.builder().id(ID).build();
        FACULTY = FacultyBuilder.builder().id(ID).build();
        GRADES = List.of(new String[]{"199", "199", "199"});

        STATEMENT = StatementBuilder.builder()
                .userId(USER)
                .facultyId(FACULTY)
                .gradePointAverage(GPA)
                .positionId(POSITION)
                .build();

        STATEMENT_TWO = StatementBuilder.builder()
                .userId(USER)
                .facultyId(FACULTY)
                .gradePointAverage(155L)
                .positionId(POSITION)
                .build();

        STATEMENT_THREE = StatementBuilder.builder()
                .userId(USER)
                .facultyId(FACULTY)
                .gradePointAverage(125L)
                .positionId(POSITION)
                .build();


        STATEMENT_FORM = StatementFormBuilder.builder()
                .user("1")
                .faculty("1")
                .grades(GRADES)
                .build();

        STATEMENTS = List.of(STATEMENT,STATEMENT_TWO,STATEMENT_THREE);


    }

    @Test
    void createStatement() throws UserAlreadyRegisteredException {
        when(statementRepository.existsByUserIdAndAndFacultyId(USER.getId(),FACULTY.getId())).thenReturn(false);
        when(positionRepository.findByPositionType(Position.PositionType.REGISTERED)).thenReturn(POSITION);
        when(statementRepository.save(STATEMENT)).thenReturn(STATEMENT);
        when(facultyRepository.findById(ID)).thenReturn(FACULTY);
        when(userRepository.findById(ID)).thenReturn(USER);
        assertEquals(statementService.createStatement(STATEMENT_FORM),STATEMENT);
        verify(statementRepository,times(1)).save(STATEMENT);
    }

    @Test
    void createStatementThrowsUserAlreadyRegisteredException() throws UserAlreadyRegisteredException {
        when(statementRepository.existsByUserIdAndAndFacultyId(USER.getId(), FACULTY.getId())).thenReturn(true);
        assertThrows(UserAlreadyRegisteredException.class,()->statementService.createStatement(STATEMENT_FORM));
    }

    @Test
    void deleteStatement() {
        statementService.deleteStatement(ID);
        verify(statementRepository,times(1)).deleteById(ID);
    }

    @Test
    void findAllStatementsByUserId() {
        when(statementRepository.findAllByUserId(USER)).thenReturn(List.of(STATEMENT));
        assertEquals(statementService.findAllStatementsByUserId(USER),List.of(STATEMENT));
        verify(statementRepository,times(1)).findAllByUserId(USER);
    }

    @Test
    void findAllStatementsByFaculty() {
        when(statementRepository.findAllByFacultyId(FACULTY.getId())).thenReturn(List.of(STATEMENT));
        assertEquals(statementService.findAllStatementsByFaculty(FACULTY.getId()),List.of(STATEMENT));
        verify(statementRepository,times(1)).findAllByFacultyId(FACULTY.getId());
    }
}