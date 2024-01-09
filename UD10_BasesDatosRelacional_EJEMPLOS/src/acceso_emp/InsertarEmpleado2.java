package acceso_emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import entrada.Teclado;

public class InsertarEmpleado2 {

	// Inserta un empleado con código autoincremental en la base de datos SQLite personal.
	public static void main(String[] args) {
		Connection conexion = null;
		try {
			String nombre = Teclado.leerCadena("¿Nombre? ");
			String fechaAlta = Teclado.leerCadena("¿Fecha de Alta? ");
			double salario = Teclado.leerReal("¿Salario? ");
			int codigoDepartamento = Teclado.leerEntero("¿Código de Departamento? ");
			Class.forName("org.sqlite.JDBC");
			conexion = DriverManager.getConnection("jdbc:sqlite:data/personal.db");
			String sentenciaSQL = "INSERT INTO empleado (nombre, fecha_alta, salario, codigo_departamento) " +
			                      "VALUES (?, ?, ?, ?)";
			PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL);
			sentenciaPreparada.setString(1, nombre);
			sentenciaPreparada.setString(2, fechaAlta);
			sentenciaPreparada.setDouble(3, salario);
			sentenciaPreparada.setInt(4, codigoDepartamento);
			int filasInsertadas = sentenciaPreparada.executeUpdate();
			if (filasInsertadas > 0) {
				System.out.println("Se ha insertado un empleado en la base de datos.");
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
