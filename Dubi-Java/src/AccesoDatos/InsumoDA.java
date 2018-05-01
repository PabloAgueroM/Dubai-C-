/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Modelo.Insumo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Pablo
 */
public class InsumoDA {
    public void registrarInsumo(Insumo i){
        try{
            //Registrar el Driver
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection
            ("jdbc:mysql://quilla.lab.inf.pucp.edu.pe/a20105734", "a20105734", "4KsrLh");      
            //("jdbc:mysql://quilla.lab.inf.pucp.edu.pe", "inf282g5", "KHjN45");
            
            //Empleando - Statement - Opción 2
            String sql = "INSERT INTO INSUMO (NOMBRE,DESCRIPCION,STOCK,STOCKMIN) VALUES(?,?,?,?);";
            PreparedStatement sentencia = con.prepareStatement(sql);
            sentencia.setString(1,i.getNombreInsumo());
            sentencia.setString(2,i.getDescInsumo());
            sentencia.setDouble(3,i.getStock());
            sentencia.setDouble(4,i.getStockMinimo());
            sentencia.executeUpdate();
            
            System.out.println("Registro realizado");
            con.close();    
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void modificarInsumo(Insumo i){
        try{
            //Registrar el Driver
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection
            ("jdbc:mysql://quilla.lab.inf.pucp.edu.pe/a20105734", "a20105734", "4KsrLh");      
            //("jdbc:mysql://quilla.lab.inf.pucp.edu.pe", "inf282g5", "KHjN45");
            
            //Empleando - Statement - Opción 2
            String sql = "UPDATE INSUMO "
                       + "SET NOMBRE = ?,DESCRIPCION = ?, STOCK = ?,STOCKMIN = ? "
                       + "WHERE ID_INSUMO = ?;";
            PreparedStatement sentencia = con.prepareStatement(sql);
            sentencia.setString(1,i.getNombreInsumo());
            sentencia.setString(2,i.getDescInsumo());
            sentencia.setDouble(3,i.getStock());
            sentencia.setDouble(4,i.getStockMinimo());
            sentencia.setInt(5, i.getIdInsumo());
            sentencia.executeUpdate();
            
            System.out.println("Registro realizado");
            con.close();    
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void eliminarInsumo(Insumo i){
        try{
            //Registrar el Driver
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection
            ("jdbc:mysql://quilla.lab.inf.pucp.edu.pe/a20105734", "a20105734", "4KsrLh");      
            //("jdbc:mysql://quilla.lab.inf.pucp.edu.pe", "inf282g5", "KHjN45");
            
            //Empleando - Statement - Opción 2
            String sql = "DELETE FROM INSUMO WHERE ID_INSUMO = ?";
            PreparedStatement sentencia = con.prepareStatement(sql);
            sentencia.setInt(1,i.getIdInsumo());
            sentencia.executeUpdate();
            
            System.out.println("Registro realizado");
            con.close();    
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
     
    public ArrayList<Insumo> listarInsumos(){
        ArrayList<Insumo> lista = new ArrayList<Insumo>();
        try{
            //Registrar el Driver
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection
            ("jdbc:mysql://quilla.lab.inf.pucp.edu.pe/a20105734", "a20105734", "4KsrLh");      
            //("jdbc:mysql://quilla.lab.inf.pucp.edu.pe", "inf282g5", "KHjN45");
            
            //Creación del Statement
            Statement sentencia = con.createStatement();
            String sql = "SELECT * FROM INSUMO;";
            ResultSet rs = sentencia.executeQuery(sql);
            while(rs.next()){
                Insumo i = new Insumo();
                i.setIdInsumo(rs.getInt("ID_INSUMO"));
                i.setNombreInsumo(rs.getString("NOMBRE"));
                i.setDescInsumo(rs.getString("DESCRIPCION"));
                i.setStock(rs.getDouble("STOCK"));
                i.setStockMin(rs.getDouble("STOCKMIN"));
                lista.add(i);
            }
            con.close();
            
        }catch(Exception e){
            
        }
        return lista;
    }
}
