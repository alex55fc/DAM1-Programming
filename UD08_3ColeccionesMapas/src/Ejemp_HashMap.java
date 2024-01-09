
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import entrada.Teclado;

// Operaciones importantes
// PUT NO ADD
//GET(CLAVE)
// REMOVE(CLAVE)

public class Ejemp_HashMap {

	public static void main(String[] args) {
		// Almacenar en una estructura las notas de los alumnos de una clase
		// almacena pares nombre-nota
		Map<String, Integer> mapaNotas = new HashMap<String, Integer>();

		// Insertar 5 alumnos con sus notas
		System.out.println("MAPA CON NOTAS PARA 5 ALUMNOS");
		String nombre;
		int nota;
		do {
			nombre = Teclado.leerCadena("Nombre? ");
			nota = Teclado.leerEntero("Nota? ");
			if (mapaNotas.put(nombre, nota) != null) {
				System.out.println("Se ha modificado la nota de " + nombre);
			} else {
				System.out.println("Alumno añadido correctamente.");
			}
		} while (mapaNotas.size() < 5);

		System.out.println("CONTENIDO DEL MAPA: " + mapaNotas.toString());

		// Obtener un valor dada una clave
		// Si no existe get devuelve null //
		// OPERACIÓN MUY RÁPIDA
		nombre = Teclado.leerCadena("Nombre? ");
		System.out.println(mapaNotas.get(nombre));

		// Recorro las claves con bucle for each
		// Alumnos - claves
		System.out.println("\nClaves");
		for (String i : mapaNotas.keySet()) {
			System.out.print(i + ",");
		}

		// Recorro los valores con bucle for each // Print values
		System.out.println("\n\nValores");
		for (Integer i : mapaNotas.values()) {
			System.out.print(i + ",");
		}

		// OPCION1 // Recorro claves-valor
		// Imprimir por pantalla los alumnos aprobados
		System.out.println("\n\nAlumnos aprobados");
		for (Entry<String, Integer> entrada : mapaNotas.entrySet()) {
			if (entrada.getValue() >= 5) {
				System.out.print(entrada.getKey() + ",");
			}
		}

		// OPCION2
		// Imprimir por pantalla los alumnos aprobados
		System.out.println("\n\nAlumnos aprobados2");
		for (String clave : mapaNotas.keySet()) {
			if (mapaNotas.get(clave) >= 5) {
				System.out.print(clave + ",");
			}
		}

		System.out.println("\n\nModificando notas\n\n");
		// Poner 1 a los alumnos que tengan un 0
		for (Entry<String, Integer> entrada : mapaNotas.entrySet()) {
			if (entrada.getValue() == 0) {
				entrada.setValue(1);
				// Opción 2
				//mapaNotas.put(entrada.getKey(), 1);
			}
		}
		//Opción 3
		for (String clave : mapaNotas.keySet()) {
			if (mapaNotas.get(clave) == 0) {
				mapaNotas.put(clave, 1);
			}
		}
		
		
		System.out.println("CONTENIDO DEL MAPA: " + mapaNotas.toString());

	}
}
