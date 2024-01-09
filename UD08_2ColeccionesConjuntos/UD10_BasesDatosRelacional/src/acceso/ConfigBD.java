package acceso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.sqlite.SQLiteConfig;

public class ConfigBD {
	
	private static final String NOMBRE_DRIVER = "org.sqlite.JDBC";
	private static final String URL = "jdbc:sqlite:db/personal.db";
	
	/*Abre una conexion con una base de datos creaadad en SQL */
	public static Connection abrirConexion() throws ClassNotFoundException, SQLException {
		Class.forName(NOMBRE_DRIVER);
		//estas dos lineas siguientes son para forzar el comprobar foreign key para la hora de eliminar no elimanr datos que son utiles
		SQLiteConfig config = new SQLiteConfig();  
        config.enforceForeignKeys(true); 
		Connection conexion = DriverManager.getConnection(URL, config.toProperties());
		return conexion;
	}
	public static void cerrarConexion(Connection conexion) throws SQLException {
		if(conexion != null && !conexion.isClosed()) {
			conexion.close();
		}
	}
}
