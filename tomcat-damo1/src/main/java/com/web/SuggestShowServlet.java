package com.web;

import com.alibaba.fastjson.JSON;
import example.informationMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import until.Tools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/SuggestShowServlet")
public class SuggestShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String choice = req.getParameter("choice");
        SqlSessionFactory sqlSessionFactory = Tools.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        informationMapper inMapper = sqlSession.getMapper(informationMapper.class);
        System.out.println(choice);
        if(choice!=null){
            if(choice.equals("traffic")){
                List<String> TrafficArray = inMapper.TrafficOF();
                System.out.println(TrafficArray);
                String TrafficJSON = JSON.toJSONString(TrafficArray);
                System.out.println(TrafficJSON);
                resp.setContentType("test/json;charset=utf-8");
                resp.getWriter().write(TrafficJSON);
            }
            if(choice.equals("serve")){
                List<String> ServeArray = inMapper.ServeOF();
                String ServeJSON = JSON.toJSONString(ServeArray);
                resp.setContentType("test/json;charset=utf-8");
                resp.getWriter().write(ServeJSON);
            }
            if(choice.equals("safe")){
                List<String> SafeArray = inMapper.SaveOF();
                String SafeJSON = JSON.toJSONString(SafeArray);
                resp.setContentType("test/json;charset=utf-8");
                resp.getWriter().write(SafeJSON);
            }
            if(choice.equals("acti")){
                List<String> ActiArray = inMapper.ActiOF();
                String ActiJSON = JSON.toJSONString(ActiArray);
                resp.setContentType("test/json;charset=utf-8");
                System.out.println(ActiJSON);
                resp.getWriter().write(ActiJSON);
            }
            if(choice.equals("beaf")){
                List<String> BeafArray = inMapper.BeafOF();
                String BeafJSON = JSON.toJSONString(BeafArray);
                resp.setContentType("test/json;charset=utf-8");
                resp.getWriter().write(BeafJSON);
            }
            if(choice.equals("Maintain")){
                List<String> MainTainArray = inMapper.MaintainOF();
                String MainTainJSON = JSON.toJSONString(MainTainArray);
                resp.setContentType("test/json;charset=utf-8");
                resp.getWriter().write(MainTainJSON);
            }
            if (choice.equals("play")){
                List<String> PlayArray = inMapper.PlayOF();
                String PlayJSON = JSON.toJSONString(PlayArray);
                resp.setContentType("test/json;charset=utf-8");
                resp.getWriter().write(PlayJSON);
            }
            if(choice.equals("elseL")){
                List<String> ElseLArray = inMapper.ElseLOF();
                String ElseLJSON = JSON.toJSONString(ElseLArray);
                resp.setContentType("test/json;charset=utf-8");
                resp.getWriter().write(ElseLJSON);
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
