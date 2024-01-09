package aplicacionGestion.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import aplicacionGestion.config.ConfBD;
import aplicacionGestion.exceptions.NullDepartamentoException;
import aplicacionGestion.modelo.Departamento;

public class AccesoDepartamento {
	/**
	 * Metodo que obtiene un Departamento y lo inserta en la tabla departamento de la base de datos
	 * @param departamento
	 * @return
	 */
	public static boolean insertarDepartamento(Departamento departamento) {
		Connection conexion = null;		
		int columnasInsertadas = 0;
		
		try {
			conexion = ConfBD.abrirConexion();
			
			String sentenciaInsertarDept = "INSERT INTO departamento(nombre, ubicacion) VALUES(?,?);";
			PreparedStatement sentencia = conexion.prepareStatement(sentenciaInsertarDept);
			
			String nombre = departamento.getNombre();
			String ubicacion = departamento.getUbicacion();
			sentencia.setString(1, nombre);
			sentencia.setString(2, ubicacion);
			
			columnasInsertadas = sentencia.executeUpdate();
			
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		finally {
			ConfBD.cerrarConexion(conexion);
		}
		
		return columnasInsertadas>0;
	}
	
	/**
	 * 
	 * @return
	 */
	public static ArrayList<Departamento> consultarDepartamentos() {
		Connection conexion = null;
		ArrayList<Departamento> consulta = new ArrayList<Departamento>();
		try {
			conexion = ConfBD.abrirConexion();
			String sentenciaConsulta = "SELECT * FROM departamento";
			PreparedStatement sentencia = conexion.prepareStatement(sentenciaConsulta);
			ResultSet resultadoDepartamentos = sentencia.executeQuery();
			while (resultadoDepartamentos.next()) {
				int codigo = resultadoDepartamentos.getInt("codigo");
				String nombre = resultadoDepartamentos.getString("nombre");
				String ubicacion = resultadoDepartamentos.getString("ubicacion");
				Departamento d = new Departamento(codigo, nombre, ubicacion);
				
				consulta.add(d);
			}
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		finally {
			ConfBD.cerrarConexion(conexion);
		}
		return consulta;
	}
	public static Departamento buscarDepartamento(int codigoDepartamento) {
		Connection conexion = null;
		Departamento d = null;
		try {
			conexion = ConfBD.abrirConexion();
			String sentenciaConsulta = "SELECT * FROM departamento WHERE codigo = (?);";
			PreparedStatement sentencia = conexion.prepareStatement(sentenciaConsulta);
			sentencia.setInt(1, codigoDepartamento);
			
			ResultSet resultadoDepartamento = sentencia.executeQuery();
			
			//No utilizo while ya que solo me puede dar un unico departamento al ser el codigo una clave unica
			if (resultadoDepartamento.next()) {
				//Si devuelve true, es decir, si hay un registro que coincida con los criterios de búsqueda
				//se crea el objeto con los datosde la bd
				//int codigo = resultadoDepartamento.getInt("codigo");
				String nombre = resultadoDepartamento.getString("nombre");
				String ubicacion = resultadoDepartamento.getString("ubicacion");
					
				d = new Departamento(codigoDepartamento, nombre, ubicacion);
			}
			else {
				//Sino devolverá d como null
				d = null;
			}
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		finally {
			ConfBD.cerrarConexion(conexion);
		}
		return d;
	}
	
	public static boolean actualizarDepartamento(int codigo, String nombre, String ubicacion) {
		int filasActualizadas = 0;
		//Si devuelve null querrá decir que el codigo introducido no corresponde con ningun departamento
		//por lo que devolverá false
		if (buscarDepartamento(codigo) == null) {
			return false;
		}
		else {
			//Sino se conectará y buscará el departamento al cual corresponde el codigo y lo actualizará
			Connection conexion = null;
			
			try {
				conexion = ConfBD.abrirConexion();
				String sentenciaActualizar = "UPDATE departamento SET nombre = ?, ubicacion = ? WHERE codigo = ?;";
				PreparedStatement sentencia = conexion.prepareStatement(sentenciaActualizar);
				sentencia.setString(1, nombre);
				sentencia.setString(2, ubicacion);
				sentencia.setInt(3, codigo);
				
				filasActualizadas = sentencia.executeUpdate(); 
			}
			catch (SQLException sqle) {
				sqle.printStackTrace();
			}
			finally {
				ConfBD.cerrarConexion(conexion);
			}
		}
		return filasActualizadas > 0;
	}
	public static void eliminarDepartamento(int codigo) throws SQLException, NullDepartamentoException{ //TODO crear exceptions para codigoNoEncontrado y departamentoAsociadoAEmpleado
		//Si devuelve null querrá decir que el codigo introducido no corresponde con ningun departamento
		//por lo que devolverá false
		if (buscarDepartamento(codigo) == null) throw new NullDepartamentoException("No existe ningún departamento con ese codigo");
		
		else {
			//Sino se conectará y buscará el departamento al cual corresponde el codigo y lo actualizará
			Connection conexion = null;
			try {
				conexion = ConfBD.abrirConexion();
				String sentenciaActualizar = "DELETE FROM departamento WHERE codigo = ?;";
				PreparedStatement sentencia = conexion.prepareStatement(sentenciaActualizar);
				sentencia.setInt(1, codigo);
				sentencia.executeUpdate();
			}
			finally {
				ConfBD.cerrarConexion(conexion);
			}
		}
	}
}
