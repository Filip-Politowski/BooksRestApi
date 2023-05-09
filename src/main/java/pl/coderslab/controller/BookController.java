package pl.coderslab.controller;


import org.springframework.web.bind.annotation.*;

import pl.coderslab.entity.Book;
import pl.coderslab.service.BookService;


import java.util.List;


@RestController
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/books")
    List<Book> getList() {
        return bookService.getBooks();
    }

    @RequestMapping("/book/{id}")
    List<Book> getBook(@PathVariable long id) {
        return bookService.getBookById(id);
    }

    @PostMapping("/addBook")
    void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

}
