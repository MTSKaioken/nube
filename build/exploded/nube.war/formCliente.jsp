<%-- 
    Document   : ClienteCriado
    Created on : 12 de mar de 2022, 01:08:22
    Author     : mtskaioken
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <title>Criar Clientes</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://bootswatch.com/5/sketchy/bootstrap.css" rel="stylesheet"><link href="https://bootswatch.com/5/sketchy/bootstrap.min.css" rel="stylesheet">

        
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
          <div class="container-fluid">
            <a class="navbar-brand" href="/">CRUD Web</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor02" aria-controls="navbarColor02" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarColor02">
              <ul class="navbar-nav me-auto">
                <li class="nav-item">
                  <a class="nav-link active" href="/">Home
                    <span class="visually-hidden">(current)</span>
                  </a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="/clientes?action=create">Criar</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="/clientes?action=list">Listar</a>
                </li>
              </ul>
            </div>
          </div>
        </nav>
        
        
        
    <center>
        <div class="card bg-light mb-3" style="max-width: 20rem; margin-top: 50px">
        <h1>${operacao} Cliente</h1>
        <form name="Form para envio de nome" action="${actionUrl == null ? "/clientes?action=create" : "/clientes?action=update"}" method="post" var="cliente">
            <input type="hidden" value="${cliente.id}" name="id"/>
            Nome: <br>
            <input type="text" value="${cliente.firstName}" name="firstName" required/>
            <br> Sobrenome: <br>
            <input type="text" value="${cliente.lastName}" name="lastName" required/>
            <br> Numero Contato: <br>
            <input type="text" value="${cliente.contactNumber}" name="contactNumber" required/>
            <br> Endereço: <br>
            <input type="text" value="${cliente.address}" name="address" required/>
            <br> Email: <br>
            <input type="text" value="${cliente.email}" name="email" required/>
            <br>           
            <button type="submit" class="btn btn-primary">${operacao}</button>
        </form>
        </div>
    </center>
        
         <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>
