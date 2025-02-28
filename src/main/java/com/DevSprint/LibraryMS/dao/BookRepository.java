package com.DevSprint.LibraryMS.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.DevSprint.LibraryMS.entities.BookEntitiy;

@Repository
public interface BookRepository extends JpaRepository<BookEntitiy, String>{

    // JPQL Query
    @Query("SELECT SUM(b.availableQty) FROM BookEntity b WHERE b.bookID = :bookID")
    int availableQty(@Param("bookID") String bookId);
}
