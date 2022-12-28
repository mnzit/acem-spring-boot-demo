package com.acem.demo.entity;

import com.acem.demo.entity.enums.AttendanceState;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "ATTENDANCE")
public class Attendance extends CommonEntity {

    @ManyToOne
    @JoinColumn(name = "STUDENT_ID", referencedColumnName = "ID")
    private User user;

    @Column(name = "STATE", columnDefinition = "VARCHAR(100) DEFAULT 'ABSENT'")
    @Enumerated(EnumType.STRING)
    private AttendanceState state;

    public Attendance(Long id, AttendanceState state) {
        this.user = new User(id);
        this.state = state;
    }
}

