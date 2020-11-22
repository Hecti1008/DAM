package A8;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.persistence.*;
import java.util.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author megah
 */
public class AC8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        Scanner scan = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        String marca;
        String model;
        String nom;
        String naixement;
        int codiPostal;
        int anyCotxe;
        int esContinua;
        boolean minusvalid;
        String matriculacio;
        boolean accident;
        boolean continuar = true;
        int menu;
        
        
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("$objectdb/db/AC8.odb");
        EntityManager em = emf.createEntityManager();
        
        System.out.println("Introdueix el primer propietari");
        em.getTransaction().begin();
        
        while(continuar == true) {
            System.out.println("nom");
            nom = scan.nextLine();
            
            System.out.println("Codi postal");
            codiPostal = scan.nextInt();
            
            System.out.println("Data naixement (dd/MM/yyyy)");
            naixement = scan.next();
            Date naixementDef = sdf.parse(naixement);
            
            System.out.println("minusvalia? true o false ");
            minusvalid = scan.nextBoolean();
            
            Propietari pr;
            pr = new Propietari(codiPostal, nom, naixementDef, minusvalid);
            
            em.persist(pr);
            
            System.out.println("Vols afegir un altre propietari? SI:1 NO:0");
            esContinua = scan.nextInt();
            scan.nextLine();
            
            if(esContinua == 1){
                continuar = true;
            } else {
                continuar = false;
            }
        }
        
        continuar = true;
        System.out.println("Introdueix el vehicle numero 1");
        while(continuar == true) {
            System.out.println("Marca");
            marca = scan.nextLine();
            
            System.out.println("Model");
            model = scan.nextLine();
            
            System.out.println("Any del cotxe");
            anyCotxe = scan.nextInt();
            
            System.out.println("Matriculacio");
            matriculacio = scan.next();
            Date dataCotxe = sdf.parse(matriculacio);
            
            System.out.println("Accidentat?");
            accident = scan.nextBoolean();
            
            Vehicles v;
            v = new Vehicles(marca, model, anyCotxe, dataCotxe, accident);
            
            em.persist(v);
            
            System.out.println("Vols introduir un altre vehicle? SI:1 NO:0");
            esContinua= scan.nextInt();
            scan.nextLine();
            if(esContinua == 1){
                continuar = true;
            } else {
                continuar = false;
            }
        }
        
        em.getTransaction().commit();
        continuar = true;
        
        while(continuar){

            System.out.println("0. Ensenyar propietaris");
            System.out.println("1. Ensenyar vehicles");
            System.out.println("2. Sortir");
            menu = scan.nextInt();

            if (menu == 0){
                returnPropietari(em);
            }else if (menu == 1){
                returnVehicles(em);
            }else{ 
                continuar = false;
            }

        }
        
    }
    public static void returnPropietari(EntityManager em){
        TypedQuery<Propietari> query =
        em.createQuery("SELECT pr FROM Propietari pr", Propietari.class);
        List<Propietari> results = query.getResultList();
        for (Propietari p : results) {
            System.out.println(p);
        }
    }
    
    public static void returnVehicles(EntityManager em){
        TypedQuery<Vehicles> query =
        em.createQuery("SELECT v FROM Vehicles v", Vehicles.class);
        List<Vehicles> results = query.getResultList();
        for (Vehicles v : results) {
            System.out.println(v);
        }
    }
    
    
    
}

