package pl.coderslab.service;


import org.springframework.stereotype.Service;
import pl.coderslab.entity.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MockBookService implements BookService {
    List<Book> list;

    private long currentId = 4L;

    public MockBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel", "Helion", "programing"));
        list.add(new Book(2L, "9788324627738", "Rusz glowa, Java.", "Bruce Eckel", "Helion", "programming"));
        list.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }


    @Override
    public List<Book> getBooks() {
        return list;
    }

    @Override
    public List<Book> getBookById(long id) {

        return list.stream()
                .filter(element -> element.getId() == id)
                .collect(Collectors.toList());

    }

    @Override
    public void add(Book book) {
        book.setId(currentId++);
        list.add(book);

    }

    @Override
    public void updateBook(Book book) {
        list.stream()
                .filter(element -> element.getId().equals(book.getId()))
                .map(element -> {
                    element.setId( book.getId());
                    element.setIsbn(book.getIsbn());
                    element.setTitle(book.getTitle());
                    element.setAuthor(book.getAuthor());
                    element.setPublisher(book.getPublisher());
                    element.setType(book.getType());
                    return element;
                }).collect(Collectors.toList());
    }

    @Override
    public void deleteBook(long id) {
        list.removeIf(element -> element.getId() == id);
    }


}
