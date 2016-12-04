package web.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.biz.IUserService;
import web.dao.UserDao;
import web.model.User;
import web.model.exceptions.DataConflictException;
import web.model.exceptions.NotFoundException;
import web.model.exceptions.WrongPasswordException;
import web.tools.MyMessage;

/**
 * Created by kylin on 04/12/2016.
 * All rights reserved.
 */
@Service
public class UserImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(String email, String password) throws NotFoundException, WrongPasswordException {
        //根据邮箱信息查询用户
        User user = this.userDao.getUserByMail(email);
        //密码正确
        if(user.getPassword().equals(password)){
            return user;
        }else{
            throw new WrongPasswordException("密码错误");
        }
    }

    @Override
    public User register(String email, String password, String username) throws DataConflictException {
        User newUser = new User();
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setUsername(username);
        MyMessage message = this.userDao.addUser(newUser);
        //注册成功
        if(message.isSuccess()){
            try {
                return this.userDao.getUserByMail(email);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
