package com.dis2020.agenda;

public class Contactos {
	
private String nombre;
private String apellidos;
private String empresa ;
private String email;
private String direccion;

public Contactos(String n,String a,String emp,String ema,String d) {
	nombre=n;
	apellidos =a ;
	empresa = emp;
	email= ema;
	direccion = d;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getApellidos() {
	return apellidos;
}

public void setApellidos(String apellidos) {
	this.apellidos = apellidos;
}

public String getEmpresa() {
	return empresa;
}

public void setEmpresa(String empresa) {
	this.empresa = empresa;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getDireccion() {
	return direccion;
}

public void setDireccion(String direccion) {
	this.direccion = direccion;
}

public boolean  leercontacto() {
	
	System.out.println("nombre :" + getNombre());
	System.out.println("apellidos:" + getApellidos());
	System.out.println("empresa:" + getEmpresa());
	System.out.println("email :" + getEmail());
	System.out.println("direccion:" + getDireccion());
	
	return true;
}

public boolean actualizarcontacto(String n,String a,String emp,String ema,String d) {
	setNombre(n);
	setApellidos(a);
	setEmpresa(emp);
	setEmail(ema);
	setDireccion(d);
	return true;
	
}




}
