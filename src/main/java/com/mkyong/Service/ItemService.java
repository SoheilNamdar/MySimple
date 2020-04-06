package com.mkyong.Service;

import com.mkyong.DTO.ItemDTO;
import com.mkyong.Entity.Item;
import com.mkyong.Mapper.ItemMapperMPS;
import com.mkyong.Repository.ItemRepository;
import com.mkyong.error.NotFoundException.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ItemDTO save(Item newItem) {
        return itemMapper.toDTO(itemRepository.save(newItem));
    }

    //update
    @PutMapping("/items")
    public ItemDTO update(@RequestBody Item item, @PathVariable Long id) {

        return itemMapper.toDTO(itemRepository.findById(id)
                .map(x -> {
                    x.setId(item.getId());
                    x.setDescription(item.getDescription());
                    x.setWeight(item.getWeight());
                    return itemRepository.save(x);
                })
                .orElseThrow(() -> new ItemNotFoundException(id)));
    }

    //delete
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
