/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A8;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author megah
 */
@Entity
public class Vehicles implements Serializable{
    @Id
    @GeneratedValue
    private long id;
    private static final long svUID = 1L;
    
    private int anyCotxe;
    private String marca;
    private String model;
    private boolean accident;
    private Date matriculacio;
    
    public Vehicles(){
    }
    
    Vehicles(String marca, String model, int anyCotxe, Date matriculacio,
        boolean accident){
    
    this.marca = marca;
    this.model = model;
    this.anyCotxe = anyCotxe;
    this.matriculacio = matriculacio;
    this.accident = accident;   
}
        
    public Long getId() {
        return id;
    }

    public int getAnyCotxe() {
        return anyCotxe;
    }

    public String getMarca() {
        return marca;
    }

    public String getModel() {
        return model;
    }

    public boolean getAccident() {
        return accident;
    }

    public Date getMatriculacio() {
        return matriculacio;
    }
    
    @Override
    public String toString() {
        return "Vehicles{" + "id=" + id + ", anyCotxe=" + anyCotxe + 
                ", marca=" + marca + ", model=" + model + ", accident=" +
                accident + ", matriculacio=" + matriculacio +"}";
    }
    
}
