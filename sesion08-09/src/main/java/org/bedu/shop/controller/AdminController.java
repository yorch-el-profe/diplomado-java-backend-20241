package org.bedu.shop.controller;

import java.util.Optional;

import org.bedu.shop.entity.Product;
import org.bedu.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

  @GetMapping("editar/{id}")
  public String edit(@PathVariable("id") int id, Model model) {

    Optional<Product> product = repository.findById(id);

    if (product.isPresent()) {
      model.addAttribute("product", product.get());

      return "...";
    }

    return "redirect:/admin";
  }

  @PostMapping("guardar")
  public String save(@ModelAttribute("product") Product data) {

    repository.save(data);

    return "redirect:/admin";
  }

  @PostMapping("eliminar/{id}")
  public String delete(@PathVariable("id") int id) {

    repository.deleteById(id);

    return "redirect:/admin";
  }
}
