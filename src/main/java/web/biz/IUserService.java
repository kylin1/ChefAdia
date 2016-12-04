package web.biz;

/**
 * Created by kylin on 03/12/2016.
 * All rights reserved.
 */
public interface IUserService {

    void login(String email, String password);

    void register(String email, String password, String username);

}
