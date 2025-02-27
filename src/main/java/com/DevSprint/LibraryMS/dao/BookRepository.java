package com.DevSprint.LibraryMS.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DevSprint.LibraryMS.entities.BookEntitiy;

@Repository
public interface BookRepository extends JpaRepository<BookEntitiy, String>{
}
