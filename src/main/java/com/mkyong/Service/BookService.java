package com.mkyong.Service;

import com.mkyong.DTO.BookDTO;
import com.mkyong.Entity.Book;
import com.mkyong.Mapper.BookMapperMPS;
import com.mkyong.Repository.BookRepository;
import com.mkyong.error.BookNotFoundException;
import com.mkyong.error.BookUnSupportedFieldPatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    @Autowired
    private BookMapperMPS bookMapper;

    // Find
    public List<BookDTO> findAll() {
        return bookMapper.toDTO(repository.findAll());
    }

    // Save
    public BookDTO newBook(Book newBook) {
        return bookMapper.toDTO(repository.save(newBook));
    }

    // Find
    public BookDTO findOne(Long id) {
        return bookMapper.toDTO(repository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id)));
    }

    // Save or update
    public BookDTO saveOrUpdate(Book newBook, Long id) {

        return bookMapper.toDTO(repository.findById(id)
                .map(x -> {
                    x.setName(newBook.getName());
                    x.setAuthor(newBook.getAuthor());
                    x.setPrice(newBook.getPrice());
                    return repository.save(x);
                })
                .orElseGet(() -> {
                    newBook.setId(id);
                    return repository.save(newBook);
                }));
    }

    // update author only
    public BookDTO patch(Map<String, String> update, Long id) {

        return bookMapper.toDTO(repository.findById(id)
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
                }));

    }

    public void deleteBook(Long id) {
        repository.deleteById(id);
    }
}
