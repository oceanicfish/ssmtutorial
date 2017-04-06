package com.ssm.mapper;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.ssm.model.Teacher;

import java.util.List;

/**
 * Created by yang on 06/04/2017.
 */
public interface TeacherMapper {

    public Teacher selectTeacherByID(int id);
    public List<Teacher> selectTeachers();

}
