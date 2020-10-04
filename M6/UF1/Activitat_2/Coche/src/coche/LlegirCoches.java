package coche;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class LlegirCoches {
    public static void main(String[]args) throws IOException, ClassNotFoundException{
        Coche coche;
        
        File fitxer=new File("C:\\CochesObjecte.txt");
        
        FileInputStream filein = new FileInputStream(fitxer);
        
        ObjectInputStream dataInCoches = new ObjectInputStream(filein);
        
        try{
        
            while(true){
                
                    coche=(Coche) dataInCoches.readObject();
                    System.out.println("Marca: "+ coche.getMarca()+ "Model: "+ coche.getModel()+ "Any: "+ coche.getAny()+ "Matricula: "+ coche.getMatricula());
            
            }
        }catch(EOFException eo){}
                   
           dataInCoches.close();
        
        
    }
}
