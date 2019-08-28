package com.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;

@WebListener
public class MySessionListener implements HttpSessionListener {
    private ServletContext context = null;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();  //HttpSessionEvent对象方法，返回状态发生改变的会话对象
        context = session.getServletContext();
        ArrayList<HttpSession> sessionArrayList = (ArrayList<HttpSession>) context.getAttribute("sessionList");
        if (sessionArrayList == null) {
            sessionArrayList = new ArrayList<>();
            sessionArrayList.add(session);
            context.setAttribute("sessionList", sessionArrayList);
        } else {
            sessionArrayList.add(session);
        }
        context.log("创建一个对话: " + session.getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        context = session.getServletContext();
        ArrayList<HttpSession> sessionArrayList = (ArrayList<HttpSession>) context.getAttribute("sessionList");
        sessionArrayList.remove(session);
        context.log("销毁一个会话: " + session.getId());
    }
}
