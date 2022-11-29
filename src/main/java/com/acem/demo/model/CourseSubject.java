package com.acem.demo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "COURSE_SUBJECTS")
public class CourseSubject implements Serializable {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="COURSE_ID", referencedColumnName = "ID")
    private Course course;

    @ManyToOne
    @JoinColumn(name="SUBJECT_ID", referencedColumnName = "ID")
    private Subject subject;


    public CourseSubject() {
    }

    public CourseSubject(Course course, Subject subject) {
        this.course = course;
        this.subject = subject;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "CourseSubject{" +
                "course=" + course +
                ", subject=" + subject +
                '}';
    }
}
