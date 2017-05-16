package com.ssm.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssm.model.Teacher;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by yang on 16/05/2017.
 */
public class Util {

    public static Collection getJSON() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        String fullPath = Util.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        Teacher[] teachers = objectMapper.readValue(new File(fullPath + "testdata.json"), Teacher[].class);

        return Arrays.asList(teachers);
    }
}
