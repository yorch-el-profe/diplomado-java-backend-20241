package org.bedu.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin") // Todas las rutas empiezan por /admin
public class AdminController {
  
  @GetMapping
  public String index() {
    return "admin/index.html";
  }


  @GetMapping("crear")
  public String add() {
    return "admin/create.html";
  }
}
