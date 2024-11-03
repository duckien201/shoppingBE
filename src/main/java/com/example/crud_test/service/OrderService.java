package com.example.crud_test.service;

import com.example.crud_test.dto.OrderDto;
import com.example.crud_test.model.OrderInfo;
import com.example.crud_test.model.OrderItem;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService {
    ResponseEntity<?> createOrder(OrderDto orderDto);

    ResponseEntity<?> getAllOrdersInfo(long idUser);

    ResponseEntity<?> getAllItemFromOrderOfUser(long idUser);

    ResponseEntity<?> getOrderInfo(long orderId);

    ResponseEntity<?> getItemsOfOrder(long orderId);

    List<OrderItem> getAllItemOfOrder(List<Long> idOrder);

    ResponseEntity<?> changeStatusOrder(long idOrder, String status);

    ResponseEntity<?> cancelOrder(long idOrder);

    List<OrderInfo> getOrders(List<Long> idOrder);

    ResponseEntity<?> paySuccess(String[] idOrder);
    List<OrderInfo> getAllOrderOfShop(long idShop);
}
