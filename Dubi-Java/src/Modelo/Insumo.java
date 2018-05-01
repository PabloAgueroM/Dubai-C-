package Modelo;

public class Insumo{
	private int idInsumo; //Se maneja por interno, autoincremento en la bd
	private String nombreInsumo;
	private String descripcionInsumo;
	private double stock; 
	private double stockMinimo;
	//El precio del insumo debe ser indicado por el proveedor
	//Debido a que un producto puede tener muchos proveedores
     	//A distintos precios

	public Insumo(){
	}
	
	//Constructor
	public Insumo(String nombreInsumo,
			   String descripcionInsumo, 
			   double stock, double stockMinimo){
		//this.idInsumo = idInsumo;
		this.nombreInsumo = nombreInsumo;
		this.descripcionInsumo = descripcionInsumo;
		this.stock = stock;
		this.stockMinimo = stockMinimo;
	}

	//Set & get idInsumo
	public void setIdInsumo(int idInsumo){
		this.idInsumo = idInsumo;
	}

	public int getIdInsumo(){
		return this.idInsumo;
	}
	
	//Set & get nombreInsumo
	public void setNombreInsumo(String nombreInsumo){
		this.nombreInsumo = nombreInsumo;
	}

	public String getNombreInsumo(){
		return this.nombreInsumo;
	}

	//Set & get descripcionInsumo
	public void setDescInsumo(String descripcionInsumo){
		this.descripcionInsumo = descripcionInsumo;
	}

	public String getDescInsumo(){
		return this.descripcionInsumo;
	}

	//Set & get stock
	public void setStock(double stock){
		this.stock = stock;
	}

	public double getStock(){
		return this.stock;
	}

	//Set & get stockMinimo
	public void setStockMin(double stockMinimo){
		this.stockMinimo = stockMinimo;
	}

	public double getStockMinimo(){
		return this.stockMinimo;
	}
}
