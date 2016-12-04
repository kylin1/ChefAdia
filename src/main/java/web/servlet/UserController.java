package web.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import web.biz.IUserService;
import web.model.User;
import web.model.exceptions.DataConflictException;
import web.model.exceptions.NotFoundException;
import web.model.exceptions.WrongPasswordException;
import web.tools.MyResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

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
        //获取参数
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //调用逻辑层
        try {
            User newUser = this.userService.register(email,password,username);
            //注册成功,返回信息
            return this.getUserResult(newUser);

            //逻辑处理异常
        } catch (DataConflictException e) {
            e.printStackTrace();
            return MyResponse.failure("0003",e.getMessage(),"");
        }
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public
    @ResponseBody
    String login(HttpServletRequest request) {
        //获取参数
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            User user = this.userService.login(email,password);
            //登录成功,返回结果
            return this.getUserResult(user);

            //用户邮箱不存在
        } catch (NotFoundException e) {
            e.printStackTrace();
            return MyResponse.failure("0003",e.getMessage(),"");

            //密码不正确
        } catch (WrongPasswordException e) {
            e.printStackTrace();
            return MyResponse.failure("0004",e.getMessage(),"");
        }

    }

    /**
     * 根据返回的用户信息提取URL参数返回前端
     *
     * @param user
     * @return
     */
    private String getUserResult(User user){
        int id = user.getId();
        String userName = user.getUsername();
        String avatar = user.getAvatar();
        Map<String,String> result = new HashMap<>();
        result.put("userid",Integer.toString(id));
        result.put("username",userName);
        result.put("avatar",avatar);
        return MyResponse.success(result);
    }

}
