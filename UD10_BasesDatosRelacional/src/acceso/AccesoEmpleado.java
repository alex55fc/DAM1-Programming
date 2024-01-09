package acceso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Departamento;
import modelo.Empleado;

public class AccesoEmpleado {
	/*Comprobacion de clave ajena*/
	public static boolean claveAjenaDepartamento(int codigo) throws ClassNotFoundException, SQLException{
		Connection conexion = null;
		try {
			conexion= ConfigBD.abrirConexion();
			String sentenciaSQL = "SELECT * FROM departamento WHERE codigo = (?) ";
			PreparedStatement sentenciaPreparada= conexion.prepareStatement(sentenciaSQL);
			sentenciaPreparada.setInt(1, codigo);
			ResultSet resultadoDepartamento =  sentenciaPreparada.executeQuery();

			if(resultadoDepartamento.next()){
				return true;
			}
			else {
				return false;
			}
		}
		finally {
			ConfigBD.cerrarConexion(conexion);
		}
	}

	/*caso 1: insertar empleado*/
	public static boolean insertarEmpleado(Empleado empleado) throws ClassNotFoundException, SQLException {
		Connection conexion= null;
		try {
			conexion = ConfigBD.abrirConexion();
			String sentenciaSQL = "INSERT INTO empleado (nombre, fecha_alta, salario, codigo_departamento)"+
					" VALUES (?, ?, ?, ?)";
			PreparedStatement sentenciaPreparada= conexion.prepareStatement(sentenciaSQL);
			sentenciaPreparada.setString(1, empleado.getNombre());
			sentenciaPreparada.setString(2, empleado.getFechAlta());
			sentenciaPreparada.setDouble(3, empleado.getSalario());
			sentenciaPreparada.setInt(4, empleado.getDepartamento().getCodigo());

			sentenciaPreparada.executeUpdate();
		}
		finally {
			ConfigBD.cerrarConexion(conexion);
		}
		return true;
	}
	/*Caso 2:consultar todos los empleados */

	public static List<Empleado> consultarEmpleados() throws ClassNotFoundException, SQLException{
		Connection conexion = null;
		List<Empleado> listaAux = new ArrayList<>();
		Empleado empleAux;
		Departamento depAux;
		try {
			conexion = ConfigBD.abrirConexion();
			String sentenciaSQL= "SELECT e.codigo AS codigoEmpleado, e.nombre AS nombreEmpleado, fecha_alta, salario, "+
					"d.codigo AS codigoDepartamento, d.nombre AS nombreDepartamento, ubicacion "+	
					"FROM empleado e JOIN departamento d "+
					"ON e.codigo_departamento = d.codigo;";
			PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL);
			ResultSet resultadoEmpleado = sentenciaPreparada.executeQuery();

			while(resultadoEmpleado.next()) {
				int codigo = resultadoEmpleado.getInt("codigoEmpleado");
				String nombre = resultadoEmpleado.getString("nombreEmpleado");
				String fechaAlta = resultadoEmpleado.getString("fecha_alta");
				double salario = resultadoEmpleado.getDouble("salario");

				int codigoDepartamento = resultadoEmpleado.getInt("codigoDepartamento");
				String nombreDepartamento = resultadoEmpleado.getString("nombreDepartamento");
				String ubicacion = resultadoEmpleado.getString("ubicacion");

				depAux = new Departamento(codigoDepartamento, nombreDepartamento, ubicacion);
				empleAux = new Empleado(codigo, nombre, fechaAlta, salario, depAux);
				listaAux.add(empleAux);
			}
		}
		finally {
			ConfigBD.cerrarConexion(conexion);
		}
		return listaAux;
	}
	/*Caso 3*/
	public static Empleado buscarEmpleado(int codigo) throws ClassNotFoundException, SQLException {
		Connection conexion= null;
		Departamento depAux;
		Empleado empleAux = null;
		try {
			conexion = ConfigBD.abrirConexion();
			String sentenciaSQL = "SELECT e.codigo AS codigoEmpleado, e.nombre AS nombreEmpleado, fecha_alta, salario, "+
					"d.codigo AS codigoDepartamento, d.nombre AS nombreDepartamento, ubicacion "+	
					"FROM empleado e JOIN departamento d "+
					"ON e.codigo_departamento = d.codigo WHERE e.codigo = ?;";
			PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL);
			sentenciaPreparada.setInt(1, codigo);
			ResultSet resultadoEmpleado = sentenciaPreparada.executeQuery();
			if(resultadoEmpleado.next()) {
				String nombre = resultadoEmpleado.getString("nombreEmpleado");
				String fechaAlta = resultadoEmpleado.getString("fecha_alta");
				double salario = resultadoEmpleado.getDouble("salario");

				int codigoDepartamento = resultadoEmpleado.getInt("codigoDepartamento");
				String nombreDepartamento = resultadoEmpleado.getString("nombreDepartamento");
				String ubicacion = resultadoEmpleado.getString("ubicacion");

				depAux = new Departamento(codigoDepartamento, nombreDepartamento, ubicacion);
				empleAux = new Empleado(codigo, nombre, fechaAlta, salario, depAux);
			}
		}
		finally {
			ConfigBD.cerrarConexion(conexion);
		}
		return  empleAux;
	}
	/*Caso 4*/
	public static boolean actualizarEmpleado(Empleado empleAux) throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		try {
			conexion = ConfigBD.abrirConexion();
			String sentenciaSQL = "UPDATE empleado "
					+ "SET nombre = ?, fecha_alta = ?, salario = ?, "
					+ "codigo_departamento = ? WHERE codigo = ?";
			PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL);
			sentenciaPreparada.setString(1, empleAux.getNombre());
			sentenciaPreparada.setString(2,empleAux.getFechAlta() );
			sentenciaPreparada.setDouble(3, empleAux.getSalario());
			sentenciaPreparada.setInt(4, empleAux.getDepartamento().getCodigo());
			sentenciaPreparada.setInt(5, empleAux.getCodigo());
			
			sentenciaPreparada.executeUpdate();
			return true;
		}
		finally {
			ConfigBD.cerrarConexion(conexion);
		}
	}
	/*Caso 5*/
	public static boolean eliminarEmpleado(int codigo) throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		try {
			conexion = ConfigBD.abrirConexion();
			String sentenciaSQL ="DELETE FROM empleado WHERE codigo = ?";
			PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL);
			sentenciaPreparada.setInt(1, codigo);
			sentenciaPreparada.executeUpdate();
			return true;
		}
		finally {
			ConfigBD.cerrarConexion(conexion);
		}
	}
}
