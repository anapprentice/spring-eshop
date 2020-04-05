package com.eshop.service.order;

import com.eshop.dao.order.OrderRepository;
import com.eshop.model.CustomerOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class OrderService {

  @Autowired
  private OrderRepository repository;

  @PostConstruct
  public void initOrders(){
    repository.saveAll(
      Stream.of(
        new CustomerOrder(1, 150, "1, 2, 4", "Janko", "janko@janko.com", "Hlavna 10, Presov", "123456789", new Date()),
        new CustomerOrder(2, 15, "1", "Ferko", "ferko@ferko.com", "Hlavna 11, Presov", "987654321", new Date()))
      .collect(Collectors.toList()));
  }

  public List<CustomerOrder> listAllOrdersByDate(){
    return repository.findAll();
  }

  public Optional<CustomerOrder> getOrderById(int id){
    return repository.findById(id);
  }

}
