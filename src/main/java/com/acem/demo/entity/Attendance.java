package com.acem.demo.entity;

import com.acem.demo.entity.enums.AttendanceStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;


@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "ATTENDANCE")
public class Attendance extends CommonEntity {

    @ManyToOne
    @JoinColumn(name = "STUDENT_ID", referencedColumnName = "ID")
    private User user;

    @Column(name = "STATUS", columnDefinition = "VARCHAR(100) DEFAULT 'ABSENT'")
    @Enumerated(EnumType.STRING)
    private AttendanceStatus status;

    public Attendance(Long id, AttendanceStatus status) {
        this.user = new User(id);
        this.status = status;
    }
}

