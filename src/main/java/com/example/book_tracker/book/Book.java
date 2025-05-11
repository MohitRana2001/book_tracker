package com.example.book_tracker.book;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "books")
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String author;
    private String title;

    @Enumerated(EnumType.STRING)
    private Status status = Status.TO_READ;

    private LocalDate addedOn = LocalDate.now();

    public enum Status {
        READ, READING, TO_READ
    }
}