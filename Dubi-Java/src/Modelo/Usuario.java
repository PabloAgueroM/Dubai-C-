/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author alulab14
 */


public class Usuario  extends PersonaNatural{
    
    private int idUsuario;
    private int tipoUsuario;
    private String password;
    private int estadoU;
    
    
    public Usuario(){
    }
    
    public Usuario(String idPersona, String email, String telefono, String dni, String nombre, String apPat, String apMat, char sexo, Date fechaNac, int idUsuario, int tipoUsuario, String password, int estadoU){
        super(idPersona, email, telefono, dni, nombre, apPat, apMat, sexo, fechaNac);
        
            this.idUsuario = idUsuario;
            this.tipoUsuario = tipoUsuario;
            this.password = password;
            this.estadoU = estadoU;
    }

    /**
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the tipoUsuario
     */
    public int getTipoUsuario() {
        return tipoUsuario;
    }

    /**
     * @param tipoUsuario the tipoUsuario to set
     */
    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the estadoU
     */
    public int getEstadoU() {
        return estadoU;
    }

    /**
     * @param estadoU the estadoU to set
     */
    public void setEstadoU(int estadoU) {
        this.estadoU = estadoU;
    }
}
