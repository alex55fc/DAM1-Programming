package aplicacionGestion;

import java.sql.SQLException;
import java.util.ArrayList;
import aplicacionGestion.dao.AccesoDepartamento;
import aplicacionGestion.dao.AccesoEmpleado;

import aplicacionGestion.exceptions.NullDepartamentoException;
import aplicacionGestion.modelo.Departamento;
import aplicacionGestion.modelo.Empleado;
import entrada.Teclado;

public class Main {
	public static void mostrarDepartamentos() {
		ArrayList<Departamento> lista = AccesoDepartamento.consultarDepartamentos();
		for (Departamento d : lista) {
			System.out.println(d);
		}
	}
	public static int mostrarMenu() {
		System.out.println("0) Salir del programa.\n"
							+ "1) Insertar departamento.\n"
							+ "2) Consultar todos los departamentos.\n"
							+ "3) Consultar un departamento por codigo.\n"
							+ "4) Actualizar un departamento por codigo.\n"
							+ "5) Eliminar un departamento por codigo.\n"
							+ "6) Insertar empleado.\n"
							+ "7) Consultar todos los empleados.\n"
							+ "8) Consultar un empleado por codigo.\n"
							+ "9) Actualizar un empleado por codigo.\n"
							+ "10) Eliminar un empleado por codigo.\n");
		int opcion = Teclado.leerEntero("¿Opcion 0 - 10? ");
		return opcion;
	}
	public static void main(String[] args) {
		int opcion;
		
		do {
			opcion = mostrarMenu();
			switch (opcion) {
				//Salir
				case 0:
					break;
				//Insertar un empleado
				case 1:
					System.out.println("--- INSERTAR DEPARTAMENTO ---");
					String nombre = Teclado.leerCadena("¿Nombre del departamento? ");
					String ubicacion = Teclado.leerCadena("¿Ubicacion del departamento? ");
					Departamento d = new Departamento(nombre, ubicacion);
					
					if (!AccesoDepartamento.insertarDepartamento(d)) {
						System.out.println("El departamento no se ha insertado correctamente.\n");
					}
					else {
						System.out.println("El departamento se ha insertado correctamente.\n");
					}
					break;
				//Consultar todos los departamentos
				case 2:
					System.out.println("--- CONSULTAR TODOS LOS DEPARTAMENTOS ---");
					ArrayList<Departamento> listaDepartamentos = AccesoDepartamento.consultarDepartamentos();
					if (listaDepartamentos.isEmpty()) {
						System.out.println("No se ha encontrado ningun departamento en la base de datos.");
					}
					else {
						for (Departamento dpto : listaDepartamentos) {
							System.out.println(dpto.toString());
						}
					}
					break;
				//Consultar un departamento por codigo
				case 3:
					System.out.println("--- CONSULTAR DEPARTAMENTO POR CODIGO ---");
					int codigo = Teclado.leerEntero("¿Codigo del departamento a consultar? ");
					d = AccesoDepartamento.buscarDepartamento(codigo);
					if (d == null) {
						System.out.println("No existe ningun departamento con ese codigo.");
					}
					else {
						System.out.println(d.toString() + "\n");
					}
					break;
				//Actualizar departamento por codigo
				case 4:
					codigo = Teclado.leerEntero("¿Codigo del departamento a actualizar? ");
					nombre = Teclado.leerCadena("¿Nuevo nombre? ");
					ubicacion = Teclado.leerCadena("¿Nueva ubicacion? ");
					
					if (!AccesoDepartamento.actualizarDepartamento(codigo, nombre, ubicacion)) {
						System.out.println("No existe ningun departamento con ese codigo.");
					}
					else {
						System.out.println("Se ha actualizado un departamento de la base de datos.");
					}
					break;
				//Eliminar departamento por codigo
				case 5:
					codigo = Teclado.leerEntero("¿Codigo del departamento a eliminar? ");
					try {
						AccesoDepartamento.eliminarDepartamento(codigo);
						
						System.out.println("Se ha eliminado el departamento de la base de datos.");
					}
					catch (NullDepartamentoException nde) {
						System.out.println(nde.getMensaje() + "\n");
					}
					catch (SQLException sqle) {
						System.out.println("No se puede eliminar el departamento porque esta referenciado a uno o mas empleados.\n" + sqle.getMessage() +"\n");
					}
					break;
				//Insertar nuevo empleado
				case 6:
					System.out.println("--- INSERTAR NUEVO EMPLEADO ---");
					nombre = Teclado.leerCadena("¿Nuevo nombre? ");
					String fechaAlta = Teclado.leerCadena("¿Nueva fecha de alta? ");
					double salario = Teclado.leerReal("¿Nuevo salario? ");
					System.out.println("Asigne un codigo de departamento entre los siguientes al nuevo empleado:\n");
					mostrarDepartamentos();
					int codigoDepartamento = Teclado.leerEntero("¿Codigo de departamento? ");
					
					d = new Departamento(codigoDepartamento);					
					Empleado e = new Empleado(nombre, fechaAlta, salario, d);
					
					if (!AccesoEmpleado.insertarEmpleado(e)) {
						System.out.println("Error al insertar el empleado.");
					}
					else {
						System.out.println("Empleado insertado correctamente.");
					}
					break;
				//Consultar todos los empleados de la base de datos
				case 7:
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
				//Buscar un empleado por codigo
				case 8:
					System.out.println("--- BUSCAR EMPLEADO POR CODIGO ---");
					codigo = Teclado.leerEntero("¿Codigo a buscar? ");					
					e = AccesoEmpleado.buscarEmpleado(codigo);
					
					if (e == null) {
						System.out.println("No se ha encontrado al empleado en la base de datos.");
					}
					else {
						System.out.println(e);
					}
					break;
				//Actualizar empleado por codigo
				case 9:
					/*
					System.out.println("--- ACTUALIZAR EMPLEADO ---");
					codigo = Teclado.leerEntero("¿Codigo del empleado? ");
					nombre = Teclado.leerCadena("¿Nombre a actualizar? ");
					fechaAlta = Teclado.leerCadena("¿Fecha alta a actualizar? ");
					salario = Teclado.leerReal("¿Salario a actualizar? ");
					System.out.println("Seleccione un codigo departamento de los siguientes: ");
					//Seleccion de departamento:
					//Se muestra lista de departamentos, se busca el departamento y se crea el empleado
					mostrarDepartamentos();
					codigoDepartamento = Teclado.leerEntero("¿Codigo departamento a actualizar? ");
					Departamento departamento = AccesoDepartamento.buscarDepartamento(codigoDepartamento);
					
					Empleado empleado = new Empleado(codigo ,nombre, fechaAlta, salario, departamento);
					
					if (!AccesoEmpleado.actualizarEmpleado(empleado)) {
						System.out.println("Error al actualizar el empleado.");
					}
					else {
						System.out.println("Empleado actualizado correctamente.");
					}
					break;
					*/
				//Eliminar empleado por codigo
				case 10:
					/*
					codigo = Teclado.leerEntero("¿Codigo del empleado a eliminar? ");
					if (!AccesoEmpleado.eliminarEmpleado(codigo)) {
						System.out.println("Error al eliminar el empleado.");
					}
					else {
						System.out.println("Empleado eliminado correctamente.");
					}
					break;
					*/
				//Opcion incorrecta
				default:
					System.out.println("La opcion debe estar entre 0 y 10.");
					break;
				}
		}
		while (opcion != 0);
		System.out.println("Adios.");
	}
}
