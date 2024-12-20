package com.nera.moment.service;

import com.nera.moment.order.Order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
