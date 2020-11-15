/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AC7;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Scanner;

/**
 *
 * @author megah
 */
public class Notaria {
     public static void main(String args[]) throws IOException,
             NoSuchAlgorithmException, InvalidKeySpecException {
         
         
        Scanner scanner = new Scanner (System.in);
        boolean verificacio;
        PublicKey clauPublica;
        byte[] clauPublicabytes;
        byte[] textBytes;
        byte[] firmaBytes;
        
        clauPublicabytes = Files.readAllBytes (Paths.get("clauPublica"));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        
       String publicKeyContent = new String (clauPublicabytes);
       byte[] publicKeyDecoded = Base64.getDecoder().decode(publicKeyContent);
       X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyDecoded);
       clauPublica = keyFactory.generatePublic(publicKeySpec);
       
       
      textBytes = Files.readAllBytes(Paths.get("missatge"));
      firmaBytes = Files.readAllBytes(Paths.get("firma"));
      verificacio = validateSignature(textBytes, firmaBytes, clauPublica);
      
      if(verificacio) {
          System.out.println("Comprovant signatura de l’arxiu missatge...OK");
      } else {
          System.out.println("Comprovant signatura de l’arxiu missatge...ERROR");
      }
     }
     

    private static boolean validateSignature(byte[] data, byte[] signature, 
            PublicKey pub) {
      boolean isValid = false;
            try {
                Signature signate = Signature.getInstance("SHA1withRSA");
                signate.initVerify(pub);
                signate.update(data);
                isValid = signate.verify(signature);
            } catch (Exception ex) {
                System.err.println("Error al validar les dades: " + ex);
            }
            return isValid;
    }
             
            
    
    
}
