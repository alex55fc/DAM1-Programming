package acceso_emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import entrada.Teclado;

public class ConsultarEmpleados1 {

	// Consulta los empleados de un departamento de la base de datos SQLite personal.
	public static void main(String[] args) {
		Connection conexion = null;
		try {
			int codigoDepartamento = Teclado.leerEntero("¿Código de Departamento? ");
			Class.forName("org.sqlite.JDBC");
			conexion = DriverManager.getConnection("jdbc:sqlite:data/personal.db");
			String sentenciaSQL = "SELECT * FROM empleado " +
			                      "WHERE codigo_departamento = " + codigoDepartamento;
			Statement sentencia = conexion.createStatement();
			ResultSet resultados = sentencia.executeQuery(sentenciaSQL);
			int contadorEmpleados = 0;
			while (resultados.next()) {
				System.out.println("Código = " + resultados.getInt("codigo") +
				                   ", Nombre = " + resultados.getString("nombre") +
				                   ", Fecha de Alta = " + resultados.getString("fecha_alta") +
				                   ", Salario = " + resultados.getDouble("salario") +
				                   ", Código de Departamento = " + resultados.getInt("codigo_departamento"));
				contadorEmpleados++;
			}
			if (contadorEmpleados == 0) {
				System.out.println("No se ha encontrado ningún empleado con ese código de departamento en la base de datos.");
			}
			else {
				System.out.println("Se han consultado " + contadorEmpleados + 
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
		finally {
			try {
				if (conexion != null && !conexion.isClosed()) {
					conexion.close();
				}
			} 
			catch (SQLException sqle) {
				System.out.println("Error al cerrar la base de datos SQLite.");
				sqle.printStackTrace();
			}
		}
	}

}
