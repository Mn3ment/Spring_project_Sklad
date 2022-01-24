package com.springboot.repositories;

import com.springboot.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {
    List<Orders> findAllByCustomer_Id(Integer id);
}
