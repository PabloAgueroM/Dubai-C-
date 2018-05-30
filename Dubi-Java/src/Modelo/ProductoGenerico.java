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
public class ProductoGenerico {    
    private int id;    
    private String nombre;
    private String descripcion;
    private String color;
    private double precio;
    private double stockActual;
    private TipoProductoG tipo;
    private UnidadDeMedida unidad;
    private int Activo;

    public ProductoGenerico() {
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getStockActual() {
        return stockActual;
    }

    public void setStockActual(double stockActual) {
        this.stockActual = stockActual;
    }

    public int isActivo() {
        return Activo;
    }

    public void setActivo(int Activo) {
        this.Activo = Activo;
    }

    public TipoProductoG getTipo() {
        return tipo;
    }

    public void setTipo(TipoProductoG tipo) {
        this.tipo = tipo;
    }

    public UnidadDeMedida getUnidad() {
        return unidad;
    }

    public void setUnidad(UnidadDeMedida unidad) {
        this.unidad = unidad;
    }
}
