package com.acem.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "STUDENT_BATCH")
public class StudentBatch extends CommonEntity {

    @ManyToOne
    @JoinColumn(name="STUDENT_ID", referencedColumnName = "ID")
    private User user;

    @ManyToOne
    @JoinColumn(name="BATCH_ID", referencedColumnName = "ID")
    private Batch batch;

}
