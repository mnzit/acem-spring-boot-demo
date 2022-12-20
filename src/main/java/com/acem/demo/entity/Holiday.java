package com.acem.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "HOLIDAYS")
public class Holiday extends CommonEntity {

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DATE")
    private Date date;
}

