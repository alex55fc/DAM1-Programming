package cositas_01;

import entrada.Teclado;

public class Ejer_1_03_Libro {

	//Escribe en consola el menú de opciones del programa principal.
	public static void escribirMenuOpciones() {
		System.out.println();// es para hacer un salto para que quede estetico(se vea mejor)
		System.out.println("(0) Salir del programa");
		System.out.println("(1) Crear un libro a partir de datos leídos por teclado.");
		System.out.println("(2) Visualizar en consola el libro.");
		System.out.println("(3) Modificar el título del libro.");
		System.out.println("(4) Modificar el número de ejemplares del libro.");
		System.out.println("(5) Modificar el precio del libro.");
		System.out.println("(6) Visualizar en consola el título del libro.");
		System.out.println("(7) Visualizar en consola el número de ejemplares del libro.");
		System.out.println("(8) Visualizar en consola el precio del libro.");
		System.out.println();// es para hacer un salto para que quede estetico(se vea mejor)
	}


	public static void main(String[] args) {
		int opcion;
// --2 aqui introducimos estas variables porque las vamos a necesitar (se llama igual que los atributos por ganas xd)
		String titulo;
		int numeroEjemplares;
		double precio;

// De la clase libro creamos este objeto(libro) que tendra los atributos definimos en su clase(titulo,numeroEjemplares,precio)--1
		Libro libro = null; 
// damos valor null por case 2(por si no hay un libro creado al principio)
// definimos un objeto libro de la clase Libro, ya que en el enunciado dice
// " Actividad_1x03 que incluya un programa principal main que gestione un libro "
		do {
			escribirMenuOpciones();
			opcion = Teclado.leerEntero("Introduce una opccion(0-8)");
			switch(opcion) {
			
		
//salir del programa
			case 0:
				break;
				
				
// crear libro
			case 1:
				if(libro == null) {
					titulo = Teclado.leerCadena("Introduce titulo: "); // pregunta se tiene que llamar igual? por que esteo **2
					numeroEjemplares = Teclado.leerNatural("Introduce número de ejemplares: ");
					precio = Teclado.leerReal("Introduce precio: ");
					libro = new Libro(titulo, numeroEjemplares, precio);
					System.out.println("Se ha creado un libro. ");
				}
				else {
					System.out.println("Ya existe un libro.");
				}
				break;
				
				
//visualizar libro
			case 2:
				if (libro == null) {
					System.out.println("Antes se debe crear un libro");
				}
				else {
					System.out.println(libro.obtenerEstado()); 
				}
				break;
				
				
//modificar el titulo de libro, para modificar tenemos que crear un get(
			case 3:
				if (libro == null) { // damos este caso para que antes de modificar el titulo tenga q haber libro xd, y asi en muchos casos
					System.out.println("Antes se debe crear un libro");
				}
				else {
					titulo = Teclado.leerCadena("Introduce título: ");
					libro.setTitulo(titulo);
					break;
				}
				System.out.println("Se ha modificado el titulo del libro");
				
				
// Visualizar en consola el titulo del libro							
			case 6:
				if (libro == null) { // damos este caso para que antes de modificar el titulo tenga q haber libro xd
					System.out.println("Antes se debe crear un libro");
				}
				else {
					System.out.println("Titulo: "+ libro.getTitulo());
				}
				
				break;
				
				
// opcion no valida
			default: 
				System.out.println("La opccion de menu debe estar comprendida entre 0 y 2");
			}

		}while(opcion != 0);
		System.out.println("Programa finalizado");
	}

}
