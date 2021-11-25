package MainApp;

import java.util.ArrayList;
import java.util.Scanner;

import Models.CuentaCorriente;
import Models.Persona;

public class MainApp {
	static Scanner s = new Scanner(System.in);
	static ArrayList<Persona> lista = new ArrayList<Persona>();

	public static void main(String[] args) {

		String opc;
		do {
			System.out.println("a. Añadir persona\nb. Elegir persona");
			System.out.println(
					"\t i. Cobrar sueldo \n\t ii. Sacar pasta \n\t iii. Subir sueldo \n\t iv. Mostrar detalles de la persona");
			System.out.println("c. Borrar persona \nd. Salir");
			System.out.println();
			System.out.print("Inserte opcion: ");
			opc = s.nextLine();

			switch (opc) {
			case "a":
				System.out.print("Nombre: ");
				String nombre = s.nextLine();
				System.out.print("Apellido: ");
				String apellido = s.nextLine();
				System.out.print("DNI: ");
				String dni = s.nextLine();
				System.out.print("Sueldo: ");
				double sueldo = Double.parseDouble(s.nextLine());

				int numCuenta = 1;

				// Crea una cuenta y la almacena en el array list
				lista.add(new Persona(nombre, apellido, dni, sueldo, new CuentaCorriente(numCuenta, 0, null))); 
				numCuenta++;
				System.out.println();
				break;

			case "b":
				System.out.println();
				int i = 1;
				for (Persona p : lista) {
					System.out.println(i + ". " + p.seleccionar()); // Imprime el string solo con el nombre y el dni
					i++;
				}
				submenu(); // Imprime el submenu e interactuas con el

				break;

			case "c":
				int j = 1;
				for (Persona p : lista) {
					System.out.println(j + ". " + p.seleccionar());
					j++;
				}
				System.out.print("Selecciona una cuenta que desee eliminar: ");
				int selec = Integer.parseInt(s.nextLine());

				lista.remove(selec - 1); // Elimina la cuenta que seleccionemos del array list

				break;

			case "d":
				System.out.println();
				System.out.println("Gracias por usar nuestro banco. Que tenga un excelente dia.");
				System.exit(0); // Se sale del bucle

				break;

			}

		} while (opc.equalsIgnoreCase("a") || opc.equalsIgnoreCase("b") || opc.equalsIgnoreCase("c")
				|| opc.equalsIgnoreCase("d"));

	}

	public static void submenu() {

		System.out.println();
		System.out.print("Elige a la persona: ");
		int selec = Integer.parseInt(s.nextLine());
		Persona elegida = lista.get(selec - 1); // Selecciona la cuenta con la que queremos interactuar

		System.out.println("Has elegido a " + elegida.getNombre());
		System.out.println();
		System.out.println("¿Que desea realizar?");
		System.out
				.println("i. Cobrar sueldo \nii. Sacar pasta \niii. Subir sueldo \niv. Mostrar detalles de la persona");
		String opc = s.nextLine();

		switch (opc) {

		case "i":
			elegida.cobrarSueldo(); // Cobras el sueldo y lo pasa al saldo de la cuenta

			break;
		case "ii":
			System.out.println("¿Que cantidad desea sacar?");
			double cantidad = Double.parseDouble(s.nextLine());
			elegida.sacarPasta(cantidad); // Sacas el dinero que deseas

			break;
		case "iii":
			System.out.println("¿Cuanto deseas subir?");
			double sueldo = Double.parseDouble(s.nextLine());
			elegida.subirSueldo(sueldo); // Subes el sueldo

			break;
		case "iv":
			int j = 1;
			for (Persona p : lista) {
				System.out.println(j + ". " + p); // Imprime toda la informacion de la cuenta seleccionada
				j++;
			}
			break;
		}

	}
}
