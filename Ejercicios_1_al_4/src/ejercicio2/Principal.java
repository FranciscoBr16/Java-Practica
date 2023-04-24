package ejercicio2;
// Leer 10 palabras y mostrarlas en orden inverso al que fueron ingresadas.
import java.util.Scanner;
public class Principal {

	public static void main(String[] args) {
		String[] palabras = new String[10];
		Scanner lector = new Scanner (System.in);
		for (int i=0; i<10; i++) {
			System.out.println("Ingrese la palabra "+ (i+1));
			palabras[i]= lector.nextLine();
		}
		lector.close();
		for(int i=9; i>=0; i--) {
				System.out.println("La palabra "+ (i+1) + " fue : "+ palabras[i]);
		}
	}

}
