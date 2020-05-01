package com.dis2020.agenda;

public class Contacto {
	String nombre;
	String apellidos;
	String empresa;
	String telefono;
	String email;
	String direccion;
	String id;
	
	
	public Contacto() {
		
	}
	
	
	public Contacto(String nom,String ape,String emp,String tlf,String mail,String dir) {
		
		nombre=nom;
		apellidos=ape;
		empresa=emp;
		telefono=tlf;
		email=mail;
		direccion=dir;
		id=generarid(nom,ape,tlf,dir);
		
		
	}
	
	public String generarid(String nom,String ape,String num,String dir) {
		return nom.charAt(0)+ape.charAt(0)+num.charAt(0)+String.valueOf(dir.length());
		
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
	
	public void setid(String ent) {
		id=ent;
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
	
	public String getid() {
		return this.id;
	}
	
	
	
	public String gettelefono() {
		return this.telefono;
	}

	public boolean  leercontacto() {
		
		System.out.println("id:" + getid());
		System.out.println("nombre :" + getnombre());
		System.out.println("apellidos:" + getapellidos());
		System.out.println("empresa:" + getempresa());
		System.out.println("telefono :" + gettelefono());
		System.out.println("email :" + getemail());
		System.out.println("direccion:" + getdireccion());
		
		return true;
	}

	public boolean actualizarcontacto(String n,String a,String emp,String tlf,String e,String d) {
		setnombre(n);
		setapellidos(a);
		setempresa(emp);
		settelefono(tlf);
		setemail(e);
		setdireccion(d);
		setid(generarid(n,a,tlf,d));
		return true;
		
	}

}
