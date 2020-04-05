package com.mkyong.Service;

import com.mkyong.DTO.BookDTO;
import com.mkyong.Mapper.BookMapperMPS;
import com.mkyong.Repository.BookRepository;
import com.mkyong.error.Book.BookNotFoundException;
import com.mkyong.error.Book.BookUnSupportedFieldPatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapperMPS bookMapper;

    // Find
    public List<BookDTO> findAll() {
        return bookMapper.toDTO(bookRepository.findAll());
    }

    // Save
    public BookDTO newBook(BookDTO newBookDTO) {

        return bookMapper.toDTO(bookRepository.save(bookMapper.toEntity(newBookDTO)));
    }

    // Find
    public BookDTO findOne(Long id) {
        return bookMapper.toDTO(bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id)));
    }

    // Save or update
    public BookDTO saveOrUpdate(BookDTO newBookDTO, Long id) {

        return bookRepository.findById(id)
                .map(x -> {
                    x.setName(newBookDTO.getName());
                    x.setAuthor(newBookDTO.getAuthor());
                    x.setPrice(newBookDTO.getPrice());
                    return bookMapper.toDTO(bookRepository.save(x));
                })
                .orElseGet(() -> {
                    newBookDTO.setId(id);
                    return bookMapper.toDTO(bookRepository.save(bookMapper.toEntity(newBookDTO)));
                });
    }

    // update author only
    public BookDTO patch(Map<String, String> update, Long id) {

        return bookMapper.toDTO(bookRepository.findById(id)
                .map(x -> {

                    String author = update.get("author");
                    if (!StringUtils.isEmpty(author)) {
                        x.setAuthor(author);

                        // better create a custom method to update a value = :newValue where id = :id
                        return bookRepository.save(x);
                    } else {
                        throw new BookUnSupportedFieldPatchException(update.keySet());
                    }

                })
                .orElseGet(() -> {
                    throw new BookNotFoundException(id);
                }));

    }

    //delete
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
