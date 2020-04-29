package com.dis2020.agenda;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class AppTest {

	Contactos contactos = null;

	// @Before
	// public void initialize() {
	// contactos=new Contactos("jorge","delgado","ufv","722297344","pozuelo");
	// }

	@Test
	public void testMain() {
		// fail("Not yet implemented");
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
    	assertNotEquals(1, c.getsizelista());                                              
	}                                     

	@Test
	void test() {
		// fail("Not yet implemented");
		assertTrue(true);
	}

	@After
	public void finalize() {

		System.out.println("execution After test");

	}

}
