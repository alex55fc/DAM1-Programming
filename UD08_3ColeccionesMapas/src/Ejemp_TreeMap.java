import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import entrada.Teclado;

public class Ejemp_TreeMap {

	public static void main(String[] args) {
		// Crear un mapa de alumnos con clave el nombre y
		// y valor una nota numérica real.
		Map<String,Double> mapaAlumnos = new TreeMap<String,Double>();
		
		// insertar varios alumnos con sus notas
		mapaAlumnos.put("Javier", 7.2);
		mapaAlumnos.put("Alex", 8.0);
		mapaAlumnos.put("Miguel", 5.7);
		mapaAlumnos.put("Miguel", 3.2); // modifica
		
		// usar el toString
		System.out.println(mapaAlumnos.toString());
		
		// recorrer el mapa con un for-each sobre el conjunto de claves
		System.out.println("FOR-EACH CON keySet()");
		for (String clave : mapaAlumnos.keySet()) {
			Double valor = mapaAlumnos.get(clave);
			System.out.println("clave=" + clave + ", valor=" + valor);
		}
		
		// recorrer el mapa con un iterador sobre el conjunto de claves
		System.out.println("ITERADOR CON keySet()");
		Iterator<String> iterador = mapaAlumnos.keySet().iterator();
		while (iterador.hasNext()) {
			String clave = iterador.next();
			Double valor = mapaAlumnos.get(clave);
			System.out.println("clave=" + clave + ", valor=" + valor);
		}
		
		// recorrer solo los valores del mapa
		System.out.println("FOR-EACH con values()");
		for (Double valor : mapaAlumnos.values()) {
			System.out.println("valor=" + valor);
		}
		
		// recorrer el mapa con un for-each sobre el conjunto de entradas
		System.out.println("FOR-EACH for entrySet()");
		for (Entry<String,Double> entrada : mapaAlumnos.entrySet()) {
			String clave = entrada.getKey();
			Double valor = entrada.getValue();
			System.out.println("clave=" + clave + ", valor=" + valor);
		}
		
		// recorrer el mapa con un iterador sobre el conjunto de entradas
		System.out.println("ITERADOR CON entrySet()");
		Iterator<Entry<String,Double>> iterador2 = 
							mapaAlumnos.entrySet().iterator();
		while (iterador2.hasNext()) {
			Entry<String,Double> entrada = iterador2.next();
			String clave = entrada.getKey();
			Double valor = entrada.getValue();
			System.out.println("clave=" + clave + ", valor=" + valor);
		}
		
		// Modificar la nota de un alumno
		String alumno = Teclado.leerCadena("¿Alumno a modificar? ");
		if (mapaAlumnos.containsKey(alumno)) {
			Double nuevaNota = Teclado.leerReal("¿Nueva Nota? ");
			mapaAlumnos.put(alumno, nuevaNota);
			System.out.println("Alumno modificado");
			System.out.println("nueva nota: " + mapaAlumnos.get(alumno));
		}
		else {
			System.out.println("Alumno no encontrado");
		}
		
		// Eliminar un alumno
		alumno = Teclado.leerCadena("¿Alumno a eliminar? ");
		if (mapaAlumnos.remove(alumno) != null) {
			System.out.println("Alumno eliminado");
		}
		else {
			System.out.println("Alumno no encontrado");
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
