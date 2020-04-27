package com.dis2020.agenda;

public class Contacto {
	String nombre;
	String apellidos;
	String empresa;
	String telefono;
	String email;
	String direccion;
	
	public Contacto(String nom,String ape,String emp,String tlf,String mail,String dir) {
		
		nombre=nom;
		apellidos=ape;
		empresa=emp;
		telefono=tlf;
		email=mail;
		direccion=dir;
		
		
	}
	
	public void setnombre(String ent) {
		nombre=ent;
	}
	
	public void setapellidos(String ent) {
		apellidos=ent;
	}
	
	public void setempresa(String ent) {
		empresa=ent;
	}
	
	public void settelefono(String ent) {
		telefono=ent;
	}
	
	public void setemail(String ent) {
		email=ent;
	}
	
	public void setdireccion(String ent) {
		direccion=ent;
	}
	
	public String getnombre() {
		return this.nombre;
	}
	
	public String getapellidos() {
		return this.apellidos;
	}

	public String getdireccion() {
		return this.direccion;
	}
	
	public String getemail() {
		return this.email;
	}
	
	public String getempresa() {
		return this.empresa;
	}
	
	public String gettelefono() {
		return this.telefono;
	}


}
