package com.ssm.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssm.model.Teacher;
import com.ssm.test.Util;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

/**
 * Created by yang on 16/05/2017.
 */
@RunWith(Parameterized.class)
public class TeacherServiceTest {

    @Parameterized.Parameter
    public Teacher teacher;


    public TeacherServiceTest() {

    }

    @Parameterized.Parameters
    public static Collection testData() throws Exception {
        return Util.getJSON();
    }

    @Test
    public void getTeacher() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();

        TeacherService service = new TeacherService();
        Teacher acutalTeacher = service.getTeacher(teacher.getId());

        Assert.assertEquals(objectMapper.writeValueAsString(teacher), objectMapper.writeValueAsString(acutalTeacher));
    }

}