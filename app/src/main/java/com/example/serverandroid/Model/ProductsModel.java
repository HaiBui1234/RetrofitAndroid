package com.example.serverandroid.Model;

public class ProductsModel {
    private  String _id;
    private String name;
    private String image;
    private String description;
    private float price;
    private CategoryModel id_Category;

    public ProductsModel() {
    }

    public ProductsModel(String _id, String name, String image, String description, float price, CategoryModel id_Category) {
        this._id = _id;
        this.name = name;
        this.image = image;
        this.description = description;
        this.price = price;
        this.id_Category = id_Category;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryModel getId_Category() {
        return id_Category;
    }

    public void setId_Category(CategoryModel id_Category) {
        this.id_Category = id_Category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
