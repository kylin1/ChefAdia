package web;

/**
 * Created by kylin on 03/12/2016.
 * All rights reserved.
 */
public class Users {
    private String name;
    private String password;
    //省略get set方法

    //重写toString()方便测试
    @Override
    public String toString() {
        return "Users [name=" + name + ", password=" + password +  "]";
    }
}