package AC7;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import java.util.Base64;
import java.util.Scanner;
/**
 *
 * @author megah
 */
public class Signatura {


    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  throws IOException, 
            NoSuchAlgorithmException, InvalidKeySpecException {
        
       Scanner scanner = new Scanner (System.in);
       Base64.Encoder encoder = Base64.getEncoder();
       
       KeyPair clau;
       int Keysize = 512;
       PrivateKey privatekey;
       PublicKey publickey;
       String missatge;
       String dataMissatge;
       byte[] missatgeBytes;
       byte[] privateArray;
       byte[] signatura;
       byte[] privateArrayBytes;
       
       clau = randomGenerate (Keysize);
       privatekey = clau.getPrivate();
       publickey = clau.getPublic();
       
       publicKeyFile(publickey);
       privateKeyFile(privatekey);
       
       System.out.println("Generant claus publiques i privades " + 
               "(arxius clauPublica i clauPrivada)...OK");
       
       System.out.println("Introdueix un missatge a signar: ");
       missatge = scanner.nextLine();
       missatgeBytes = missatge.getBytes();
       
       privateKeyFile(privatekey);
       signatura = signData(missatgeBytes, privatekey);
       firma(signatura);
       guardarMissatge(missatge);
    }
    
    public static void guardarMissatge(String missatge){
        try{
            FileWriter out = new FileWriter ("missatge");
            out.write(missatge);
            System.out.println("Generant arxiu missatge...OK");
            out.close();
        } catch (Exception ex) {
            System.err.println("Generador no funcional");
        }
    }
    
    public static void firma(byte[] signatura){
        try{
            BufferedOutputStream buf = new BufferedOutputStream 
            (new FileOutputStream("firma"));
            buf.write(signatura);
            buf.flush();
            System.out.println("Generant arxiu firma_missatge...OK");
        } catch (Exception ex){
            System.err.println("Generador no funcional");
        }
    }
    
    public static KeyPair randomGenerate(int longitudClau){
        KeyPair keys = null;
        try{
           KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
           keyGen.initialize(longitudClau);
           keys = keyGen.genKeyPair(); 
        } catch (Exception ex){
            System.err.println("Generador no funcional");
        }
        return keys;
    }

    
    
    public static void publicKeyFile(PublicKey pub) throws IOException{
         Base64.Encoder encoder = Base64.getEncoder();
         try(FileWriter out = new FileWriter("clauPublica")) {
             out.write(encoder.encodeToString(pub.getEncoded()));
            out.close();
         } catch (IOException ex) {
             System.out.println("Fitxer amb clau publica no creat");
         }
    }

    private static void privateKeyFile(PrivateKey priv)throws IOException {
        Base64.Encoder encoder = Base64.getEncoder();
        try (FileWriter out = new FileWriter("clauPrivada")) {
            out.write(encoder.encodeToString(priv.getEncoded()));
            out.close();
        } catch (IOException ex) {
           System.out.println("Fitxer amb clau privada no creat"); 
        }
    }

    private static byte[] signData(byte[] missatgeBytes, PrivateKey 
            clauPrivadaText) {
        byte[] signature = null;
        try {
            Signature signer = Signature.getInstance("SHA1withRSA");
            signer.initSign(clauPrivadaText);
            signer.update(missatgeBytes);
            signature = signer.sign();
        } catch (Exception ex){
            System.err.println("Error al signarr les dades: " + ex);
        }
        return signature;
    }
    
    
    
    
}
