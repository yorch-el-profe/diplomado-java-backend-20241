package org.bedu.todo.controller;

import org.bedu.todo.entity.Task;
import org.bedu.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController {

  @Autowired
  private TaskRepository repository;
  
  @GetMapping
  public String index(Model model) {
    // Obtener la lista de todas las tareas
    // almacenadas en la base de datos
    model.addAttribute("list", repository.findAll());

    // Tarea vacía para rellenar con la información
    // del formulario
    model.addAttribute("task", new Task());

    return "index.html";
  }

  @PostMapping("guardar")
  public String save(@ModelAttribute("task") Task data) {
   
    // Guardando la tarea que llega al controlador
    // directamente en la base de datos
    repository.save(data);

    return "redirect:/";
  }
}
