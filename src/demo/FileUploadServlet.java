package demo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@WebServlet(name = "FileUploadServlet", urlPatterns = "/helloweb/fileUpload.do")
@MultipartConfig(location = "D:\\",fileSizeThreshold = 1024)  //必须使用
public class FileUploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //返回web应用程序文档根目录
        String path = this.getServletContext().getRealPath("/");
        String id = request.getParameter("id");
        Part p = request.getPart("fileName");

        String message = "";
        if (p.getSize() > 1024 * 1024) {  //上传的文件不能超过1MB大小
            p.delete();
            message = "文件太大，不能上传";
        } else {
            path = path + "member\\" + id;
            File f = new File(path);
            if (!f.exists()) {  //若目录不存在，则创建目录
                f.mkdirs();
            }
            String h = p.getHeader("content-disposition");
            //得到文件名
            //例：Content-Disposition:from-data;name="filename";filename="C:\study\HelloWorld.java"
            String fname = h.substring(h.lastIndexOf(";") + 12, h.length() - 1);

            p.write(path + "\\" + fname);
            message=("文件上传成功");
        }
        request.setAttribute("message", message);
        RequestDispatcher rd = request.getRequestDispatcher("/fileUpload.jsp");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
