package com.acem.demo.service.impl;


import com.acem.demo.builder.ResponseBuilder;
import com.acem.demo.constant.ResponseMessageConstant;
import com.acem.demo.entity.User;
import com.acem.demo.repository.StudentRepository;
import com.acem.demo.response.Response;
import com.acem.demo.service.StudentService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Response getAll() {
        List<User> users = studentRepository.findAll();
        Response responseBody = null;
        if (!users.isEmpty()) {
            responseBody = ResponseBuilder.success(ResponseMessageConstant.Student.ALL, users);
        } else {
            responseBody = ResponseBuilder.notFound(ResponseMessageConstant.Student.NOT_FOUND);
        }
        return responseBody;
    }

    @Override
    public Response getById(Long id) {
        Optional<User> optionalStudent = studentRepository.findById(id);
        Response responseBody = null;
        if (optionalStudent.isPresent()) {
            User user = optionalStudent.get();
            responseBody = ResponseBuilder.success(ResponseMessageConstant.Student.ONE, user);
        } else {
            responseBody = ResponseBuilder.notFound(ResponseMessageConstant.Student.NOT_FOUND);
        }
        return responseBody;
    }

    @Override
    public Response getByEmailAddress(String emailAddress) {
        Optional<User> optionalStudent = studentRepository.findByEmail(emailAddress);
        Response responseBody = null;
        if (optionalStudent.isPresent()) {
            User user = optionalStudent.get();
            responseBody = ResponseBuilder.success(ResponseMessageConstant.Student.ONE, user);

        } else {
            responseBody = ResponseBuilder.notFound(ResponseMessageConstant.Student.NOT_FOUND);
        }
        return responseBody;
    }


    @Override
    public Response save(User user) {
        User savedUser = studentRepository.save(user);
        Response responseBody = null;
        if(user.equals(savedUser)){
            responseBody = ResponseBuilder.success(ResponseMessageConstant.Student.SAVED, user);
        }
        else {
            responseBody = ResponseBuilder.notFound(ResponseMessageConstant.Student.NOT_SAVED);
        }
        return responseBody;
    }

    @Override
    public Response update(User user) {
        Optional<User> optionalStudent = studentRepository.findById(user.getId());
        Response responseBody = null;
        if (optionalStudent.isPresent()) {
            studentRepository.save(user);
            responseBody = ResponseBuilder.success(ResponseMessageConstant.Student.UPDATED, user);
        } else {
            responseBody = ResponseBuilder.notFound(ResponseMessageConstant.Student.NOT_UPDATED);
        }
        return responseBody;
    }

    @Override
    public Response delete(Long id) {
        Optional<User> optionalStudent = studentRepository.findById(id);
        User user = optionalStudent.get();
        Response responseBody = null;
        if(user.getId().equals(id)){
            studentRepository.deleteById(id);
            responseBody = ResponseBuilder.success(ResponseMessageConstant.Student.DELETED, user);
        }else {
            responseBody = ResponseBuilder.notFound(ResponseMessageConstant.Student.NOT_DELETED);
        }
        return responseBody;
    }


}