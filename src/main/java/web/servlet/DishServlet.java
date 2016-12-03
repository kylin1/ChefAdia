package web.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import web.biz.IDishManage;
import web.model.Dish;
import web.model.DishMenu;
import web.model.enums.DishType;
import web.model.exceptions.NotFoundException;
import web.tools.MyResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DishServlet {

    @Autowired
    private IDishManage dishManage;

    @RequestMapping(value = "addDish.do", method = RequestMethod.POST)
    public
    @ResponseBody
    String addDish(HttpServletRequest request) {
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String price = request.getParameter("price");

        try {
            double doublePrice = Double.parseDouble(price);
            DishType dishType = DishType.getDishType(type);
            Dish dish = new Dish();
            dish.setName(name);
            dish.setType(dishType);
            dish.setPrice(doublePrice);
            this.dishManage.addDish(dish);
            return MyResponse.success(Boolean.TRUE);
        } catch (Exception ex) {
            return MyResponse.failure("0001", "add dish failed, please try again", Boolean.TRUE);
        }
    }

    @RequestMapping(
            value = {"allDish.do"},
            method = {RequestMethod.GET}
    )
    @ResponseBody
    public String getPostList() {
        List postList = this.dishManage.getAllDish();
        return MyResponse.success(postList);
    }

    @RequestMapping(
            value = {"getMenu"},
            method = {RequestMethod.GET}
    )
    @ResponseBody
    public String getMenu() {
        List<DishMenu> menus = this.dishManage.getMenuCategory();
        return MyResponse.success(menus);
    }

    @RequestMapping(
            value = {"getList"},
            method = {RequestMethod.GET}
    )
    @ResponseBody
    public String getDishListInMenu(HttpServletRequest request) {
        String menuid = request.getParameter("menuid");
        int id = Integer.parseInt(menuid);
        try {
            List<Dish> menus = this.dishManage.getDishInMenu(id);
            return MyResponse.success(menus);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return MyResponse.failure("0002",
                    "sorry, we do not serve this type of food currently", new ArrayList<>());
        }
    }
}
