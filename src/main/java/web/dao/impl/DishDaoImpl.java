//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package web.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.dao.DishDao;
import web.dao.opearion.DishOperation;
import web.dao.util.MybatisUtils;
import web.model.Dish;
import web.model.DishMenu;
import web.model.exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.List;

@Repository("dishDao")
@Transactional
public class DishDaoImpl implements DishDao {
    SqlSession session;
    DishOperation dishOperation;

    public DishDaoImpl() {
    }

    public List<Dish> getAllDish() {
        List<Dish>  list = new ArrayList<>();

        try {
            this.session = MybatisUtils.getSession();
            this.dishOperation = this.session.getMapper(DishOperation.class);
            list = this.dishOperation.getAllPost();
            this.session.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            this.session.rollback();
        } finally {
            this.session.close();
        }

        return list;
    }

    public boolean addDish(Dish dish) {
        boolean var3;
        try {
            this.session = MybatisUtils.getSession();
            this.dishOperation = this.session.getMapper(DishOperation.class);
            this.dishOperation.save(dish);
            this.session.commit();
            return true;
        } catch (Exception var7) {
            var7.printStackTrace();
            this.session.rollback();
            var3 = false;
        } finally {
            this.session.close();
        }

        return var3;
    }

    @Override
    public List<DishMenu> getDishMenu() {
        List<DishMenu>  list = new ArrayList<>();

        try {
            this.session = MybatisUtils.getSession();
            this.dishOperation = this.session.getMapper(DishOperation.class);
            list = this.dishOperation.getDishMenu();
            this.session.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            this.session.rollback();
        } finally {
            this.session.close();
        }

        return list;
    }

    @Override
    public List<Dish> getDishByType(int menuId) throws NotFoundException {
        List<Dish> result = new ArrayList<>();
        try {
            this.session = MybatisUtils.getSession();
            this.dishOperation = this.session.getMapper(DishOperation.class);
            result= this.dishOperation.getDishOfType(menuId);
            this.session.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            this.session.rollback();
            throw new NotFoundException("菜单下面没有菜品!");
        } finally {
            this.session.close();
        }
        return result;
    }
}
