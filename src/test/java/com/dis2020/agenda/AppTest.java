package com.dis2020.agenda;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;



class AppTest {

	Contacto contactos = null;

	
	@Test
	public void testcontacto() {
		Contacto contacto= new Contacto();

	}

	@Test
	public void testcrear_contacto() {
	    contactos = new Contacto();   
		listaContactos c = new listaContactos();
		 int expected=1;
		c.addContacto(contactos);
		assertEquals(expected, c.getsizelista());

	}

	@Test
	public void testErrorcrear_contacto() {
	    contactos = new Contacto("jorge", "delgado", "ufv", "722297344","qwerty@gmail.com", "pozuelo");   
		listaContactos c = new listaContactos();   
		 int expected=0;
		c.addContacto(contactos);                                                       
    	assertNotEquals(expected, c.getsizelista());                                              
	}  
	
	@Test
	public void testleer_contacto() {
	    contactos = new Contacto("jorge", "delgado", "ufv", "722297344","qwerty@gmail.com", "pozuelo"); 
		                                                      
	    assertTrue(contactos.leercontacto());                                             
	}      
	@Test
	public void testErrorleer_contacto() {
	    contactos = new Contacto("jorge", "delgado", "ufv", "722297344","qwerty@gmail.com", "pozuelo"); 
		                                                      
    	assertFalse(!contactos.leercontacto());                                              
	}     

	@Test
	public void testActualizar_contacto() {
	    contactos = new Contacto("jorge", "delgado", "ufv", "722297344","qwerty@gmail.com", "pozuelo"); 
		  
    	assertTrue( contactos.actualizarcontacto("jorge", "delgado", "ufv", "722297344","qwerty@gmail.com", "pozuelo"));                                              
	}      
	@Test
	public void testErrorActualizar_contacto() {
	    contactos = new Contacto("jorge", "delgado", "ufv", "722297344","qwerty@gmail.com", "pozuelo");    
		                                                      
    	assertFalse(!contactos.actualizarcontacto("jorge", "delgado", "ufv", "722297344","qwerty@gmail.com", "pozuelo"));                                              
	}     

	
	@Test
	public void testeliminar_contacto() {
	    contactos = new Contacto("jorge", "delgado", "ufv", "722297344","qwerty@gmail.com", "pozuelo");  
		listaContactos c = new listaContactos();
		 int expected=0;
		c.addContacto(contactos);
		c.eliminarContacto(contactos);   
		assertEquals(expected, c.getsizelista());

	}

	@Test
	public void testErroreliminar_contacto() {
	    contactos = new Contacto("jorge", "delgado", "ufv", "722297344","qwerty@gmail.com", "pozuelo");  
		listaContactos c = new listaContactos();    
		 int expected=1;
		c.addContacto(contactos);
		c.eliminarContacto(contactos);                                                       
    	assertNotEquals(expected, c.getsizelista());                                              
	}  
	
	@Test
	public void testmain() {
	    MyUI probando = new MyUI();
	  int expected=0;
    	assertEquals(expected,probando.programa());                                              
	}  
	

	


}
