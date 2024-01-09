
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import entrada.Teclado; 

public class Ejemp_TreeMap2 {
	
	public static void main(String[] args) {
		
		// Se desea almacenar un listín de teléfonos
		// almacenamos persona,telefonos
		// ordena por clave
		Map<String,List<String>> mapaTelefonos = new TreeMap<String,List<String>>();	
		
		int cantidad;
		String nombre, telefono;
		System.out.println("AGENDA DE TELÉFONOS ORDENADA POR NOMBRE");
		do {
			nombre = Teclado.leerCadena("Nombre? ");
			cantidad = Teclado.leerNatural("Cuántos teléfonos? ");
			List<String> telefonos = new ArrayList<String>();
			for (int i = 0 ; i < cantidad ; i++ ) {
				telefono = Teclado.leerCadena("teléfono" + ( i + 1) + " ? ");
				telefonos.add(telefono);
			}
			if (mapaTelefonos.put(nombre, telefonos) != null) {
				System.out.println("Se ha modificado el registro de " + nombre);
			}
			else {
				System.out.println("Contacto añadido correctamtente.");
			}
		}
		while (mapaTelefonos.size() < 2);
		
		System.out.println("RESUMEN DE LOS DATOS: " + mapaTelefonos.toString());
		
		// Operación muy rápida
		// Obtener los teléfonos del contacto X pedido por teclado		
		nombre = Teclado.leerCadena("Nombre? ");
		List<String> telefonosPersona = mapaTelefonos.get(nombre);
		System.out.println(telefonosPersona);
					
		// Recorrido del mapa
		for (String contacto : mapaTelefonos.keySet()) {
			List<String> telefonos = mapaTelefonos.get(contacto);
			System.out.println(contacto + " tiene " + telefonos.size() + 
					" número/s de teléfono, que son " + telefonos.toString());
		}
				
		// Añadir un teléfono a una persona		
		nombre = Teclado.leerCadena("Nombre? ");
		String nuevoTelefono = Teclado.leerCadena("Nuevo Teléfono? ");
		List<String> telefonos = mapaTelefonos.get(nombre);
		telefonos.add(nuevoTelefono);
		
		
		
		
		//Borrar a una persona y sacar por pantalla si se ha borrado
		// o esa persona no existía		
		nombre = Teclado.leerCadena("Nombre? ");
		if (mapaTelefonos.remove(nombre)!=null) {
			System.out.println("Se ha borrado esa persona");
		}
		else {
			System.out.println("No existe esa persona");
		}
		
		System.out.println("RESUMEN DE LOS DATOS: " + mapaTelefonos.toString());
		
		
		
		
		// Recorrido de claves con iterator
		System.out.println("Elementos del Mapa Árbol de telefonos (Iterador de Claves):");
		Iterator<String> iteradorClaves = mapaTelefonos.keySet().iterator();
		while (iteradorClaves.hasNext()) {
			nombre = iteradorClaves.next();
			telefonos = mapaTelefonos.get(nombre);
			System.out.println(nombre + " tiene " + telefonos.size() + 
					" número/s de teléfono, que son " + telefonos.toString());
		}
		
		// Recorrido de entradas con iterador
		System.out.println("Elementos del Mapa Árbol de telefonos (Iterador de Entradas):");
		Iterator<Entry<String,List<String>>> iteradorEntradas = mapaTelefonos.entrySet().iterator();
		while (iteradorEntradas.hasNext()) {
			Entry<String,List<String>> entrada = iteradorEntradas.next();
			nombre = entrada.getKey();
			telefonos = entrada.getValue();
			System.out.println(nombre + " tiene " + telefonos.size() + 
					" número/s de teléfono, que son " + telefonos.toString());
		}
		System.out.println("");
		
		// Dado un nombre de una persona sustituir uno de sus teléfonos por otro.
		
	}
	
}
