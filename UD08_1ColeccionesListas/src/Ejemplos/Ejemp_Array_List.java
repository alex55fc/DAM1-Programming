package Ejemplos;

import java.util.ArrayList;
import java.util.Iterator;

//array list guarda los objetos en un vector redimensionbles, se crea con una capacidad donde se puede añadir mas hasta la capacidad del sistema
public class Ejemp_Array_List {

	public static void main(String[] args) {
		//crar un array list por defecto(vacio y con 10 posiciones)
		
		
		//añadir varios nombres a la lista
		//importamos la clase Arralist y entre <> el tipo de lista
		ArrayList<String> listaNom = new ArrayList<String>();
		listaNom.add("Juan");
		listaNom.add("Andres");
		listaNom.add("Irene");
		listaNom.add("Isabel");
		listaNom.add("Jaime");
		
		//el add devuel un booleano 
		if(listaNom.add("Elena")) {
			System.out.println("Elena añadida");
		}
		//asi insertamos un nombre en una posicion
		listaNom.add(3, "Manolo");
		listaNom.add("Tobias");
		listaNom.add("Jaime");

		
		//reporrer por posicion
		System.out.println("Recorrer por posicion");
		for (int pos = 0; pos < listaNom.size(); pos++) {
			String elem = listaNom.get(pos);
			System.out.println(elem);
		}
		
		//recorrer con un iterador 
		System.out.println("Recorrer con un iterador");
		Iterator<String> iterador = listaNom.iterator();
		//hasNext mira si hay un elemento en la posicion y devuelve creo que true cuando hay un valor
		while(iterador.hasNext()) {
			//.next 
			String elem = iterador.next();
			System.out.println(elem);
		}	
		
		System.out.println();
		//Recorrer con bucle for-each
		for(String elemento :listaNom) {
			System.out.println("Recorre con un bucle for-each");
			System.out.println(elemento);
		}
		
		System.out.println();
		//Visualizar con el metodo toString()
		System.out.println("Visualizar con un to string");
		System.out.println(listaNom.toString());
		
		System.out.println();
		//buscar por nombre
		if (listaNom.contains("Juanito")) {
			System.out.println("Juan encontrado");
		}
		else {
			System.out.println("Juanito no encontrado");
		}
		
		System.out.println();
		//Obtener la primera posicion de un nombre en este caso, usamos el indexOf para buscar la posicion 
		int pos = listaNom.indexOf("Jaime");
		if (pos == -1) {
			System.out.println("Jaime no encontrado");
		}
		else {
			System.out.println("Jaime esta en la posicion "+ pos);
		}
		
		System.out.println();
		//eliminar el primer string en est caso Jaime
		
		if(listaNom.remove("Jaime")) {
			System.out.println("Jaime eliminado ");
		}
		else {
			System.out.println("Jaime no eliminado");
		}
		
		System.out.println();
		//eliminar por posicion en este caso pos2
		System.out.println(listaNom.toString());
		String nom = listaNom.remove(2);
		System.out.println(nom +"Elimnado en la segunda posicion");
		
		if (listaNom.size() >= 20) {
			String nom2 = listaNom.remove(20);
			System.out.println(nom2  + " eliminado");
		}
	}

}
