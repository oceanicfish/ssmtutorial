package com.ssm.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssm.model.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by yang on 05/04/2017.
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //create a new account, set account properties
        Account myAccount = new Account();
        myAccount.setName("my account");
        myAccount.setAddress("I don't know");
        myAccount.setContact("yang");
        myAccount.setLatitude(123.987654323456);
        myAccount.setLongtitude(10.1234563);
        myAccount.setTelephone("12345678");

        //输出json
        PrintWriter out = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(out, myAccount);
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
