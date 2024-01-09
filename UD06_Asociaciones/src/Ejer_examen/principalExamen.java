package Ejer_examen;
import java.util.Arrays;
import java.util.Random;

import entrada.Teclado;

public class principalExamen {
	public static void escribirMenuOpciones() {
		System.out.println();
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("0) Salir del programa");
		System.out.println("1) Insertar un producto en la primera posicion del inventario");
		System.out.println("2) Buscar un producto por codigo");
		System.out.println("3) Consultar todos los productos perecederos del inventario sin caducar");
		System.out.println("-------------------------------------------------------------------------");
		System.out.println();

	}

	public static void main(String[] args) {
		String nombre;
		int diasParaCaducar, opcion, capMax, posicion, letras;
		Producto producto;
		Producto [] vecProducto;

		capMax = Teclado.leerEntero("¿Capacidad Maxima?");
		Inventario inventario = new Inventario(capMax);

		do {
			escribirMenuOpciones();
			opcion = Teclado.leerEntero("Opcion (0-4)? ");
			switch (opcion) {
			// Salir del programa.
			case 0:
				break;

			case 1:
				letras=Teclado.leerEntero("Numero de letras del producto: ");
				nombre=Producto.pasoLetras(letras);
				diasParaCaducar = Teclado.leerEntero("¿Dias para Caducar? ");
				producto = new Producto(nombre, diasParaCaducar);
				if (inventario.insertar(producto)) {
					System.out.println("Se ha insertado un producto en el inventario.");
				}
				else {
					System.out.println("Error al insertar un producto:");
					System.out.println("El invebtario esta lleno.");
				}
				break;
			case 2:
				posicion = Teclado.leerEntero("Posicion?");
				producto = inventario.consultar(posicion);
				if (producto == null) {
					System.out.println("No hay ningun producto en la posici�n del inventario.");
				}
				else {
					System.out.println(producto);
				}
				break;
			case 3:
				vecProducto = inventario.recorrerProductos();
				System.out.println(Arrays.toString(vecProducto));
				System.out.println();
			}


		}
		while (opcion != 0);


	}
}
