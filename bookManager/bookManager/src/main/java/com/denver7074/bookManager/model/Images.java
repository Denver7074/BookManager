package com.denver7074.bookManager.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @NonNull
    String name;
    @NonNull
    String type;
    @NonNull
    Long size;
    @NonNull
    @Lob
    byte[] bytes;
    @NonNull
    @OneToOne(cascade = CascadeType.REFRESH,fetch = FetchType.LAZY)
    Books book;

}
