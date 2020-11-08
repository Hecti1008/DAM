/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac5;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Scanner;
import javax.crypto.Cipher;

/**
 *
 * @author megah
 */
public class AC5 {

    /**
     * @param args the command line arguments
     */
    
        public static void main(String args[]){
       
            
        Scanner scanner = new Scanner (System.in);
        
        
        byte[] ArrayBytes;
        byte[] missatgeEncript;
        byte[] missatgeDesencript;
        String missatgeDesencriptat;
        KeyPair clave;
        PrivateKey clauPrivada;
        PublicKey clauPublica;
        String data;
          
        
        clave = randomGenerate (512);
        
        
        clauPrivada = clave.getPrivate();
        clauPublica = clave.getPublic();
        
        
        System.out.println("Escriu el misatge a encriptar");
        data = scanner.nextLine();
        ArrayBytes = data.getBytes();
        
       
        missatgeEncript = encryptData(ArrayBytes,clauPublica);
        System.out.println(missatgeEncript + "\n");
        
        
        missatgeDesencript = decryptData(missatgeEncript,clauPrivada);
        missatgeDesencriptat = new String (missatgeDesencript);
        System.out.println(missatgeDesencriptat);
        
        
        System.out.println();
    } 
    
    
    
    public static byte[] encryptData(byte[] data, PublicKey pub) {
        byte[] criptedData = null;
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding","SunJCE");
            cipher.init(Cipher.ENCRYPT_MODE, pub);
            criptedData = cipher.doFinal(data);
        }catch (Exception ex) {
            System.err.println("Error cifrat: " + ex);
        }
        
        
        return criptedData;
}
    
    public static byte[] decryptData(byte[] data, PrivateKey pub) {
        byte[] criptedData = null;
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding","SunJCE");
            cipher.init(Cipher.DECRYPT_MODE, pub);
            criptedData = cipher.doFinal(data);
        }catch (Exception ex) {
            System.err.println("Error de cifratge: " + ex);
        }
        
        
        return criptedData;
}       

    public static KeyPair randomGenerate(int lenghClau) {
            KeyPair keys = null;
            try {
                KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
                keyGen.initialize(lenghClau);
                keys = keyGen.genKeyPair();
            } catch (Exception ex) {
                System.err.println("La generacio no respon.");
            }
            
            
        return keys;
        }
    

}