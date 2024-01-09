package principal;

import acceso.AccesoDepartamento;
import entrada.Teclado;
import modelo.Departamento;

public class main_01 {
	public static void escribirManu() {
		System.out.println();
		System.out.println("(0) Salir del programaa ");
		System.out.println("(1) Insertar un departamento en la base de datos");
		System.out.println("(2) Consultar todos los departamentos de la base de datos.");
		System.out.println("(3) Consultar un departamento, por código, de la base de datos.");
		System.out.println("(4)Actualizar un departamento, por código, de la base de datos.");
		System.out.println("(5)Eliminar un departamento, por código, de la base de datos");
		System.out.println();

	}

	public static void main(String[] args) {
		int opcion ;
		//case 1
		String nombre,ubicacion,departamento;
		//case 2
		List<Departamento> 
		do {
			escribirManu();
			opcion = Teclado.leerEntero("Opcion ");

			switch(opcion) {
			case 1:
				nombre =Teclado.leerCadena("");
				ubicacion = Teclado.leerCadena("");
				departamento = new Departamento(nombre,ubicacion);
				filasAfectadas = AccesoDepartamento.insertar(departamento);
				if (filasAfectadas == 1) {
					System.out.println("Se ha insertado un departamento en la base de datos ");
				}
				break;
			case 2:
				break;
			case 3:
				codigo = Teclado.leerCadena("Codigo ");
				departamento = AccesoDepartamento.consultar(codigo);
				if (departamento == null) {
					System.out.println("No se ha encontrado nigun departamento");
				}
				else {
					System.out.println(departamento.toString());
				}
				break;
			case 4 :
				codigo = Teclado.leerCadena("Codigo ");
				departamento = AccesoDepartamento.consultar(codigo);
				if (departamento == null) {
					System.out.println("No se ha encontrado ningun departamaneto con ese codigo ");
				}
				else {
					nombre = Teclado.leerCadena("NOmbre ");
					ubicacion = Teclado.leerCadena("ubicacion ");
					departamento.setNombre(nombre);
					departamento.setUbicacion(ubicacion);
					filasAfectadas = AccesoDepartamento.actualizar(codigo,departamento);
					if(filasAfectadas == 1	{
						System.out.println("Se ha actualizafo un departamento en la base de datos ");
					}
				}
				break;
			case 5:
				codgio = Teclado.leerNatural("Codigo ");
				listaEmpleados = AccesoEmpleado.consultarPorDepartamento(codigo);
				if (listaEmpleados.isEmpty()) {
					filasAfectadas = AccesoDepartamento.elimnar(codigo);
					if(filasAfectadas == 0) {
						System.out.println("No se ha encontrado ningun departamento ");
					}
					else {
						System.out.println("Se ha eliminado un departamento de la base de datos ");
					}
				}
				//en este else vemos que hay empleados en ese departamento por lo cual va a salatar un error 
				//que impedira la elimnacion por que hay una foreign key, entyonces nosotros le decimos lo siguiente al usuario convencional
				else {
					System.out.println("Se han encontrado varios emleados relacionados con el dearatmento");
					escribirListaEmpleados(listaEmpleados);
				}
				break;

			}
		}while(opcion != 0);


	}

}
