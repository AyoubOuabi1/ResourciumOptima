<%@ page import="com.ayoub.resourciumoptima.Config.EntityManagerFct" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
        EntityManagerFct.getEntityManagerFactory();

        response.sendRedirect("/ResourciumOptima_war/employees");
%>

