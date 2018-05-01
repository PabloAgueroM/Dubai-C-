package Modelo;
import java.util.*;

public class Producto {
	private static int count = 10000; 
	private final int id;
	private String descripcion;
	private float precio;
	private int stock;
        private Estado estado;
	private ArrayList<InsumoxProducto> insumos;
	
	public Producto(){
		id=++count;
                estado=Estado.Activo;
                insumos=new ArrayList<>();             
	}
	public Producto(String _descripcion,float _precio,int _stock){
		id=++count;
		descripcion=_descripcion;
		precio=_precio;
		stock=_stock;
                estado=Estado.Activo;
                insumos=new ArrayList<>(); 
	}
	
	public int getID(){
		return id;
	}
	
	public void setDescripcion(String _descripcion){
		descripcion=_descripcion;
	}
	public String getDescripcion(){
		return descripcion;
	}
	
	public void setPrecio(float _precio){
		precio=_precio;
	}
	public float getPrecio(){
		return precio;
	}
	
	public void setStock(int _stock){
		stock=_stock;
	}
	public int getStock(){
		return stock;
	}
	public void setEstado(char e){
		if (e=='a') estado=Estado.Activo;
                else estado=Estado.Inactivo;
	}
	public Estado getEstado(){
		return estado;
	}
	public void insertarInsumos(InsumoxProducto ip){
		insumos.add(ip);		
	}
	public ArrayList<InsumoxProducto> getLista(){
		return insumos;
	}
	public void mostrarDatos(){
		System.out.println(getID()+" "+ getDescripcion()+" "+getPrecio()+" "+getStock());
	}
}