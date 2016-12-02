//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package web.biz;

import web.model.Dish;
import web.model.DishMenu;
import web.model.exceptions.NotFoundException;

import java.util.List;

public interface IDishManage {
    List<Dish> getAllDish();

    boolean addDish(Dish var1);

    List<DishMenu> getMenuCategory();

    List<Dish> getDishInMenu(int menuId) throws NotFoundException;
}
