package com.ssm.service;

import com.ssm.mapper.TeacherMapper;
import com.ssm.model.ResponseData;
import com.ssm.model.Teacher;
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

    private static ApplicationContext ctx;
    private static TeacherMapper teacherMapper;

    static {

        // spring-mybatis
        try {
            ctx = new ClassPathXmlApplicationContext("spring-mybatis.xml");
            teacherMapper = (TeacherMapper) ctx.getBean("teacherMapper");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public @ResponseBody Teacher getTeacher(@PathVariable int id) {

        Teacher teacher = teacherMapper.selectTeacherByID(id);
        return teacher;
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Teacher> getAllTeacher() {

        List<Teacher> teachers = teacherMapper.selectTeachers();
        return teachers;
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody ResponseData addTeacher(@RequestBody Teacher teacher) {

        ResponseData responseData = new ResponseData();
        teacherMapper.addTeacher(teacher);
        responseData.setSuccess(true);
        return responseData;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public @ResponseBody ResponseData updateTeacher(@RequestBody Teacher teacher, @PathVariable int id) {

        ResponseData responseData = new ResponseData();
        Teacher teacherForUpdate = teacherMapper.selectTeacherByID(id);
        teacherForUpdate.setName(teacher.getName());
        teacherForUpdate.setRate(teacher.getRate());
        // to finish all setter...
        teacherMapper.updateTeacher(teacherForUpdate);

        responseData.setSuccess(true);
        return responseData;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public @ResponseBody ResponseData deleteTeacher(@PathVariable int id) {

        ResponseData responseData = new ResponseData();
        teacherMapper.deleteTeacher(id);

        responseData.setSuccess(true);
        return responseData;
    }

}
