package cn.itcast.web.request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/requestDemo8")
public class requestDemo8 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //请求转发
        System.out.println("demo888888被访问了");

        request.setAttribute("msg","hello");
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/requestDemo9");
//        requestDispatcher.forward(request,response);

        request.getRequestDispatcher("/requestDemo9").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get获取请求参数
//        String username = request.getParameter("username");
//        System.out.println("get");
//        System.out.println(username);

        this.doPost(request,response);
    }
}
