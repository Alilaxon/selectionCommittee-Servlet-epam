package com.epam.selectioncommittee.model.service;

import com.epam.selectioncommittee.model.builders.SubjectBuilder;
import com.epam.selectioncommittee.model.builders.SubjectFormBuilder;
import com.epam.selectioncommittee.model.dao.SubjectRepository;
import com.epam.selectioncommittee.model.dto.SubjectForm;
import com.epam.selectioncommittee.model.entity.Subject;
import com.epam.selectioncommittee.model.exception.SubjectIsReservedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;


class SubjectServiceTest {


    SubjectRepository subjectRepository = mock(SubjectRepository.class);

    SubjectService subjectService = new SubjectService(subjectRepository);

    private Subject SUBJECT;

    private SubjectForm SUBJECT_FORM;

    private final Long ID = 1L;

    private String NAME_EN = "English";

    private String NAME_RU = "Русский";

    @BeforeEach
    void setUp() {
        SUBJECT = SubjectBuilder.builder()
                .nameEN(NAME_EN)
                .nameRU(NAME_RU)
                .build();

        SUBJECT_FORM = SubjectFormBuilder.builder()
                .nameEN(NAME_EN)
                .nameRU(NAME_RU)
                .build();



    }

    @Test
    void createSubject() throws SubjectIsReservedException {
        when(subjectRepository.existsByNameEN(NAME_EN)).thenReturn(false);
        when(subjectRepository.save(SUBJECT)).thenReturn(SUBJECT);
        assertEquals(subjectService.createSubject(SUBJECT_FORM),SUBJECT);
        verify(subjectRepository,times(1)).save(SUBJECT);
    }

    @Test
    void createSubjectThrowsSubjectIsReservedException() {
        when(subjectRepository.existsByNameEN(NAME_EN)).thenReturn(true);
        when(subjectRepository.save(SUBJECT)).thenReturn(SUBJECT);
        assertThrows(SubjectIsReservedException.class,()->subjectService.createSubject(SUBJECT_FORM));

    }

    @Test
    void getAllSubjects() {
        when(subjectRepository.findAll()).thenReturn(List.of(SUBJECT));
        assertEquals(subjectService.getAllSubjects(),List.of(SUBJECT));
        verify(subjectRepository,times(1)).findAll();
    }

    @Test
    void deleteSubject() {
        subjectService.deleteSubject(ID);
        verify(subjectRepository,times(1)).deleteById(ID);

        //TODO
    }
}