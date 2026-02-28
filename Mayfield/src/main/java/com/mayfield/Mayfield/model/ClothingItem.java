package com.mayfield.Mayfield.model;

public class ClothingItem {
    private Long clothesID;
    private String name;
    private String imagePath;
    private String sizes;
    private Double price;
    private String category;

    // Add getters and setters
    public Long getClothesID() { return clothesID; }
    public void setClothesID(Long clothesID) { this.clothesID = clothesID; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getImagePath() { return imagePath; }
    public void setImagePath(String imagePath) { this.imagePath = imagePath; }

    public String getSizes() { return sizes; }
    public void setSizes(String sizes) { this.sizes = sizes; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}