package ejercicio5;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner lector = new Scanner (System.in);
		int opcion;
		boolean seguir = true;
		int indice =0;
		int dni=0, hsExtra, hsMes;
		String nombre=null, apellido=null, email=null;
		float sueldoBase=0, totalVentas,porcentaje;
		Empleado[] empleados = new Empleado[20];
		int preg=0;
		while(seguir && indice <20) {
			
			System.out.println("Quiere ingresar un  \n 1 - Administrativo  \n 2 - Vendedor");
			opcion = Integer.parseInt(lector.nextLine());
			
			if (opcion ==1 || opcion == 2) {
				System.out.println("Ingrese DNI del empleado:");
				dni = Integer.parseInt(lector.nextLine());
				System.out.println("Ingrese Nombre del empleado:");
				nombre = lector.nextLine();
				System.out.println("Ingrese Apellido del empleado:");
				apellido = lector.nextLine();
				System.out.println("Ingrese Email del empleado:");
				email = lector.nextLine();
				System.out.println("Ingrese Sueldo Base del empleado:");
				sueldoBase = Float.parseFloat(lector.nextLine());
			}
			
			if (opcion == 1) {
				
				empleados[indice] = new Administrativo();
				System.out.println("Ingrese Horas extra del empleado Administrativo:");
				hsExtra = Integer.parseInt(lector.nextLine());
				System.out.println("Ingrese Horas Mes del empleado Administrativo:");
				hsMes = Integer.parseInt(lector.nextLine());
				((Administrativo)empleados[indice]).setValores(dni, nombre, apellido ,email ,sueldoBase, hsExtra, hsMes);
				indice++; 
			}
			
			if (opcion == 2) {
				
				empleados[indice] = new Vendedor();
				System.out.println("Ingrese Horas extra del Vendedor:");
				porcentaje = Float.parseFloat(lector.nextLine());
				System.out.println("Ingrese Horas Mes del Vendedor:");
				totalVentas = Float.parseFloat(lector.nextLine());
				((Vendedor)empleados[indice]).setValores(dni, nombre, apellido ,email ,sueldoBase, porcentaje, totalVentas);
				indice++;
				
				
			}
			
			if (opcion != 1 && opcion != 2) {System.out.println("Ingrese una opcion valida");}
			
			System.out.println("Desea ingresar otro Empleado? 1- Si 2- No");
			preg = Integer.parseInt(lector.nextLine());
			if (preg !=1) {seguir=false;}
			
			
		}
			
			for (int i=0; i<indice;i++) {
				
				System.out.println(empleados[i].mostrarDatos());
			}
			
			lector.close();
			
		
			
			

	}

}
