package com.listener;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;
import java.time.LocalTime;

@WebListener            //使用注解注册监听器
public class MyContextListener implements ServletContextListener, ServletContextAttributeListener {
    private ServletContext context = null;

    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        context = scae.getServletContext();
        /*
        getName(): 返回发生改变的属性名
        getValue(): 返回发生改变的属性值对象。注意，当替换属性时，该方法返回的是替换之前的属性值
         */
        context.log("添加一个属性: " + scae.getName() + ": " + scae.getValue());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        context = scae.getServletContext();
        context.log("删除一个属性: " + scae.getName() + ": " + scae.getValue());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        context = scae.getServletContext();
        context.log("替换一个属性: " + scae.getName() + ": " + scae.getValue());
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Context ctx;
        DataSource dataSource = null;
        context = sce.getServletContext();  //返回状态发生改变的ServletContext对象
        try {
            ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/webstoreDS");

        } catch (NamingException e) {
            context.log("发生异常: " + e);
            e.printStackTrace();
        }
        context.setAttribute("dataSource", dataSource);
        context.log("应用程序已经启动: " + LocalTime.now());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        context = sce.getServletContext();
        context.removeAttribute("dataSource");
        context.log("应用程序已关闭: " + LocalTime.now());
    }
}
