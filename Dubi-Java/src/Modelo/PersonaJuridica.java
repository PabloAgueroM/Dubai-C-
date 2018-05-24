/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;



/**
 *
 * @author Carlos
 */
public class PersonaJuridica extends Persona {

    private String razonSocial;
    private String nombre;
    private String RUC;
    private Date fechaAniversario;
    
    public PersonaJuridica(String idPersona, String email, String telefono, String razonSocial, String nombre, String RUC, Date fechaAniversario) {
        super(idPersona, email, telefono);
        this.razonSocial=razonSocial;
        this.nombre = nombre;
        this.RUC=RUC;
        this.fechaAniversario=fechaAniversario;

    }
    public PersonaJuridica( String telefono, String razonSocial, String nombre, String RUC, Date fechaAniversario) {
        super( telefono);
        this.razonSocial=razonSocial;
        this.nombre = nombre;
        this.RUC=RUC;
        this.fechaAniversario=fechaAniversario;

    }
    public PersonaJuridica(){
        super();
    }
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRazonSocial() {
        return this.razonSocial;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }
    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public String getRUC() {
        return this.RUC;
    }
    public void setFechaAniversario(Date fechaAniversario) {
        this.fechaAniversario = fechaAniversario;
    }

    public Date getFechaAniversario() {
        return this.fechaAniversario;
    }
    

}
