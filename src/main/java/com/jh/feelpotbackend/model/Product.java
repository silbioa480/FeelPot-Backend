package com.jh.feelpotbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column
  private String name;

  @Column
  private String image;

  @Column
  private int price;

  @Column
  private String description;

  public Product() {
  }

  public Product(long id, String name, String image, int price, String description) {
    this.id = id;
    this.name = name;
    this.image = image;
    this.price = price;
    this.description = description;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
