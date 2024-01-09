package acceso;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Departamento;
import modelo.Empleado;

public class AccesoDepartamento {

	//inserta un departamento en la base de datos 
	//devuleve el numero de departamentos insertados 
	public static int insertar (Departamento departamento) throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		try {
			conexion = ConfigBD.abrirConexion();
			String sentenciaSQL = "INSERT INTO departamento "+ 
					"(nombre, ubicacion) "+ 
					"VALUES ('"+ departamento.getNombre()+
					"', '"+ departamento.getUbicacion() + "';";
			Statement sentencia = conexion.createStatement();
			int filasInsertadas = sentencia.executeUpdate(sentenciaSQL);
			return filasInsertadas;
		}
		finally {
			ConfigBD.cerrarConexion(conexion);
		}
	}

	/*//consulta todos los departamento de la base de datos
	public static List<Departamento> consultarTodos(){
		Connection conexion = null;
		try {
			conexion = ConfigBD.abrirConexion();

		}
	}*/
	//caso 3
	public static Departamento consultar(int codigo) throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		try {
			conexion = ConfigBD.abrirConexion();
			String sentenciaSQL = "SELECT * FROM departamento " +
					"WHERE codigo = "+ codigo; //no hace falta las comillas por  q alser varchar ya ve implicito
			Statement sentencia = conexion.createStatement();
			ResultSet resultado = sentencia.executeQuery(sentenciaSQL);
			Departamento departamento = null;
			if(resultado.next()) {
				codigo = resultado.getInt("codigo ");
				String nombre = resultado.getString("codigo ");
				String ubicacion = resultado.getString("ubicacion ");
				departamento = new Departamento(codigo, nombre, ubicacion);
			}
			return departamento;
		}
		finally {
			ConfigBD.cerrarConexion(conexion);
		}
	}
	//caso 4
	public static int actualizar (int codigo , Departamento nuevoDepartamento) 
			throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		try {
			conexion = ConfigBD.abrirConexion();
			String sentenciaSQL = "UPDATE departamento " +
					"SET nombre = '"+  nuevoDepartamento.getNombre()+
					"' , ubicacion = ' "+ nuevoDepartamento.getUbicacion() + 
					"' WHERE codigo = " + codigo;
			Statement sentencia = conexion.createStatement();
			int filasActualizadas = sentencia.executeUpdate(sentenciaSQL);
			return filasActualizadas;
		}
		finally {
			ConfigBD.cerrarConexion(conexion);

		}
	}

	//caso 5
	public static int eliminar(int codigo)
			throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		try {
			conexion = ConfigBD.abrirConexion();
			String sentenciaSQL = "DELETE FROM departamento " +
					"WHERE codigo = "+ codigo ;
			Statement sentencia = conexion.createStatement();
			int filasEliminadas = sentencia.executeUpdate(sentenciaSQL);
			return filasEliminadas;

		}
		finally {
			ConfigBD.cerrarConexion(conexion);

		}
	}
	//caso 5 
	public static List<Empleado> consultarPorDepartamento(int codigoDepartamento) throws SQLException{
		Connection conexion = null;
		try {
			String sentenciaSQL ="SELECT * FROM empleado "+ 
								"WHERE codigo_departamento = "+ codigoDepartamento;
			Statement sentencia = conexion.createStatement();
			ResultSet resultados = sentencia.executeQuery(sentenciaSQL);
			List<Empleado> listaEmpleados = new ArrayList<Empleado>();
			while(resultados.next()) {
				int codigo = resultados.getInt("codigo" );
				String nombre = resultados.getString("nombre");
				String fechaAlta = resultados.getString("fecha_alta");
				double salario = resultados.getDouble("salario");
				codigoDepartamento = resultados.getInt("codigo_departamento");
				Empleado empleado = new Empleado(codigo, nombre, fechaAlta, salario, codigoDepartamento);
				listaEmpleados.add(empleado);
			}
			return listaEmpleados;
		}
		finally{
			ConfigBD.cerrarConexion(conexion);

		}
	}
}


