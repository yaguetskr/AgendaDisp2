package com.dis2020.agenda;

import java.util.ArrayList;

public class listaContactos {

	private ArrayList<Contacto> listacontacto;

	public listaContactos() {
		listacontacto = new ArrayList<Contacto>();

	}

	public int getsizelista() {
	return listacontacto.size();
	}
	public void addContacto(Contacto c) {
		listacontacto.add(c);
	}
	public void eliminarContacto(Contacto c) {
		listacontacto.remove(c);
	}
	

}
