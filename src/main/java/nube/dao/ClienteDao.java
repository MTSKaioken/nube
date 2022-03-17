/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nube.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import nube.model.Cliente;

/**
 *
 * @author mtskaioken
 */
public class ClienteDao {
    
    //create
    public void create(Cliente cliente){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = "INSERT INTO clientes (firstName, lastName, contactNumber, address, email) VALUES (?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cliente.getFirstName());
            stmt.setString(2, cliente.getLastName());
            stmt.setString(3, cliente.getContactNumber());
            stmt.setString(4, cliente.getAddress());
            stmt.setString(5, cliente.getEmail());
            stmt.executeUpdate();
            System.out.println("Dados salvos!");     
        }
        catch (SQLException ex){
            System.out.print("Erro ao salvar!");
        }
        finally{
            System.out.println("Conexão Fechada");
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    //read
    public List<Cliente> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM clientes";
        List <Cliente> clientes = new ArrayList<>();
            try{
               stmt = con.prepareStatement(sql);
               rs = stmt.executeQuery();

                while(rs.next()){
                   Cliente cliente = new Cliente();
                   cliente.setId(rs.getInt("id"));
                   cliente.setFirstName(rs.getString("firstName"));
                   cliente.setLastName(rs.getString("lastName"));
                   cliente.setAddress(rs.getString("address"));
                   cliente.setContactNumber(rs.getString("contactNumber"));
                   cliente.setEmail(rs.getString("email"));
                   clientes.add(cliente);
                }
            }
            catch(SQLException ex){
                System.out.println("Erro na leitura");
            }
            finally{
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
         return clientes;
    }
    //update
    public void update(Cliente cliente){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try{
            stmt = con.prepareStatement("UPDATE clientes SET firstName = ?, lastName = ?, address = ?, contactNumber = ?, email = ? WHERE id = ?");
            stmt.setString(1, cliente.getFirstName());
            stmt.setString(2, cliente.getLastName());
            stmt.setString(3, cliente.getAddress());
            stmt.setString(4, cliente.getContactNumber());
            stmt.setString(5, cliente.getEmail());
            stmt.setInt(6, cliente.getId());
            stmt.executeUpdate();
            System.out.println("Atualizado com sucesso");
        }
        catch(SQLException ex){
            System.out.println("Erro ao atualizar: "+ex);
        }finally{
              ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    //delete
    public void delete(Cliente cliente){
      Connection con =  ConnectionFactory.getConnection();
      PreparedStatement stmt = null;
      try{
         stmt = con.prepareStatement("DELETE FROM clientes WHERE id = ?");
         stmt.setInt(1, cliente.getId());
         stmt.executeUpdate();
         System.out.println("Excluido com sucesso!");
      }
      catch(SQLException ex){
         System.out.println("Erro ao deletar"+ex);
      }
      finally{
          ConnectionFactory.closeConnection(con, stmt);
      }
    }
    
    public Cliente findById(int id){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = new Cliente();
        try{
            stmt = con.prepareStatement("SELECT * FROM clientes WHERE id = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while(rs.next()){
                   cliente.setId(rs.getInt("id"));
                   cliente.setFirstName(rs.getString("firstName"));
                   cliente.setLastName(rs.getString("lastName"));
                   cliente.setAddress(rs.getString("address"));
                   cliente.setContactNumber(rs.getString("contactNumber"));
                   cliente.setEmail(rs.getString("email"));
            }
            
        } catch(SQLException ex){
         System.out.println("Erro ao procurar"+ex);
      }
      finally{
          ConnectionFactory.closeConnection(con, stmt, rs);
      }
        return cliente;
    }
    
}
