package web.servlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import web.biz.impl.DishManage;
import web.model.Dish;
import web.model.DishType;
import web.tools.JsonConverter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class DishServlet extends HttpServlet {

    @Autowired
    private DishManage dishManage;

    public DishServlet() {
    }

    @RequestMapping(
            value = {"addDish.do"},
            method = {RequestMethod.POST}
    )
    public String inputPost(HttpServletRequest request) throws JsonProcessingException {
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String price = request.getParameter("price");
        double doublePrice = Double.parseDouble(price);
        DishType dishType = DishType.getDishType(type);
        Dish dish = new Dish();
        dish.setName(name);
        dish.setType(dishType);
        dish.setPrice(doublePrice);
        this.dishManage.addDish(dish);
        return JsonConverter.jsonOfObject(Boolean.TRUE);
    }

    @RequestMapping(
            value = {"allDish.do"},
            method = {RequestMethod.GET}
    )
    @ResponseBody
    public String getPostList() throws JsonProcessingException {
        List postList = this.dishManage.getAllDish();
        return JsonConverter.jsonOfObject(postList);
    }
}
