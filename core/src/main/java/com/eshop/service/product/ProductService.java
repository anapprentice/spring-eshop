package com.eshop.service.product;

import com.eshop.dao.product.ProductRepository;
import com.eshop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProductService {

  @Autowired
  private ProductRepository repository;

  @PostConstruct
  public void initProducts(){
    repository.saveAll(
      Stream.of(
        new Product(1, 5, "Ponozky", "Pohodlne ponozky"),
        new Product(2, 10, "Tricko", "Bavlnene tricko"))
      .collect(Collectors.toList()));
  }

  public Product createProduct(Product product){
    return repository.save(product);
  }

  public List<Product> listAllProducts(){
    return repository.findAll();
  }

  public Optional<Product> getProductById(int id){
    return repository.findById(id);
  }

  public Optional<Product> findOne(int id){
    return repository.findById(id);
  }

  public void deleteProduct(int id){
    repository.deleteById(id);
  }

}
