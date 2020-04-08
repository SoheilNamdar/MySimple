package com.mkyong.mapper;

import com.mkyong.dto.ItemDTO;
import com.mkyong.entity.Item;
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
