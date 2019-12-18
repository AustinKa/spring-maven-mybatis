package net.wanho.service;

import net.wanho.pjo.User;

/**
 * Created by Administrator on 2019/12/17.
 */
public interface UserServiceI {
    void addUser(User user);
    User getUsername(String username);
    String shiroMD5(String password,String salt);
}
