package com.eshop.controller;

import com.eshop.model.Product;
import com.eshop.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class EshopController {

  @Autowired
  private ProductService service;

  @RequestMapping("/")
  public String index(Model model) {
    List<Product> products =  service.listAllProducts();
    model.addAttribute("products", products);

    String ahoj = "ahoj";
    model.addAttribute("ahoj", ahoj);

    return "index";
  }
}
