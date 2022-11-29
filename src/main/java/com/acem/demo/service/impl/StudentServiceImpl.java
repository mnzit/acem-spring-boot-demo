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
    Response responseBody = null;
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    
    @Override
    public Response getAll() {
        List<Student> students = studentRepository.findAll();

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
        if(student.getId().equals(id)){
            studentRepository.deleteById(id);
            responseBody = ResponseBuilder.success(ResponseMessageConstant.Student.DELETED, student);
        }else {
            responseBody = ResponseBuilder.notFound(ResponseMessageConstant.Student.NOT_DELETED);
        }
        return responseBody;
    }


}