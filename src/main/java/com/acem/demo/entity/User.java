package com.acem.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

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

}
