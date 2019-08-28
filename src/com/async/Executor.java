package com.async;

import javax.servlet.AsyncContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

public class Executor implements Runnable {
    private AsyncContext asyncContext = null;

    public Executor(AsyncContext asyncContext) {
        this.asyncContext = asyncContext;
    }

    @Override
    public void run() {
        try {
            //等待10秒钟，以模拟业务方法的执行
            Thread.sleep(10000);
            PrintWriter out = asyncContext.getResponse().getWriter();
            out.println("业务处理完毕的时间: " + LocalTime.now() + ".<br>");
            out.flush();
            asyncContext.complete();  //结束异步线程
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
