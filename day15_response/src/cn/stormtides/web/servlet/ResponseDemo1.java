package cn.stormtides.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重定向
 */
@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("demo1....");

        request.setAttribute("mag","response");
//第一种方法
//        //设置状态码为302
//        response.setStatus(302);
//        //设置响应头location
//        response.setHeader("location","/day15/responseDemo2");



        //第二种方法
        //简单的重定向方法
//        response.sendRedirect("/day15/responseDemo2");

//        //第三种，动态获取虚拟目录
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath+"/responseDemo2");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
