package web.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.dao.opearion.UserOperation;
import web.model.User;
import web.model.exceptions.NotFoundException;
import web.tools.MyMessage;

import java.util.List;

/**
 * Created by kylin on 04/12/2016.
 * All rights reserved.
 */
@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {

    private SqlSession session;
    private UserOperation operation;

    @Override
    public List<User> getAllUser() {
        return null;
    }

    @Override
    public List<User> searchUser(String userName) {
        return null;
    }

    @Override
    public User getUser(int id) {
        return null;
    }

    @Override
    public User getUserByMail(String email) throws NotFoundException {
        return null;
    }

    @Override
    public MyMessage addUser(User user) {
        return null;
    }

    @Override
    public MyMessage updateUser(User user) {
        return null;
    }
}
