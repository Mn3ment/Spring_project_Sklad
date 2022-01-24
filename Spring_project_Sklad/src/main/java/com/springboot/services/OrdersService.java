package com.springboot.services;

import com.springboot.forms.OrdersForm;
import com.springboot.models.Orders;

import java.util.List;

public interface OrdersService {

    void addOrders(OrdersForm form);
    List<Orders> getAllOrders();
}
