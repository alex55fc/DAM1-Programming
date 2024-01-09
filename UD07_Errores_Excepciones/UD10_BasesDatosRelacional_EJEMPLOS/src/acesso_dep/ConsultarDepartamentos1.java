package acesso_dep;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConsultarDepartamentos1 {

	// Consulta todos los departamentos de la base de datos SQLite personal.
	public static void main(String[] args) {
		Connection conexion = null;
		try {
			Class.forName("org.sqlite.JDBC");
			conexion = DriverManager.getConnection("jdbc:sqlite:data/personal.db");
			int contadorDepartamentos = 0;
			String sentenciaSQL = "SELECT * FROM departamento";
			Statement sentencia = conexion.createStatement();
			ResultSet resultados = sentencia.executeQuery(sentenciaSQL);
			while (resultados.next()) {
				System.out.println("Código = " + resultados.getInt("codigo") +
				                   ", Nombre = " + resultados.getString("nombre") +
				                   ", Ubicación = " + resultados.getString("ubicacion"));
				contadorDepartamentos++;
			}
			if (contadorDepartamentos == 0) {
				System.out.println("No se ha encontrado ningún departamento en la base de datos.");
			}
			else {
				System.out.println("Se han consultado " + contadorDepartamentos + 
				                   " departamentos de la base de datos.");
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
