package com.ayoub.resourciumoptima;

import java.io.*;

import com.ayoub.resourciumoptima.entities.Department;
import com.ayoub.resourciumoptima.entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Department em=new Department();
        em.setName(request.getParameter("name"));
        entityManager.getTransaction().begin();
        entityManager.persist(em);
        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        new PrintWriter(response.getWriter()).println(em.getName());

    }

    public void destroy() {
    }
}