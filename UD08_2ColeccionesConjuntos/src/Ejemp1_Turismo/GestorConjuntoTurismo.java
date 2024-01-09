package Ejemp1_Turismo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import entrada.Teclado;

public class GestorConjuntoTurismo {

	public static void escribirMenu() {
		System.out.println();
		System.out.println("(0) salir ");
		System.out.println("(1) Insertar un turismo en el con junto");
		System.out.println("(2) Consultar todos los turismos del conjunto por orden de inserccion");
		System.out.println("(3) Eliminar un turismo, por matricula del conjunto");
		System.out.println("(4) Ordenar el conjunto por matricula ascendente");
		System.out.println("(5) Ordenar el conjunto por precio descendente");
		System.out.println();

	}

	public static void main(String[] args) {
		Set<Turismo> conjuntoTurismo = new LinkedHashSet<Turismo>();
		Set<Turismo> conjuntoOrdenado;
		List<Turismo> listaOrdenada;
		int opcion;
		//caso 1
		Turismo turismo;
		String matricula, marca, modelo;
		int agno;
		double precio;
		do {
			escribirMenu();
			opcion = Teclado.leerEntero("Elige una opcion.");
			switch(opcion) {
			case 0:
				break;
			case 1:
				matricula = Teclado.leerCadena("Matricula ");
				turismo = new Turismo(matricula, "", "",0,0.0);
				if(conjuntoTurismo.contains(turismo)) {
					System.out.println("Coche con matricula existente");
				}
				else {
					marca = Teclado.leerCadena("Marca ");
					modelo = Teclado.leerCadena("Modelo");
					agno = Teclado.leerEntero("Año ");
					precio = Teclado.leerReal("Precio");

					turismo = new Turismo(matricula, marca, modelo, agno, precio);
					if (conjuntoTurismo.add(turismo)) {
						System.out.println("Turismo insertado en el conjunto");
					}
					else {
						System.out.println("No se ha podido insertar el turismo");
					}
				}
				break;
				//----------------
			case 2:
				if (conjuntoTurismo.isEmpty()) {
					System.out.println("El conjunto de turismo esta vacio");
				}
				else {
					for(Turismo turismox : conjuntoTurismo) {
						System.out.println(turismox.toString());
					}
					System.out.println("Turismo consultados "+ conjuntoTurismo.size());
				}
				break;
				//----------------
			case 3:
				matricula = Teclado.leerCadena("Matricula ");
				turismo = new Turismo(matricula, "", "",0,0.0);
				if (conjuntoTurismo.remove(turismo)) {
					System.out.println("Turismo eliminado del conjunto");
				}
				else {
					System.out.println("no hay ningun turismo con esa maatricula");
				}
				break;
				//----------------
			case 4:
				/*para ordenar un conjunto lo hacemos con un TreeSet<>()
				 * asi ponemos el orden para un TreeSet*/
				conjuntoOrdenado = new TreeSet<Turismo>(new OrdenTurismoPorMatriculaAsc());
				conjuntoOrdenado.addAll(conjuntoTurismo);
				if (conjuntoOrdenado.isEmpty()) {
					System.out.println("El conjunto esta vacio ");	
				}
				else{
					for(Turismo t : conjuntoOrdenado) {
						System.out.println(t.toString());
					}
					System.out.println("Turimos consultados del conjunto"+ conjuntoOrdenado.size());
				}

				break;
				//----------------
			case 5:
				listaOrdenada = new ArrayList<Turismo>();
				listaOrdenada.addAll(conjuntoTurismo);
				Collections.sort(listaOrdenada, new OrdenTurismoPorPrecioDesc());
				if (listaOrdenada.isEmpty()) {
					System.out.println("El conjunto esta vacio ");	
				}
				else{
					for(Turismo t : listaOrdenada) {
						System.out.println(t.toString());
					}
					System.out.println("Turimos consultados del conjunto"+ listaOrdenada.size());
				}
				break;
			default:
				System.out.println("Elige una opcion correcta");
				break;

			}
		}while (opcion != 0);
	}

}
