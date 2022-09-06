package com.epam.selectioncommittee.model.service;

import com.epam.selectioncommittee.model.builders.SubjectBuilder;
import com.epam.selectioncommittee.model.dao.SubjectRepository;
import com.epam.selectioncommittee.model.dto.SubjectForm;
import com.epam.selectioncommittee.model.entity.Subject;
import com.epam.selectioncommittee.model.exception.SubjectIsReservedException;

import java.awt.print.Pageable;
import java.util.List;

public class SubjectService {
    private  final SubjectRepository subjectRepository;


    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public Subject createSubject(SubjectForm subjectForm) throws SubjectIsReservedException {

        checkSubjectNameEN(subjectForm.getNameEN());

     //   log.info("Subject '{}' was created", subjectForm.getNameEN());

        return subjectRepository.save(SubjectBuilder.builder()
                .nameEN(subjectForm.getNameEN())
                .nameRU(subjectForm.getNameRU())
                .build());
    }
//    public Page<Subject> getAllSubjectsPage(Pageable pageable) {
//        return subjectRepository.findAll(pageable);
//    }
    public List<Subject> getAllSubjects() {

        return subjectRepository.findAll();
    }

    private void checkSubjectNameEN(String nameEN) throws SubjectIsReservedException {
        if (subjectRepository.existsByNameEN(nameEN)) {

        //    log.warn("Subject '{}' is reserved",nameEN);

            throw new SubjectIsReservedException();
        }
    }
    public void deleteSubject(Long id) {

      //  log.info("Subject '{}' is deleted",subjectRepository.findById(id).get().getNameEN());

        subjectRepository.deleteById(id);
    }
}
