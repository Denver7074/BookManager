package com.denver7074.bookManager.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @NonNull
    String firstName;
    @NonNull
    String userName;
    @NonNull
    LocalDate birth;
    @NonNull
    int age;
    @NonNull
    String email;
    @NonNull
    String numberPhone;

}

