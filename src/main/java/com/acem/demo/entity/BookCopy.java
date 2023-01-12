package com.acem.demo.entity;

import com.acem.demo.entity.enums.BookState;
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
@Table(name = "BOOK_COPIES")
public class BookCopy extends CommonEntity {

    @ManyToOne
    @JoinColumn(name = "BOOK_DETAIL_ID")
    private BookDetail bookDetail;

    @Column(name = "STATE", columnDefinition = "VARCHAR(100) DEFAULT 'NEW'")
    @Enumerated(EnumType.STRING)
    private BookState state;

//    @JsonIgnore
//    @OneToMany(mappedBy = "bookCopy", fetch = FetchType.EAGER)
//    @Fetch(FetchMode.SUBSELECT)
//    private List<BookCopyHistory> bookCopyHistories;
}
