package acceso_emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entrada.Teclado;
import modelo.Empleado;

public class ConsultarEmpleados3 {

	// Consulta los empleados con un nombre de la base de datos SQLite personal.
	public static List<Empleado> consultarPorNombre(String nombre) 
	throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		try {
			Class.forName("org.sqlite.JDBC");
			conexion = DriverManager.getConnection("jdbc:sqlite:data/personal.db");
			String sentenciaSQL = "SELECT * FROM empleado " +
			                      "WHERE nombre = ?";
			PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL);
			sentenciaPreparada.setString(1, nombre);
			ResultSet resultados = sentenciaPreparada.executeQuery();
			List<Empleado> listaEmpleados = new ArrayList<Empleado>();
			while (resultados.next()) {
				int codigo = resultados.getInt("codigo");
				nombre = resultados.getString("nombre");
				String fechaAlta = resultados.getString("fecha_alta");
				double salario = resultados.getDouble("salario");
				int codigoDepartamento = resultados.getInt("codigo_departamento");
				Empleado empleado = new Empleado(codigo, nombre, fechaAlta, salario, codigoDepartamento);
				listaEmpleados.add(empleado);
			}
			return listaEmpleados;
		} 	
		finally {
			if (conexion != null && !conexion.isClosed()) {
				conexion.close();
			}
		}
	}
	
	// Consulta los empleados con un nombre de la base de datos SQLite personal.
	public static void main(String[] args) {
		try {
			String nombre = Teclado.leerCadena("¿Nombre? ");
			List<Empleado> listaEmpleados = consultarPorNombre(nombre);
			if (listaEmpleados.isEmpty()) {
				System.out.println("No se ha encontrado ningún empleado con ese nombre en la base de datos.");
			}
			else {
				for (Empleado empleado : listaEmpleados) {
					System.out.println(empleado.toString());
				}
				System.out.println("Se han consultado " + listaEmpleados.size() + 
				                   " empleados de la base de datos.");
			}
		} 
		catch (ClassNotFoundException cnfe) {
			System.out.println("Error al cargar el conector de SQLite.");
			cnfe.printStackTrace();
		} 
		catch (SQLException sqle) {
			System.out.println("Error al acceder a la base de datos SQLite.");
			sqle.printStackTrace();
		}
	}

}
