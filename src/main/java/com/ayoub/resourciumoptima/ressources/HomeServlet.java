package com.ayoub.resourciumoptima.ressources;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "homeServlet",value = "/")
public class HomeServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session= req.getSession();
        //System.out.println(session.getAttribute("currentUser"));
        if(session.getAttribute("currentUser")==null){
            System.out.println("login");
            resp.sendRedirect("login.jsp");
        }else {
            System.out.println("index");
            resp.sendRedirect("home.jsp");

        }
    }
}
