package Modelo;

/**
 *
 * @author Carlos
 */
public class Persona {
	private String idPersona;
	private String email;
	private String telefono;
	
	
	public Persona(String _idPersona,String _email,String _telefono){
		
		this.idPersona=_idPersona;
                this.email=_email;
                this.telefono=_telefono;
                
		//fechaNac=_fechaNac;
	}
	
	
	public void setIdPersona (String idPersona){
            this.idPersona=idPersona;
        }
        public String getIdPersona (){
            return this.idPersona;
        }
        public void setEmail (String email){
            this.email=email;
        }
        public String getEmail (){
            return this.email;
        }
        public void setTelefono(String _telefono){
		telefono=_telefono;
	}
	public String getTelefono(){
		return telefono;
	}
	
	
}