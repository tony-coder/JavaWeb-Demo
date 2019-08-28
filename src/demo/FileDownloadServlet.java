package demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@WebServlet(name = "FileDownloadServlet", urlPatterns = "/fileDownload.do")
public class FileDownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置文件的内容类型
        response.setContentType("image/gif");
        //设置Content-Disposition响应头，指定文件名

        /**Content-disposition 是 MIME 协议的扩展，MIME 协议指示 MIME 用户代理如何显示附加的文件。
         *  Content-disposition其实可以控制用户请求所得的内容存为一个文件的时候提供一个默认的文件名，
         *  文件直接在浏览器上显示或者在访问时弹出文件下载对话框。
         */
        response.setHeader("Content-Disposition", "attachment;filename=duke.gif");

        //获得输出流对象
        OutputStream output = response.getOutputStream();
        ServletContext context = getServletContext();
        //返回输入流对象
        InputStream input = context.getResourceAsStream("/files/duke.gif");  //相对于该web应用程序的文档根目录

        byte[] bytearray = new byte[1024];
        int bytesread = 0;
        //从输入流中读取1KB，然后写道输出流中
        //int read(byte[] b) 将数据读入byte[]，返回实际读取的字节数
        while ((bytesread = input.read(bytearray)) != -1) {
            output.write(bytearray, 0, bytesread);
        }
        output.flush();
        input.close();
    }
}
