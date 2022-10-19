package co.edu.uniquindio.test;

import java.util.ArrayList;
import java.util.Collections;

public class Test {

	public static void main(String[] args) {
		ArrayList<String> nombres = new ArrayList<>(0); 
		nombres.add("z");
		nombres.add("d"); 
		nombres.add("v"); 
		nombres.add("a"); 
		
		
		for (int i = 0; i < nombres.size(); i++) {
			System.out.print(nombres.get(i)+" ") ;
		}
		
		System.out.println();
		Collections.sort(nombres);
		
		for (int i = 0; i < nombres.size(); i++) {
			System.out.print(nombres.get(i)+" ") ;
		}
	}

}
