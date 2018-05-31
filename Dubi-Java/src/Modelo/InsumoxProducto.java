package Modelo;

public class InsumoxProducto {
    private int idInsumo;
    private String descripcion;
    private double cantidad;

    public InsumoxProducto(int i,String d,double c){
        idInsumo=i;
        descripcion=d;
        cantidad=c;
    }

    public InsumoxProducto() {
    }

    public void setIdInsumo(int i){
        idInsumo=i;
    }
    public int getIdInsumo(){
        return idInsumo;
    }

    public void setCantidad(float c){
        cantidad=c;
    }
    public double getCantidad(){
        return cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}