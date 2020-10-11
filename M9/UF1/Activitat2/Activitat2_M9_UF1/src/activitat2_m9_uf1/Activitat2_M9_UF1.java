package activitat2_m9_uf1;

import java.security.NoSuchAlgorithmException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Activitat2_M9_UF1 {


    public static void main(String[] args) throws NoSuchAlgorithmException {
		
	
		byte [] encoded=keygenKeyGeneration(128).getEncoded();
		
		for (int i=0; i<encoded.length; i++) {
			System.out.println(Integer.toBinaryString(encoded[i] & 0xFF).replace(' ', '0')+ "--"+ encoded[i] );
		}
		System.out.println("Algoritme 2:");
		byte [] encoded2=keygenKeyGeneration2(56).getEncoded();
		
		for (int b=0; b<encoded.length; b++) {
			System.out.println(Integer.toBinaryString(encoded2[b] & 0xFF).replace(' ', '0')+ "--"+ encoded2[b] );
		}
		
	}
	
	public static  SecretKey keygenKeyGeneration(int keySize) {
		
        
		SecretKey sKey = null;
		
		if ((keySize == 128 )|| (keySize == 192)|| ( keySize == 256)) {
			try {
				KeyGenerator kgen = KeyGenerator.getInstance("AES");
				kgen.init(keySize);
				sKey= kgen.generateKey();
				
			}catch (NoSuchAlgorithmException ex) {
				System.err.println("Generacio no posible" );
			}
		}
		return sKey;
		} 
	
	
	public static  SecretKey keygenKeyGeneration2(int keySize) {
		
        
		SecretKey sKey = null  ;
		
		if ((keySize == 56 )|| (keySize == 192)|| ( keySize == 256)) {
			try {
				KeyGenerator kgen = KeyGenerator.getInstance("DES");
				kgen.init(keySize);
				sKey= kgen.generateKey();
				
			}catch (NoSuchAlgorithmException ex) {
				System.err.println("Generacio no posible" );
				
			}
		}
		return sKey;
		} 
    
}
