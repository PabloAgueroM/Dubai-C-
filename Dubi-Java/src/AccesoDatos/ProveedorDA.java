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
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class ProveedorDA {
    public void registrarProveedor(Proveedor p){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection
            ("jdbc:mysql://quilla.lab.inf.pucp.edu.pe/inf282g5", "inf282g5", "KHjN45");  
            
            CallableStatement sentencia= con.prepareCall("{CALL INSERTAR_PROVEEDOR(?,?,?,?,?,?,?,?,?,?,?,?)}");
                   
            sentencia.registerOutParameter("_ID_PROVEEDOR",java.sql.Types.INTEGER );
            sentencia.registerOutParameter("_ID_PERSONA", java.sql.Types.INTEGER );
            sentencia.setString("_RAZON_SOCIAL", p.getRazonSocial());
            sentencia.setString("_RUC", p.getRUC());
            sentencia.setString("_NOMBRE", p.getNombre());
             sentencia.setDate("_FECHA_ANIVERSARIO", p.getFechaAniversario());
            sentencia.setInt("_ACTIVO", 1);
            sentencia.setString("_NOMBRE", p.getRepresentante().getNombre());
            sentencia.setString("_APELLIDO_PATERNO", p.getRepresentante().getApellidoP());
            sentencia.setString("_APELLIDO_MATERNO", p.getRepresentante().getApellidoM());
            sentencia.setString("_DNI", p.getRepresentante().getDNI() );                      
            sentencia.setString("_TELEFONO", p.getRepresentante().getTelefono());
            sentencia.execute();
            con.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    public void modificarProveedor(){
        
    }
    public void eliminarProveedor(){
        
    }
    public ArrayList<Proveedor> listarProveedor(){
        
    }
}
