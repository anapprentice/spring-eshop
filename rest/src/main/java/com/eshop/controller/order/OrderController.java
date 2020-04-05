package com.eshop.controller.order;

import com.eshop.model.CustomerOrder;
import com.eshop.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

  @Autowired
  private OrderService service;

  @GetMapping("/order/get/{id}")
  public Optional<CustomerOrder> getOrder(@PathVariable int id) {
    return service.getOrderById(id);
  }

  @GetMapping("/order/listAllByDate")
  public List<CustomerOrder> getOrders(){
    return service.listAllOrdersByDate();
  }

}
