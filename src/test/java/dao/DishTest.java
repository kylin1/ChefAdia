package dao;

import junit.framework.TestCase;
import web.dao.impl.DishDaoImpl;
import web.model.Dish;
import web.model.DishMenu;

import java.util.List;

/**
 * Created by JiachenWang on 2016/8/30.
 */
public class DishTest extends TestCase {

    public void test2() throws Exception {
        DishDaoImpl dishDao = new DishDaoImpl();
        List<DishMenu> dishes = dishDao.getDishMenu();
        for (DishMenu dish:dishes){
            System.out.println(dish.getName()+dish.getId()+dish.getPicture()+dish.getDishnum());
        }
    }

    public void testGetAllPost() throws Exception {
        DishDaoImpl dishDao = new DishDaoImpl();
        List<Dish> dishes = dishDao.getDishByType(1);
        for (Dish dish:dishes){
            System.out.println(dish.getName());
        }
    }

}