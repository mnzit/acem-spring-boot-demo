package com.acem.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class CommonEntity implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CREATED_DATE", updatable = false)
    private Date createdDate;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="MODIFIED_DATE")
    private Date modifiedDate;

    @CreatedBy
    @JoinColumn(name="CREATED_BY", referencedColumnName = "ID", updatable = false)
    @ManyToOne
    private User createdBy;

    @LastModifiedBy
    @ManyToOne
    @JoinColumn(name="MODIFIED_BY", referencedColumnName = "ID")
    private User modifiedBy;


    // ROLE - STUDENT, ADMIN, TEACHER, ACCOUNTANT, SYSTEM
    /*
    AUTHORITY
        ADMIN -> USER = CREATE, UPDATE, DELETE, VIEW
              -> COURSE = CREATE, UPDATE, DELETE, VIEW
              -> SUBJECT = CREATE, UPDATE, DELETE, VIEW
      TEACHER -> ATTENDANCE = CREATE, UPDATE, DELETE, VIEW

     */
}
