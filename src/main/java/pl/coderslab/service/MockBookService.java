package pl.coderslab.service;


import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.entity.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
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
    public void addBook(Book book) {
        book.setId(currentId++);
        list.add(book);

    }

}
