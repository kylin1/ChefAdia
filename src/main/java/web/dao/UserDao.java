package web.dao;

import web.model.User;
import web.tools.MyMessage;

import java.util.List;

/**
 * Created by kylin on 04/12/2016.
 * All rights reserved.
 */
public interface UserDao {

    /**
     * 获取用户列表
     *
     * @return
     */
    List<User> getAllUser();

    /**
     * 根据用户名关键字查找用户
     *
     * @param userName
     * @return
     */
    List<User> searchUser(String userName);

    /**
     * 一个用户信息
     *
     * @param id
     * @return
     */
    User getUser(int id);

   /**
     * 验证是否棉麻正确
     *
     * @param email
     * @param password
     * @return
     */
    MyMessage checkUser(String email, String password);

    /**
     * 注册
     *
     * @param user
     * @return
     */
    MyMessage addUser(User user);

    /**
     * 更新信息
     *
     * @param user
     * @return
     */
    MyMessage updateUser(User user);



}
