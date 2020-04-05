package com.eshop.controller.product;

import com.eshop.model.Product;
import com.eshop.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

  @Autowired
  private ProductService service;

  @PostMapping("/product/create")
  public Product createProduct(@RequestBody Product productForm ) {
    return service.createProduct(productForm);
  }

  @GetMapping("/product/get/{id}")
  public Optional<Product> getProduct(@PathVariable int id) {
    return service.getProductById(id);
  }

  @GetMapping("/product/listAll")
  public List<Product> getProducts(){
    return service.listAllProducts();
  }

  @PostMapping("/product/update/{id}")
  public ResponseEntity<Object> createProduct(@RequestBody Product productForm, @PathVariable int id) {

    Optional<Product> productOptional = service.getProductById(id);

    if (productOptional.isEmpty())
      return ResponseEntity.notFound().build();

    productForm.setId(id);

    service.createProduct(productForm);
    return ResponseEntity.noContent().build();
  }

  @PostMapping("/product/delete/{id}")
  public ResponseEntity<Object> createProduct(@PathVariable int id) {

    service.deleteProduct(id);
    return ResponseEntity.noContent().build();
  }

  }
