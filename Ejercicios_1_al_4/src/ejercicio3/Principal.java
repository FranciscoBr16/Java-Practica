package ejercicio3;
import java.util.Iterator;
// Leer 10 palabras, luego leer una nueva palabra e indicar si la misma ya había sido ingresada en las 10 primeras.
import java.util.Scanner;
public class Principal {
	
	public static void main(String[] args) {

		String[] palabras = new String[10];
		String palabra;
		int b=0;
		Scanner lector = new Scanner (System.in);
		for (int i =0; i<10; i++) {
			System.out.println("Ingrese la palabra "+ (i+1) +": ");
			palabras[i]= lector.nextLine();
		}
		System.out.println("Ingrese palabra a buscar");
		palabra = lector.nextLine();
		
			for (String unaPalabra : palabras) {
				if(unaPalabra.equals(palabra)) b++;
				}
			if (b>0) System.out.println("La palabra ya habia sido ingresada!");
				else {System.out.println("La palabra no se encontraba entre las ingresadas :(");}
	}

}
