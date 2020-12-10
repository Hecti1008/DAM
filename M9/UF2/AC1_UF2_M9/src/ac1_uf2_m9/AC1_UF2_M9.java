/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac1_uf2_m9;

import java.util.*;
import java.util.concurrent.*;
/**
 *
 * @author megah
 */
public class AC1_UF2_M9 {

    /**
     * @param args the command line arguments
     */
    static class Multiplicacio implements Callable<Integer> {
			private int operador1;
			private int operador2;
			
			public Multiplicacio(int operador1, int operador2) {
				this.operador1 = operador1;
				this.operador2 = operador2;
				}
				
			@Override
			public Integer call() throws Exception {
				
				//Thread.sleep(3000);
				System.out.println(Thread.currentThread().getName());
				return operador1 + operador2;
				}
			}
    
    
    public static void main(String[] args) throws InterruptedException, ExecutionException {
      //creem 3 fils
				ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
				
				List<Multiplicacio> llistaTasques= new ArrayList<Multiplicacio>();
				//va fent combinacions de 25 numeros 
				for (int i = 0; i < 25; i++) {
					//inicialitzem els numeros aleatorris a l'objecte
					Multiplicacio calcula = new Multiplicacio((int)(Math.random()*10), (int)(Math.random()*10));
					llistaTasques.add(calcula);
					}
				List <Future<Integer>> llistaResultats;
				llistaResultats = executor.invokeAll(llistaTasques);
				
				executor.shutdown();
				//ensenya el resultat
				for (int i = 0; i < llistaResultats.size(); i++) {
					Future<Integer> resultat = llistaResultats.get(i);
					try {
						System.out.println("El resultat de la tasca "+i+ " es:" +
						resultat.get());
					}
					catch (InterruptedException | ExecutionException e)
						{
						}
					}
}
}