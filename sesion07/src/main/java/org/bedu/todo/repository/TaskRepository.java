package org.bedu.todo.repository;

import org.bedu.todo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
  
}



// Guardar una nueva tarea en la base de datos
// repository.save( tarea );

// Leer todas las tareas de la base de datos
// repository.findAll();