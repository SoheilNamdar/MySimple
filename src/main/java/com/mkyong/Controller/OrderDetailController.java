package com.mkyong.Controller;

import com.mkyong.DTO.OrderDetailDTO;
import com.mkyong.Service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderDetailController {

    @Autowired
    private OrderDetailService itemService;

    // Find
    @GetMapping("/items")
    public List<OrderDetailDTO> findAll() {
        return itemService.findAll();
    }

    // Save
    @PostMapping("/items")
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDetailDTO newOrderDetail(@RequestBody OrderDetailDTO newOrderDetailDTO) {
        return itemService.newOrderDetail(newOrderDetailDTO);
    }

    // Find
    @GetMapping("/items")
    public OrderDetailDTO findOne(@RequestParam Long id) {
        return itemService.findOne(id);
    }

    // Save
    @PutMapping("/items")
    public OrderDetailDTO save(@RequestBody OrderDetailDTO newOrderDetailDTO) {

        return itemService.save(newOrderDetailDTO);
    }

    //update
    @PutMapping("/items")
    public OrderDetailDTO update(@RequestBody OrderDetailDTO newOrderDetailDTO, @RequestParam Long id) {

        return itemService.update(newOrderDetailDTO,id);
    }

    //delete
    @DeleteMapping("/items")
    void deleteOrderDetail(@RequestParam Long id) {
        itemService.deleteOrderDetail(id);
    }

}
