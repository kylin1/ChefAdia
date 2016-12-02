package web.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.biz.IDishManage;
import web.dao.DishDao;
import web.model.Dish;
import web.model.DishMenu;
import web.model.exceptions.NotFoundException;

import java.util.List;

@Service
public class DishManage implements IDishManage {

    @Autowired
    private DishDao dishDao;

    public DishManage() {

    }

    public List<Dish> getAllDish() {
        return this.dishDao.getAllDish();
    }

    public List<Dish> getDishInMenu(int menuId) throws NotFoundException {
        List<DishMenu> dishMenus = this.getMenuCategory();
        for (DishMenu oneMenu:dishMenus){
            //找到目标菜品种类
            int id = oneMenu.getId();
            if(id == menuId){
                //寻找菜品种类下面的所有菜品信息
                return dishDao.getDishByType(id);
            }
        }
        throw new NotFoundException("请求的菜品种类不存在");
    }

    public List<DishMenu> getMenuCategory() {
        return this.dishDao.getDishMenu();
    }

    public boolean addDish(Dish dish) {
        return this.dishDao.addDish(dish);
    }
}
