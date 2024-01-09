
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

import entrada.Teclado;

public class Ejemp_LinkedHashMap {
	//si recorrieramos un objeta de clase y no un conjunto como ahora hariamos otro bucle normal como los que ya haciamos (for-each)
	public static void escribirMapa(Map<String, HashSet<String>> mapaTelefonos ) {
		if(mapaTelefonos.isEmpty()) {
			System.out.println("El mapa no cnotiene ningun nombre de contacto ");
		}
		else {
			for (String nombreContacto: mapaTelefonos.keySet()) {
				HashSet<String> conjuntoTelefonos = mapaTelefonos.get(nombreContacto);	
				
				System.out.println("Nombre= "+ nombreContacto + "--> "+ conjuntoTelefonos.toString());
			}
			System.out.println("nombre consultados "+ mapaTelefonos.size());
		}
	}
	public static void main(String[] args) {
		int opcion ;
		Map<String, HashSet<String>> mapaTelefonos = new LinkedHashMap<String, HashSet<String>>();
		//caso 2
		String nombre, telefono;
		HashSet<String> conjuntoTelefonos;
		do  {
			System.out.println("(0) Salir");
			System.out.println("(1) Escribir el mapa");
			System.out.println("(2) Insertar un nombre y un telefono ");
			System.out.println("(3) ");
			System.out.println("(4) ");
			opcion = Teclado.leerEntero("Opcion? ");
			switch(opcion) {
			case 0:
				break;
			case 1:
				escribirMapa(mapaTelefonos);
				break;
			case 2:
				nombre = Teclado.leerCadena("Nombre ");
				telefono = Teclado.leerCadena("telefono ");

				if (mapaTelefonos.containsKey(nombre)) {
					conjuntoTelefonos = mapaTelefonos.get(nombre);
					if (conjuntoTelefonos.contains(telefono)) {
						System.out.println("Ese nombre ya tiene el telefono en el mapa");
					}
					else {
						conjuntoTelefonos.add(telefono);
						System.out.println("Se ha añadido un telefono al nombre del mapa");
					}
					
				}
				else {
					conjuntoTelefonos = new HashSet<>();
					conjuntoTelefonos.add(telefono);
					mapaTelefonos.put(nombre , conjuntoTelefonos);
					System.out.println("Se ha añadido un nombre con un telefono contactos");
				}
				break;
			case 3:
				//no hace falta comprobar si el nombre existe ya que eso lo hace el remove del mapa
				//este  mapa devulve null o != null
				nombre = Teclado.leerCadena("Nombre ");
				if (mapaTelefonos.remove(nombre) == null) {
					System.out.println("No se ha encontrado ese nombre en el mapa");
				}
				else {
					System.out.println("Se ha eliminado un nombre y todos sus contactos");
				}
				break;
			case 4: 
				nombre = Teclado.leerCadena("Nombre ");
				telefono = Teclado.leerCadena("telefono ");
				//si existe el nombr, recuperamos el valor asociado con un get(nombre)
				if (mapaTelefonos.containsKey(nombre)) {
					conjuntoTelefonos = mapaTelefonos.get(nombre); //aqui recuperamos el valor
					if (conjuntoTelefonos.remove(telefono)) {
						System.out.println("Se elimino un numero de telefono de un nombre del mapa");
					}
					else {
						System.out.println("No se ha encontrado ese telefono asociado al nombre del mapa");
					}
				}
				else {
					System.out.println("No se ha encontrado ese nombre en el mapa");
				}
				break;
			default:
				System.out.println("Elige opcion correcta");
				break;
			}
		}while(opcion != 0);

	}
}
