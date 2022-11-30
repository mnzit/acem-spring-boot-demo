package com.acem.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "BATCHES")
public class Batch extends CommonEntity {

    @Column(name = "YEAR", length = 4, nullable = false)
    private Long year;

    @ManyToOne
    @JoinColumn(name="COURSE_ID", referencedColumnName = "ID")
    private Course course;
}
