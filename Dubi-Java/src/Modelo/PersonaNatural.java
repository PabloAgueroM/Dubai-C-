/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.time.LocalDateTime;

/**
 *
 * @author Carlos
 */
public class PersonaNatural extends Persona {

    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String DNI;
    private char sexo;
    private LocalDateTime fechaNacimiento;

    public PersonaNatural(String idPersona, String email, String telefono, String nombre, String apellidoP, String apellidoM, String DNI, char sexo, LocalDateTime fechaNacimiento) {
        super(idPersona, email, telefono);
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.DNI = DNI;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoP() {
        return this.apellidoP;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getApellidoM() {
        return this.apellidoM;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getDNI() {
        return this.DNI;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public char getSexo() {
        return this.sexo;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDateTime getFechaNacimiento() {
        return this.fechaNacimiento;
    }

}
