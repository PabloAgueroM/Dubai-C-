package Modelo;

import java.util.*;

public class Producto extends ProductoGenerico{
    private Talla talla;
    private ArrayList<InsumoxProducto> insumos;

    public Producto() {
        setActivo(1);
        insumos = new ArrayList<>();
    }
    
    public char getTalla() {
        if (talla==Talla.S) {
            return 'S';
        } else if (talla==Talla.M) {
            return 'M';
        } else {
            return 'L';
        }
    }
    public void setTalla(char talla) {
        if (talla == 's' || talla == 'S') {
            this.talla = Talla.S;
        } else if (talla == 'm' || talla == 'M') {
            this.talla = Talla.M;
        } else {
            this.talla = Talla.L;
        }
    }
    public void insertarInsumos(InsumoxProducto ip) {
        insumos.add(ip);
    }
    public ArrayList<InsumoxProducto> getLista() {
        return insumos;
    }
    public void setLista(ArrayList<InsumoxProducto> l) {
        insumos=l;
    }
    public void mostrarDatos() {
        System.out.println(getId()+ " " + getDescripcion() + " " + getPrecio() + " " + getStockActual());
    }
}