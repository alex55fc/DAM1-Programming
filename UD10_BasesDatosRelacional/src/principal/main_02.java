package principal;

import java.sql.SQLException;
import java.util.List;

import acceso.AccesoDepartamento;
import acceso.AccesoEmpleado;
import entrada.Teclado;
import modelo.Departamento;
import modelo.Empleado;

public class main_02 {
	public static void escribirMenu() {
		System.out.println();
		System.out.println("(0) salir del programa");
		System.out.println("(1) Insertar un empleado en la base de datos");
		System.out.println("(2) Consultar todos los empleados de la base de datos.");
		System.out.println("(3) Consultar un empleado, por código, de la base de datos");
		System.out.println("(4) Actualizar un empleado, por código, de la base de datos.");
		System.out.println("(5) Eliminar un empleado, por código, de la base de datos.");
		System.out.println();
	}
	public static void escribirTodosDepartamentos() throws ClassNotFoundException, SQLException {
		List<Departamento> listaAuxDep = AccesoDepartamento.consultarTodosDepartamentos();
		for(Departamento x : listaAuxDep) {
			System.out.println(x.toString());
		}
	}
	public static void main(String[] args) {
		int opcion;
		//caso 1
		String nombre,fechaAlta;
		double salario;
		Departamento depAux;
		int codigoDep;
		Empleado empleAux;
		//caso 2
		List<Empleado> listaAux;
		//caso 3
		int codigo;
		do {
			escribirMenu();
			opcion = Teclado.leerEntero("opcion ");
			try {
				switch(opcion) {
				case 0:
					break;
					//-----------------------------------------------
				case 1:
					// Insertar un empleado en la base de datos
					nombre= Teclado.leerCadena("nombre ");
					fechaAlta = Teclado.leerCadena("fecha alta? ");
					salario = Teclado.leerReal("salario? ");
					System.out.println("Asigna un codigo de los departamentos siguientes.");
					escribirTodosDepartamentos();
					codigoDep = Teclado.leerEntero("Codigo departamento? ");
					if(AccesoEmpleado.claveAjenaDepartamento(codigoDep)) {
						depAux = new Departamento(codigoDep);
						empleAux= new Empleado(nombre, fechaAlta, salario, depAux);
						if(AccesoEmpleado.insertarEmpleado(empleAux)) {
							System.out.println("Se ha insertado un empleado correctamente");
						}
						else {
							System.out.println("Error  al insertar un empleado");
						}
					}
					else {
						System.out.println("No hay ningun departamento con ese codigo en la base de datos ");
					}

					break;
					//-----------------------------------------------
				case 2:
					//Consultar todos los empleado de la base de datos.
					listaAux= AccesoEmpleado.consultarEmpleados();
					if(listaAux.isEmpty()) {
						System.out.println("No hay empleados en la base de datos");
					}
					else{
						for(Empleado x : listaAux) {
							System.out.println(x.toString());
						}
					}
					break;
					//-----------------------------------------------
				case 3:
					//Consultar un empleado, por código, de la base de datos
					codigo = Teclado.leerEntero("codigo? ");
					empleAux = AccesoEmpleado.buscarEmpleado(codigo);
					if(empleAux == null) {
						System.out.println("No hay ningun empleado con ese codigo en la base de datos ");
					}
					else
						System.out.println(empleAux.toString());
					break;
					//-----------------------------------------------
				case 4:
					//Actualizar un empleado, por código, de la base de datos.
					codigo = Teclado.leerEntero("�Codigo del empleado? ");
					empleAux = AccesoEmpleado.buscarEmpleado(codigo);
					if(empleAux == null) {
						System.out.println("No hay un empleado con ese codigo en la base de datos");
					}
					else {
						nombre = Teclado.leerCadena("�Nombre a actualizar? ");
						fechaAlta = Teclado.leerCadena("�Fecha alta a actualizar? ");
						salario = Teclado.leerReal("�Salario a actualizar? ");
						System.out.println("Seleccione un codigo departamento de los siguientes: ");
						escribirTodosDepartamentos();
						codigoDep = Teclado.leerEntero("�Codigo departamento a actualizar? ");
						depAux = new Departamento(codigoDep);
						empleAux = new Empleado(codigo,nombre, fechaAlta, salario, depAux);
						if(AccesoEmpleado.claveAjenaDepartamento(codigoDep)) {
							if(AccesoEmpleado.actualizarEmpleado(empleAux)) {
								System.out.println("Se ha actualizado un empleado en la base de datos");
							}
							else {
								System.out.println("Error al actualizar un empleado en la base de datos");
							}

						}
						else {
							System.out.println("No hay ningun departamento con ese codigo en la base de datos ");
						}
					}

					break;
					//-----------------------------------------------
				case 5:
					//Eliminar un emp, por código, de la base de datos.
					codigo= Teclado.leerEntero("codigo?");
					empleAux = AccesoEmpleado.buscarEmpleado(codigo);
					if(empleAux == null) {
						System.out.println("No hay ningun departamento con ese codigo  en la base de datos");

					}
					else {
						if(AccesoEmpleado.eliminarEmpleado(codigo)) {
							System.out.println("Se ha eliminado correctamente un empleado de la base de datos");
						}
						else {
							System.out.println("Error al eliminar un empleado");
						}
					}
					break;
					//-----------------------------------------------

				default:
					System.out.println("Escoge una opcion correcta");

					break;
				}
			}
			catch(ClassNotFoundException cnfe){
				System.out.println("Error al cargar el conector de SQLite");
				cnfe.printStackTrace();
			}
			catch(SQLException sqle) {
				System.out.println("Error al acceder a la base de datos");
				sqle.printStackTrace();
			}
		}while(opcion!= 0);
	}

}
