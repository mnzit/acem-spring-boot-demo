package com.acem.demo.repository;

import com.acem.demo.entity.Attendance;
import com.acem.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    @Query(
            value = "SELECT DISTINCT STUDENT_ID FROM Attendance",
            nativeQuery = true)
    List<Long> findAllStudentIDs();

    @Query(value= "SELECT * FROM Attendance a WHERE a.STUDENT_ID = ?1", nativeQuery = true)
    List<Attendance> findAttendanceByStudent(Long userId);

    @Query(value= "SELECT STUDENT_ID FROM Attendance a WHERE a.user.email = ?1", nativeQuery = true)
    Long findIdByEmail(String email);

}
