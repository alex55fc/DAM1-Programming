package Ejemp2_Empleados;

import java.util.Set;
import entrada.Teclado;

public class Principal {

	public static void escribirMenuOpciones() {
		System.out.println();
		System.out.println("(0) Salir del programa.");
		System.out.println("(1) Insertar un empleado en la plantilla.");
		System.out.println("(2) Consultar todos los empleados de la plantilla, por DNI ascendente.");
		System.out.println();
	}
	
	public static void escribirConjuntoEmpleados
							(Set<Empleado> conjuntoEmpleados) {
		for (Empleado emp : conjuntoEmpleados) {
			System.out.println(emp.toString());
		}
		System.out.println(conjuntoEmpleados.size() + 
							" empleados consultados");
	}
	
	public static void main(String[] args) {
		Plantilla plantilla = new Plantilla();
		Empleado empleado;
		int opcion;
		String dni, nombre, departamento;
		double salario;
		do {
			escribirMenuOpciones();
			opcion = Teclado.leerEntero("¿Opción? ");
			switch (opcion) {
			// Salir del programa.
			case 0:
				break;
				
			// Insertar un empleado en la plantilla.
			case 1:
				dni = Teclado.leerCadena("¿DNI? ");
				if (plantilla.buscarPorDni(dni)) {
					System.out.println("Se ha encontrado otro empleado con ese DNI.");
				}
				else {
					nombre = Teclado.leerCadena("¿Nombre? ");
					salario = Teclado.leerReal("¿Salario? ");
					departamento = Teclado.leerCadena("¿Departamento? ");
					empleado = new Empleado(dni, nombre, departamento, salario);
					if (plantilla.insertar(empleado)) {
						System.out.println("Se ha insertado un empleado");
					}
				}
				break;
				
			// Consultar todos los empleados de la plantilla, por DNI ascendente.
			case 2:
				if (plantilla.estaVacia()) {
					System.out.println("plantilla vacía");
				}
				else {
					escribirConjuntoEmpleados(plantilla.obtenerEmpleados());
				}
				break;
			}
		}
		while (opcion != 0);
		System.out.println("Programa finalizado.");
	}

}
