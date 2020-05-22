package cn.stormtides.web.servlet;

import cn.stormtides.domain.Province;
import cn.stormtides.service.ProvinceService;
import cn.stormtides.service.impl.ProvinceServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/provinceServlet")
public class provinceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //调用service查询
        ProvinceService service=new ProvinceServiceImpl();

//        //使用普通过程
//        List<Province> list = service.findAll();
//        //序列化list为json
//        ObjectMapper mapper=new ObjectMapper();
//        String json=mapper.writeValueAsString(list);

        //使用redis缓存
        String json=service.findAllJson();


        System.out.println(json);

        //响应结果
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
