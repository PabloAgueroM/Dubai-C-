/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Bruno Diaz
 */
public class LoginDA {
    
    public LoginDA(){}
    
    public void inicioSesion(String user){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://quilla.lab.inf.pucp.edu.pe/inf282g5", "inf282g5", "KHjN45");
            String sql = "UPDATE USUARIO SET ENLINEA = 1  WHERE ID_USUARIO = ?";
            PreparedStatement pstmt = null;
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user);
            pstmt.executeUpdate();
            pstmt.close();
            con.close();            
        }
        catch( ClassNotFoundException | SQLException e){
        }           
    }
    
    public void cerrarSesion(String user){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://quilla.lab.inf.pucp.edu.pe/inf282g5", "inf282g5", "KHjN45");
            String sql = "UPDATE USUARIO SET ENLINEA = 0  WHERE ID_USUARIO = ?";
            PreparedStatement pstmt = null;
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user);
            pstmt.executeUpdate();
            pstmt.close();
            con.close();            
        }
        catch( ClassNotFoundException | SQLException e){
        }     
    }
    
    public int validarUsuario(String user, String pass){
        int retorno = 0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://quilla.lab.inf.pucp.edu.pe/inf282g5", "inf282g5", "KHjN45");
            String sql = "SELECT * FROM USUARIO WHERE ID_USUARIO = ? AND CONTRASENHA = ? AND ACTIVO=1";
            PreparedStatement pstmt = null;
            ResultSet rset = null;
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user);
            pstmt.setString(2, pass);
            rset = pstmt.executeQuery();
            if(rset.next()){
                retorno = 1;
                inicioSesion(user);
            }      
            rset.close();
            pstmt.close();
            con.close();            
        }
        catch( ClassNotFoundException | SQLException e){
        }       
        return retorno;       
    }
}
