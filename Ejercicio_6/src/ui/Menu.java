package ui;
import java.util.Scanner;
import data.DbHandler;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;


import entities.Product;
public class Menu {
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public static void main(String[] args) {
		
			Product pro = new Product();
			int op,id;
			Scanner lector = new Scanner(System.in);
			do {
		 	System.out.println("Ingrese una Opcion \n [1] -- Listado de Productos \n [2] -- Busqueda \n [3] -- Nuevo Producto \n [4] -- Borrar Producto \n [5] -- Actualizar Producto \n [6] -- Salir \n");
		 	System.out.print("Su opcion:");
		 	op = Integer.parseInt(lector.nextLine());
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
		 		System.out.println("Ingrese ID a buscar:");
		 		id = Integer.parseInt(lector.nextLine());
		 		System.out.println(db.busqueda(id));
		 		break;
		 		
		 	case 3:
		 		System.out.println("Ingrese Nombre del producto a ingresar");
		 		pro.setName(lector.nextLine());
		 		System.out.println("Ingrese Descripcion del producto a ingresar");
		 		pro.setDescription(lector.nextLine());
		 		System.out.println("Ingrese Stock del producto a ingresar");
		 		pro.setStock(Integer.parseInt(lector.nextLine()));
		 		System.out.println("Ingrese Precio del producto a ingresar");
		 		pro.setPrice(Double.parseDouble(lector.nextLine()));
		 		System.out.println("Incluye el envio? \n [1] -- Si [2] -- No");
		 		int b = Integer.parseInt(lector.nextLine());
		 		if (b == 1 || b == 2) {
		 			if (b==1) {
		 				pro.setShippingIncluded(true);
		 				db.newProduct(pro);
		 			} else {pro.setShippingIncluded(false);
		 			db.newProduct(pro);
		 			}
		 		} else System.out.println("Error al confirmar el envio del producto"); 
		 		break;
		 	case 4:
		 		System.out.println("Ingrese ID a buscar:");
		 		id = Integer.parseInt(lector.nextLine());
		 		System.out.println(db.busqueda(id));
		 		System.out.println("Seguro que quieres eliminar este registro? \n [1]-- Si  [2]-- No");
		 		int op1 = Integer.parseInt(lector.nextLine());
		 		if (op1 == 1)
		 		{
		 			if (db.delete(db.busqueda(id))) {
		 				System.out.println("El registro fue eliminado");
		 			} else System.out.println("No fue posible eliminar el registro :(");
		 		}
		 		break;
		 	case 5:
		 		Product pro2 = new Product();
		 		System.out.println("Ingrese ID a buscar:");
		 		id = Integer.parseInt(lector.nextLine());
		 		System.out.println(db.busqueda(id));
		 		String att=null;
		 		pro2.setID(id);
		 		System.out.println("Que atributo desea modificar?\n[1]-- Nombre \n[2]-- Descripcion \n[3]-- Stock \n[4]-- Precio \n[5]-- Envio \n[6]-- Fecha de deshabilitacion");
		 		int op2 = Integer.parseInt(lector.nextLine());
		 		switch (op2) {
		 		case 1:
		 			att = "name";
		 			System.out.println("Ingrese el nuevo nombre para el producto");
		 			String name = lector.nextLine();
		 			pro2.setName(name);
		 			break;
		 		case 2:
		 			att = "description";
		 			System.out.println("Ingrese la nueva descripcion para el producto");
		 			String desc = lector.nextLine();
		 			pro2.setDescription(desc);
		 			break;
		 		case 3:
		 			att = "stock";
		 			System.out.println("Ingrese el nuevo stock para el producto");
		 			int stk = Integer.parseInt(lector.nextLine());
		 			pro2.setStock(stk);
		 			break;
		 		case 4:
		 			att = "price";
		 			System.out.println("Ingrese el nuevo nombre para el producto");
		 			Double prc = Double.parseDouble(lector.nextLine());
		 			pro2.setPrice(prc);
		 			break;
		 		case 5:
		 			att= "shippingincluded";
		 			if (pro2.isShippingIncluded()) {
		 				pro2.setShippingIncluded(false);
		 			} else pro2.setShippingIncluded(true);
		 				
		 			break;
		 		case 6:
		 			att = "disabledOn";
		 			System.out.println("Ingrese la fecha en el que fue deshabilitado (dd/MM/yyyy)");
		 			String aux = lector.nextLine();
		 			
		 			try {
		 	            LocalDate fecha = LocalDate.parse(aux, formatter);
		 	            pro2.setDisabledOn(fecha);
		 	        } catch (DateTimeParseException e) {
		 	            System.out.println("La fecha ingresada no cumple con el formato establecido (dd/MM/yyyy).");
		 	        }
		 			
		 			break;
		 		default:
		 			break;
		 		
		 		}

		 		if(db.updateProduct(pro2,att) >0) {
		 			System.out.println("Se modifico la tabla");
		 		} else System.out.println("No es posible modificar la tabla");
		 		break;
		 	case 6:
		 		break;
		 	
		 	default: 
		 		System.out.println("Ingrese una opcion Correcta");
		 	
		 	
		 	}
		 	} while (op != 6);
			lector.close();
	}

}
