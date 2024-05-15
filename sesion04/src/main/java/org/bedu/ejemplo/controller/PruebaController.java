package org.bedu.ejemplo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PruebaController {

  // http://localhost:8080
  @GetMapping
  public String index() {
    return "index.html";
  }

  // http://localhost:8080/acerca
  @GetMapping("acerca")
  public String about() {
    return "about.html";
  }

  // http://localhost:8080/contacto
  @GetMapping("contacto")
  public String contact() {
    return "contact.html";
  }

}
