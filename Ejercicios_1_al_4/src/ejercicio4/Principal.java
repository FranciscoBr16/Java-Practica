package ejercicio4;
import java.util.Scanner;
// Leer un entero y luego una lista de 20 enteros. Guardar los mayores al número inicial y mostrarlos al final. Usar arrays, no otras colecciones
public class Principal {

	public static void main(String[] args) {

		int[] numeros= new int[10];
		int[] misNumeros= new int[10];
		int cont=0;
		int miNumero;
		Scanner lector = new Scanner (System.in);
		System.out.println("Ingrese un numero de control");
		miNumero = lector.nextInt();
		for (int i =0; i<10; i++) {
			System.out.println("Ingrese el numero "+ (i+1) +": ");
			numeros[i]= lector.nextInt();
			}
			for (int i=0;i<10;i++) {
				if(numeros[i] > miNumero ) { 
					
					misNumeros[cont]= numeros[i];
					cont++;
					}
				}
			if (cont >0 ) {
				System.out.println("Los numeros mayores son: ");
			for (int i=0; i < cont; i++) {
				System.out.println(misNumeros[i]);
				
			}
			}else System.out.println("No habia numeros mayores al ingresado");

	}
}
