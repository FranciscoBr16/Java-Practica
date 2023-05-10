package ejercicio5b.ejercicio4;

import java.util.Scanner;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		ArrayList <Integer> numeros= new ArrayList<>();
		ArrayList <Integer> misNumeros= new ArrayList<>();
		int cont=0;
		int miNumero;
		Scanner lector = new Scanner (System.in);
		System.out.println("Ingrese un numero de control");
		miNumero = lector.nextInt();
		for (int i =0; i<10; i++) {
			System.out.println("Ingrese el numero "+ (i+1) +": ");
			numeros.add(lector.nextInt());
			}
			for (Integer unNumero: numeros) {
				if(unNumero > miNumero ) { 
					
					misNumeros.add(unNumero);
					cont++;
					}
				}
			if (cont >0 ) {
				System.out.println("Los numeros mayores son: ");
			for (Integer unNumero: misNumeros) {
				System.out.println(unNumero);
				
			}
			}else System.out.println("No habia numeros mayores al ingresado");

	}
}


