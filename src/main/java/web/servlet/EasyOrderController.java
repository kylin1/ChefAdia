package web.servlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Alan on 2016/12/5.
 */
@Controller
public class EasyOrderController {
    @RequestMapping(value = "/getEasyOrder", method = RequestMethod.GET)
    @ResponseBody
    public String getEasyOrder(HttpServletRequest request) {
        String userID = request.getParameter("userid");
//        int intUserID =
        return null;
    }
}
