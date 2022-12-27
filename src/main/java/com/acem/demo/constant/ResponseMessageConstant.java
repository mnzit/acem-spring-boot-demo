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

    interface Course {
        String ONE = "Course fetched successfully";
        String ALL = "Courses fetched successfully";
        String NOT_FOUND = "Courses not found";
        String SAVED = "Course saved successfully";
        String UPDATED = "Course updated successfully";
        String NOT_UPDATED = "Course not updated";
        String NOT_SAVED = "Course not saved";

        String NOT_DELETED = "Course not deleted";

        String DELETED = "Course deleted successfully";
    }


    interface Attendance {
        String ONE = "ONE record fetched successfully";
        String ALL = "ALL record fetched successfully";
        String NOT_FOUND = "Record not found";
        String SAVED = "Record saved successfully";
        String UPDATED = "Record updated successfully";
        String NOT_SAVED = "Record not saved";
        String NOT_UPDATED = "Record not updated";
        String NOT_DELETED = "Record not deleted";
        String DELETED = "Record deleted successfully";
    }

    String SERVER_ERROR = "Server Error";
    String UNAUTHORIZED = "Unauthorized";

    String UNAUTHORIZED_ACCESS = "Unauthorized! You do not have permission to access this.";

    String SESSION_EXPIRED = "Session expired! Please login again.";

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
