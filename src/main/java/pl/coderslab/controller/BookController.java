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

    @GetMapping("/books")
    List<Book> getList() {
        return bookService.getBooks();
    }

    @GetMapping("/book/{id}")
    List<Book> getBook(@PathVariable long id) {
        return bookService.getBookById(id);
    }

    @PostMapping("/addBook")
    void addBook(@RequestBody Book book) {
        bookService.add(book);

    }

    @PutMapping("/updateBook")
    void updateBook(@RequestBody Book book) {
        bookService.updateBook(book);
    }

}
