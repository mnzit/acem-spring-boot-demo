package com.acem.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "COURSE")
public class Course {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="NAME", length=100, nullable = false, unique = true)
    private String name;
    @Column(name="DESCRIPTION", length=100, nullable = false, unique = true)
    private String description;

    public Course() {
    }

    public Course(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "Course {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }


}
