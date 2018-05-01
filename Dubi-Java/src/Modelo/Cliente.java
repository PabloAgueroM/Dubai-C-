/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

public class Cliente{
        private String name;
	private String id;
	private String email;
	private String telefono;
        private String tipoCliente;
        
	
	public Cliente(String _email,String _telefono, String _name, String _tC){		
		//id=_id;
		email=_email;
		telefono =_telefono;
                name= _name;
                tipoCliente = _tC;
	}
	
	public void setID(String _id){
		id=_id;
	}
	public String getID(){
		return id;
	}
	
	public void setEmail(String _email){
		email=_email;
	}
	public String getEmail(){
		return email;
	}
	
	public void setTelefono(String _telefono){
		telefono=_telefono;
	}
	public String getTelefono(){
		return telefono;
	}
	public void mostrarDatos(){
	}

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the tipoCliente
     */
    public String getTipoCliente() {
        return tipoCliente;
    }

    /**
     * @param tipoCliente the tipoCliente to set
     */
    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
}