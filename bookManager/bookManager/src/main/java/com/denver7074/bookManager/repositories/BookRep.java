package com.denver7074.bookManager.repositories;

import com.denver7074.bookManager.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRep extends JpaRepository<Books,Long> {

    List<Books> findBooksByTitleBookContainingIgnoreCase(String title);

}
