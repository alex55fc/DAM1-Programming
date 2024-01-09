package acesso_dep;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import entrada.Teclado;
import modelo.Departamento;

public class ConsultarDepartamentos2 {

	// Consulta los departamentos de la base de datos SQLite personal 
	// con la misma ubicación y ordenados por nombre ascendente.
	public static List<Departamento> consultarPorUbicacion(String ubicacion) 
	throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		try {
			Class.forName("org.sqlite.JDBC");
			conexion = DriverManager.getConnection("jdbc:sqlite:data/personal.db");
			String sentenciaSQL = "SELECT * FROM departamento " +
			                      "WHERE ubicacion = '" + ubicacion +
			                      "' ORDER BY nombre";
			Statement sentencia = conexion.createStatement();
			ResultSet resultados = sentencia.executeQuery(sentenciaSQL);
			List<Departamento> listaDepartamentos = new ArrayList<Departamento>();
			while (resultados.next()) {
				int codigo = resultados.getInt("codigo");
				String nombre = resultados.getString("nombre");
				ubicacion = resultados.getString("ubicacion");
				Departamento departamento = new Departamento(codigo, nombre, ubicacion);
				listaDepartamentos.add(departamento);
			}
			return listaDepartamentos;
		} 	
		finally {
			if (conexion != null && !conexion.isClosed()) {
				conexion.close();
			}
		}
	}

	// Consulta los departamentos de la base de datos SQLite personal
	// con la misma ubicación y ordenados por nombre ascendente.
	public static void main(String[] args) {
		try {
			String ubicacion = Teclado.leerCadena("¿Ubicación? ");
			List<Departamento> listaDepartamentos = consultarPorUbicacion(ubicacion);
			if (listaDepartamentos.isEmpty()) {
				System.out.println("No se ha encontrado ningún departamento con esa ubicación en la base de datos.");
			}
			else {
				for (Departamento departamento : listaDepartamentos) {
					System.out.println(departamento.toString());
				}
				System.out.println("Se han consultado " + listaDepartamentos.size() + 
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
	}

}
