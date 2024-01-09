package principal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import acceso.AccesoDepartamento;
import entrada.Teclado;
import modelo.Departamento;

public class main_01 {
	public static void escribirMenu() {
		System.out.println();
		System.out.println("(0) salir del programa");
		System.out.println("(1) Insertar un departamento en la base de datos");
		System.out.println("(2) Consultar todos los departamentos de la base de datos.");
		System.out.println("(3) Consultar un departamento, por código, de la base de datos");
		System.out.println("(4) Actualizar un departamento, por código, de la base de datos.");
		System.out.println("(5) Eliminar un departamento, por código, de la base de datos.");
		System.out.println();
	}

	public static void main(String[] args) {
		int opcion;
		//caso 1
		String nombre, ubicacion;
		Departamento departamento;
		int filasAfectadas;
		//caso 2
		List<Departamento> listaAux;
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
					// Insertar un departamento en la base de datos
					nombre = Teclado.leerCadena("Nombre ");
					ubicacion = Teclado.leerCadena("Ubicacion ");
					departamento = new Departamento(nombre,ubicacion);
					
					filasAfectadas = AccesoDepartamento.InsertarDepartamento(departamento);
					if(filasAfectadas == 1) {
						System.out.println("Se ha insertado un departamento");
					}
					else {
						System.out.println("Ha habido un error en la inserccion del departamento");
					}
					break;
					//-----------------------------------------------
				case 2:
					//Consultar todos los departamentos de la base de datos.
					listaAux = new ArrayList<>();
					listaAux = AccesoDepartamento.consultarTodosDepartamentos();
					if(listaAux.isEmpty()) {
						System.out.println("No se ha encontrado ningún departamento en la base de datos.");
					}
					else {
						for(Departamento x : listaAux) {
							System.out.println(x.toString());
						}
						System.out.println("Se han consultado "+ listaAux.size() +" departamentos");
					}
					break;
					//-----------------------------------------------
				case 3:
					//Consultar un departamento, por código, de la base de datos
					codigo = Teclado.leerEntero("Codigo? ");
					departamento = AccesoDepartamento.consultarPorCodigoDepartamento(codigo);
					if(departamento != null) {
						System.out.println(departamento.toString());
					}
					else {
						System.out.println("No existe ningún departamento con ese código en la base de datos.");
					}
					break;
					//-----------------------------------------------
				case 4:
					//Actualizar un departamento, por código, de la base de datos.
					codigo = Teclado.leerEntero("Codigo? ");
					departamento = AccesoDepartamento.consultarPorCodigoDepartamento(codigo);
					if(departamento != null) {
						nombre = Teclado.leerCadena("nombre? ");
						ubicacion  = Teclado.leerCadena("Ubicacion? ");
						if(AccesoDepartamento.actualizarDepPorCodigo(codigo, nombre, ubicacion)) {
							System.out.println("Se ha actualizado un departamento de la base de datos");
						}
						else {
							System.out.println("Error al intentar actualizar un departamento");
						}
					}
					else {
						System.out.println("No existe ningún departamento con ese código en la base de datos.");
					}
					break;
					//-----------------------------------------------
				case 5:
					//Eliminar un departamento, por código, de la base de datos.
					codigo = Teclado.leerEntero("Codigo? ");
					departamento = AccesoDepartamento.consultarPorCodigoDepartamento(codigo);
					if(departamento != null) {
						if(AccesoDepartamento.eliminarDepPorCodigo(codigo)) {
							System.out.println("Se ha eliminado correctamento un departamento de la base dedatos");
						}
						else {
							System.out.println("Error al intentar elimnar un departamento de la base de datos");
						}
					}
					else {
						System.out.println("No existe ningún departamento con ese código en la base de datos.");
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
