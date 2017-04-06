package com.ssm.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssm.mapper.TeacherMapper;
import com.ssm.model.Account;
import com.ssm.model.Teacher;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;

/**
 * Created by yang on 05/04/2017.
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    private static SqlSessionFactory sessionFactory;
    private static Reader reader;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        //连接数据库
        reader = Resources.getResourceAsReader("mybatis.xml");
        sessionFactory = new SqlSessionFactoryBuilder().build(reader);

        //打开一个sql session
        SqlSession sqlSession = sessionFactory.openSession();

        //将sql session 映射到 mapper类
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = teacherMapper.selectTeacherByID(8003);

        //输出json
        PrintWriter out = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(out, teacher);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
