package com.jsuszynski.library.books;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookRepository {


    private List<Book> books = new ArrayList<>();
    private static BookRepository instance;


    private BookRepository() {
    }

    public static BookRepository getInstance() {
        if (instance == null) {
            synchronized (BookRepository.class) {
                if (instance == null) {
                    instance = new BookRepository();
                }
            }
        }
        return instance;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Book findByIsbn(String isbn) {
        return books.stream()
                .filter(s -> s.getIsbn().equals(isbn))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Nie znaleziono książki"));
    }

    public Book findByTitle(String title) {
        return books.stream()
                .filter(s -> s.getTitle().equals(title))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Nie znaleziono książki"));
    }

    public List<Book> findByAuthor(String author) {
        return books.stream()
                .filter(s -> s.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public void removeBook(Book book) {
        books.remove(book);
    }
}