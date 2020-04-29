package com.dis2020.agenda;

import java.util.ArrayList;

public class listaContactos {

	private ArrayList<Contactos> listacontactos;

	public listaContactos() {
		listacontactos = new ArrayList<Contactos>();

	}

	public int getsizelista() {
	return listacontactos.size();
	}
	public void addContacto(Contactos c) {
		listacontactos.add(c);
	}

}
