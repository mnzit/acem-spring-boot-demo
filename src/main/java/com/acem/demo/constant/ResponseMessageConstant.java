package com.acem.demo.constant;

public interface ResponseMessageConstant {

    interface Student {
        String ONE = "Student fetched successfully";
        String ALL = "Students fetched successfully";
        String NOT_FOUND = "Students not found";
        String SAVED = "Student saved successfully";
        String UPDATED = "Student updated successfully";
        String NOT_SAVED = "Student not saved";
        String NOT_UPDATED = "Student not updated";
        String NOT_DELETED = "Student not deleted";
        String DELETED = "Student deleted successfully";
    }

    String SERVER_ERROR = "Server Error";
    String INVALID_PATH_PARAMETER = "Not a valid request";
    String INVALID_REQUEST_BODY = "Not a valid request";

    interface Subject {
        String ONE = "Subject fetched successfully";
        String ALL = "Subjects fetched successfully";
        String NOT_FOUND = "Subjects not found";
        String SAVED = "Subject saved successfully";
        String UPDATED = "Subject updated successfully";
        String NOT_SAVED = "Subject not saved";
        String NOT_UPDATED = "Subject not updated";
        String NOT_DELETED = "Subject not deleted";
        String DELETED = "Subject deleted successfully";
    }

}
