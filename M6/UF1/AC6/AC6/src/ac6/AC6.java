/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac6;

import static java.awt.SystemColor.menu;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import javax.xml.bind.JAXB;
 
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Hector Garzon Borras
 */
public class AC6 {

    private static final String MENU_XML_FILE = "menu2.xml";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JAXBException, IOException {
        // TODO code application logic here
        
        JAXBContext context = JAXBContext.newInstance(Comidas.class);
	Marshaller marshaller = context.createMarshaller();
	marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        
        
        Comidas comidas = llenaComidas();
        
        marshaller.marshal(comidas, System.out);
        
        FileOutputStream fos = new FileOutputStream(MENU_XML_FILE);
        
        marshaller.marshal(comidas, fos);
		fos.close();
                
                Unmarshaller unmarshaller = context.createUnmarshaller();
                
        Comidas comidasAux = (Comidas) unmarshaller.unmarshal(new File(MENU_XML_FILE));
		System.out.println("********* Menu cargado desde archivo XML***************");
            
     
        Comidas comidas2 = JAXB.unmarshal(new FileReader("menu.xml"), Comidas.class);
        JAXB.marshal(comidas, System.out);
        
    }
    
    private static Comidas llenaComidas(){
		
		String[] nombreComida = {"Macarrones", "Pollo frito"};
                int[] precioComida = {6, 11};
                String[] descripcionComida = {"Los que te hace tu madre", "Como si en Kentucky"};
		int[] caloriasComida = {500, 800};
		Comida[] ArrayComidas = new Comida[2];
		
		for(int i=0; i<2; i++){
			ArrayComidas[i] = new Comida();
                        ArrayComidas[i].setNombre(nombreComida[i]);
                        ArrayComidas[i].setPrecio(precioComida[i]);
                        ArrayComidas[i].setDescripcion(descripcionComida[i]);
                        ArrayComidas[i].setCalorias(caloriasComida[i]);
			ArrayComidas[i].setId(i);			
		}
		
		Comidas comidas = new Comidas();
		comidas.setComidas(ArrayComidas);
		
		return comidas;
	}
    
}
