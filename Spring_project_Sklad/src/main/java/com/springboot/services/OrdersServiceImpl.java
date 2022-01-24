package com.springboot.services;

import com.springboot.forms.OrdersForm;
import com.springboot.models.Customer;
import com.springboot.models.FilesInfo;
import com.springboot.models.Orders;
import com.springboot.models.Products;
import com.springboot.repositories.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class OrdersServiceImpl implements OrdersService {
    private final OrdersRepository ordersRepository;

    @Override
    public void addOrders(OrdersForm form) {
        Orders order = Orders.builder()
                .count(form.getCount())
                .orders_date(form.getOrders_date())
                .customer(Customer.builder()
                        .id(form.getCustomer_id())
                        .build())
                .product(Products.builder()
                        .id(form.getProduct_id())
                        .build())
                .filesInfo(FilesInfo.builder()
                        .id(form.getFile_info_id())
                        .build())
                .build();
    }

    @Override
    public List<Orders> getAllOrders() {
       return ordersRepository.findAll();
    }
}
