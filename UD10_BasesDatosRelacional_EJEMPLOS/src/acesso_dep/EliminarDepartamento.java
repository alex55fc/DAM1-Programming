package acesso_dep;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.sqlite.SQLiteConfig;
import entrada.Teclado;

public class EliminarDepartamento {

	// Elimina un departamento, por código, de la base de datos SQLite personal.
	public static void main(String[] args) {
		Connection conexion = null;
		try {
			int codigo = Teclado.leerEntero("¿Código? ");
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();  
	        config.enforceForeignKeys(true); 
			conexion = DriverManager.getConnection("jdbc:sqlite:data/personal.db", 
			                                       config.toProperties());
			String sentenciaSQL = "DELETE FROM departamento " +
			                      "WHERE codigo = " + codigo;
			Statement sentencia = conexion.createStatement();
			int filasEliminadas = sentencia.executeUpdate(sentenciaSQL);
			if (filasEliminadas == 0) {
				System.out.println("No se ha encontrado ningún departamento con ese código en la base de datos.");
			}
			else {
				System.out.println("Se ha eliminado un departamento de la base de datos.");
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
