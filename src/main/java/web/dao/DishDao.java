//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package web.dao;

import java.util.List;
import web.model.Dish;

public interface DishDao {
    List<Dish> getAllDish();

    boolean addDish(Dish var1);
}
