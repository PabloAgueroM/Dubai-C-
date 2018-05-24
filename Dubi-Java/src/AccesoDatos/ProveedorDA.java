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

    public void registrarProveedor(Proveedor p) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://quilla.lab.inf.pucp.edu.pe/inf282g5", "inf282g5", "KHjN45");

            CallableStatement sentencia = con.prepareCall("{CALL INSERTAR_PROVEEDOR(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

            sentencia.registerOutParameter("_ID_PROVEEDOR", java.sql.Types.INTEGER);
            sentencia.registerOutParameter("_ID_PERSONA", java.sql.Types.INTEGER);
            sentencia.setInt("_ACTIVO", 1);
            sentencia.setString("_RAZON_SOCIAL", p.getRazonSocial());
            sentencia.setString("_RUC", p.getRUC());
            sentencia.setString("_NOMBRE", p.getNombre());
            sentencia.setDate("_FECHA_ANIVERSARIO", p.getFechaAniversario());
            sentencia.setString("_NOMBRE_REP", p.getRepresentante().getNombre());
            sentencia.setString("_APELLIDOP_REP", p.getRepresentante().getApellidoP());
            sentencia.setString("_APELLIDOM_REP", p.getRepresentante().getApellidoM());
            sentencia.setString("_DNI_REP", p.getRepresentante().getDNI());
            sentencia.setString("_EMAIL", p.getEmail());
            sentencia.setString("_TELEFONO", p.getTelefono());
            sentencia.setString("_TELEFONO_REP", p.getRepresentante().getTelefono());
            sentencia.execute();
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void modificarProveedor(Proveedor p) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://quilla.lab.inf.pucp.edu.pe/inf282g5", "inf282g5", "KHjN45");
            CallableStatement sentencia = con.prepareCall("{CALL MODIFICAR_PROVEEDOR(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            sentencia.setInt("_ID_PROVEEDOR", Integer.parseInt(p.getIDProveedor()));
            sentencia.setInt("_ID_PERSONA", Integer.parseInt(p.getRepresentante().getIdPersona()));
            sentencia.setInt("_ACTIVO", 1);
            sentencia.setString("_RAZON_SOCIAL", p.getRazonSocial());
            sentencia.setString("_RUC", p.getRUC());
            sentencia.setString("_NOMBRE", p.getNombre());
            sentencia.setDate("_FECHA_ANIVERSARIO", p.getFechaAniversario());
            sentencia.setString("_NOMBRE_REP", p.getRepresentante().getNombre());
            sentencia.setString("_APELLIDOP_REP", p.getRepresentante().getApellidoP());
            sentencia.setString("_APELLIDOM_REP", p.getRepresentante().getApellidoM());
            sentencia.setString("_DNI_REP", p.getRepresentante().getDNI());
            sentencia.setString("_EMAIL", p.getEmail());
            sentencia.setString("_TELEFONO", p.getTelefono());
            sentencia.setString("_TELEFONO_REP", p.getRepresentante().getTelefono());
            sentencia.execute();
            con.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminarProveedor(Proveedor p) {
         try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://quilla.lab.inf.pucp.edu.pe/inf282g5", "inf282g5", "KHjN45");
            CallableStatement sentencia= con.prepareCall("{CALL ELIMINAR_PROVEEDOR(?)}");
            sentencia.setInt("_ID_PROVEEDOR",Integer.parseInt(p.getIDProveedor()));
            sentencia.execute();
            con.close();
             
         }catch (Exception e){
             System.out.println(e.getMessage());
         }
    }

    public ArrayList<Proveedor> listarProveedor() {
          ArrayList<Proveedor> lista = new ArrayList<Proveedor>();
          try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://quilla.lab.inf.pucp.edu.pe/inf282g5", "inf282g5", "KHjN45");
            CallableStatement sentencia=con.prepareCall("{CALL LISTAR_PROVEEDORES()}");
            ResultSet rs= sentencia.executeQuery();
            while(rs.next()){
                Proveedor p= new Proveedor();
                PersonaNatural pn= new PersonaNatural();
                
                p.setIDProveedor(rs.getString("_ID_PROVEEDOR"));
                p.setRazonSocial(rs.getString("_RAZON_SOCIAL"));
                p.setRUC(rs.getString("_RUC"));
                p.setNombre(rs.getString("_NOMBRE"));
                p.setFechaAniversario(rs.getDate("_FECHA_ANIVERSARIO"));
                p.setEmail(rs.getString("_EMAIL"));
                p.setTelefono(rs.getString("_TELEFONO"));
                pn.setIdPersona(rs.getString("_ID_PERSONA"));
                pn.setNombre(rs.getString("_NOMBRE_REP"));
                pn.setApellidoP(rs.getString("_APELLIDOP_REP"));
                pn.setApellidoM(rs.getString("_APELLIDOM_REP"));
                pn.setDNI(rs.getString("_DNI_REP"));
                pn.setTelefono(rs.getString("_TELEFONO_REP"));
                p.setRepresentante(pn);
                lista.add(p);
                
            }
            
          }catch (Exception e){
              
          }
          return lista;
    }
}
