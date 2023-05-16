package ui;
import java.util.Scanner;
import data.DbHandler;
import java.util.ArrayList;
import entities.Product;
public class Menu {

	public static void main(String[] args) {
		
			int op;
			Scanner lector = new Scanner(System.in);
			do {
		 	System.out.println("Ingrese una Opcion \n [1] -- Listado de Productos \n [2] -- Busqueda \n [3] -- Nuevo Producto \n [4] -- Borrar Producto \n [5] -- Actualizar Producto \n [6] -- Salir \n");
		 	System.out.print("Su opcion:");
		 	op = Integer.parseInt(lector.nextLine());
		 	
		 	/*
		 	try {
		 		Class.forName("com.mysql.cj.jdbc.Driver");
		 	} catch (Exception e) {e.printStackTrace();
		 	}		 	
		 	*/
		 	DbHandler db = new DbHandler();
		 	
		 	switch (op) {
		 	
		 	
		 	case 1:
		 		ArrayList<Product> productos = new ArrayList<>();
		 		productos.addAll(db.listado());
		 		for (Product unProducto : productos) {
		 			System.out.println(unProducto);
					
				}
		 		break;
		 	case 2:
		 		break;
		 	case 3:
		 		break;
		 	case 4:
		 		break;
		 	case 5:
		 		break;
		 	case 6:
		 		break;
		 	
		 	default: 
		 		System.out.println("Ingrese una opcion Correcta");
		 	
		 	
		 	}
		 	} while (op != 6);
	}

}
