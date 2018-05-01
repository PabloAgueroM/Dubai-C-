package Modelo;
import Modelo.Persona;
public class Proveedor{
	private String IDProveedor; 
	private String Nombre;
	private Persona Representante; // Puede ser que lo cambiemos por un tipo persona
	private String DNIRepresentante;
	private String Telefono;
	private String Correo;
	private String RUC;

	public void setIDProveedor(String obj){ this.IDProveedor = obj;}

	public String getIDProveedor(){return this.IDProveedor;}

	public void setNombre(String obj){this.Nombre = obj;}

	public String getNombre(){return this.Nombre;}

	public void setRepresentante(Persona obj){this.Representante = obj;}

	public Persona getRepresentante(){return this.Representante;}

	public void setDNIRepresentante(String obj){this.DNIRepresentante = obj;}

	public String getDNIRepresentante(){return this.DNIRepresentante;}

	public void setTelefono(String obj){this.Telefono = obj;}

	public String getTelefono(){return this.Telefono;}

	public void setCorreo(String obj){this.Correo = obj;}

	public String getCorreo(){return this.Correo;}

	public void setRUC(String obj){this.RUC = obj;}

	public String getRUC(){return this.RUC;}

	public Proveedor(){}

	public Proveedor( String _IDProveedor,  String _Nombre, Persona _Representante, String _DNIRepresentante, String _Telefono,
						 String _Correo, String _RUC){
		setIDProveedor(_IDProveedor);
		setNombre(_Nombre);
		setRepresentante(_Representante);
		setDNIRepresentante(_DNIRepresentante);
		setTelefono(_Telefono);
		setCorreo(_Correo);
		setRUC(_RUC);
	}
        public Proveedor( String _RUC,  String _Nombre, Persona _Representante,  String _Telefono, String _Correo){
		
		setNombre(_Nombre);
		setRepresentante(_Representante);
		
		setTelefono(_Telefono);
		setCorreo(_Correo);
		setRUC(_RUC);
	}

	public void MostrarDatosProveedor(){
		System.out.print("ID Proveedor: " + this.getIDProveedor() + "\n"+
			          "Nombre: "+this.getNombre()+"\n"+
					  "Representante: "+this.getRepresentante() +"\n"+
					  "DNI de Representante "+this.getDNIRepresentante()+"\n"+
					  "Telefono: "+this.getTelefono()+"\n"+
					  "Correo: "+this.getCorreo()+"\n"+
					  "RUC: "+this.getRUC()+"\n"+
					  "Aqui va lista de insumos que se ofrece\n");
	}

	
}