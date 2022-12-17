package com.web;

import example.MainInformation;
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
import java.util.Calendar;

@WebServlet("/addMainInf")
public class addMainInf extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SqlSessionFactory sqlSessionFactory = Tools.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        informationMapper inMapper = sqlSession.getMapper(informationMapper.class);
        req.setCharacterEncoding("UTF-8");

        String number = req.getParameter("number");
        number = new String(number.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        String lcofhome = req.getParameter("lcofhome");
        lcofhome = new String(lcofhome.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        Calendar cal=Calendar.getInstance();
        int y=cal.get(Calendar.YEAR);
        System.out.println(y);
        int m=cal.get(Calendar.MONTH);
        System.out.println(m);
        int d=cal.get(Calendar.DATE);
        System.out.println(d);
        int h=cal.get(Calendar.HOUR_OF_DAY);
        System.out.println(h);
        int mi=cal.get(Calendar.MINUTE);
        System.out.println(mi);
        int s=cal.get(Calendar.SECOND);
        System.out.println(s);
        System.out.println("-------------");
        String time = ""+y+"-"+m+"-"+d+"-"+h+":"+mi+":"+s;
        System.out.println(time);
        String mofhome = req.getParameter("mofhome");
        mofhome = new String(mofhome.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        String hofhome = req.getParameter("hofhome");
        hofhome = new String(mofhome.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        String cofhome = req.getParameter("cofhome");
        cofhome = new String(mofhome.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        String singlemoney = req.getParameter("singlemoney");
        singlemoney = new String(mofhome.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        int sing = Integer.parseInt(singlemoney);
        String sofhome = req.getParameter("sofhome");
        sofhome = new String(mofhome.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        float sh = Float.parseFloat(sofhome);
        String description = req.getParameter("description");
        description = new String(description.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        if(!number.equals("") && !time.equals("") && !description.equals("") && !lcofhome.equals("")){
            System.out.println();
            ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");
            MainInformation mainInformation = (MainInformation) application.getBean("mainInformation");
//            MainInformation mainInformation = new MainInformation();
            mainInformation.setNumber(number);
            mainInformation.setMofhome(mofhome);
            mainInformation.setTime(time);
            mainInformation.setLcofhome(lcofhome);
            mainInformation.setCofhome(cofhome);
            System.out.println("cofhome is :"+cofhome);
            mainInformation.setHofhome(hofhome);
            mainInformation.setSinglemoney(sing);
            mainInformation.setSofhome(sh);
            mainInformation.setDescription(description);
            inMapper.addMInf(mainInformation);
            sqlSession.commit();
            System.out.println("增加完成");
            resp.sendRedirect("Main_new.html");
        }
        sqlSession.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
