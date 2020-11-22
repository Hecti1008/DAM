/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A8;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
/**
 *
 * @author megah
 */
@Entity
public class Propietari implements Serializable{
    private static final long svUID = 1L;
    @Id
    @GeneratedValue
    private long id;
    
    private int codiPostal;
    private String nom;
    private Date naixement;
    private boolean minusvalid;
    
    public Propietari() {
    }
    
    Propietari(int codiPostal, String nom, Date naixement, 
            boolean minusvalid){
        this.codiPostal = codiPostal;
        this.nom = nom;
        this.naixement = naixement;
        this.minusvalid = minusvalid;
    }

    public long getId() {
        return id;
    }

    public int getCodiPostal() {
        return codiPostal;
    }

    public String getNom() {
        return nom;
    }

    public Date getNaixement() {
        return naixement;
    }

    public boolean getMinusvalid() {
        return minusvalid;
    }
    
    @Override
    public String toString(){
        return "Propietari{" + "id=" + id + ", codiPostal=" + codiPostal + 
                ", nom=" + nom + ", naixement=" + naixement + ", minusvalid=" + 
                minusvalid + "}";
    }
}
