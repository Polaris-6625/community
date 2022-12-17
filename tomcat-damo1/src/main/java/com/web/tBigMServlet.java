package com.web;

import com.alibaba.fastjson.JSON;
import example.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import until.Tools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/tBigMServlet")
public class tBigMServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SqlSessionFactory sqlSessionFactory = Tools.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // informationMapper inMapper = sqlSession.getMapper(informationMapper.class);
        informationMapper inMapper = sqlSession.getMapper(informationMapper.class);
        int TrafficCount = inMapper.selectTraffic("traffic");
        TrafficL trafficL = new TrafficL();
        trafficL.setTraffic("traffic");
        String TrafficCountNew = TrafficCount+"";
        trafficL.setCount_1(TrafficCountNew);
        System.out.println(trafficL.getCount_1());

        ServeL serveL = new ServeL();
        //serveL.setServe("serve");
        int ServeCount = inMapper.selectServe("serve");
        serveL.setServe("serve");
        String ServeCountNew = ServeCount+"";
        serveL.setCount_2(ServeCountNew);

        SafeL safeL = new SafeL();
        int SaveCount = inMapper.selectSave("save");
        safeL.setSafe("save");
        String SaveCountNew = SaveCount+"";
        safeL.setCount_3(SaveCountNew);

        ActiL actiL = new ActiL();
        int ActiCount = inMapper.selectActi("acti");
        actiL.setActi("acti");
        String ActiCountNew = ActiCount+"";
        actiL.setCount_4(ActiCountNew);

        BeafL beafL = new BeafL();
        int BeafCount = inMapper.selectBeaf("beaf");
        beafL.setBeaf("beaf");
        String BeafCountNew = BeafCount+"";
        beafL.setCount_5(BeafCountNew);

        MaintainL maintainL = new MaintainL();
        int MaintainCount = inMapper.selectMaintain("maintain");
        maintainL.setMaintain("maintain");
        String MaintainCountNew = MaintainCount+"";
        maintainL.setCount_6(MaintainCountNew);


        PlayL playL = new PlayL();
        int PlayCount = inMapper.selectPlay("play");
        playL.setPlay("play");
        String PlayCountNew = "" + PlayCount;
        playL.setCount_e(PlayCountNew);


        ElseLL elseLL = new ElseLL();
        int ElseLCount = inMapper.selectElseL("elseL");
        elseLL.setElseL("elseL");
        String ElseLCountNew = ElseLCount+"";
        elseLL.setCount_7(ElseLCountNew);

        System.out.println("finish all");

        String Json_1 = JSON.toJSONString(trafficL);
        System.out.println(Json_1);
        resp.setContentType("test/json;charset=utf-8");
        resp.getWriter().write(Json_1);

        String Json_2 = JSON.toJSONString(serveL);
        System.out.println(Json_2);
        resp.setContentType("test/json;charset=utf-8");
        resp.getWriter().write(Json_2);

        String Json_3 = JSON.toJSONString(safeL);
        System.out.println(Json_3);
        resp.setContentType("test/json;charset=utf-8");
        resp.getWriter().write(Json_3);

        String Json_4 = JSON.toJSONString(actiL);
        System.out.println(Json_4);
        resp.setContentType("test/json;charset=utf-8");
        resp.getWriter().write(Json_4);

        String Json_5 = JSON.toJSONString(beafL);
        System.out.println(Json_5);
        resp.setContentType("test/json;charset=utf-8");
        resp.getWriter().write(Json_5);

        String Json_6 = JSON.toJSONString(maintainL);
        System.out.println(Json_6);
        resp.setContentType("test/json;charset=utf-8");
        resp.getWriter().write(Json_6);

        String Json_7 = JSON.toJSONString(elseLL);
        System.out.println(Json_7);
        resp.setContentType("test/json;charset=utf-8");
        resp.getWriter().write(Json_7);

        String Json_e = JSON.toJSONString(playL);
        resp.setContentType("test/json;charset=utf-8");
        resp.getWriter().write(Json_e);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
