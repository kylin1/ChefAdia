package dao;

import junit.framework.TestCase;
import web.dao.impl.DishDaoImpl;

/**
 * Created by JiachenWang on 2016/8/30.
 */
public class PostDaoImplTest extends TestCase {

    public void testGetAllPost() throws Exception {
        DishDaoImpl dishDao = new DishDaoImpl();
        System.out.println(dishDao.getAllDish().size());
    }

}