package com.acem.demo.service;
import com.acem.demo.model.Attendance;
import com.acem.demo.response.Response;

public interface AttendanceService {

    Response getAll();

    Response getById(Long id);

    Response getByName(String name);

    Response getByBatchId(String batchId);        // it would generate the list so need review here as these are not unique

    Response getByCourseId(String CourseId);    // it would generate the list so need review here as these are not unique

    Response getByData(String Data);            // it would generate the list so need review here as these are not unique

    Response save(Attendance student);

    Response update(Attendance student);

    Response delete(Long id);

}
