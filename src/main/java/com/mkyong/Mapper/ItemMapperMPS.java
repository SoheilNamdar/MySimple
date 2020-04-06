package com.mkyong.Mapper;

import com.mkyong.DTO.ItemDTO;
import com.mkyong.Entity.Item;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ItemMapperMPS {

    ItemDTO toDTO(Item item);
    Item toEntity(ItemDTO itemDTO);

    default List<ItemDTO> toDTO(List<Item> items){
        return items.stream().map(itemDTO -> toDTO(itemDTO)).collect(Collectors.toList());

    }
}
