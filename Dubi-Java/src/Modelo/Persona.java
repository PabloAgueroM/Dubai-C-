package Modelo;
public class Persona {
	private String nombres;
	private String apellidoP;
	private String apellidoM;
        private String DNI;
        private String telefono;
	//private Date fechaNac;
	
	public Persona(String _nombres,String _apellidoP,String _apellidoM,/*Date _fechaNac,String _email,*/String _DNI,String _telefono){
		
		nombres=_nombres;
		apellidoP=_apellidoP;
		apellidoM=_apellidoM;
                DNI=_DNI;
                telefono=_telefono;
                
		//fechaNac=_fechaNac;
	}
	
	public void setNombres(String _nombres){
		nombres=_nombres;
	}
	public String getNombres(){
		return nombres;
	}
	
	public void setApellidoP(String _apellidoP){
		apellidoP=_apellidoP;
	}
	public String getApellidoP(){
		return apellidoP;
	}
	
	public void setApellidoM(String _apellidoM){
		apellidoM=_apellidoM;
	}
	public String getApellidoM(){
		return apellidoM;
	}
        public void setDNI(String _DNI){
		apellidoM=_DNI;
	}
	public String getDNI(){
		return DNI;
	}
        public void setTelefono(String _telefono){
		telefono=_telefono;
	}
	public String getTelefono(){
		return telefono;
	}
	
	/*public void setFechaNac(Date _fechaNac){
		fechaNac=_fechaNac;
	}
	public Date getFechaNac(){
		return fechaNac;
	}*/
//	public void mostrarDatos(){
//		System.out.println(getID()+" "+ getNombres()+" "+getApellidoP()+" "+getApellidoM()+" "+getEmail()+" "+getTelefono()/*+" "+ getFechaNac()*/);		
//	}
}