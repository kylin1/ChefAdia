//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package web.model;

import web.model.enums.DishType;

public class Dish {
    private String name;
    private DishType type;
    private double price;
    private int like;
    private int dislike;
    private String imagePath;

    public Dish() {
    }

    public String getName() {
        return this.name;
    }

    public DishType getType() {
        return this.type;
    }

    public double getPrice() {
        return this.price;
    }

    public int getLike() {
        return this.like;
    }

    public int getDislike() {
        return this.dislike;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(DishType type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
