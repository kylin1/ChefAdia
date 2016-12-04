package web.biz;

import web.model.User;
import web.model.exceptions.DataConflictException;
import web.model.exceptions.NotFoundException;
import web.model.exceptions.WrongPasswordException;

/**
 * Created by kylin on 03/12/2016.
 * All rights reserved.
 */
public interface IUserService {

    /**
     * 用户登录
     *
     * @param email 邮箱
     * @param password 密码
     * @return 用户信息(登录成功)
     *
     * 失败则抛出异常:
     * @throws NotFoundException 用户不存在
     * @throws WrongPasswordException 密码错误
     */
    User login(String email, String password)
            throws NotFoundException,WrongPasswordException;

    /**
     * 注册
     *
     * @param email 邮箱
     * @param password 密码
     * @param username 用户名
     * @return 注册结果
     *
     * 失败则抛出异常
     * @throws DataConflictException 用户邮箱已经存在
     */
    User register(String email, String password, String username)
            throws DataConflictException;

}
