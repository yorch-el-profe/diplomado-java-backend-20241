package org.bedu.shop.controller;

import org.bedu.shop.entity.Product;
import org.bedu.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin") // Todas las rutas empiezan por /admin
public class AdminController {

  @Autowired
  private ProductRepository repository;
  
  @GetMapping
  public String index(Model model) {

    model.addAttribute("products", repository.findAll());

    return "admin/index.html";
  }

  @GetMapping("crear")
  public String create(Model model) {
    model.addAttribute("product", new Product());

    return "admin/create.html";
  }

  @PostMapping("guardar")
  public String save(@ModelAttribute("product") Product data) {

    repository.save(data);

    return "redirect:/admin";
  }
}
