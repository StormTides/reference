package cn.itcast.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
*1. 获取请求方式 ：GET
    * String getMethod()
2. (*)获取虚拟目录：/day14
    * String getContextPath()
3. 获取Servlet路径: /demo1
    * String getServletPath()
4. 获取get方式请求参数：name=zhangsan
    * String getQueryString()
5. (*)获取请求URI：/day14/demo1
    * String getRequestURI(): /day14/demo1
    * StringBuffer getRequestURL() :http://localhost:8080/day14/demo1

    * URL:统一资源定位符 ： http://localhost:8080/**1/**2
    * URI：统一资源标识符 : /**1/**2

6. 获取协议及版本：HTTP/1.1
    * String getProtocol()

7. 获取客户机的IP地址：
    * String getRemoteAddr()
* */
@WebServlet("/requestDemo1")
public class RequestDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getMethod();
        System.out.println("获取请求方式 ："+method);

        String contextPath = request.getContextPath();
        System.out.println("获取虚拟目录："+contextPath);

        String servletPath = request.getServletPath();
        System.out.println("获取Servlet路径:"+servletPath);

        String queryString = request.getQueryString();
        System.out.println("获取get方式请求参数："+queryString);

        String requestURI = request.getRequestURI();
        System.out.println("URI:"+requestURI);
        StringBuffer requestURL = request.getRequestURL();
        System.out.println("URL:"+requestURL);

        String protocol = request.getProtocol();
        System.out.println("获取协议及版本："+protocol);

        String remoteAddr = request.getRemoteAddr();
        System.out.println("获取客户机的IP地址："+remoteAddr);
    }
}
