package Acceso;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.sqlite.SQLiteConfig;

public class configBD {

	//clase para datos constantes
	private static final String NOMBRE_DRIVER ="org.sqlite.JDBC";
	private static final String URL = "jdbc:sqlite:db\\discografica_musical.db";
	
	//ahora me defino 2 métodos publicos. Uno que devolverá un objeto conexion para abrir y para cerrar la conexión
	
	public static Connection abrirConexion() throws ClassNotFoundException, SQLException {
		Class.forName(NOMBRE_DRIVER);//ponemos la constante
		SQLiteConfig config = new SQLiteConfig();  
        config.enforceForeignKeys(true); 
		return DriverManager.getConnection(URL, 
		                                       config.toProperties());
	}
	
	public static void cerrarConexion(Connection conexion)
			throws SQLException { //necesitamos la conexión a cerrar
		if(conexion != null && !conexion.isClosed()) {
			conexion.close();
		}
	}
}
