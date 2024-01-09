package acceso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Departamento;

public class AccesoDepartamento {

	/*Caso 1: Insertar un departamento en la base de datos*/
	public static int InsertarDepartamento(Departamento departamento) throws SQLException, ClassNotFoundException {
		Connection conexion = null;
		try {
			conexion = ConfigBD.abrirConexion();
			String sentenciaSQL ="INSERT INTO departamento (nombre, ubicacion) "
					+"VALUES (?, ?)";
			PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL);
			sentenciaPreparada.setString(1, departamento.getNombre());
			sentenciaPreparada.setString(2,departamento.getUbicacion());

			int filasInsertadas = sentenciaPreparada.executeUpdate();
			return filasInsertadas;
		}
		finally {
			ConfigBD.cerrarConexion(conexion);
		}
	}
	/*Caso 2*/
	public static List<Departamento> consultarTodosDepartamentos() throws ClassNotFoundException, SQLException{
		Connection conexion = null;
		List<Departamento> listaAux = new ArrayList<>();
		try {
			conexion= ConfigBD.abrirConexion();
			String sentenciaSQL = "SELECT * FROM departamento ";
			PreparedStatement sentenciaPreparada= conexion.prepareStatement(sentenciaSQL);
			ResultSet resultadoDepartamento =  sentenciaPreparada.executeQuery();

			while(resultadoDepartamento.next()) {
				int codigo = resultadoDepartamento.getInt("codigo");
				String nombre = resultadoDepartamento.getString("nombre");
				String ubicacion = resultadoDepartamento.getString("ubicacion");

				Departamento departamentoAux =  new Departamento(codigo, nombre, ubicacion);
				listaAux.add(departamentoAux);
			}
			return listaAux;
		}
		finally {
			ConfigBD.cerrarConexion(conexion);
		}
	}
	/*Caso 3*/
	public static Departamento consultarPorCodigoDepartamento(int codigo) throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		Departamento depAux = null;
		try {
			conexion = ConfigBD.abrirConexion();
			String sentenciaSQL = "SELECT * FROM departamento WHERE codigo = (?);";
			PreparedStatement sentenciaPreparada= conexion.prepareStatement(sentenciaSQL);
			//que hace esta linea??  le da valor a la interrogacion?
			sentenciaPreparada.setInt(1, codigo);

			ResultSet resultadoDepartamento =  sentenciaPreparada.executeQuery();
			if(resultadoDepartamento.next()) {
				//Si devuelve true, es decir, si hay un registro que coincida con los criterios de búsqueda
				//se crea el objeto con los datosde la bd
				//int codigo2 = resultadoDepartamento.getInt("codigo"); es necesario esto?
				String nombre = resultadoDepartamento.getString("nombre");
				String ubicacion = resultadoDepartamento.getString("nombre");
				depAux= new Departamento(codigo, nombre, ubicacion);
			}
			//es necesario hacer aqui un else null?
		}	
		finally {
			ConfigBD.cerrarConexion(conexion);
		}
		return depAux;
	}
	/*Caso 4*/
	public static boolean actualizarDepPorCodigo(int codigo, String nombre, String ubicacion) throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		try {
			conexion = ConfigBD.abrirConexion();
			String sentenciaSQL = "UPDATE departamento SET nombre = ?, ubicacion = ? WHERE codigo = ?;";
			PreparedStatement sentenciaPreparada= conexion.prepareStatement(sentenciaSQL);
			sentenciaPreparada.setString(1, nombre);
			sentenciaPreparada.setString(2, ubicacion);
			//no entiendo este ultimo setInt que hace? y no entiendo como funcia el orden este de 123
			//el orden es segun la sentencia SQL donde hay ? (huecos vacios)
			sentenciaPreparada.setInt(3, codigo);
			sentenciaPreparada.executeUpdate();
			//esta bien este unico return true?
			return true;
		}
		finally {
			ConfigBD.cerrarConexion(conexion);
		}

	}
	/*Caso 4*/
	public static boolean eliminarDepPorCodigo(int codigo) throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		try {
			conexion = ConfigBD.abrirConexion();
			String sentenciaSQL = "DELETE FROM departamento WHERE codigo = ? ;";
			PreparedStatement sentenciaPreparada= conexion.prepareStatement(sentenciaSQL);
			sentenciaPreparada.setInt(1, codigo);
			sentenciaPreparada.executeUpdate();
			//esta bien este unico return true?
			return true;
		}
		finally {
			ConfigBD.cerrarConexion(conexion);
		}

	}
}
