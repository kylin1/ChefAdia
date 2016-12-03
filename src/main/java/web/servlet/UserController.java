package web.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import web.biz.IUserService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by kylin on 03/12/2016.
 * All rights reserved.
 */
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public
    @ResponseBody
    String register(HttpServletRequest request) {
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        this.userService.register(email,password,username);
        return "";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public
    @ResponseBody
    String login(HttpServletRequest request) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        this.userService.login(email,password);
        return "";
    }

}
