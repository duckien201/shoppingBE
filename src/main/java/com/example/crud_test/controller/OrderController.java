package com.example.crud_test.controller;

import com.example.crud_test.repository.OrderInfoRepo;
import com.example.crud_test.repository.OrderItemRepo;
import com.example.crud_test.dto.OrderDto;
import com.example.crud_test.dto.RateDto;
import com.example.crud_test.service.OrderService;
import com.example.crud_test.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import static com.example.crud_test.constant.Constant.URL_ORIGIN;

@RestController
@CrossOrigin(URL_ORIGIN)
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderInfoRepo orderInfoRepo;

    @Autowired
    private OrderItemRepo orderItemRepo;

    @Autowired
    private RateService rateService;

    @PostMapping("/order")
    public ResponseEntity<?> createOrder(@RequestBody OrderDto orderDto) {
        return orderService.createOrder(orderDto);
    }

    @GetMapping("/order")
    public ResponseEntity<?> getAllOrdersInfo(@RequestParam long idUser) {
        return  orderService.getAllOrdersInfo(idUser);
    }

    @GetMapping("/orderItems")
    public ResponseEntity<?> getAllItemFromOrderOfUser(@RequestParam long idUser) {
        return orderService.getAllItemFromOrderOfUser(idUser);
    }

    @GetMapping("/getOrderInfo")
    public ResponseEntity<?> getOrderInfo(@RequestParam long idOrder) {
        return orderService.getOrderInfo(idOrder);
    }

    @GetMapping("/getItemsOfOrder")
    public ResponseEntity<?> getItemsOfOrder(@RequestParam long idOrder) {
        return orderService.getItemsOfOrder(idOrder);
    }

    @PostMapping("/rateProduct")
    public ResponseEntity<?> rateProduct(@RequestBody RateDto rateDto) {
        return rateService.addRateProduct(rateDto);
    }

    @PostMapping("/cancelOrder")
    public ResponseEntity<?> cancelOrder(@RequestParam long idOrder) {
        return orderService.cancelOrder(idOrder);
    }

    @PostMapping("/rateOfItem")
        public ResponseEntity<?> rateOfItem(@RequestParam long idOrderItem) {
        return rateService.getRateOfOrderItem(idOrderItem);
    }
}