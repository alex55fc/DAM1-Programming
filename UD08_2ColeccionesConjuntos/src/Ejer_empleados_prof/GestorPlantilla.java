package Ejer_empleados_prof;

import java.util.Collection;
import java.util.List;
import entrada.Teclado;

public class GestorPlantilla {

	public static void escribirMenuOpciones() {
		System.out.println();
		System.out.println("(0) Salir del programa.");
		System.out.println("(1) Insertar un empleado en la plantilla.");
		System.out.println("(2) Consultar todos los empleados de la plantilla, por DNI ascendente.");
		System.out.println("(8) Consultar los empleados que m�s cobran de cada departamento.");
		System.out.println("(9) Consultar empleados, ordenados por departamento y nombre.");
		System.out.println("(13) Eliminar los empleados de un departamento.");
		System.out.println();
	}
	
	public static void escribirEmpleados
							(Collection<Empleado> coleccionEmpleados) {
		for (Empleado emp : coleccionEmpleados) {
			System.out.println(emp.toString());
		}
		System.out.println(coleccionEmpleados.size() + 
							" empleados consultados");
	}
	
	public static void main(String[] args) {
		Plantilla plantilla = new Plantilla();
		List<Empleado> listaEmpleadosAux;
		Empleado empleado;
		int opcion, empleadosEliminados;
		String dni, nombre, departamento;
		double salario;
		do {
			escribirMenuOpciones();
			opcion = Teclado.leerEntero("�Opci�n? ");
			switch (opcion) {
			// Salir del programa.
			case 0:
				break;
				
			// Insertar un empleado en la plantilla.
			case 1:
				dni = Teclado.leerCadena("�DNI? ");
				if (plantilla.buscarPorDni(dni)) {
					System.out.println("Se ha encontrado otro empleado con ese DNI.");
				}
				else {
					nombre = Teclado.leerCadena("�Nombre? ");
					salario = Teclado.leerReal("�Salario? ");
					departamento = Teclado.leerCadena("�Departamento? ");
					empleado = new Empleado(dni, nombre, departamento, salario);
					if (plantilla.insertar(empleado)) {
						System.out.println("Se ha insertado un empleado");
					}
				}
				break;
				
			// Consultar todos los empleados de la plantilla, por DNI ascendente.
			case 2:
				if (plantilla.estaVacia()) {
					System.out.println("plantilla vac�a");
				}
				else {
					escribirEmpleados(plantilla.obtenerEmpleados());
				}
				break;
				
			// Consultar los empleados que m�s cobran de cada departamento.
			case 8:
				if (plantilla.estaVacia()) {
					System.out.println("plantilla vac�a");
				}
				else {
					listaEmpleadosAux = plantilla.consultarEmpleadosPorDept();
					escribirEmpleados(listaEmpleadosAux);
				}
				break;
				
			// Consultar todos los empleados, ordenados por departamento y nombre.
			case 9:
				if (plantilla.estaVacia()) {
					System.out.println("plantilla vac�a");
				}
				else {
					listaEmpleadosAux = 
						plantilla.ordenarPorDepartamentoYNombreAsc();
					escribirEmpleados(listaEmpleadosAux);
				}
				break;
				
			// Eliminar los empleados de un departamento.
			case 13:
				departamento = Teclado.leerCadena("�Departamento? ");
				if (plantilla.estaVacia()) {
					System.out.println("plantilla vac�a");
				}
				else {
					empleadosEliminados = 
						plantilla.eliminarEmpleadosPorDepartamento(departamento);
					if (empleadosEliminados > 0) {
						System.out.println("Se han eliminado " + empleadosEliminados + " empleados");
					}
					else {
						System.out.println("No se ha encontrado ning�n empleado con ese departamento");
					}
				}
				break;
			}
		}
		while (opcion != 0);
		System.out.println("Programa finalizado.");
	}

}
