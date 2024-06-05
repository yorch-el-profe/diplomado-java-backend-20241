package org.bedu.shop.repository;

import org.bedu.shop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * Los repositorios tienen operaciones en común:
 * 
 * findAll() -> Regresa todos los elementos del repositorio
 * findById(id) -> Regresa el elemento con el id o nulo si no lo encuentra
 * save(elemento) -> Crea un nuevo elemento
 * deleteById(id) -> Eliminar un elemento por su id
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
  
}
