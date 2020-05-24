package com.dis2020.agenda;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.Gson;
import javax.servlet.annotation.WebServlet;
import com.vaadin.ui.Grid;
import java.util.Arrays;
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
import java.io.Reader;
import java.io.FileWriter;
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
     programa();
        
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
    

@SuppressWarnings("unused")
public int programa() {
    final VerticalLayout layout = new VerticalLayout();
    

    Gson gson = new Gson();
    Gson gson2 = new Gson();
    listaContactos contacts = new listaContactos();
    VerticalLayout añadir= new VerticalLayout();	
    VerticalLayout modificar= new VerticalLayout();
	HorizontalLayout botones=new HorizontalLayout();

	
	
    Grid<Contacto> tabla = new Grid<>("Contactos");
    
    final TextField name = new TextField();
    name.setCaption("Type your name here:");

    Button hid = new Button("Contacto nuevo");
    Button hid2 = new Button("Editar contacto");
    
    
    try (Reader reader = new FileReader("contactos.json")) {

        // Convert JSON File to Java Object
        Contacto[] contactos =gson.fromJson(reader, Contacto[].class);

        contacts.addAll(Arrays.asList(contactos));
      

    } catch (IOException e) {
        e.printStackTrace();
    }
		
  
    
	TextField añadirnombre=new TextField("Nombre");
	TextField añadirapellido=new TextField("Apellido");
	TextField añadirdireccion=new TextField("Direccion");
	TextField añadirempresa=new TextField("Empresa");
	TextField añadirmail=new TextField("Email");
	TextField añadirtelefono=new TextField("Telefono");
	Button boton1=new Button ("Añadir contacto");
	añadir.addComponents(añadirnombre,añadirapellido,añadirdireccion,añadirempresa,añadirmail,añadirtelefono,boton1);
	añadir.setVisible(false);
   	
   	
   	
   	TextField modificarid=new TextField("ID del contacto a modificar");
   	TextField modificarnombre=new TextField("Nombre");
   	TextField modificarapellido=new TextField("Apellido");
   	TextField modificardireccion=new TextField("Direccion");
   	TextField modificarempresa=new TextField("Empresa");
   	TextField modificarmail=new TextField("Email");
   	TextField modificartelefono=new TextField("Telefono");
   	Button boton2=new Button ("Modificar contacto");
   	modificar.addComponents(modificarid,modificarnombre,modificarapellido,modificardireccion,modificarempresa,modificarmail,modificartelefono,boton2);       	
   	modificar.setVisible(false);
   

    hid.addClickListener(e -> {
        
    	if (añadir.isVisible()){
    		
    		añadir.setVisible(false);
    	}else {
    		añadir.setVisible(true);
    	}
    	
    });
   	
   	
    hid2.addClickListener(e -> {
        
    	if (modificar.isVisible()){
    		
    		modificar.setVisible(false);
    	}else {
    		modificar.setVisible(true);
    	}
    	
    });

   	
   	
   	boton1.addClickListener(add ->{
   		
   		
   		contacts.add(new Contacto(añadirnombre.getValue(),añadirapellido.getValue(),añadirempresa.getValue(),añadirtelefono.getValue(),añadirmail.getValue(),añadirdireccion.getValue()));
   		tabla.getDataProvider().refreshAll();
   		Notification.show("Contacto añadido");
   		//Se añade el contacto al JSON
   		try (FileWriter writer = new FileWriter("contactos.json")) {
            gson.toJson(contacts, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
   	});
   	
   	
   	boton2.addClickListener(mod ->{
   		int i;
   		for(i=0;i<contacts.size();++i) {
   			
   			if( modificarid.getValue().toString().equals(contacts.get(i).getid()) ) {
   				Notification.show("Contacto modificado con éxito");
   				
   				contacts.set(i,new Contacto(modificarnombre.getValue(),modificarapellido.getValue(),modificarempresa.getValue(),modificartelefono.getValue(),modificarmail.getValue(),modificardireccion.getValue() ));
   				i=contacts.size()+2;
   				tabla.getDataProvider().refreshAll();
   			}
   			
   			
   			
   		}
   		if(i==contacts.size()) {
   			Notification.show("No se encontró el contacto");
   			
   		}
   		
   	});
   	
   	HorizontalLayout formularios = new HorizontalLayout();
   	formularios.addComponents(hid,añadir,hid2,modificar);
   	layout.addComponent(formularios);
   	formularios.setSizeFull();
    
    
    
    tabla.setSizeFull();
    tabla.setItems(contacts);
    
    tabla.getEditor().setEnabled(false);
    tabla.getEditor().setSaveCaption("Modificar");
    tabla.getEditor().setCancelCaption("Cancelar");
    
    tabla.addColumn(Contacto::getnombre).setCaption("Nombre");
    tabla.addColumn(Contacto::getapellidos).setCaption("Apellidos");
    tabla.addColumn(Contacto::gettelefono).setCaption("Telefono");

    tabla.addComponentColumn(item -> new Button("BORRAR", click -> {
        contacts.remove(item);
        tabla.getDataProvider().refreshAll();
        
        try (FileWriter writer = new FileWriter("contactos.json")) {
            gson.toJson(contacts, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }));

    
    
    
    
    
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
    
    layout.addComponents(tabla,botones);
    
    
    
    
    setContent(layout);
    return 0;
}
public MyUI() {}
	
}
