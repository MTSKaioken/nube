<%-- 
    Document   : Cliente
    Created on : 12 de mar de 2022, 00:52:56
    Author     : mtskaioken
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://bootswatch.com/5/sketchy/bootstrap.css" rel="stylesheet"><link href="https://bootswatch.com/5/sketchy/bootstrap.min.css" rel="stylesheet">
        <title>Listar Clientes</title>
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
        
        <h1>Lista de Clientes</h1>     
       
<table class="table table-hover">
  <thead>
    <tr>
        <th scope="col">id</th>
        <th scope="col">nome</th>
        <th scope="col">sobrenome</th>
        <th scope="col">tel/cel</th>
        <th scope="col">endereço</th>
        <th scope="col">email</th>
    </tr>
  </thead>
  <tbody>
      <c:forEach items="${clientes}" var="cliente">
        <tr class="table table-hover">
            <td>${cliente.id}</td>
            <td>${cliente.firstName}</td>
            <td>${cliente.lastName}</td>
            <td>${cliente.address}</td>
            <td>${cliente.contactNumber}</td>
            <td>${cliente.email}</td>
            <td><a href="/clientes?action=edit&id=<c:out value="${cliente.id}"/>">Atualizar</a></td>
            <td><a href="/clientes?action=delete&id=<c:out value="${cliente.id}"/>">Apagar</a></td>
        </tr>
       </c:forEach>
  </tbody>
</table>


        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>
