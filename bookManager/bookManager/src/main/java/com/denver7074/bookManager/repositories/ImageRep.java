package com.denver7074.bookManager.repositories;

import com.denver7074.bookManager.model.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRep extends JpaRepository<Images,Long> {

}
