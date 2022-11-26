package com.acem.demo.service.impl;


import com.acem.demo.builder.ResponseBuilder;
import com.acem.demo.constant.ResponseMessageConstant;
import com.acem.demo.model.Student;
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
        List<Student> students = studentRepository.findAll();
        Response responseBody = null;
        if (!students.isEmpty()) {
            responseBody = ResponseBuilder.success(ResponseMessageConstant.Student.ALL, students);
        } else {
            responseBody = ResponseBuilder.notFound(ResponseMessageConstant.Student.NOT_FOUND);
        }
        return responseBody;
    }

    @Override
    public Response getById(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        Response responseBody = null;
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            responseBody = ResponseBuilder.success(ResponseMessageConstant.Student.ONE, student);
        } else {
            responseBody = ResponseBuilder.notFound(ResponseMessageConstant.Student.NOT_FOUND);
        }
        return responseBody;
    }

    @Override
    public Response getByEmailAddress(String emailAddress) {
        Optional<Student> optionalStudent = studentRepository.findByEmail(emailAddress);
        Response responseBody = null;
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            responseBody = ResponseBuilder.success(ResponseMessageConstant.Student.ONE, student);

        } else {
            responseBody = ResponseBuilder.notFound(ResponseMessageConstant.Student.NOT_FOUND);
        }
        return responseBody;
    }


    @Override
    public Response save(Student student) {
        Student savedStudent = studentRepository.save(student);
        Response responseBody = null;
        if(student.equals(savedStudent)){
            responseBody = ResponseBuilder.success(ResponseMessageConstant.Student.SAVED, student);
        }
        else {
            responseBody = ResponseBuilder.notFound(ResponseMessageConstant.Student.NOT_SAVED);
        }
        return responseBody;
    }

    @Override
    public Response update(Student student) {
        Optional<Student> optionalStudent = studentRepository.findById(student.getId());
        Response responseBody = null;
        if (optionalStudent.isPresent()) {
            studentRepository.save(student);
            responseBody = ResponseBuilder.success(ResponseMessageConstant.Student.UPDATED, student);
        } else {
            responseBody = ResponseBuilder.notFound(ResponseMessageConstant.Student.NOT_UPDATED);
        }
        return responseBody;
    }

    @Override
    public Response delete(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        Student student = optionalStudent.get();
        Response responseBody = null;
        if(student.getId().equals(id)){
            studentRepository.deleteById(id);
            responseBody = ResponseBuilder.success(ResponseMessageConstant.Student.DELETED, student);
        }else {
            responseBody = ResponseBuilder.notFound(ResponseMessageConstant.Student.NOT_DELETED);
        }
        return responseBody;
    }


}