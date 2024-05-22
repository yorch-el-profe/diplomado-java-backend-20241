package org.bedu.store.controller;

import java.util.ArrayList;
import java.util.List;

import org.bedu.store.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StoreController {

  private List<Product> products = new ArrayList<>();
  private int currentId = 1;
  
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

    // Asignando un ID (secuencial)
    data.setId(currentId++);

    // Agregando el producto nuevo a la lista
    products.add(data);

    // Redigir la petición al index (/)
    return "redirect:/";
  }

  @GetMapping("editar/{id}")
  public String update(Model model, @PathVariable("id") int id) {

    for (Product product : products) {
      if (product.getId() == id) {
        model.addAttribute("product", product);

        return "update.html";
      }
    }

    return "redirect:/";
  }

  @PostMapping("actualizar")
  public String put(@ModelAttribute("product") Product data) {
    for (Product product : products) {
      if (product.getId() == data.getId()) {
       
        // Actualizando el producto con los nuevos valores
        product.setName(data.getName());
        product.setPrice(data.getPrice());
        product.setStock(data.getStock());
      }
    }

    return "redirect:/";
  } 
}
