package com.acem.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;


@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "BOOK_DETAILS")
public class BookDetail extends CommonEntity {

    @Column(name = "YEAR", length = 4, nullable = false)
    private Long year;

    @JsonIgnore
    @OneToMany(mappedBy = "bookDetail", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<BookCopy> bookCopies;
}
