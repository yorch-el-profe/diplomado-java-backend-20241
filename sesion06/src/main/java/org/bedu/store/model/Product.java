package org.bedu.store.model;

public class Product {
  
  private int id;
  private String name;
  private double price;
  private int stock;

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

  public int getStock() {
    return stock;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }
}
