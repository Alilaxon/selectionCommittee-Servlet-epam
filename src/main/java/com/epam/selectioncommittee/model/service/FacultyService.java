package com.epam.selectioncommittee.model.service;

import com.epam.selectioncommittee.model.builders.FacultyBuilder;
import com.epam.selectioncommittee.model.dao.FacultyRepository;
import com.epam.selectioncommittee.model.dao.SubjectRepository;
import com.epam.selectioncommittee.model.dto.FacultyForm;
import com.epam.selectioncommittee.model.entity.Faculty;
import com.epam.selectioncommittee.model.entity.Subject;
import com.epam.selectioncommittee.model.exception.FacultyIsReservedException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class FacultyService {

    private static final Logger log = LogManager.getLogger(FacultyService.class);
    private  final FacultyRepository facultyRepository;

   private final SubjectRepository subjectRepository;

    public FacultyService(FacultyRepository facultyRepository,
                          SubjectRepository subjectRepository) {
        this.facultyRepository = facultyRepository;
        this.subjectRepository = subjectRepository;
    }

    public Faculty addFaculty(FacultyForm facultyForm) throws FacultyIsReservedException {

        checkFacultyName(facultyForm.getFacultyName());

        for (String s:
             facultyForm.getRequiredSubjects()) {

            System.out.println(s);

        }

        log.info("Faculty '{}' was created", facultyForm.getFacultyName());

        return facultyRepository.save(FacultyBuilder.builder()
                .facultyName(facultyForm.getFacultyName())
                .facultyNameRU(facultyForm.getFacultyNameRU())
                .budgetPlaces(facultyForm.getGeneralPlaces())
                .generalPlaces(facultyForm.getGeneralPlaces())
                .requiredSubjects(findSubjectsById(facultyForm.getRequiredSubjects()))
                .recruitment(false)
                .build());
    }


    private void checkFacultyName(String name) throws FacultyIsReservedException {

        if (facultyRepository.existsByName(name)) {

            log.warn("Faculty '{}' is reserved", name);

            throw new FacultyIsReservedException();
        }
    }

    public List<Faculty> getAllFaculties() {

        return facultyRepository.findAll();
    }

    public void deleteFaculty(Long id) {

        log.warn("Faculty = '{}' was deleted", facultyRepository.findById(id).getFacultyName());

        facultyRepository.deleteById(id);
    }

    public Faculty getFaculty(Long id) {

        return facultyRepository.findById(id);

    }

    public Faculty updateFaculty(FacultyForm facultyForm) throws FacultyIsReservedException {

        if (checkFacultyRename(facultyForm)) {

            throw new FacultyIsReservedException();
        }

        log.info("Faculty '{}' was updated", facultyForm.getFacultyName());

        return facultyRepository.save(FacultyBuilder.builder()
                .id(facultyForm.getId())
                .facultyName(facultyForm.getFacultyName())
                .facultyNameRU(facultyForm.getFacultyNameRU())
                .budgetPlaces(facultyForm.getBudgetPlaces())
                .generalPlaces(facultyForm.getGeneralPlaces())
                .requiredSubjects(findSubjectsById(facultyForm.getRequiredSubjects()))
                .recruitment(facultyForm.getRecruitment())
                .build());
    }

    public Faculty closeFacultyById(Long id) {

        Faculty faculty = facultyRepository.findById(id);
        faculty.setRecruitment(true);

        log.info("Faculty '{}'  closed recruitment", faculty.getFacultyName());

        return facultyRepository.save(faculty);
    }

    public Faculty openFacultyById(Long id) {

        Faculty faculty = facultyRepository.findById(id);
        faculty.setRecruitment(false);

        log.info("Faculty '{}'  opened recruitment", faculty.getFacultyName());

        return facultyRepository.save(faculty);
    }

    private boolean checkFacultyRename(FacultyForm facultyForm) {
        return facultyRepository.existsByName(facultyForm.getFacultyName()) &&
                !facultyRepository.findByName(facultyForm.getFacultyName()).getId().equals(facultyForm.getId());
    }


    private List<Subject> findSubjectsById(List<String> ids){

        List<Subject> subjects = new ArrayList<>();
        for (String id: ids) {

           subjects.add(subjectRepository.findById(Long.parseLong(id)));
        }

        return subjects;
    }



}
