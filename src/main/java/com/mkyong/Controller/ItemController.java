package com.mkyong.Controller;

import com.mkyong.DTO.ItemDTO;
import com.mkyong.Service.ItemService;
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

    // Save
    @PostMapping("/items")
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDTO newItem(@RequestBody ItemDTO newItemDTO) {
        return itemService.newItem(newItemDTO);
    }

    // Find
    @GetMapping("/items")
    public ItemDTO findOne(@RequestParam Long id) {
        return itemService.findOne(id);
    }

    // Save
    @PutMapping("/items")
    public ItemDTO save(@RequestBody ItemDTO newItemDTO) {

        return itemService.save(newItemDTO);
    }

    //update
    @PutMapping("/items")
    public ItemDTO update(@RequestBody ItemDTO newItemDTO, @RequestParam Long id) {

        return itemService.update(newItemDTO,id);
    }

    //delete
    @DeleteMapping("/items")
    void deleteItem(@RequestParam Long id) {
        itemService.deleteItem(id);
    }

}
