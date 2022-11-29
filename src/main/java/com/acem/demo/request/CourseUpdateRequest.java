package com.acem.demo.request;


import javax.validation.constraints.NotBlank;

public class CourseUpdateRequest {


    private long id;
    @NotBlank
    private String name;
    @NotBlank
    private String acronym;
    @NotBlank
    private String description;

    public CourseUpdateRequest(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

