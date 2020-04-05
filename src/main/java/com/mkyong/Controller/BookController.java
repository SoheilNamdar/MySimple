package com.mkyong.Controller;

import com.mkyong.DTO.BookDTO;
import com.mkyong.Mapper.BookMapperMPS;
import com.mkyong.Repository.BookRepository;
import com.mkyong.Entity.Book;
import com.mkyong.Service.BookService;
import com.mkyong.error.BookNotFoundException;
import com.mkyong.error.BookUnSupportedFieldPatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    // Find
    @GetMapping("/books")
    public List<BookDTO> findAll() {
        return bookService.findAll();
    }

    // Save
    @PostMapping("/books")
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO newBook(@RequestBody BookDTO newBookDTO) {
        return bookService.newBook(newBookDTO);
    }

    // Find
    @GetMapping("/books/{id}")
    public BookDTO findOne(@PathVariable Long id) {
        return bookService.findOne(id);
    }

    // Save or update
    @PutMapping("/books/{id}")
    public BookDTO saveOrUpdate(@RequestBody BookDTO newBookDTO, @PathVariable Long id) {

        return bookService.saveOrUpdate(newBookDTO,id);
    }

    // update author only
    @PatchMapping("/books/{id}")
    public BookDTO patch(@RequestBody Map<String, String> update, @PathVariable Long id) {

        return bookService.patch(update, id);

    }

    @DeleteMapping("/books/{id}")
    void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

}
