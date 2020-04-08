package com.mkyong.mapper;

import com.mkyong.dto.BookDTO;
import com.mkyong.entity.Book;
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
