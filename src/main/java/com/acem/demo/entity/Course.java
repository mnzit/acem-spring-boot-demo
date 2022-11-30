package com.acem.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "COURSE")
public class Course extends CommonEntity {

    @Column(name="NAME", length=100, nullable = false, unique = true)
    private String name;

    @Column(name="ACRONYM", length=10, nullable = false, unique = true)
    private String acronym;

    @Column(name="DESCRIPTION", length=100, nullable = false)
    private String description;

//    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
//    @Fetch(FetchMode.SUBSELECT)
//    private List<CourseSubject> courseSubjects;

    @ManyToMany
    @JoinTable(
        name="COURSE_SUBJECTS",
        joinColumns = @JoinColumn(name="COURSE_ID"),
        inverseJoinColumns = @JoinColumn(name="SUBJECT_ID")
    )
    private List<Subject> subjects;

    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<Batch> batches;

}
