package com.DevSprint.LibraryMS.dao;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.DevSprint.LibraryMS.entities.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, String> {

    // JPQL Query
    @Query("SELECT b.availableQty FROM BookEntity b WHERE b.bookID = :bookID")
    Integer availableQty(@Param("bookID") String bookId);

    // Deduct book count based on lending
    @Modifying
    @Transactional
    @Query("UPDATE BookEntity b SET b.availableQty = b.availableQty - 1 WHERE b.bookId = :bookId AND b.availableQty > 0")
    Integer deductBasedOnLending(@Param("bookId") String bookId);
}
