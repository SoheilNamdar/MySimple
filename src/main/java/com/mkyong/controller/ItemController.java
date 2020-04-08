package com.mkyong.controller;

import com.mkyong.dto.ItemDTO;
import com.mkyong.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    // Find
    @GetMapping("/items")
    public List<ItemDTO> findAll() {
        return itemService.findAll();
    }

    // Find
    @GetMapping("/items/{id}")
    public ItemDTO findOne(@PathVariable Long id) {
        return itemService.findOne(id);
    }

    // Save
    @PostMapping("/items")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDTO save(@RequestBody ItemDTO newItemDTO) {

        return itemService.save(newItemDTO);
    }

    //update
    @PutMapping("/items")
    public ItemDTO update(@RequestBody ItemDTO itemDTO) {

        return itemService.update(itemDTO,new ItemDTO().getId());
    }

    //delete
    @DeleteMapping("/items")
    void deleteItem(@RequestParam Long id) {
        itemService.deleteItem(id);
    }

}
