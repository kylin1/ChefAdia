//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package web.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.dao.DishDao;
import web.dao.util.DishOperation;
import web.dao.util.MybatisUtils;
import web.model.Dish;

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
            this.dishOperation = (DishOperation)this.session.getMapper(DishOperation.class);
            list = this.dishOperation.getAllPost();
            this.session.commit();
        } catch (Exception var6) {
            var6.printStackTrace();
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
            this.dishOperation = (DishOperation)this.session.getMapper(DishOperation.class);
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
}
