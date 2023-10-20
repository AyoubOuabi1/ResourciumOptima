<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%--
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
--%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- CSRF Token -->
  <meta name="csrf-token" content="<%= request.getAttribute("org.springframework.security.web.csrf.CsrfToken") %>">
  <title>Resourcium Optima</title>
  <link rel="stylesheet"
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i&amp;display=swap">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
        integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.9.1/font/bootstrap-icons.min.css"
        integrity="sha512-5PV92qsds/16vyYIJo3T/As4m2d8b6oWYfoqV+vtizRB6KhF1F9kYzWzQmsO6T3z3QG2Xdhrx7FQ+5R1LiQdUA=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
  <link rel="stylesheet" href="http://localhost:8080/ResourciumOptima_war/fonts/fontawesome-all.min.css"/>
  <link rel="stylesheet" href="http://localhost:8080/ResourciumOptima_war/bootstrap/css/bootstrap.min.css"/>
  <link rel="stylesheet" href="http://localhost:8080/ResourciumOptima_war/style/style.css"/>
</head>
<body id="page-top">
<div id="wrapper">
  <%@ include file="sidebar.jsp" %>
  <div class="d-flex flex-column" id="content-wrapper">
    <div id="content">
      <%@ include file="header.jsp" %>
      <div class="container-fluid overflow-auto" style="max-height: 80vh">