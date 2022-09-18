package com.epam.selectioncommittee.model.service;

import com.epam.selectioncommittee.model.builders.FacultyBuilder;
import com.epam.selectioncommittee.model.builders.FacultyFormBuilder;
import com.epam.selectioncommittee.model.builders.SubjectBuilder;
import com.epam.selectioncommittee.model.dao.FacultyRepository;
import com.epam.selectioncommittee.model.dao.SubjectRepository;
import com.epam.selectioncommittee.model.dto.FacultyForm;
import com.epam.selectioncommittee.model.entity.Faculty;
import com.epam.selectioncommittee.model.entity.Subject;
import com.epam.selectioncommittee.model.exception.FacultyIsReservedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import static org.mockito.Mockito.*;
class FacultyServiceTest {





    private final FacultyRepository facultyRepository = mock(FacultyRepository.class);

    private final SubjectRepository subjectRepository = mock(SubjectRepository.class);

    private final FacultyService facultyService = new FacultyService(facultyRepository,subjectRepository);


    private Faculty FACULTY;

    private Faculty FACULTY_WITH_ID;

    private FacultyForm FACULTY_FORM;
    private FacultyForm FACULTY_FORM_WITH_ID;

    private final Long ID = 1L;

    private final String FACULTY_NAME = "Faculty";

    private final String FACULTY_NAME_RU = "Факультет";

    private Subject SUBJECT;

    private final String SUBJECT_ID = "1";

    private final String SUBJECT_NAME_EN = "English";

    private final String SUBJECT_NAME_RU = "Русский";

    @BeforeEach
    void setUp() {
        SUBJECT = SubjectBuilder.builder()
                .nameRU(SUBJECT_NAME_RU)
                .nameEN(SUBJECT_NAME_EN)
                .build();



        FACULTY = FacultyBuilder.builder()
                .facultyName(FACULTY_NAME)
                .facultyNameRU(FACULTY_NAME_RU)
                .generalPlaces(10)
                .budgetPlaces(5)
                .requiredSubjects(List.of(SUBJECT))
                .recruitment(false)
                .build();

        FACULTY_FORM = FacultyFormBuilder.builder()
                .facultyName(FACULTY_NAME)
                .facultyNameRU(FACULTY_NAME_RU)
                .generalPlaces(10)
                .budgetPlaces(5)
                .requiredSubjects(List.of(SUBJECT_ID))
                .build();

        FACULTY_WITH_ID = FacultyBuilder.builder()
                .id(ID)
                .facultyName(FACULTY_NAME)
                .facultyNameRU(FACULTY_NAME_RU)
                .generalPlaces(10)
                .budgetPlaces(5)
                .requiredSubjects(List.of(SUBJECT))
                .recruitment(false)
                .build();



        FACULTY_FORM_WITH_ID = FacultyFormBuilder.builder()
                .id(2L)
                .facultyName(FACULTY_NAME)
                .facultyNameRU(FACULTY_NAME_RU)
                .generalPlaces(10)
                .budgetPlaces(5)
                .requiredSubjects(List.of(SUBJECT_ID))
                .recruitment(false)
                .build();
    }

    @Test
    void addFaculty() {
        //TODO
    }

    @Test
    void addFacultyThrowsFacultyIsReservedException() {

        when(facultyRepository.existsByName(FACULTY_NAME)).thenReturn(true);
        assertThrows(FacultyIsReservedException.class,()->facultyService.addFaculty(FACULTY_FORM));
    }

    @Test
    void getAllFaculties() {
        when(facultyRepository.findAll()).thenReturn(List.of(FACULTY));
        assertEquals(facultyService.getAllFaculties(),List.of(FACULTY));
    }

    @Test
    void deleteFaculty() {
        when(facultyRepository.findById(ID)).thenReturn(FACULTY_WITH_ID);
        facultyService.deleteFaculty(ID);
        verify(facultyRepository,times(1)).deleteById(ID);
        //TODO
    }

    @Test
    void getFaculty() {
        when(facultyRepository.findById(ID)).thenReturn(FACULTY);
        assertEquals(facultyService.getFaculty(ID), FACULTY);
    }

    @Test
    void updateFaculty() {

        //TODO
    }

    @Test
    void updateFacultyThrowsFacultyIsReservedException() {

        when(facultyRepository.existsByName(FACULTY_NAME)).thenReturn(true);
        when(facultyRepository.findByName(FACULTY_FORM_WITH_ID.getFacultyName())).thenReturn(FACULTY_WITH_ID);
        assertThrows(FacultyIsReservedException.class,()->facultyService.updateFaculty(FACULTY_FORM_WITH_ID));
    }

    @Test
    void closeFacultyById() {
        when(facultyRepository.findById(ID)).thenReturn(FACULTY);
        when(facultyRepository.update(FACULTY)).thenReturn(FACULTY);
        assertEquals(facultyService.closeFacultyById(ID).getRecruitment(),true);
    }

    @Test
    void openFacultyById() {
        when(facultyRepository.findById(ID)).thenReturn(FACULTY);
        when(facultyRepository.update(FACULTY)).thenReturn(FACULTY);
        assertEquals(facultyService.openFacultyById(ID).getRecruitment(),false);
    }
}