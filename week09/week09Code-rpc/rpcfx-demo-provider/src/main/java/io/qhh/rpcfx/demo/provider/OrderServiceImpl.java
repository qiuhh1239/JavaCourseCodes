package io.qhh.rpcfx.demo.provider;

import io.qhh.rpcfx.demo.api.Order;
import io.qhh.rpcfx.demo.api.OrderService;

public class OrderServiceImpl implements OrderService {

    @Override
    public Order findOrderById(int id) {
        return new Order(id, "Cuijing" + System.currentTimeMillis(), 9.9f);
    }
}
