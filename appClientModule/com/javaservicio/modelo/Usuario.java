package com.javaservicio.modelo;
import javax.persistence.Entity;
import javax.persistence.Id;


public class Usuario {
	
	
    private int idusuario;
    private long dni;
    private String nombre;
    private String apellido;
    private String email;
    private boolean bajausuario;
    private Login login;
    
    
    public Usuario(){
    	
    }
        
	public Usuario(long dni, String nombre, String apellido, String email, boolean bajausuario, Login login) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.bajausuario = bajausuario;
		this.login = login;
	}
	public int getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}
	public long getDni() {
		return dni;
	}
	public void setDni(long dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isBajausuario() {
		return bajausuario;
	}
	public void setBajausuario(boolean bajausuario) {
		this.bajausuario = bajausuario;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}

	@Override
	public String toString() {
		return "Usuario [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", bajausuario=" + bajausuario + ", login=" + login + "]";
	}
    
    
 
	
    

}
