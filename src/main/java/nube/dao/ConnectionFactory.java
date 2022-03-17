/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nube.dao;
import java.sql.*;
import org.postgresql.Driver;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author mtskaioken
 */

public final class ConnectionFactory { 
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/nube";
    private static final String USER = "mtskaioken";
    private static final String PASS = "WilsonAtacante123@";
    
    public static Connection getConnection(){
        try {  
            Class.forName(DRIVER);
            return (Connection) DriverManager.getConnection(URL, USER, PASS);    
            
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro no Método getConnection.",ex);
        }

   }
    public static void closeConnection(Connection con){       
            try {
                 if(con != null){
                con.close();
                 }
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    public static void closeConnection(Connection con, PreparedStatement stmt){       
            closeConnection(con);
            try {
                 if(stmt != null){
                stmt.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){       
            closeConnection(con, stmt);
            try {
                if(rs != null){
                rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
       
    }
    
