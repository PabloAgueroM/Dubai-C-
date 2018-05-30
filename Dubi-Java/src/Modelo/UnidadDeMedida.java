/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Katherine Espinoza 20122127
 */
public class UnidadDeMedida {
    private int id;
    private String nombre;
    private int activo;

    public UnidadDeMedida() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
    @Override
    public String toString(){
        return nombre;
    }
    @Override  
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (!(o instanceof UnidadDeMedida)) {
            return false;
        }
        UnidadDeMedida t = (UnidadDeMedida) o;
        if (id != t.id) {
            return false;
        }
        if (nombre != null ? !nombre.equals(t.nombre) : t.nombre != null) {
            return false;
        }
        if (activo!=t.activo)
            return false;
        return true;
    }
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (this.nombre != null ? this.nombre.hashCode() : 0);
        hash = 89 * hash + this.id;
        return hash;
    }
}
