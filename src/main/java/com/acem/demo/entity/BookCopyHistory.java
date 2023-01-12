package com.acem.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;


/**
 * SELECT * FROM BOOK_COPY_HISTORIES WHERE USER_ID=1 AND BOOK_COPY=1 AND RETURNED_DATE IS NULL
 *
 1, 1, 1, 2022-01-09, 2022-01-12
 1, 1, 1, 2022-01-09, 2022-01-14
 1, 1, 1, 2022-01-09, 2022-01-15
 1, 1, 1, 2022-01-09, null
 */

/**
 * // ISSUE/RETURN
 * {
 *   "userId": 1,
 *   "type": "ISSUE" // RETURN
 *   "books":[
 *     1,2,3
 *   ]
 * }
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "BOOK_COPY_HISTORIES")
public class BookCopyHistory extends CommonEntity {

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "BOOK_COPY_ID", referencedColumnName = "ID")
    private BookCopy bookCopy;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private User user;

    @JoinColumn(name = "ISSUED_DATE", nullable = false)
    private Date issuedDate;

    @JoinColumn(name = "RETURNED_DATE")
    private Date returnedDate;

}

