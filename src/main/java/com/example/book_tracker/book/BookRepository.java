package com.example.book_tracker.book;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByAuthor(String author);

    @Query("SELECT b FROM Book b WHERE b.status = :s")
    List<Book> findAllByStatus(@Param("s") Book.Status s);
}
