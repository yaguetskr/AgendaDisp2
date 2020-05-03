package com.dis2020.agenda;

import java.util.ArrayList;
import java.util.List;


public class listaContactos extends ArrayList<Contacto> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Contacto> listacontacto;

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
