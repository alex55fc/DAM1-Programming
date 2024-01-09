package Ejer4;

import java.io.IOException;
import java.util.List;

import entrada.Teclado;

public class GestorEmpleados {
	public static void escribirMenuOpciones() {
		System.out.println();
		System.out.println("(0) salir del programa ");
		System.out.println("(1) Insertar in empleado en el fichero ");
		System.out.println("(2) Consultar todos los empleados del fichero ");
		System.out.println("(3) Consultar un empleado, por codigo del fichero ");
		System.out.println("(4) Actualizar un empleado, por codigo del fichero ");
		System.out.println("(5) Eliminar un empleado, por codigo del fichero ") ;
		System.out.println("(6) Consultar por departamento") ;
		System.out.println("(7) Ordenar por nombre asc ") ;
		System.out.println();

	}
	//atencion a la gestion de usuario con los procedimientos.

	public static void main(String[] args) {	
		int opcion;
		//caso1
		int codigo;
		Empleado empleado;
		String nombre, fechaNac, departamento;
		double salario;
		// caso 2
		List<Empleado> listaAux;
		do {
			escribirMenuOpciones();
			opcion = Teclado.leerEntero("Opcion ");
			try {
				switch(opcion) {
					//caso 0
				case 0:
					break;
					//----------------------------------------------------------------------
					// caso 1 Insertar in empleado en el fichero
				case 1:
					codigo = Teclado.leerEntero("Codigo ");
					empleado = AccesoEmpleado.consultar(codigo);
					if (empleado == null) {
						nombre = Teclado.leerCadena("Nombre ");
						fechaNac = Teclado.leerCadena("Fecha nacimiento ");
						departamento = Teclado.leerCadena("Departamento ");
						salario = Teclado.leerReal("Salario ");
						
						empleado = new Empleado(codigo, nombre, fechaNac, departamento, salario);
						AccesoEmpleado.insertar(empleado);
						System.out.println("Se ha insertado un empleado en el fihcero");
					}
					else {
						System.out.println("ya hay un empleado con ese codigo");
					}
					break;
					//----------------------------------------------------------------------

					// caso 2 Consultar todos los empleados del fichero
				case 2:
					listaAux = AccesoEmpleado.consultarTodos();
					if(listaAux.isEmpty()) {
						System.out.println("No hay empleados en el fichero");
					}
					else {
						for(Empleado e : listaAux) {
							System.out.println(e.toString());
						}
						System.out.println("Se ha consulta un total de "+ listaAux.size()+ " de empleados");
					}
					break;
					//----------------------------------------------------------------------
					//Caso 4. Actualizar un empleado, por codigo del fichero
				case 4:
					codigo = Teclado.leerEntero("Codigo ");
					empleado = AccesoEmpleado.consultar(codigo);
					if (empleado == null) {
						System.out.println("No hay ningun empleado con ese codigo");
					}
					else {
						nombre = Teclado.leerCadena("Nombre ");
						fechaNac = Teclado.leerCadena("Fecha nacimiento ");
						departamento = Teclado.leerCadena("Departamento ");
						salario = Teclado.leerReal("Salario ");
						empleado = new Empleado(codigo, nombre, fechaNac, departamento, salario);

					}
					break;
					//----------------------------------------------------------------------
				case 5:
					codigo=Teclado.leerEntero("Codgio ");
					if() {
						
					}
					else {
						System.out.println("No se ha encontrado un empleado con ese codigo. ");
					}
					break;
					//----------------------------------------------------------------------
					//Consultar por departamento
				case 6:
					
					break;
				}
			}
			catch(IOException ioe) {
				System.out.println("Error al acceder al fichero");
				ioe.printStackTrace();
			}
		}while(opcion != 0);
	}

}
