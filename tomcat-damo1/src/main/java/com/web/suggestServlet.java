package com.web;

//import example.informationMapper;
import example.informationMapper;
import example.suggestInformaition;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import until.Tools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

//
@WebServlet("/suggestServlet")
public class suggestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SqlSessionFactory sqlSessionFactory = Tools.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
       // informationMapper inMapper = sqlSession.getMapper(informationMapper.class);
        informationMapper inMapper = sqlSession.getMapper(informationMapper.class);
        System.out.println("======="+inMapper.getClass());
        String TempA = req.getParameter("act");
        TempA = new String(TempA.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        String TempB = req.getParameter("cho");
        if(TempA != null && TempB != null){
            System.out.println("1");
//            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//            suggestInformaition suggestinformaition = (suggestInformaition) applicationContext.getBean("suggestinformaition");
            suggestInformaition suggestinformaition = new suggestInformaition();
            suggestinformaition.setAct(TempA);
            suggestinformaition.setActClass(TempB);
            System.out.println(suggestinformaition);
            inMapper.addSug(suggestinformaition);

            sqlSession.commit();
            System.out.println("finish");
            resp.sendRedirect("Main.html");

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
