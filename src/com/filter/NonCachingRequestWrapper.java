package com.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * NonCachingRequestWrapper扩展了HttpServletRequestWrapper类，覆盖了hetHeader()方法
 */
public class NonCachingRequestWrapper extends HttpServletRequestWrapper {
    public NonCachingRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getHeader(String name) {
        //隐藏If-Modified-Since头值
        if (name.equals("If-Modified-Since")) {
            return null;
        } else {
            return super.getHeader(name);
        }
    }
}
