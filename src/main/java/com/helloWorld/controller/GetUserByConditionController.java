package com.helloWorld.controller;
// https://mvnrepository.com/artifact/mysql/mysql-connector-java

import com.google.gson.Gson;
import com.helloWorld.entity.User;
import com.helloWorld.service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/getUserByCondition")
public class GetUserByConditionController extends HttpServlet {
    private PersonService personService = new PersonService();
    private Gson gson = new Gson();

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/json;charset=UTF-8");
        PrintWriter out = res.getWriter();

        String idStr = req.getParameter("id");
        Integer id = null;
        System.out.println("idStr:"+idStr);

        if(idStr != null){
            id = Integer.valueOf(idStr);
        }
        String username = req.getParameter("username");
        String addr = req.getParameter("addr");
        String gender = req.getParameter("gender");
        User user = new User();
        user.setAddr(addr);
        user.setId(id);
        user.setUsername(username);
        user.setGender(gender);

        List<User> users = this.personService.getUserByCondition(user);

        String json = gson.toJson(users);
        out.println(json);
    }

}
