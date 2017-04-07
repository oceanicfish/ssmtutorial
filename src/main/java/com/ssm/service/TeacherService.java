package com.ssm.service;

import com.ssm.mapper.TeacherMapper;
import com.ssm.model.ResponseData;
import com.ssm.model.Teacher;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.util.List;

/**
 * Created by yang on 06/04/2017.
 */
@Controller
@RequestMapping("/teacher")
public class TeacherService {

    private static SqlSessionFactory sessionFactory;
    private static SqlSession session;
    private static ApplicationContext ctx;
    private static TeacherMapper teacherMapper;

    static {
        String mybatisResource = "mybatis.xml";

        /* 使用类加载器加载mybatis的配置文件（它也加载关联的映射文件） */
        try{
            InputStream ins = Resources.getResourceAsStream(mybatisResource);
            //构建sqlSession的工厂
            sessionFactory = new SqlSessionFactoryBuilder().build(ins);
            //创建能执行映射文件中sql的sqlSession
            session = sessionFactory.openSession();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public @ResponseBody Teacher getTeacher(@PathVariable int id) {

        TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
        Teacher teacher = teacherMapper.selectTeacherByID(id);

        return teacher;
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Teacher> getAllTeacher() {

        TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);

        List<Teacher> teachers = teacherMapper.selectTeachers();

        return teachers;
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody ResponseData addTeacher(@RequestBody Teacher teacher) {
        ResponseData responseData = new ResponseData();

        TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
        teacherMapper.addTeacher(teacher);
        session.commit();
        responseData.setSuccess(true);
        return responseData;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public @ResponseBody ResponseData updateTeacher(@RequestBody Teacher teacher, @PathVariable int id) {
        ResponseData responseData = new ResponseData();

        TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
        Teacher teacherForUpdate = teacherMapper.selectTeacherByID(id);
        teacherForUpdate.setName(teacher.getName());
        teacherForUpdate.setRate(teacher.getRate());
        // to finish all setter...
        teacherMapper.updateTeacher(teacherForUpdate);
        session.commit();

        responseData.setSuccess(true);
        return responseData;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public @ResponseBody ResponseData deleteTeacher(@PathVariable int id) {
        ResponseData responseData = new ResponseData();

        TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
        teacherMapper.deleteTeacher(id);
        session.commit();

        responseData.setSuccess(true);
        return responseData;
    }

}
