package com.acem.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
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
    protected Long id;

    @CreationTimestamp
    @Column(name = "CREATED_DATE")
    protected Date createdDate;

    @UpdateTimestamp
    @Column(name = "MODIFIED_DATE")
    protected Date modifiedDate;

    @CreatedBy
    @JoinColumn(name = "CREATED_BY", referencedColumnName = "ID", updatable = false)
    @ManyToOne
    protected User createdBy;

    @LastModifiedBy
    @ManyToOne
    @JoinColumn(name = "MODIFIED_BY", referencedColumnName = "ID")
    protected User modifiedBy;

    @Column(name = "STATUS", nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
    protected Boolean status; // 0, 1


    // ROLE - STUDENT, ADMIN, TEACHER, ACCOUNTANT, SYSTEM
    /*
    AUTHORITY
        ADMIN -> USER = CREATE, UPDATE, DELETE, VIEW
              -> COURSE = CREATE, UPDATE, DELETE, VIEW
              -> SUBJECT = CREATE, UPDATE, DELETE, VIEW
      TEACHER -> ATTENDANCE = CREATE, UPDATE, DELETE, VIEW

     */
}