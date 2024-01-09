package Ejer_lista_persona;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import entrada.Teclado;
//hecho en clse sin enunciado
public class GestorListaPersonas {
	public static void escribirMenu() {
		System.out.println();
		System.out.println("(0) Salir del programa");
		System.out.println("(1) Insertar una persona en la lista");
		System.out.println("(2) Consultar todas las personas de la lista");
		System.out.println("(3) Eliminar una persona, por Dni");
		System.out.println("(4) Consultar personas por nombre de la lista");
		System.out.println("(5) Ordenar la lista por edad descendente");
		System.out.println("(6) Ordenar la lista por apellido ascendente y nombre ascendente");
		System.out.println();
	}
	
	public static void escribirLista(List<Persona> lista) {
		for(Persona p : lista) {
			System.out.println(p.toString());
		}
		System.out.println(lista.size()+ " personas consultadas");
	}
	
	public static void main(String[] args) {
		int opcion; 
		//crear una lista de personas, indicamos el tipo en este caso un objeto de Persona
		//esta vez lo creamos con Linked List pero podria ser con Array List
		List<Persona> lista = new LinkedList<Persona>(); //--------------------------------------------------
		//creamos una lista auxiliar para algunos casos
		List<Persona> listaAux;
		//caso 1
		String dni, nombres, apellidos ;
		int edad;
		Persona persona;

		do {
			escribirMenu();
			opcion = Teclado.leerEntero("opcion");

			switch(opcion) {
			case 0:
				break;
				//----------------------------
			case 1:
				dni = Teclado.leerCadena("¿DNI?");
				//creamos una persona para poder buscar solo el dni, me da igual el resto de datos de momento
				persona = new Persona (dni, "", "", 0);
				//comparamos cada objeto de la lista,usando el metodo contains, el dni que hemos metido por teclado
				//contains es booleano devuleve true si es igual, lo compara con un equals en la clase persona con el metodo que creamos con source
				if (lista.contains(persona)) {
					System.out.println("Ya existe otra persona con ese DNI en la lista");
				}
				else {
					//ahora que sabemos que en la lista no hay dni repetidmos pedimos el resto de datos
					nombres = Teclado.leerCadena("Nombres ");
					apellidos = Teclado.leerCadena("Apellidos ");
					edad = Teclado.leerEntero("edad");
					persona = new Persona (dni, nombres, apellidos, edad);
					
					if(lista.add(persona)) {
						System.out.println("Se ha insertado una persona en la lista");
					}
				}
				break;
				//----------------------------
				//Consultar todas las personas de la lista
			case 2:
				if(lista.isEmpty()) {
					System.out.println("La lista esta vacia");
				}
				else {
					escribirLista(lista);
				}
				break;
				//----------------------------
			case 3:
				// Eliminar una persona, por Dni
				dni = Teclado.leerCadena("¿Dni a elminar?");
				persona = new Persona (dni, "", "", 0);
				if (lista.remove(persona)) {
					System.out.println("Se ha eliminado una persona de la lista");
				}
				else {
					System.out.println("No se ha encontrado ninguna persona con ese DNI");
				}
				break;
				//----------------------------
			case 4:
				//Consultar personas por nombre de la lista
				nombres = Teclado.leerCadena("Nombre a buscar ");
				listaAux = new LinkedList<Persona>();
				/*para comparar nomres recorremos la lista con un for each y comparamos el nombre de perseona con un get 
				 y un equals comparamos el nombre que hemos escrito ahora*/
				for(Persona p : lista) {//equalsIgnoreCase ignora si el String esta en mayuculas o minuculas
					if(p.getNombres().equalsIgnoreCase(nombres)) {
						listaAux.add(p);
					}
				}
				if(listaAux.isEmpty()) {
					System.out.println("La lista esta vacia");
				}
				else {
					escribirLista(listaAux);
				}
				break;
				//----------------------------
				//Ordenar la lista por edad descendente
			case 5:
				//en este caso haremos que se ordene en la listaAux para que el orden original se quede en la lista
				listaAux = new LinkedList<Persona>();
				listaAux.addAll(lista);
				
				//para ordenar una lista por un parametro debemos crear otra clase, de esta otra clase devolvemos un constructor por defecto
				//con la clase Collections ordenamos con sort
				Collections.sort(listaAux, new OrdenPersonaPorEdadDescendente());
				if(listaAux.isEmpty()) {
					System.out.println("La lista esta vacia");
				}
				else {
					escribirLista(listaAux);
				}
				break;
				//----------------------------
				//Ordenar la lista por apellido ascendente y nombre ascendente
			case 6:
				listaAux = new LinkedList<Persona>();
				listaAux.addAll(lista);
				
				//definimos otra clase para ordenar por nombre ya pellido ASC
				Collections.sort(listaAux, new OrdenPorPersonaPorApeNomAsc());
				
				if(listaAux.isEmpty()) {
					System.out.println("La lista esta vacia");
				}
				else {
					escribirLista(listaAux);
				}
				break;
			}
		}while(opcion != 0);
		System.out.println("Acabado");
	}

}
