package cn.stormtides.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/responseDemo4")
public class ResponseDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取流对象之前，设置流的默认编码
//        response.setCharacterEncoding("UTF-8");

        //告诉浏览器，服务器发送的消息体数据编码，建议使用该编码解码
//        response.setHeader("content-type","text/html;charset=utf-8");

        //简单的设置编码
        response.setContentType("text/html;charset=utf-8");

        //获取字符输出流
        PrintWriter pw = response.getWriter();
        //输出数据
        //pw.write("hello response...");
        pw.write("你好 response");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
