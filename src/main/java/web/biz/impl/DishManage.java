package web.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.biz.IDishManage;
import web.dao.DishDao;
import web.model.Dish;

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

    public boolean addDish(Dish dish) {
        return this.dishDao.addDish(dish);
    }
}
