package coche;

import java.io.Serializable;

public class Coche implements Serializable{

    private String marca;
    private String model;
    private int any;
    private String matricula;
    
    public Coche (String marca, String model, int any, String matricula){
        this.marca = marca;
        this.model = model;
        this.any = any;
        this.matricula = matricula;
    }
    
            
    public Coche(){
        this.marca = null;
    
    }
    
    public void setMarca(String marca){
        this.marca= marca;
    }
    public void setModel(String model){
        this.model= model;
    }
    public void setAny(int any){
        this.any= any;
    }
    public void setMatricula(String matricula){
        this.matricula= matricula;
    }
    
    
    
    public String getMarca(){
        return marca;
    }
    public String getModel(){
        return model;
    }
    public int getAny(){
        return any;
    }
    public String getMatricula(){
        return matricula;
    }
    
  
}
