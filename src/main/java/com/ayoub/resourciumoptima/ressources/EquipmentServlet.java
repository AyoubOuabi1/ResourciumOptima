package com.ayoub.resourciumoptima.ressources;


import com.ayoub.resourciumoptima.Services.EquipmentService;
import com.ayoub.resourciumoptima.entities.Department;
import com.ayoub.resourciumoptima.entities.Employee;
import com.ayoub.resourciumoptima.entities.Equipment;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.SneakyThrows;

import  java.sql.Date;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDate;
 import java.util.List;
import java.util.Optional;

@WebServlet(name="EquipmentServlet", urlPatterns = "/equipments")

public class EquipmentServlet extends HttpServlet {

    EquipmentService equipmentService;

    @Override
    public void init() throws ServletException {
        equipmentService=new EquipmentService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session= req.getSession();
        if (session.getAttribute("currentUser") == null) {
            System.out.println("login");
            resp.sendRedirect("/ResourciumOptima_war/login");
        }else {
            Optional<List<Equipment>> equipments = equipmentService.getEquipments();
            req.setAttribute("equipmentList", equipments);
            RequestDispatcher rd=req.getRequestDispatcher("views/layouts/equipment.jsp");
            rd.forward(req,resp);
        }
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException ,RuntimeException{
        String action = req.getParameter("action");
        if (action.equals("delete")) {
            Long id = Long.valueOf(req.getParameter("equipmentId"));

            equipmentService.removeEquipment(id);
        }else if (action.equals("create")){
            equipmentService.saveEquipment(getEquipment(req));

        } else if (action.equals("update")) {
            equipmentService.updateEquipment(getEquipment(req));

        }
    }

    Equipment getEquipment(HttpServletRequest req) throws ParseException {
        Equipment equipment = new Equipment();
        equipment.setName(req.getParameter("name"));
        equipment.setType(req.getParameter("type"));
        equipment.setPurchaseDate(Date.valueOf(req.getParameter("purchaseDate")));
        equipment.setStatus("available");
        Date date= new Date(System.currentTimeMillis());
        equipment.setMaintenance_date(date);
        return equipment;
    }
}
