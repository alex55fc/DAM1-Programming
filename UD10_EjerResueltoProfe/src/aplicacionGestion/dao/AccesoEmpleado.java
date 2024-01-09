package aplicacionGestion.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import aplicacionGestion.config.ConfBD;
import aplicacionGestion.modelo.Departamento;
import aplicacionGestion.modelo.Empleado;

public class AccesoEmpleado {
	
	/**
	 * Metodo que inserta un empleado en la base de datos
	 * @param empleado
	 * @return
	 */
	public static boolean insertarEmpleado(Empleado empleado) {
		Connection conexion = null;
		int filasInsertadas = 0;
		boolean encontrado = false;
		try {
			//Abrir conexion a la base de datos
			conexion = ConfBD.abrirConexion();
			String nombre = empleado.getNombre();
			String fechaAlta = empleado.getFechaAlta();
			double salario = empleado.getSalario();
			int codigoDepartamento = empleado.getDepartamento().getCodigo();			
			
			String sentenciaInsertar = "INSERT INTO empleado(nombre, fecha_alta, salario, codigo_departamento) VALUES (?,?,?,?)";
			PreparedStatement sentencia = conexion.prepareStatement(sentenciaInsertar);
			
			//Asignamos cada valor
			sentencia.setString(1, nombre);
			sentencia.setString(2, fechaAlta);
			sentencia.setDouble(3, salario);
			sentencia.setInt(4, codigoDepartamento);
				
			//Ejecutamos la sentencia
			filasInsertadas = sentencia.executeUpdate();
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		finally {
			ConfBD.cerrarConexion(conexion);
		}
		return filasInsertadas > 0;
	}
	
	/**
	 * Metodo que devuelve un ArrayList con todos los empleados de la base de datos
	 * @return
	 */
	public static ArrayList<Empleado> consultarEmpleados() {
		ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();
		Connection conexion = null;
		Empleado empleado = null;
		
		try {
			conexion = ConfBD.abrirConexion();
			
			String sentenciaBuscarEmpleado = "SELECT e.codigo AS codigoEmpleado, e.nombre AS nombreEmpleado, fecha_alta, salario, "+
			"d.codigo AS codigoDepartamento, d.nombre AS nombreDepartamento, ubicacion "+	
			"FROM empleado e JOIN departamento d "+
			"ON e.codigo_departamento = d.codigo;";
			
			PreparedStatement sentencia = conexion.prepareStatement(sentenciaBuscarEmpleado);
			
			ResultSet consulta = sentencia.executeQuery();
			
			while (consulta.next()) {
				int codigo = consulta.getInt("codigoEmpleado");
				String nombre = consulta.getString("nombreEmpleado");
				String fechaAlta = consulta.getString("fecha_alta");
				double salario = consulta.getDouble("salario");
				
				int codigoDepartamento = consulta.getInt("codigoDepartamento");
				String nombreDepartamento = consulta.getString("nombreDepartamento");
				String ubicacion = consulta.getString("ubicacion");
				
				Departamento departamento = new Departamento(codigoDepartamento, nombreDepartamento, ubicacion);
				empleado = new Empleado(codigo, nombre, fechaAlta, salario, departamento);
				
				listaEmpleados.add(empleado);
			}
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		finally {
			ConfBD.cerrarConexion(conexion);
		}
		return listaEmpleados;
	}
	
	/**
	 * Metodo que obtiene un codigo y busca al empleado en la base de datos con ese codigo
	 * @param codigo
	 * @return
	 */
	public static Empleado buscarEmpleado(int codigo) { //TODO
		Connection conexion = null;
		Empleado empleado = null;
		
		try {
			conexion = ConfBD.abrirConexion();
			
			String sentenciaBuscarEmpleado = "SELECT e.nombre AS nombreEmpleado, fecha_alta, salario, "+
			"d.codigo AS codigoDepartamento, d.nombre AS nombreDepartamento, ubicacion "+	
			"FROM empleado e JOIN departamento d "+
			"ON e.codigo_departamento = d.codigo " +
			"WHERE e.codigo = ?;";
			
			PreparedStatement sentencia = conexion.prepareStatement(sentenciaBuscarEmpleado);
			sentencia.setInt(1, codigo);
			ResultSet consulta = sentencia.executeQuery();
			
			if (consulta.next()) {
				String nombre = consulta.getString("nombreEmpleado");
				String fechaAlta = consulta.getString("fecha_alta");
				double salario = consulta.getDouble("salario");
				
				int codigoDepartamento = consulta.getInt("codigoDepartamento");
				String nombreDepartamento = consulta.getString("nombreDepartamento");
				String ubicacion = consulta.getString("ubicacion");
				
				Departamento departamento = new Departamento(codigoDepartamento, nombreDepartamento, ubicacion);
				empleado = new Empleado(codigo, nombre, fechaAlta, salario, departamento);
			}
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		finally {
			ConfBD.cerrarConexion(conexion);
		}
		return empleado;
	}
	//TODO
	public static boolean actualizarEmpleado(Empleado empleado) {
		Connection conexion = null;
		int filaActualizada = 0;
		try {
			conexion = ConfBD.abrirConexion();
			
			int codigo = empleado.getCodigo();
			String nombre = empleado.getNombre();
			String fechaAlta = empleado.getFechaAlta();
			double salario = empleado.getSalario();
			Departamento departamento = empleado.getDepartamento();
			int codigoDepartamento = departamento.getCodigo();
			
			String sentenciaUpdate = "UPDATE empleado SET nombre = ?, fecha_alta = ?, salario = ?, codigo_departamento = ? WHERE codigo = ?";
			PreparedStatement sentencia = conexion.prepareStatement(sentenciaUpdate);
			
			sentencia.setString(1, nombre);
			sentencia.setString(2, fechaAlta);
			sentencia.setDouble(3, salario);
			sentencia.setInt(4, codigoDepartamento);
			sentencia.setInt(5, codigo);
			
			filaActualizada = sentencia.executeUpdate();
			
		}
		catch(SQLException sqle) {
			sqle.printStackTrace();
		}
		finally {
			ConfBD.cerrarConexion(conexion);
		}
		return filaActualizada > 0;
	}
	//TODO
	public static boolean eliminarEmpleado(int codigo) {
		Connection conexion = null;
		int filaEliminada = 0;
		
		try {
			conexion = ConfBD.abrirConexion();
			
			String sentenciaEliminar = "DELETE FROM empleado WHERE codigo = ?";
			PreparedStatement sentencia = conexion.prepareStatement(sentenciaEliminar);
			
			sentencia.setInt(1, codigo);
			
			filaEliminada = sentencia.executeUpdate();
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		finally {
			ConfBD.cerrarConexion(conexion);
		}
		return filaEliminada > 0;
	}
	
}
