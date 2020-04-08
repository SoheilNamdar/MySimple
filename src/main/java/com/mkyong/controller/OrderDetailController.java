package com.mkyong.controller;

import com.mkyong.dto.OrderDetailDTO;
import com.mkyong.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    // Find
    @GetMapping("/orderDetails")
    public List<OrderDetailDTO> findAll() {
        return orderDetailService.findAll();
    }

    // Save
    @PostMapping("/orderDetails")
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDetailDTO newOrderDetail(@RequestBody OrderDetailDTO newOrderDetailDTO) {
        return orderDetailService.newOrderDetail(newOrderDetailDTO);
    }

    // Find
    @GetMapping("/orderDetails/{id}")
    public OrderDetailDTO findOne(@PathVariable Long id) {
        return orderDetailService.findOne(id);
    }

    // Save
    @PutMapping("/orderDetail")
    public OrderDetailDTO save(@RequestBody OrderDetailDTO newOrderDetailDTO) {

        return orderDetailService.save(newOrderDetailDTO);
    }

    //update
    @PutMapping("/orderDetails")
    public OrderDetailDTO update(@RequestBody OrderDetailDTO newOrderDetailDTO, @RequestParam Long id) {

        return orderDetailService.update(newOrderDetailDTO,id);
    }

    //delete
    @DeleteMapping("/orderDetails")
    void deleteOrderDetail(@RequestParam Long id) {
        orderDetailService.deleteOrderDetail(id);
    }

}
