
package AccesoDatos;

import Modelo.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ClienteDA {
    public void registrarClienteNatural(PersonaNatural c) {


    }
    
    public void registrarClienteJuridica(PersonaJuridica c) {
    }

    public void modificarClienteNatural(PersonaNatural p) {
        
    }

    
    public void modificarClienteJuridico(PersonaJuridica p) {
        
    }
    public void eliminarClienteNatural(PersonaNatural p) {
        
    }
    
    public void eliminarClienteJuridico(PersonaJuridica p) {
        
    }

    public ArrayList<PersonaNatural> listarClienteNatural() {
        ArrayList<PersonaNatural> lista = new ArrayList<PersonaNatural>();
        try{
          Class.forName("com.mysql.jdbc.Driver");
          Connection con = DriverManager.getConnection("jdbc:mysql://quilla.lab.inf.pucp.edu.pe/inf282g5", "inf282g5", "KHjN45");
          CallableStatement sentencia=con.prepareCall("{CALL LISTAR_CLIENTE_NATURAL()}");
          ResultSet rs= sentencia.executeQuery();
          while(rs.next()){
              PersonaNatural pn= new PersonaNatural();
              pn.setIdPersona(rs.getString("ID_PERSONA"));
              pn.setNombre(rs.getString("NOMBRE"));
              pn.setApellidoP(rs.getString("AP_PATERNO"));
              pn.setApellidoM(rs.getString("AP_MATERNO"));
              pn.setDNI(rs.getString("DNI"));
              pn.setTelefono(rs.getString("TELEFONO"));
              pn.setEmail(rs.getString("EMAIL"));
              lista.add(pn);
          }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return lista;
    }
    
    
    public ArrayList<PersonaJuridica> listarPersonaJuridica() {
        ArrayList<PersonaJuridica> lista = new ArrayList<PersonaJuridica>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://quilla.lab.inf.pucp.edu.pe/inf282g5", "inf282g5", "KHjN45");
            CallableStatement sentencia=con.prepareCall("{CALL LISTAR_CLIENTE_JURIDICO()}");
            ResultSet rs= sentencia.executeQuery();
            while(rs.next()){
                PersonaJuridica pn= new PersonaJuridica();
                pn.setIdPersona(rs.getString("ID_PERSONA"));
                pn.setNombre(rs.getString("NOMBRE"));
                pn.setRUC(rs.getString("RUC"));
                pn.setRazonSocial(rs.getString("RAZON_SOCIAL"));
                pn.setTelefono(rs.getString("TELEFONO"));
                pn.setEmail(rs.getString("EMAIL"));
                lista.add(pn);
            }
          }catch (Exception e){
              System.out.println(e.getMessage());
          }
        return lista;
    }
    
}
