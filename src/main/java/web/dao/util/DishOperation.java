//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package web.dao.util;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import web.model.Dish;

import java.util.List;

public interface DishOperation {
    @Select({"select * from dish"})
    List<Dish> getAllPost();

    @Insert({"insert into dish(name,type,price)  \n             values(#{name},#{type},#{price})"})
    void save(Dish var1);
}
