package com.example.crud_test.repository;

import com.example.crud_test.model.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderInfoRepo extends JpaRepository<OrderInfo, Long> {
    @Query("SELECT o FROM OrderInfo o WHERE o.user.id=:idUser")
    List<OrderInfo> findByUserId(Long idUser);

    @Query("SELECT o FROM OrderInfo o WHERE o.shop.id=:idShop")
    List<OrderInfo> findByIdShop(Long idShop);

    Optional<OrderInfo> findById(Long orderId);
    OrderInfo findByCode(String code);
}
