package com.mkyong.Mapper;

import com.mkyong.DTO.BookDTO;
import com.mkyong.Entity.Book;
import org.mapstruct.Mapper;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface BookMapperMPS {

    BookDTO toDTO(Book book);
    Book toEntity(BookDTO bookDTO);

    default List<BookDTO> toDTO(List<Book> books){
        return books.stream().map(bookDTO -> toDTO(bookDTO)).collect(Collectors.toList());

    }
}
