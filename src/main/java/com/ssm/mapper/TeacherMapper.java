package com.ssm.mapper;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.ssm.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by yang on 06/04/2017.
 */
public interface TeacherMapper {

    @Autowired
    public Teacher selectTeacherByID(int id);
    @Autowired
    public List<Teacher> selectTeachers();
    @Autowired
    public void addTeacher(Teacher teacher);
    @Autowired
    public void updateTeacher(Teacher teacher);
    @Autowired
    public void deleteTeacher(int id);

}
