package aplicacionGestion;

import java.util.ArrayList;

import aplicacionGestion.dao.AccesoDepartamento;
import aplicacionGestion.dao.AccesoEmpleado;
import aplicacionGestion.modelo.Departamento;
import aplicacionGestion.modelo.Empleado;
import entrada.Teclado;

public class Actividad11x02 {
	public static void mostrarDepartamentos() {
		ArrayList<Departamento> lista = AccesoDepartamento.consultarDepartamentos();
		for (Departamento d : lista) {
			System.out.println(d);
		}
	}
	public static int mostrarMenu() {
		System.out.println("0) Salir del programa.\n"
							+ "1) Insertar empleado.\n"
							+ "2) Consultar todos los empleados.\n"
							+ "3) Consultar un empleado por codigo.\n"
							+ "4) Actualizar un empleado por codigo.\n"
							+ "5) Eliminar un empleado por codigo.\n");
		int opcion = Teclado.leerEntero("¿Opcion 0 - 5? ");
		return opcion;
	}
	public static void main(String[] args) {
		int opcion;
		
		do {
			opcion = mostrarMenu();
			switch(opcion) {
				case 0:
					break;
				case 1:
					System.out.println("--- INSERTAR NUEVO EMPLEADO ---");
					String nombre = Teclado.leerCadena("¿Nuevo nombre? ");
					String fechaAlta = Teclado.leerCadena("¿Nueva fecha de alta? ");
					double salario = Teclado.leerReal("¿Nuevo salario? ");
					System.out.println("Asigne un codigo de departamento entre los siguientes al nuevo empleado:\n");
					mostrarDepartamentos();
					int codigoDepartamento = Teclado.leerEntero("¿Codigo de departamento? ");
					
					Departamento d = new Departamento(codigoDepartamento);					
					Empleado e = new Empleado(nombre, fechaAlta, salario, d);
					
					if (!AccesoEmpleado.insertarEmpleado(e)) {
						System.out.println("Error al insertar el empleado.");
					}
					else {
						System.out.println("Empleado insertado correctamente.");
					}
					break;
				case 2:
					ArrayList<Empleado> lista = AccesoEmpleado.consultarEmpleados();
					if (lista.isEmpty()) {
						System.out.println("No se han encontrado empleados en la base de datos.");
					}
					else {
						System.out.println("--- CONSULTANDO A TODOS LOS EMPLEADOS DE LA BASE DE DATOS ---");
						for (Empleado em : lista) {
							System.out.println(em);
						}
					}
					break;
				case 3:
					System.out.println("--- BUSCAR EMPLEADO POR CODIGO ---");
					int codigo = Teclado.leerEntero("¿Codigo a buscar? ");					
					e = AccesoEmpleado.buscarEmpleado(codigo);
					
					if (e == null) {
						System.out.println("No se ha encontrado al empleado en la base de datos.");
					}
					else {
						System.out.println(e);
					}
					break;
				case 4:
					/*
					System.out.println("--- ACTUALIZAR EMPLEADO ---");
					codigo = Teclado.leerEntero("¿Codigo del empleado? ");
					nombre = Teclado.leerCadena("¿Nombre a actualizar? ");
					fechaAlta = Teclado.leerCadena("¿Fecha alta a actualizar? ");
					salario = Teclado.leerReal("¿Salario a actualizar? ");
					System.out.println("Seleccione un codigo departamento de los siguientes: ");
					mostrarDepartamentos();
					codigoDepartamento = Teclado.leerEntero("¿Codigo departamento a actualizar? ");
					
					if (!AccesoEmpleado.actualizarEmpleado(codigo, nombre, fechaAlta, salario, codigoDepartamento)) {
						System.out.println("Error al actualizar el empleado.");
					}
					else {
						System.out.println("Empleado actualizado correctamente.");
					}
					break;*/
				case 5:
					codigo = Teclado.leerEntero("¿Codigo del empleado a eliminar? ");
					if (!AccesoEmpleado.eliminarEmpleado(codigo)) {
						System.out.println("Error al eliminar el empleado.");
					}
					else {
						System.out.println("Empleado eliminado correctamente.");
					}
					break;
				default:
					System.out.println("La opcion seleccionada debe estar entre 0 y 5.");
					break;
			}
		}
		while (opcion != 0);
		
		
		

	}

}
