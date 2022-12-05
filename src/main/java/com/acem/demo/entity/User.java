package com.acem.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@ToString
@Table(name = "USERS")
public class User extends CommonEntity {

    @Embedded
    private Name name;

    @Column(name="EMAIL", length=100, nullable = false, unique = true)
    private String email;

    @Column(name="CONTACT_NO", length=100, nullable = false, unique = true)
    private String contactNo;


    public User(Long id) {
        this.id = id;
    }
}
