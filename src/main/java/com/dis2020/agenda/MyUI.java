package com.dis2020.agenda;

import java.util.Arrays;

import javax.servlet.annotation.WebServlet;
import com.vaadin.ui.Grid;
import java.util.ArrayList;
import java.util.List;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import java.util.Arrays;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        
        final TextField name = new TextField();
        name.setCaption("Type your name here:");

        Button button = new Button("Click Me");
        button.addClickListener(e -> {
            layout.addComponent(new Label("Thanks " + name.getValue() 
                    + ", it works!"));
        });
        
        List<Contacto> contacts =new ArrayList<Contacto>();
        
        Contacto temp = new Contacto("Aurelio","Sanchez de la serna","microsoft","999999","pipo@gmail.com","Calle falsa numero 8");
       	contacts.add(temp);
        	
        		
        		
        
        
        
        Grid<Contacto> tabla = new Grid<>("Contactos");
        tabla.setSizeFull();
        tabla.setItems(contacts);
        tabla.addColumn(Contacto::getnombre).setCaption("Nombre");
        tabla.addColumn(Contacto::getapellidos).setCaption("Apellidos");
        tabla.addColumn(Contacto::getempresa).setCaption("Empresa");
        tabla.addColumn(Contacto::gettelefono).setCaption("Telefono");
        tabla.addColumn(Contacto::getemail).setCaption("Email");
        tabla.addColumn(Contacto::getdireccion).setCaption("Direccion");
        
        
        
        
        
        layout.addComponents(tabla);
        
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
