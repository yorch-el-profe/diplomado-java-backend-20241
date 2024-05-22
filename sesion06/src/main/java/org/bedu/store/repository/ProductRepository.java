package org.bedu.store.repository;

import java.util.ArrayList;
import java.util.List;

import org.bedu.store.model.Product;
import org.springframework.stereotype.Repository;

// El repositorio se trata de exponer
// métodos que permitan leer y manipular los datos
@Repository
public class ProductRepository {
    private List<Product> products = new ArrayList<>();
    private int currentId = 1;

    public List<Product> findAll() {
      return products;
    }

    public void save(Product data) {
      data.setId(currentId++);
      products.add(data);
    }

    public Product findById(int id) {
      for (Product product : products) {
        if (product.getId() == id) {
          return product;
        }
      }

      return null;
    }

    public void update(Product data) {
      Product product = findById(data.getId());

      if (product == null) {
        return;
      }

      product.setName(data.getName());
      product.setPrice(data.getPrice());
      product.setStock(data.getStock());
    }
}
