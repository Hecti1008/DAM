package coche;

import java.io.*;
import java.util.Scanner;

public class IntroduirCoches {
    public static void main(String[]args) throws IOException{
        
        Coche coche;
        
        File fitxer=new File("C:\\CochesObjecte.txt");
        
        FileOutputStream fileout = new FileOutputStream(fitxer);
        
        ObjectOutputStream dataOuCoches = new ObjectOutputStream(fileout);
        
        String Marca[]={"Porsche", "Audi", "BMW", "Hyundai", "Volkswagen", "Lamborghini"};
        
        String Model[]={"911 Turbo", "R8 v10", "M8 Competition", "i30 N", "Golf GTI", "Huracan EVO"};
        
        int Any[]={1995, 2015, 1999, 2017, 1976, 2017};
               
        String Matricula[]={"3495 NJF", "7219 AFD", "9648 CSW", "3617 LTR", "8521 TTS", "6731 MNL"};
        
        for (int i=0; i<Marca.length; i++){
            coche = new Coche(Marca[i], Model[i], Any[i], Matricula[i]);
            dataOuCoches.writeObject(coche);
        }
        
        Scanner sc = new Scanner(System.in);
        
        String marcaM="";
        String modelM="";
        int anyM=0;
        String matriculaM="";
        
         

        System.out.println("Introdueix un nou coche: ");
        System.out.println("Marca del coche: ");
        marcaM = sc.next();
        
        System.out.println("Model del coche: ");
        modelM = sc.next();
        
        System.out.println("Any del coche: ");
        anyM = sc.nextInt();
        
        System.out.println("Matricula del cotxe: ");
        matriculaM = sc.next();
        
        coche = new Coche(marcaM, modelM, anyM, matriculaM);
            dataOuCoches.writeObject(coche);
        
        
        
        
        dataOuCoches.close();
    }
}
