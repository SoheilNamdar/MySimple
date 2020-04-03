package com.mkyong.Service;

import com.mkyong.Entity.Book;
import com.mkyong.Repository.BookRepository;
import com.mkyong.error.BookNotFoundException;
import com.mkyong.error.BookUnSupportedFieldPatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

public class BookService {

    @Autowired
    private BookRepository repository;

    // Find
    List<Book> findAll() {
        return repository.findAll();
    }

    // Save
    Book newBook(Book newBook) {
        return repository.save(newBook);
    }

    // Find
    Book findOne(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    // Save or update
    Book saveOrUpdate(Book newBook, Long id) {

        return repository.findById(id)
                .map(x -> {
                    x.setName(newBook.getName());
                    x.setAuthor(newBook.getAuthor());
                    x.setPrice(newBook.getPrice());
                    return repository.save(x);
                })
                .orElseGet(() -> {
                    newBook.setId(id);
                    return repository.save(newBook);
                });
    }

    // update author only
    Book patch(Map<String, String> update, Long id) {

        return repository.findById(id)
                .map(x -> {

                    String author = update.get("author");
                    if (!StringUtils.isEmpty(author)) {
                        x.setAuthor(author);

                        // better create a custom method to update a value = :newValue where id = :id
                        return repository.save(x);
                    } else {
                        throw new BookUnSupportedFieldPatchException(update.keySet());
                    }

                })
                .orElseGet(() -> {
                    throw new BookNotFoundException(id);
                });

    }

    void deleteBook(Long id) {
        repository.deleteById(id);
    }
}
