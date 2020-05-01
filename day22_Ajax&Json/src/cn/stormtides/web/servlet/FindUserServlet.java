package cn.stormtides.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");

        //期望服务器响应回的数据格式{"userExsit":true,"msg":"此用户名太受欢迎，请更换一个"}
        //                           {"userExsit":false,"msg":"用户名可用"}
        response.setContentType("text/html;charset=utf-8");
        Map<String,Object> map=new HashMap<String,Object>();
        if ("tom".equals(username)){

            map.put("userExsit",true);
            map.put("msg","此用户名太受欢迎，请更换一个");
        }else {
            map.put("userExsit",false);
            map.put("msg","用户名可用");
        }
        //将map转回json，转回客户端
        ObjectMapper mapper=new ObjectMapper();
        mapper.writeValue(response.getWriter(),map);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
