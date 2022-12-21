package com.acem.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/*
    ROLE - STUDENT, ADMIN, TEACHER, ACCOUNTANT, SYSTEM

    AUTHORITY
       ADMIN -> USER = CREATE, UPDATE, DELETE, VIEW
             -> COURSE = CREATE, UPDATE, DELETE, VIEW
             -> SUBJECT = CREATE, UPDATE, DELETE, VIEW

       TEACHER -> ATTENDANCE = CREATE, UPDATE, DELETE, VIEW

*/
@Getter
@Setter
@Entity
@Table(name = "ROLES")
@NoArgsConstructor
@AllArgsConstructor
public class Role extends CommonEntity {

    @Column(length = 150, name = "NAME", nullable = false)
    private String name;


    @ManyToMany
    @JoinTable(
            name="ROLE_AUTHORITIES",
            joinColumns = @JoinColumn(name="ROLE_ID"),
            inverseJoinColumns = @JoinColumn(name="AUTHORITY_ID")
    )
    private List<Authority> authorities;

    public Role(Long id) {
        this.id = id;
    }
}
