package org.bedu.ejemplo.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegistroController {
  
  @GetMapping("registro")
  public String formulario() {
    return "form.html";
  }

  @PostMapping(name = "guardar", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  public @ResponseBody String guardar(@RequestParam(value = "nombre", required = false) String nombre, @RequestParam(value = "correo", required = false) String correo, @RequestParam(value = "contrasenia", required = false) String contrasenia) {
    return "index.html";
  }
}
