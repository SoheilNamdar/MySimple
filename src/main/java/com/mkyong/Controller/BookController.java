package com.mkyong.Controller;

import com.mkyong.DTO.BookDTO;
import com.mkyong.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    //todo fix it
    @GetMapping("/books")
    public BookDTO findOne(@RequestBody Long id) {
        return bookService.findOne(id);
    }

    // Save or update
    @PutMapping("/books")
    public BookDTO saveOrUpdate(@RequestBody BookDTO newBookDTO, @RequestBody Long id) {

        return bookService.saveOrUpdate(newBookDTO,id);
    }

    /* update author only
    @PatchMapping("/books/{id}")
    public BookDTO patch(@RequestBody Map<String, String> update, @PathVariable Long id) {

        return bookService.patch(update, id);

    }*/

    //delete
    @DeleteMapping("/books/{id}")
    void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

}
