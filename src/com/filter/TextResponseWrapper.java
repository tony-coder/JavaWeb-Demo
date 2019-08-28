package com.filter;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class TextResponseWrapper extends HttpServletResponseWrapper {
    public TextResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    //内部类扩展ServletOutputStream,把写给它的数据写到字节数组中而不发给客户
    private static class ByteArrayServletOutputStream extends ServletOutputStream {
        ByteArrayOutputStream baos;

        ByteArrayServletOutputStream(ByteArrayOutputStream baos) {
            this.baos = baos;
        }

        @Override
        public boolean isReady() {
            return true;
        }

        @Override
        public void setWriteListener(WriteListener writeListener) {

        }

        @Override
        public void write(int b) throws IOException {
            baos.write(b);
        }
    }

    // PrintWriter和ServletOutputStream使用的字节数组输出流
    private ByteArrayOutputStream baos = new ByteArrayOutputStream();
    // 由ByteArrayOutputStream创建PrintWriter
    private PrintWriter pw = new PrintWriter(baos);
    // 由ByteArrayOutputStream创建ServletOutputStream
    private ByteArrayServletOutputStream basos = new ByteArrayServletOutputStream(baos);

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return basos;  //返回定制的ServletOutputStream对象 使用字节数组输出流
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return pw;  //返回定制的PrintWriter 使用字节数组输出流
    }
    // 将字节输出流转换成字节数组
    byte[] toByteArray() {
        return baos.toByteArray();
    }
}
