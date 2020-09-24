
package veureinfo;

import java.io.File;

/**
 *
 * @author Hector
 */
public class Veureinfo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Fitxers al directori actual: ");
		 File f = new File(args[0]);
		 String[] arxius = f.list();
                 
                 
                  System.out.println("INFORMACIÓ SOBRE EL FITXER");
		 if(f.exists()){
                        if(f.isFile()){
			 System.out.println("Nom del fitxer : "+f.getName());
			 System.out.println("Ruta           : "+f.getPath());
			 System.out.println("Ruta absoluta  : "+f.getAbsolutePath());
			 System.out.println("Es pot escriure: "+f.canRead());
			 System.out.println("Es pot llegir  : "+f.canWrite());
			 System.out.println("Grandaria      : "+f.length());
			 System.out.println("Es un directori: "+f.isDirectory());
			 System.out.println("Es un fitxer   : "+f.isFile());
                        }
                 }
                           
                        if(f.isDirectory()){
                          for (int i = 0; i<arxius.length; i++){
                            System.out.println(arxius[i]);
                          }
                        }
                 else{
                     System.out.println("EL FITXER O DIRECTORI NO EXISTEIX");
                 }
                
               if(f.isHidden()){
                   System.out.println("Esta ocult");        
               }
               
               System.out.println("L'ultima modificacio va ser el: " + (18528-( ( ( ( ((f.lastModified()) /1000) /60) /60) /24) ) ) );
               
               if(18528-( ( ( ( ((f.lastModified()) /1000) /60) /60) /24) ) <3){
                   System.out.println("Fa menys de 3 dies que es va modificar l'arxiu");
               }
    }
}
    

