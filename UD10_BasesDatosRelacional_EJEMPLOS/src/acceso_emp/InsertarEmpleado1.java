package acceso_emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import entrada.Teclado;
//USAR METODO "
public class InsertarEmpleado1 {

	// Inserta un empleado con c�digo autoincremental en la base de datos SQLite personal.
	public static void main(String[] args) {
		Connection conexion = null;
		try {
			String nombre = Teclado.leerCadena("�Nombre? ");
			String fechaAlta = Teclado.leerCadena("�Fecha de Alta? ");
			double salario = Teclado.leerReal("�Salario? ");
			int codigoDepartamento = Teclado.leerEntero("�C�digo de Departamento? ");
			Class.forName("org.sqlite.JDBC");
			conexion = DriverManager.getConnection("jdbc:sqlite:data/personal.db");
			String sentenciaSQL = "INSERT INTO empleado (nombre, fecha_alta, salario, codigo_departamento) " +
			                      "VALUES ('" + nombre + 
			                      "', '" + fechaAlta + 
			                      "', " + salario + 
			                      ", " + codigoDepartamento + ")";
			Statement sentencia = conexion.createStatement();
			int filasInsertadas = sentencia.executeUpdate(sentenciaSQL);
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
