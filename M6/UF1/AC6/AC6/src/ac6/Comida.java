/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac6;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author Hector Garzon Borras
 */

@XmlRootElement(name = "Comida")


public class Comida {
    
    
        private String nombre;
        private int precio;
        private String descripcion;
        private int calorias;
        private int id;
        
        @XmlAttribute(name="nombre")        
        public String getNombre() {
		return this.nombre;
	}        
            
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
        
        public int getPrecio() {
                return this.precio;
        }
        
        public void setPrecio (int precio) {
                this.precio = precio;
        }
        
        public String getDescripcio() {
                return this.descripcion;
        }
        
        public void setDescripcion(String descripcion) {
                this.descripcion = descripcion;
        }
        
        public int getCalorias() {
                return this.calorias;
        }
        
        public void setCalorias(int calorias) {
                this.calorias = calorias;
        }
        
        public int getId() {
                return this.id;
        }
        
        public void setId(int id) {
                this.id = id;
        }

 
}
