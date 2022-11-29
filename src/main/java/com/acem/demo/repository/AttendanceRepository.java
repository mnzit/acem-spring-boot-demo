package com.acem.demo.repository;
import com.acem.demo.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    Optional<Attendance> findByName(String name);
    Optional<Attendance> findByBatchId(String batchId);
    Optional<Attendance> findByCourseId(String courseId);
    Optional<Attendance> findByData(String data);
}
