package com.denver7074.bookManager.model;

import com.denver7074.bookManager.model.constant.Genre;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.RequestMapping;


import java.awt.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@RequiredArgsConstructor
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @NonNull
    String titleBook;
    @NonNull
    String author;
    @NonNull
    double price;
    @NonNull
    LocalDate yearWrite;
    @NonNull
    Genre genre;
    @NonNull
    String isbn;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "book")
    Images coverBook;
    public void addImage(Images image){
        image.setBook(this);
        this.coverBook = image;
    }
}
