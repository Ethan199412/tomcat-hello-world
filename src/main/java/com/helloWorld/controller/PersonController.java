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

@WebServlet("/person")
public class PersonController extends HttpServlet {
    private PersonService personService = new PersonService();
    private Gson gson = new Gson();

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        //out.println("{a:1,b:2,c:3,d:4,e:5,f:6}");

        List<User> users = this.personService.getAll();

        String json = gson.toJson(users);
        out.println(json);
    }
}
