package com.example.book_tracker.book;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService service;

    @GetMapping
    public List<Book> all() {
        return service.list();
    }

    @PostMapping
    public ResponseEntity<Book> create(@Valid @RequestBody Book book) {
        var saved = service.add(book);

        URI location = URI.create("/api/books/" + saved.getId());
        return ResponseEntity.created(location).body(saved);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }
}
