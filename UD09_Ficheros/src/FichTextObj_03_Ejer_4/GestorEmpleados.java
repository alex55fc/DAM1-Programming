package FichTextObj_03_Ejer_4;

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
		System.out.println("(6) Consultar los empleados de un departamento del fichero") ;
		System.out.println("(7) Ordenar el fichero por nombre asc ") ;
		System.out.println();

	}
	public static void escribirListaEmpleados(List<Empleado> listaEmpleados) {
		for (Empleado empleado : listaEmpleados) {
			System.out.println(empleado.toString());
		}
		System.out.println("Se han consultado " + listaEmpleados.size() + " empleados del fichero.");
	}
	//atencion a la gestion de usuario con los procedimientos.

	public static void main(String[] args) {	
		int opcion;
		//caso1
		int codigo;
		Empleado empleado;
		String nombre, fechaNacimiento, departamento;
		double salario;
		// caso 2
		List<Empleado> listaEmpleados;
		do {
			escribirMenuOpciones();
			opcion = Teclado.leerEntero("�Opci�n? ");
			try {
				switch (opcion) {
				// Salir del programa.
				case 0:
					break;

					// Insertar un empleado en el fichero.
				case 1:
					codigo = Teclado.leerEntero("�C�digo? ");
					empleado = AccesoEmpleado.consultar(codigo);
					if (empleado == null) {
						nombre = Teclado.leerCadena("�Nombre? ");
						fechaNacimiento = Teclado.leerCadena("�Fecha Nacimiento? ");
						departamento = Teclado.leerCadena("�Departamento? ");
						salario = Teclado.leerReal("�Salario? ");
						empleado = new Empleado(codigo, nombre, fechaNacimiento, departamento, salario);
						AccesoEmpleado.insertar(empleado);
						System.out.println("Se ha insertado un empleado en el fichero.");
					}
					else {
						System.out.println("Se ha encontrado un empleado con ese c�digo en el fichero.");
					}
					break;

					// Consultar todos los empleados del fichero.
				case 2:
					listaEmpleados = AccesoEmpleado.consultarTodos();
					if (listaEmpleados.isEmpty()) {
						System.out.println("No se ha encontrado ning�n empleado en el fichero.");
					}
					else {
						escribirListaEmpleados(listaEmpleados);
					}
					break;

					// Consultar un empleado, por c�digo, del fichero.
				case 3:
					// TODO
					break;

					// Actualizar un empleado, por c�digo, del fichero.
				case 4:
					codigo = Teclado.leerEntero("�C�digo? ");
					empleado = AccesoEmpleado.consultar(codigo);
					if (empleado == null) {
						System.out.println("No se ha encontrado ning�n empleado con ese c�digo en el fichero.");
					}
					else {
						nombre = Teclado.leerCadena("�Nombre? ");
						fechaNacimiento = Teclado.leerCadena("�Fecha Nacimiento? ");
						departamento = Teclado.leerCadena("�Departamento? ");
						salario = Teclado.leerReal("�Salario? ");
						empleado = new Empleado(codigo, nombre, fechaNacimiento, departamento, salario);
						if (AccesoEmpleado.actualizar(codigo, empleado)) {
							System.out.println("Se ha actualizado un empleado del fichero.");
						}
					}
					break;

					// Eliminar un empleado, por c�digo, del fichero.
				case 5:
					codigo = Teclado.leerEntero("�C�digo? ");
					if (AccesoEmpleado.eliminar(codigo)) {
						System.out.println("Se ha eliminado un empleado del fichero.");
					}
					else {
						System.out.println("No se ha encontrado ning�n empleado con ese c�digo en el fichero.");
					}
					break;

					// Consultar los empleados de un departamento del fichero.
				case 6:
					// TODO
					break;

					// Ordenar el fichero por nombre de empleado ascendente.
				case 7:
					// TODO				
					break;
				}
			}
			catch (IOException ioe) {
				System.out.println("Error al acceder al fichero.");
				ioe.printStackTrace();
			}
		}while(opcion != 0);
	}

}
