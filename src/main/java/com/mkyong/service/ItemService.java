package com.mkyong.service;

import com.mkyong.dto.ItemDTO;
import com.mkyong.mapper.ItemMapperMPS;
import com.mkyong.repository.ItemRepository;
import com.mkyong.error.NotFoundException.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemMapperMPS itemMapper;

    // Find
    public List<ItemDTO> findAll() {
        return itemMapper.toDTO(itemRepository.findAll());
    }

    // Save
    public ItemDTO newItem(ItemDTO newItemDTO) {

        return itemMapper.toDTO(itemRepository.save(itemMapper.toEntity(newItemDTO)));
    }

    // Find
    public ItemDTO findOne(Long id) {
        return itemMapper.toDTO(itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id)));
    }

    //Save
    public ItemDTO save(ItemDTO newItemDTO) {
        return itemMapper.toDTO(itemRepository.save(itemMapper.toEntity(newItemDTO)));
    }

    //update
    public ItemDTO update(ItemDTO itemDTO, Long id) {

        return itemMapper.toDTO(itemRepository.findById(id)
                .map(x -> {
                    x.setId(itemDTO.getId());
                    x.setDescription(itemDTO.getDescription());
                    x.setWeight(itemDTO.getWeight());
                    return itemRepository.save(x);
                })
                .orElseThrow(() -> new ItemNotFoundException(id)));
    }

    //delete
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
