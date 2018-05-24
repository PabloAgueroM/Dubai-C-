package Modelo;

public class InsumoxProducto {
    private Insumo insumo;
    private float cantidad;

    public InsumoxProducto(Insumo i,float c){
        insumo=i;
        cantidad=c;
    }

    public void setInsumo(Insumo i){
        insumo=i;
    }
    public Insumo getInsumo(){
        return insumo;
    }

    public void setCantidad(float c){
        cantidad=c;
    }
    public float getCantidad(){
        return cantidad;
    }
}