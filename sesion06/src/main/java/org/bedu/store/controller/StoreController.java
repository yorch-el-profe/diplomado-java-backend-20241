package org.bedu.store.controller;

import java.util.ArrayList;
import java.util.List;

import org.bedu.store.model.Product;
import org.bedu.store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StoreController {
  
  // Dependencias
  @Autowired
  private ProductRepository repository;

  @GetMapping
  public String index(Model model) {

    List<Product> products = repository.findAll();

    // Enviar la lista de todos los productos a la vista
    model.addAttribute("products", products);

    return "index.html";
  }

  @GetMapping("crear")
  public String create(Model model) {

    // Enviar un objeto vacío para que sea llenado en la vista
    model.addAttribute("product", new Product());

    return "create.html";
  }

  @PostMapping("guardar")
  public String save(@ModelAttribute("product") Product data) {

    repository.save(data);

    // Redigir la petición al index (/)
    return "redirect:/";
  }

  @GetMapping("editar/{id}")
  public String update(Model model, @PathVariable("id") int id) {

    Product product = repository.findById(id);

    if (product == null) {
      return "redirect:/";
    }

    model.addAttribute("product", product);
    return "update.html";
  }

  @PostMapping("actualizar")
  public String put(@ModelAttribute("product") Product data) {

    repository.update(data);

    return "redirect:/";
  } 
}
