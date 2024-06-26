package org.bedu.store.controller;

import java.util.ArrayList;
import java.util.List;

import org.bedu.store.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StoreController {

  private List<Product> products = new ArrayList<>();
  
  @GetMapping
  public String index(Model model) {

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

    // Agregando el producto nuevo a la lista
    products.add(data);

    // Redigir la petición al index (/)
    return "redirect:/";
  }
}
