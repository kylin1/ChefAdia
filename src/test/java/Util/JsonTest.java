package Util;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import web.dao.DishDao;
import web.dao.impl.DishDaoImpl;
import web.tools.MyResponse;

/**
 * Created by kylin on 03/12/2016.
 * All rights reserved.
 */
public class JsonTest {

    @Test
    public void testJson() throws JsonProcessingException {
        DishDao dishDao = new DishDaoImpl();
        String result = MyResponse.success(dishDao.getAllDish());
        System.out.println(result);

    }

    @Test
    public void testJsonFail() throws JsonProcessingException {
        DishDao dishDao = new DishDaoImpl();
        String result = MyResponse.failure("0001","not found",dishDao.getAllDish());
        System.out.println(result);

    }

}
