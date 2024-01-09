package Ejer_Empleados;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import entrada.Teclado;
/*Solucionar EJERCICIO EN AEDUCAR
 * 2) en el 12 para hacerlo usamos metodos de cadena, eliminamos el ultimo caracter y luego con un endsWith comprovamos si termina por los digitos que nosotro le pasamos por teclado
 * 3)copia pegar EL CASO ( YA QUE DEVULVE 0)
 * 4) cambiar las llamadas a la lista auxiliar que nos devulve el una lista con los empleados del conjunto
 * 5) en el 12 primero quitamos la ultima letra yl uego con el ends with nos dveulve true o false y tambn comprueba si acaba por 3 digitos por lo que no hay q comprobar la longitud del dni*/
public class Principal {
	public static void escribeEmpleadosListaConjuntos(Collection<Empleados> collecionAux) {
		for (Empleados p : collecionAux)	{
			System.out.println(p.toString());
		}
		System.out.println("Empleados consultado "+ collecionAux.size());
	}

	public static void escribirMenuOpciones() {
		System.out.println();
		System.out.println("(0) Salir del programa.");
		System.out.println("(1) Insertar un empleado en la plantilla.");
		System.out.println("(2) Consultar todos los empleados, ordenados por nombre ascendente, de la plantilla.");
		System.out.println("(3) Consultar todos los empleados, ordenados por salario descendente, de la plantilla.");
		System.out.println("(4) Eliminar un empleado, por DNI, de la plantilla");
		System.out.println("(5) Consultar los empleados de un departamento de la plantilla.");
		System.out.println("(6) Consultar los empleados, por nombre y/o apellido, de la plantilla.");
		System.out.println("(7) Consultar el número de empleados de cada departamento de la plantilla.");
		System.out.println("(8) Consultar el/los empleado/s que más cobra/n de cada departamento de la plantilla.");
		System.out.println("(9) Consultar todos los empleados, ordenados por departamento ascendente y nombre ascendente, de la plantilla.");
		System.out.println("(10 Insertar una cantidad de empleados con datos aleatorios en la plantilla.");
		System.out.println("(11) Incrementar un 5% el salario a los empleados de un departamento de la plantilla.");
		System.out.println("(12) Mover los empleados con el DNI finalizado con una terminación de 3 dígitos pasada por teclado a un departamento de la plantilla");
		System.out.println("(13) Eliminar los empleados de un departamento de la plantilla.");
		System.out.println("(14) Eliminar los empleados con un salario inferior a un cantidad de la plantilla.");
		System.out.println("(15) Eliminar los empleados con un salario inferior a la media de los salarios de la plantilla.");
		System.out.println();

	}

