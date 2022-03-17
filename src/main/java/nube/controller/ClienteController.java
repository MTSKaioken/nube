/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nube.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nube.dao.*;
import nube.model.Cliente;

/**
 *
 * @author mtskaioken
 */

@WebServlet("/clientes")
public class ClienteController extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/formCliente.jsp";
    private static String LIST_CLIENTE = "/listaClientes.jsp";
    private ClienteDao dao;
    
    public ClienteController() {
        super();
        dao = new ClienteDao();
    }
    
    protected void doGet(HttpServletRequest request,
              HttpServletResponse response) throws ServletException, IOException  {
        
        String forward = "";
        String action = request.getParameter("action");
        
        //delete
        if (action.equalsIgnoreCase("create")){
            request.setAttribute("operacao", "Cadastrar");
            forward = INSERT_OR_EDIT;
        } else if (action.equalsIgnoreCase("delete")){
            //tratativa
            int id = Integer.parseInt(request.getParameter("id"));
            Cliente cliente = new Cliente();
            cliente.setId(id);
            dao.delete(cliente);
            forward = LIST_CLIENTE;
            request.setAttribute("clientes", dao.read());       
        } else if (action.equalsIgnoreCase("edit")){
            //tratativa
            forward = INSERT_OR_EDIT;
            Cliente cliente = dao.findById(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("cliente", cliente); 
            request.setAttribute("operacao", "Atualizar");
            request.setAttribute("actionUrl", "update");
            //enviar o action acima p decidir se é create ou update
        } else if (action.equalsIgnoreCase("list")){ //read
            //tratativa
            forward = LIST_CLIENTE;
            request.setAttribute("clientes", dao.read());
            
        } else {
            forward = INSERT_OR_EDIT;
        }
        
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
        
        //redireciona para a criação do cliente
        //response.sendRedirect("formCliente.jsp");
     }
    
    protected void doPost(HttpServletRequest request,
              HttpServletResponse response) throws ServletException, IOException  {
        
        String forward = "";
        String action = request.getParameter("action");
        
        if (action.equalsIgnoreCase("create")){
        Cliente cliente = new Cliente();
        
        cliente.setFirstName(request.getParameter("firstName"));
        cliente.setLastName(request.getParameter("lastName"));
        cliente.setContactNumber(request.getParameter("contactNumber"));
        cliente.setAddress(request.getParameter("address"));
        cliente.setEmail(request.getParameter("email"));
  
        ClienteDao clienteDao = new ClienteDao();       
        clienteDao.create(cliente);
        
        forward = LIST_CLIENTE;
        request.setAttribute("clientes", dao.read());
        
        
        } else if(action.equalsIgnoreCase("update")){
            Cliente cliente = new Cliente();
            cliente.setId(Integer.parseInt(request.getParameter("id")));
            cliente.setFirstName(request.getParameter("firstName"));
            cliente.setLastName(request.getParameter("lastName"));
            cliente.setContactNumber(request.getParameter("contactNumber"));
            cliente.setAddress(request.getParameter("address"));
            cliente.setEmail(request.getParameter("email"));
            
            ClienteDao clienteDao = new ClienteDao();
        
            clienteDao.update(cliente);
            
            forward = LIST_CLIENTE;
            request.setAttribute("clientes", dao.read());
            
        }
        
        //criar o cliente e redirecionar
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
     }
    
    
}
