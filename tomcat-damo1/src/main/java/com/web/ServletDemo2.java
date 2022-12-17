package com.web;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;


@WebServlet("/demo4")
public class ServletDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("乱码测试");
        String hThe = req.getParameter("resl");
        if (hThe != null){
            String str = new String(hThe.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
            System.out.println(str);
            boolean b = false;
            int flag0 = 0;
            int flag1 = 0;
            int flag2 = 0;
            int flag3 = 0;
            String[] S1 = {"废纸","报纸","布","杂志","书","包装","办公用纸","报刊","报","盒","塑料","袋","笔","牙刷","餐具","玻璃","瓶","罐","管","镜","杯","盖","金属","钢","铁","铜","铝","钉","螺丝","冒","帽","合金","导","线","箔","网","被","褥","裤","袜","鞋","衣","套","金","电子"};
            for(String it:S1)
            {
                b = str.contains(it);
                if(b==true)
                    flag1 =flag1 + 1;
            }
            if(flag1 != 0)
            {
                str+="是可回收垃圾";
                flag0 = 1;
            }
            String[] S2 = {"菜","厨","骨","鱼","汤","羹","肉","泡","椒","豆","料","香蕉皮","汁","叶","梗","茎","蛋","粥","馒头","花卷","馅","饺子","蒸","糕","点心","冰淇淋","冰棍","食","血","渣","末"};
            b = false;
            for(String it:S2)
            {
                b = str.contains(it);
                if(b==true)
                    flag2 =flag2 + 1;
            }
            if(flag2 != 0)
            {
                str+="是厨余垃圾(湿垃圾)";
                flag0 = 1;
            }
            String[] S3 = {"过期","胶","药","电池","水银","荧","化","毒","漆"};
            b = false;
            for(String it:S3)
            {
                b = str.contains(it);
                if(b==true)
                    flag3 =flag3 + 1;
            }
            if(flag3 != 0)
            {
                str+="是有害垃圾";
                flag0 = 1;
            }
            if(flag0 == 0)
                str+="是其他垃圾(干垃圾)";
            System.out.println(str);

            resp.setContentType("application/json;charset=utf-8");
            String strN = JSON.toJSONString(str);
            System.out.println("JSON是:"+strN);
//            resp.getWriter().write(strN);


            StringBuilder sb = new StringBuilder("{");
            sb.append("\"name\"").append(":").append(strN);
            sb.append("}");

            resp.getWriter().print(sb);
            System.out.println(sb);

//            resp.getWriter().write(str);
//            resp.sendRedirect("ceshi4.html");
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
//        String headers = req.getHeader("User-agent");
//        System.out.println("headers为"+headers);
//        StringBuffer URL = req.getRequestURL();
//        System.out.println(URL);
//        String query = req.getQueryString();
//        System.out.println(query);
//        System.out.println("get");
//        Map<String,String[]> map = req.getParameterMap();
//        for(String key : map.keySet()) {
//            System.out.print(key + ':');
//            String[] values = map.get(key);
//            for (String it : values) {
//                System.out.print(it);
//            }
//            System.out.println();
//        }
//        String name = req.getParameter("name");
//        resp.setHeader("content-type","text/html;charset=utf-8");
//        resp.getWriter().write("<h1>"+name+"欢迎您!</h1>");
    }
}
