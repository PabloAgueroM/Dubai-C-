package Modelo;
import Modelo.Persona;
import java.sql.Date;


public class Proveedor extends PersonaJuridica{
    private String IDProveedor; 
    private PersonaNatural Representante;

    public String getIDProveedor() {
        return IDProveedor;
    }

    public void setIDProveedor(String IDProveedor) {
        this.IDProveedor = IDProveedor;
    }

    public PersonaNatural getRepresentante() {
        return Representante;
    }

    public void setRepresentante(PersonaNatural Representante) {
        this.Representante = Representante;
    }
    public Proveedor(){
        super();
    }
    public Proveedor(String idPersona, String email, String telefono,
    String razonSocial, String nombre, String RUC, Date fechaAniversario,
    String IDProveedor, PersonaNatural Representante){
        super(idPersona, email, telefono, razonSocial, nombre, RUC, fechaAniversario);
        this.IDProveedor = IDProveedor;
        this.Representante = Representante;
    }
    
}