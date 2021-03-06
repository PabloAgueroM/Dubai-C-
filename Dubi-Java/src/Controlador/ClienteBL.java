
package Controlador;
import AccesoDatos.*;
import Modelo.*;
import java.util.ArrayList;

public class ClienteBL {
    private ClienteDA accesoDatos = new ClienteDA();
    public void registrarClienteNatural(PersonaNatural c) {    }    
    public void registrarClienteJuridica(PersonaJuridica c) {    }
    public void modificarClienteNatural(PersonaNatural p) { }    
    public void modificarClienteJuridico(PersonaJuridica p) {  }
    public void eliminarClienteNatural(PersonaNatural p) {       }    
    public void eliminarClienteJuridico(PersonaJuridica p) {}
    public ArrayList<PersonaNatural> listarClienteNatural() {
          
          return accesoDatos.listarClienteNatural();
    }        
    public ArrayList<PersonaJuridica> listarClienteJuridico() {
         
          return accesoDatos.listarPersonaJuridica();
    }
}