	public static void main(String[] args) {
		int opcion;
		Plantilla plantilla = new Plantilla();
		Empleados empleado;
		List<Empleados> listaAux;
		//caso 1
		String dni, nombre, departamento;
		double salario;
		//caso 13 
		int empleadosEliminados;
		do {
			escribirMenuOpciones();
			opcion = Teclado.leerEntero("Escoger opcion. ");
			switch(opcion) {
			case -1:
				if(plantilla.estaVacio()) {
					System.out.println("El conjunto esta vacio");
				}
				else {
					listaAux = plantilla.listaConjunto();
					escribeEmpleadosListaConjuntos(listaAux);
				}
				break;
			case 1:
				// Insertar un empleado en la plantilla.
				dni = Teclado.leerCadena("Dni?");
				if(plantilla.buscarPorDni(dni)) {
					System.out.println("Se ha encontrado un empleado con ese DNI");
				}
				else {
					nombre = Teclado.leerCadena("Nombre ");
					departamento = Teclado.leerCadena("departamento ");
					salario = Teclado.leerReal("salario? ");
					empleado = new Empleados(dni,nombre,departamento,salario);
					if (plantilla.insertarPordni(empleado)) {
						System.out.println("Se ha insertado un empleado al conjunto");
					}
					else{
						System.out.println("No se pude insertar correctamente ");
					}
				}
				break;
				//------------
			case 2:
				// Consultar todos los empleados, ordenados por nombre ascendente, de la plantilla.
				if(plantilla.estaVacio()) {
					System.out.println("El conjunto esta vacio");
				}
				else {
					listaAux = plantilla.listaConjunto();
					plantilla.ordenNombreAscendente(listaAux);
					escribeEmpleadosListaConjuntos(listaAux);
				}
				break;
				//------------
			case 3:
				//Consultar todos los empleados, ordenados por salario descendente, de la plantilla.
				if(plantilla.estaVacio()) {
					System.out.println("El conjunto esta vacio");
				}
				else {
					listaAux = plantilla.listaConjunto();
					plantilla.ordenPrecioDesc(listaAux);
					escribeEmpleadosListaConjuntos(listaAux);
				}
				break;
				//------------
			case 4:
				//Eliminar un empleado, por DNI, de la plantilla
				if(plantilla.estaVacio()) {
					System.out.println("El conjunto esta vacio");
				}
				else {
					dni = Teclado.leerCadena("Dni? ");
					if(plantilla.buscarPorDni(dni)) {
						if(plantilla.eliminarUsuarioDni(dni)) {
							System.out.println("se ha eliminado el Empledo con ese DNI");
						}
					}
					else {
						System.out.println("No se ha encontrado ningun Empleado con ese DNI");
					}
				}
				break;
				//------------
			case 5:
				//Consultar los empleados de un departamento de la plantilla
				if(plantilla.estaVacio()) {
					System.out.println("El conjunto esta vacio");
				}
				else {
					departamento = Teclado.leerCadena("departameto ");
					listaAux = plantilla.listaEmpleadosDepartamento(departamento);
					escribeEmpleadosListaConjuntos(listaAux);
				}
				break;
				//------------
			case 6:
				//Consultar los empleados, por nombre y/o apellido, de la plantilla.
				if(plantilla.estaVacio()) {
					System.out.println("El conjunto esta vacio");
				}
				else {
					nombre = Teclado.leerCadena("nombre ");
					listaAux = plantilla.listaEmpleadosPorNombre(nombre);
					escribeEmpleadosListaConjuntos(listaAux);
				}
				break;
				//------------
			case 7:
				//clave hacer un conjunto de departamentos, ya que ahi al insertar un dep si esta repetido no lo inserta
				//Consultar el número de empleados de cada departamento de la plantilla.
				break;
			case 8:
				//Consultar el/los empleado/s que más cobra/n de cada departamento de la plantilla.
				if(plantilla.estaVacio()) {
					System.out.println("El conjunto esta vacio");
				}
				else {	
					listaAux = plantilla.consultarEmpleadosPorDept();
					escribeEmpleadosListaConjuntos(listaAux);
				}
					break;
				case 9:
					// Consultar todos los empleados, ordenados por departamento ascendente y nombre ascendente, de la plantilla.
					if(plantilla.estaVacio()) {
						System.out.println("El conjunto esta vacio");
					}
					else {
						listaAux = plantilla.listaConjunto();
						plantilla.listaEmpleadosDepNomAsc(listaAux);
						escribeEmpleadosListaConjuntos(listaAux);
					}
					break;
				case 10:
					//Insertar una cantidad de empleados con datos aleatorios en la plantilla.

					break;

				case 11:
					//Incrementar un 5% el salario a los empleados de un departamento de la plantilla.
					if(plantilla.estaVacio()) {
						System.out.println("El conjunto esta vacio");
					}
					else {
						departamento = Teclado.leerCadena("Departamento");
						listaAux = plantilla.incrementa5PorCienDeDepartamento(departamento);
						if(listaAux.isEmpty()) {
							System.out.println("No hay ningun empleado en ese dpeartamentp");
						}
						else {
							escribeEmpleadosListaConjuntos(listaAux);
						}

					}
					break;
				case 12:
					//Mover los empleados con el DNI finalizado con una terminación de 3 dígitos a un departamento de la plantilla
					if(plantilla.estaVacio()) {
						System.out.println("El conjunto esta vacio");
					}
					else {
						departamento = Teclado.leerCadena("Departamento al que moverl os empleados");
						listaAux = plantilla.listaConjunto();
						/*plantilla.moverEmpleadosConDni3Digitos(departamento);
					recorreLista(listaAux);*/

					}
					break;

				case 13:
					//Eliminar los empleados de un departamento de la plantilla.
					if(plantilla.estaVacio()) {
						System.out.println("El conjunto esta vacio");
					}
					else {
						departamento = Teclado.leerCadena("Departamento");
						empleadosEliminados = plantilla.eliminarEmpleadoDepar(departamento);
						if(empleadosEliminados > 0) {
							System.out.println("Se ha eliminado correctamente" + empleadosEliminados + " del departamento");
						}
						else {
							System.out.println("no se encontraron empleados del departamento");
						}
					}
					break;

				case 14:
					break;	
				}
			}
			while(opcion != 0);
		}

	}
