//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package web.dao;

import web.model.Dish;
import web.model.DishMenu;
import web.model.exceptions.NotFoundException;

import java.util.List;

public interface DishDao {

    List<Dish> getAllDish();

    boolean addDish(Dish var1);

    List<DishMenu> getDishMenu();

    List<Dish> getDishByType(int menuId) throws NotFoundException;
}
