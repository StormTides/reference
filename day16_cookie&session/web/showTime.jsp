<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URLDecoder" %>

<%--
  Created by IntelliJ IDEA.
  User: uni
  Date: 2020/4/24
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>StormTides</title>
</head>
<body>
<%

    boolean flag=false;

    //1.获取所有Cookie
    Cookie[] cookies = request.getCookies();
    //2.遍历cookie数组
    if (cookies!=null&&cookies.length>0){
        for (Cookie cookie:cookies){
            //3.获取cookie的名称
            String name=cookie.getName();
            //4.判断cookie名称是否是：lastTime
            if ("lastTime".equals(name)){
                //第一次访问会存储name="lastTime",返回结果如果是true，则不是第一次访问
                //有lastTime的cookie

                flag=true;

                //设置Cookie的value
                //获取当前时间的字符串，重新设置Cookie的值，重新发送cookie
                Date date=new Date();
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                String str_date = sdf.format(date);

                //URL编码
                System.out.println("编码前："+str_date);
                str_date= URLEncoder.encode(str_date,"utf-8");
                System.out.println("编码后："+str_date);

                cookie.setValue(str_date);

                //设置cookie的存活时间
                cookie.setMaxAge(60*60*24*30);//一个月
                response.addCookie(cookie);

                //响应数据
                //获取Cookie的value，时间
                String value = cookie.getValue();

                //URL解码：
                System.out.println("解码前:"+value);
                value= URLDecoder.decode(value,"utf-8");
                System.out.println("解码后:"+value);

                out.write("<h1>欢迎回来，你上次访问的时间"+value+"</h1>");

                break;

            }
        }
    }


    if (cookies == null || cookies.length == 0 || flag == false ){
        //第一次访问
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String str_date = sdf.format(date);

        System.out.println("编码前："+str_date);
        str_date= URLEncoder.encode(str_date,"utf-8");
        System.out.println("编码后："+str_date);

        Cookie cookie=new Cookie("lastTime",str_date);

        cookie.setValue(str_date);

        cookie.setMaxAge(60*60*24*30);
        response.addCookie(cookie);
        out.write("<h1>欢迎回来，首次登陆</h1>");

    }



%>



</body>
</html>
