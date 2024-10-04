package com.example.demoapi.data.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

public class GetAllProducts  {
  private List<String> images;

  private String creationAt;

  private Integer price;

  private String description;

  private Integer id;

  private String title;

  private Category category;

  private String updatedAt;

  public List<String> getImages() {
    return this.images;
  }

  public void setImages(List<String> images) {
    this.images = images;
  }

  public String getCreationAt() {
    return this.creationAt;
  }

  public void setCreationAt(String creationAt) {
    this.creationAt = creationAt;
  }

  public Integer getPrice() {
    return this.price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Category getCategory() {
    return this.category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public String getUpdatedAt() {
    return this.updatedAt;
  }

  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }

  public static class Category implements Serializable {
    private String image;

    private String creationAt;

    private String name;

    private Integer id;

    private String updatedAt;

    public String getImage() {
      return this.image;
    }

    public void setImage(String image) {
      this.image = image;
    }

    public String getCreationAt() {
      return this.creationAt;
    }

    public void setCreationAt(String creationAt) {
      this.creationAt = creationAt;
    }

    public String getName() {
      return this.name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public Integer getId() {
      return this.id;
    }

    public void setId(Integer id) {
      this.id = id;
    }

    public String getUpdatedAt() {
      return this.updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
      this.updatedAt = updatedAt;
    }
  }
}
