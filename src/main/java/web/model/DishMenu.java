package web.model;

/**
 * Created by kylin on 02/12/2016.
 * All rights reserved.
 *
 * 菜品分类
 */
public class DishMenu {

    private int id;

    private String picture;

    private String name;

    private int dishnum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDishnum() {
        return dishnum;
    }

    public void setDishnum(int dishnum) {
        this.dishnum = dishnum;
    }
}
