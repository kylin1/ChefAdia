//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package web.dao.util;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import web.model.Dish;
import web.model.DishMenu;

import java.util.List;

public interface DishOperation {
    @Select({"select * from dish"})
    List<Dish> getAllPost();

    @Insert({"insert into dish(name,type,price)" +
            " values(#{name},#{type},#{price})"})
    void save(Dish var1);

    @Select({"select * from menu"})
    List<DishMenu> getDishMenu();

    @Select({"select * from dish where menuid =#{menuId}"})
    List<Dish> getDishOfType(int menuId);
}
