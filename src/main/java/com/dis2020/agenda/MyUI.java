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
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.HorizontalLayout;
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
        
        
        Grid<Contacto> tabla = new Grid<>("Contactos");
        
        final TextField name = new TextField();
        name.setCaption("Type your name here:");

        Button button = new Button("Click Me");
        button.addClickListener(e -> {
            layout.addComponent(new Label("Thanks " + name.getValue() 
                    + ", it works!"));
        });
        
        List<Contacto> contacts =new ArrayList<Contacto>();
        
       
        
       	contacts.add(new Contacto("Aurelio","Sanchez de la serna","Microsoft","999999","pipo@gmail.com","Calle falsa numero 8"));
       	contacts.add(new Contacto("Eusebio","afters","NASA","8888888","euse@gmail.com","Calle falsa numero 11"));
        	
        		
       	VerticalLayout añadir= new VerticalLayout();
       	TextField añadirnombre=new TextField("Nombre");
       	TextField añadirapellido=new TextField("Apellido");
       	TextField añadirdireccion=new TextField("Direccion");
       	TextField añadirempresa=new TextField("Empresa");
       	TextField añadirmail=new TextField("Email");
       	TextField añadirtelefono=new TextField("Telefono");
       	Button boton1=new Button ("Añadir contacto");
       	añadir.addComponents(añadirnombre,añadirapellido,añadirdireccion,añadirempresa,añadirmail,añadirtelefono,boton1);
       	
       	
       	VerticalLayout modificar= new VerticalLayout();
       	TextField modificarid=new TextField("ID del contacto a modificar");
       	TextField modificarnombre=new TextField("Nombre");
       	TextField modificarapellido=new TextField("Apellido");
       	TextField modificardireccion=new TextField("Direccion");
       	TextField modificarempresa=new TextField("Empresa");
       	TextField modificarmail=new TextField("Email");
       	TextField modificartelefono=new TextField("Telefono");
       	Button boton2=new Button ("Modificar contacto");
       	modificar.addComponents(modificarid,modificarnombre,modificarapellido,modificardireccion,modificarempresa,modificarmail,modificartelefono,boton2);       	
       	
      
       	
       	boton1.addClickListener(e ->{
       		
       		//Notification.show("Exito");
       		contacts.add(new Contacto(añadirnombre.getValue(),añadirapellido.getValue(),añadirempresa.getValue(),añadirtelefono.getValue(),añadirmail.getValue(),añadirdireccion.getValue()));
       		
       		Notification.show(contacts.get(2).getnombre());
       		tabla.getDataProvider().refreshAll();
       	});
       	
       	
       	boton2.addClickListener(e2 ->{
       	
       		for(int i=0;i<contacts.size();++i) {
       			System.out.println(contacts.get(i).getid().length());
       			System.out.println(modificarid.getValue().length());
       			System.out.println(modificarid.getValue().toString().equals(contacts.get(i).getid()));
       			if( modificarid.getValue().toString().equals(contacts.get(i).getid()) ) {
       				Notification.show(contacts.get(i).getnombre());
       				System.out.println(contacts.get(i).getapellidos());
       				contacts.set(i,new Contacto(modificarnombre.getValue(),modificarapellido.getValue(),modificarempresa.getValue(),modificartelefono.getValue(),modificarmail.getValue(),modificardireccion.getValue() ));
       				
       				tabla.getDataProvider().refreshAll();
       			}
       			
       			
       			
       		}
       		
       	});
       	
       	HorizontalLayout formularios = new HorizontalLayout();
       	formularios.addComponents(añadir,modificar);
       	layout.addComponent(formularios);
       	formularios.setSizeFull();
        
        
        
        tabla.setSizeFull();
        tabla.setItems(contacts);
        tabla.addColumn(Contacto::getnombre).setCaption("Nombre");
        tabla.addColumn(Contacto::getapellidos).setCaption("Apellidos");
        tabla.addColumn(Contacto::gettelefono).setCaption("Telefono");
        
        
        
        
        
        tabla.setDetailsGenerator(Contacto -> {
            HorizontalLayout sublayout = new HorizontalLayout();
            Label label = new Label("    Empresa: "+Contacto.getempresa()+"\n");
            Label label2 = new Label("    \nEmail: "+Contacto.getemail()+"\n");
            Label label3 = new Label("    \nDireccion: "+Contacto.getdireccion()+"\n");
            Label label4 = new Label("    \nID: "+Contacto.getid()+"\n");
            
            
            
            
            
            sublayout.addComponents(label,label2,label3,label4);  
            return sublayout;
        });
        
        tabla.addItemClickListener(click -> {
            final Contacto person = click.getItem();
            tabla.setDetailsVisible(person, !tabla.isDetailsVisible(person));
        });
        
        layout.addComponents(tabla);
        
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
