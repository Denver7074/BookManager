package com.denver7074.bookManager.repositories;

import com.denver7074.bookManager.model.Authors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRep extends JpaRepository<Authors,Long> {
}
