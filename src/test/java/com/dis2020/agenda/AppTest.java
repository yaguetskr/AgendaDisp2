package com.dis2020.agenda;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class AppTest {

	Contactos contactos = null;

	
	@Test
	public void testMain() {
		assertTrue(true);
	}

	@Test
	public void testcrear_contacto() {
	    contactos = new Contactos("jorge", "delgado", "ufv", "722297344", "pozuelo");   
		listaContactos c = new listaContactos();
		c.addContacto(contactos);
		assertEquals(1, c.getsizelista());

	}

	@Test
	public void testErrorcrear_contacto() {
	    contactos = new Contactos("jorge", "delgado", "ufv", "722297344", "pozuelo");   
		listaContactos c = new listaContactos();                                        
		c.addContacto(contactos);                                                       
    	assertNotEquals(0, c.getsizelista());                                              
	}  
	
	@Test
	public void testleer_contacto() {
	    contactos = new Contactos("jorge", "delgado", "ufv", "722297344", "pozuelo");   
		                                                      
	    assertTrue(contactos.leercontacto());                                             
	}      
	@Test
	public void testErrorleer_contacto() {
	    contactos = new Contactos("jorge", "delgado", "ufv", "722297344", "pozuelo");   
		                                                      
    	assertFalse(!contactos.leercontacto());                                              
	}     

	@Test
	public void testActualizar_contacto() {
	    contactos = new Contactos("jorge", "delgado", "ufv", "722297344", "pozuelo");   
		  
    	assertTrue( contactos.actualizarcontacto("yago", "cabello", "ufv", "654323232", "pozuelo"));                                              
	}      
	@Test
	public void testErrorActualizar_contacto() {
	    contactos = new Contactos("jorge", "delgado", "ufv", "722297344", "pozuelo");   
		                                                      
    	assertFalse(!contactos.actualizarcontacto("yago", "cabello", "ufv", "654323232", "pozuelo"));                                              
	}     

	
	@Test
	public void testeliminar_contacto() {
	    contactos = new Contactos("jorge", "delgado", "ufv", "722297344", "pozuelo");   
		listaContactos c = new listaContactos();
		c.addContacto(contactos);
		c.eliminarContacto(contactos);   
		assertEquals(0, c.getsizelista());

	}

	@Test
	public void testErroreliminar_contacto() {
	    contactos = new Contactos("jorge", "delgado", "ufv", "722297344", "pozuelo");   
		listaContactos c = new listaContactos();    
		c.addContacto(contactos);
		c.eliminarContacto(contactos);                                                       
    	assertNotEquals(1, c.getsizelista());                                              
	}  
	

	


}
