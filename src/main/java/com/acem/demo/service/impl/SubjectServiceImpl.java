package com.acem.demo.service.impl;

import com.acem.demo.builder.ResponseBuilder;
import com.acem.demo.constant.ResponseMessageConstant;
import com.acem.demo.model.Subject;
import com.acem.demo.repository.SubjectRepository;
import com.acem.demo.response.Response;
import com.acem.demo.service.SubjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Response getAll() {
        List<Subject> subjects = subjectRepository.findAll();
        Response responseBody = null;
        if (!subjects.isEmpty()) {
            responseBody = ResponseBuilder.success(ResponseMessageConstant.Subject.ALL, subjects);
        } else {
            responseBody = ResponseBuilder.notFound(ResponseMessageConstant.Subject.NOT_FOUND);
        }
        return responseBody;
    }

    @Override
    public Response getById(Long id) {
        Optional<Subject> optionalSubject = subjectRepository.findById(id);
        Response responseBody = null;
        if (optionalSubject.isPresent()) {
            Subject subject = optionalSubject.get();
            responseBody = ResponseBuilder.success(ResponseMessageConstant.Subject.ONE, subject);
        } else {
            responseBody = ResponseBuilder.notFound(ResponseMessageConstant.Subject.NOT_FOUND);
        }
        return responseBody;
    }

    @Override
    public Response save(Subject subject) {
        Subject savedSubject = subjectRepository.save(subject);
        Response responseBody = null;
        if(subject.equals(savedSubject)){
            responseBody = ResponseBuilder.success(ResponseMessageConstant.Student.SAVED, subject);
        }
        else {
            responseBody = ResponseBuilder.notFound(ResponseMessageConstant.Student.NOT_SAVED);
        }
        return responseBody;
    }


    @Override
    public Response update(Subject subject) {
        Optional<Subject> optionalSubject = subjectRepository.findById(subject.getId());
        Response responseBody = null;
        if (optionalSubject.isPresent()) {
            subjectRepository.save(subject);
            responseBody = ResponseBuilder.success(ResponseMessageConstant.Subject.UPDATED, subject);
        } else {
            responseBody = ResponseBuilder.notFound(ResponseMessageConstant.Subject.NOT_UPDATED);
        }
        return responseBody;
    }

    @Override
    public Response delete(Long id) {
        Optional<Subject> optionalSubject = subjectRepository.findById(id);
        Subject subject = optionalSubject.get();
        Response responseBody = null;
        if(subject.getId().equals(id)){
            subjectRepository.deleteById(id);
            responseBody = ResponseBuilder.success(ResponseMessageConstant.Subject.DELETED, subject);
        }else {
            responseBody = ResponseBuilder.notFound(ResponseMessageConstant.Subject.NOT_DELETED);
        }
        return responseBody;
    }
}
