/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;
import Modelo.*;
import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Bruno Diaz
 */
public class ReportesDA {
    
    
    
    public ArrayList listaVentasTotales(int idCliente,String fIni, String fFin){
        ArrayList listaDatos = new ArrayList();
        
        try {
            //Registrar el Driver
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://quilla.lab.inf.pucp.edu.pe/inf282g5", "inf282g5", "KHjN45");
            CallableStatement cs = con.prepareCall("{call REPORTE_VENTAS_X_CLIENTE(?,?,?)}");
            cs.setInt(1, idCliente);
            cs.setString(2, fIni);
            cs.setString(3, fFin);
            ResultSet rset = cs.executeQuery();
            while(rset.next()){
                ArrayList<String> registro = new ArrayList<String>();
                registro.add(rset.getString(1));
                registro.add(rset.getString(2));
                registro.add(rset.getString(3));
                registro.add(rset.getString(4));
                registro.add(rset.getString(5));
                registro.add(rset.getString(6));
                registro.add(rset.getString(7));
                registro.add(rset.getString(8));
                registro.add(rset.getString(9));
                registro.add(rset.getString(10));
                listaDatos.add(registro);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listaDatos;
    } 
    
    public ArrayList listaComprasTotales(int idProveedor,String fIni, String fFin){
        ArrayList listaDatos = new ArrayList();
        
        try {
            //Registrar el Driver
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://quilla.lab.inf.pucp.edu.pe/inf282g5", "inf282g5", "KHjN45");
            CallableStatement cs = con.prepareCall("{call REPORTE_COMPRAS_X_PROVEEDOR(?,?,?)}");
            cs.setInt(1, idProveedor);
            cs.setString(2, fIni);
            cs.setString(3, fFin);
            ResultSet rset = cs.executeQuery();
            while(rset.next()){
                ArrayList<String> registro = new ArrayList<String>();
                registro.add(rset.getString(1));
                registro.add(rset.getString(2));
                registro.add(rset.getString(3));
                registro.add(rset.getString(4));
                registro.add(rset.getString(5));
                registro.add(rset.getString(6));
                registro.add(rset.getString(7));
                registro.add(rset.getString(8));
                registro.add(rset.getString(9));
                registro.add(rset.getString(10));
                listaDatos.add(registro);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listaDatos;
    } 
    
    public ArrayList listaMejoresClientes(String fIni, String fFin ){
        ArrayList listaDatos = new ArrayList();
        
        try {
            //Registrar el Driver
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://quilla.lab.inf.pucp.edu.pe/inf282g5", "inf282g5", "KHjN45");
            CallableStatement cs = con.prepareCall("{call REPORTE_CLIENTES(?,?)}");
            cs.setString(1, fIni);
            cs.setString(2, fFin);
            ResultSet rset = cs.executeQuery(); 
            while(rset.next()){
                ArrayList<String> registro = new ArrayList<String>();
                registro.add(rset.getString(1));
                registro.add(rset.getString(2));
                registro.add(rset.getString(3));
                registro.add(rset.getString(4));
                registro.add(rset.getString(5));
                listaDatos.add(registro);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listaDatos;
    } 
    
    public ArrayList listaProductos( String fIni, String fFin){
        ArrayList listaDatos = new ArrayList();
        
        try {
            //Registrar el Driver
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://quilla.lab.inf.pucp.edu.pe/inf282g5", "inf282g5", "KHjN45");
            CallableStatement cs = con.prepareCall("{call REPORTE_PRODUCTOS(?,?)}");
            cs.setString(1, fIni);
            cs.setString(2, fFin);
            ResultSet rset = cs.executeQuery(); 
            while(rset.next()){
                ArrayList<String> registro = new ArrayList<String>();
                registro.add(rset.getString(1));
                registro.add(rset.getString(2));
                registro.add(rset.getString(3));
                registro.add(rset.getString(4));
                registro.add(rset.getString(5));
                registro.add(rset.getString(6));
                registro.add(rset.getString(7));
                registro.add(rset.getString(8));
                registro.add(rset.getString(9));
                registro.add(rset.getString(10));
                listaDatos.add(registro);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listaDatos;
    } 
    
    public ArrayList listaInsumos(String fIni, String fFin ){
        ArrayList listaDatos = new ArrayList();
        
        try {
            //Registrar el Driver
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://quilla.lab.inf.pucp.edu.pe/inf282g5", "inf282g5", "KHjN45");
            CallableStatement cs = con.prepareCall("{call REPORTE_INSUMOS(?,?)}");
            cs.setString(1, fIni);
            cs.setString(2, fFin);
            ResultSet rset = cs.executeQuery(); 
            while(rset.next()){
                ArrayList<String> registro = new ArrayList<String>();
                registro.add(rset.getString(1));
                registro.add(rset.getString(2));
                registro.add(rset.getString(3));
                registro.add(rset.getString(4));
                registro.add(rset.getString(5));
                registro.add(rset.getString(6));
                registro.add(rset.getString(7));
                registro.add(rset.getString(8));
                registro.add(rset.getString(9));
                listaDatos.add(registro);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listaDatos;
    } 
}
