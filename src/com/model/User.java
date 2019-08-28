package com.model;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

//实现HttpSessionBindingListener的对象不必注册，而是当相应事件发生时由容器调用对象相应的方法
public class User implements HttpSessionBindingListener {
    private String username;
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        HttpSession session = event.getSession();
        session.getServletContext().log("用户名: " + username + ", 口令" + password + " 登录系统.");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        HttpSession session = event.getSession();
        session.getServletContext().log("用户名: " + username + "口令: " + password + " 退出系统.");
    }
}
