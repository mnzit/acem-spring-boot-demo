package com.acem.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Entity
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
@Table(name = "HOLIDAYS")
public class Holiday extends CommonEntity {

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DATE")
    private Date date;
}

