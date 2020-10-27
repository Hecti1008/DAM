/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac6;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hector Garzon Borras
 */

@XmlRootElement
public class Comidas {
    
    private Comida[] comidas;
 
	
	public Comida[] getComidas() {
		return comidas;
	}
	public void setComidas(Comida[] comidas) {
		this.comidas = comidas;
	}
}
