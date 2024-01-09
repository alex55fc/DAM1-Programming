package Ejer_1_01;

import entrada.Teclado;

public class Actividad_1x01 {
	public static void escribirMenu() {
		System.out.println();
		System.out.println("(0) Salir del programacion");
		System.out.println("(1) Insertar un videojuego en el almacén.");
		System.out.println("(2) Eliminar un videojuego, por posición, del almacén.");
		System.out.println("(3) Consultar un videojuego, por posición, del almacén");
		System.out.println("(4) Consultar todos los videojuegos del almacén");
		System.out.println();
	}

	public static void main(String[] args) {
		int opcion;
		//empezar delcarando objeto de clase almacen e instanciarlo con su constructor, donde decimos su capacidad
		Almacen almacen1 = new Almacen(20);
		//instanciamos un videojuego y sus datos 
		Videojuego videojuego1;
		String titulo;
		double precio;
		// 
		int pos = 0;
			
		do {
			escribirMenu();
			opcion = Teclado.leerEntero("Elige una opcion.");
			switch(opcion) {
			
			case 0:
				break;
//--------------------------------------------------------------------------------------------------------------------------------	
			//Insertar un videojuego en el almacén.
			case 1:
				titulo = Teclado.leerCadena("¿titulo? ");
				precio = Teclado.leerReal("¿precio ");
				videojuego1 = new Videojuego(titulo, precio);
				
				if(almacen1.insertar(videojuego1)) {
					System.out.println("Se ha insertado un videojuego en el almacen");
				}
				else {
					System.out.println("Error al insertar un videojuego almacen esta lleno");
				}
				System.out.println("Se añadio un videojuego.");
				
				break;
//--------------------------------------------------------------------------------------------------------------------------------	
				//Eliminar un videojuego, por posición, del almacén.
			case 2:
				pos = Teclado.leerEntero("¿Posicion a eliminar");
				if(almacen1.eliminar(pos)) {
					System.out.println("se inserto correctamente");
				}
				else {
					System.out.println("Error al eliminar un videojuego \n" +"El almacén esta vacio , o\n"
				+ "No hay ningun videojuego en esa posicion");
				}
				break;
//--------------------------------------------------------------------------------------------------------------------------------	
				//Consultar un videojuego, por posición, del almacén
			case 3:
				pos = Teclado.leerEntero("¿posicion");
				videojuego1 = almacen1.consultar(pos);
				if ( videojuego1 == null) {
					System.out.println("no hay ningun videojuego en esa posicion del almacen");
				}
				else {
					System.out.println(videojuego1.toString());
				}
				break;
//--------------------------------------------------------------------------------------------------------------------------------	
			//Consultar todos los videojuegos del almacén, este y el apartado 1 deberian ser los primeros een hacerse
			case 4:
				System.out.println(almacen1.toString());
				break;
				
			}
		}while(opcion != 0);

	}

}
