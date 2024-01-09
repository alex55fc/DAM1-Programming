package Ejemplos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Ejemp_Linked_List {

	// Linked list es una lista enlazada, van creciendo y decreciendo 
	//como ambos son listas los metodos que usamos en Array list son los mismos que en Linked list 
	public static void main(String[] args) {
		//tambien lo podemos poner con la interfaz
		//List<String> listaNom = new ArrayList<String>(30);
		
		//importamos la clase Arralist y entre <> el tipo de lista el constructor vacio () por defecto 
		//crar un array list por defecto(vacio y con 30 posiciones)
		ArrayList<String> listaNom = new ArrayList<String>(30);
		//añadir varios nombres a la lista 
		listaNom.add("Juan");
		listaNom.add("Andres");
		listaNom.add("Irene");
		listaNom.add("Isabel");
		listaNom.add("Jaime");
		listaNom.add("Elena");
		listaNom.add("Manolo");
		listaNom.add("Tobias");
		listaNom.add("Jaime");
		
		//crear un linked list con los datos del arrary list 
		
		//de este modo insertamos los datos de una lista a otra 
		//LinkedList<String> lista2 = new LinkedList<String>(listaNom);
		
		//de este otro metodo insertamos los datos de una lista a otra 
		LinkedList<String> lista2 =  new LinkedList<String>();
		lista2.addAll(listaNom);
		
		//visualizar con el metodo to String 
		System.out.println("Visualizar con el metodo toString: ");
		System.out.println(lista2.toString());
		
		//comprobar si esta vacia
		if(lista2.isEmpty()) {
			System.out.println("lista vacia");
		}
		else {
			System.out.println("lista no vacia ");
		}
		
		System.out.println();
		//ordenar la lista de forma ascendente 
		Collections.sort(lista2);
		System.out.println("Lista ordenada ascendente: "+ lista2.toString());

		//ordenar la lista de forma descendente 
		Collections.sort(lista2, Collections.reverseOrder());
		System.out.println("Lista ordenada descendente "+ lista2.toString());
		
		//ordenar la lista de forma descendente 2,
		//aqui primero ordenamos de orden normal(ascendente) y luego de forma descendente 
		Collections.sort(lista2);
		Collections.reverse(lista2);
		System.out.println("Lista ordenada descendent (v2)" + lista2.toString());
		
	}

}
