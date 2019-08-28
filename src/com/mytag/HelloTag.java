package com.mytag;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;
import java.io.IOException;

public class HelloTag implements SimpleTag {
    JspContext jspContext=null;
    JspTag parent=null;
    //该方法是简单标签的核心方法，由容器调用完成简单标签的操作
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out=jspContext.getOut();
        out.print("<font color='blue'>Hello, A simple tag.</font><br>");
        out.print("现在的时间是：" + new java.util.Date());
    }
    //该方法由容器调用，用来设置父标签对象
    @Override
    public void setParent(JspTag jspTag) {
        this.parent=jspTag;
    }
    //返回当前标签的父标签
    @Override
    public JspTag getParent() {
        return parent;
    }
    //该方法由容器调用，用来设置JspContext对象，使其在标签处理类中可用
    @Override
    public void setJspContext(JspContext jspContext) {
        this.jspContext=jspContext;
    }
    //若标签带标签体，容器调用该方法将标签体内容存放到JspFragment中。
    @Override
    public void setJspBody(JspFragment jspFragment) {

    }
}
