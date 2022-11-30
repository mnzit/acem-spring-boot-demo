//package com.acem.demo.entity;
//
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.Entity;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@Entity
//@Table(name = "COURSE_SUBJECTS")
//public class CourseSubject extends CommonEntity {
//
//    @ManyToOne
//    @JoinColumn(name="COURSE_ID", referencedColumnName = "ID")
//    private Course course;
//
//    @ManyToOne
//    @JoinColumn(name="SUBJECT_ID", referencedColumnName = "ID")
//    private Subject subject;
//
//
//}
