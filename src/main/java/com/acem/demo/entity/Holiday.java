package com.acem.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@Table(name = "HOLIDAYS")
public class Holiday implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DATE")
    private Date date;
}

