package com.example.book_tracker.book;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BookService {

    private final BookRepository repo;

    public Book add(Book b) {
        if (b.getTitle() == null || b.getTitle().length() < 3) {
            throw new IllegalArgumentException("Title is too short");
        }
        return repo.save(b);
    }

    @Transactional(readOnly = true)
    public List<Book> list() {
        return repo.findAll(Sort.by("addedOn").descending());
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
}
