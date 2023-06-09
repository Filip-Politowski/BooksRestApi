package pl.coderslab.service;

import pl.coderslab.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getBooks();
    List<Book> getBookById(long id);
    void add(Book book);
    void updateBook( Book book);
    void deleteBook(long id);
}
