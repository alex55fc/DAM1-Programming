package Acceso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modelos.Album;
import Modelos.Banda;
import Modelos.Musico;

public class AccesoAlbum {
	/*clave ajena banda*/
	public static boolean claveAjenaBanda(int codigo) throws ClassNotFoundException, SQLException{
		Connection conexion = null;
		try {
			conexion = configBD.abrirConexion();
			String sentenciaSQL = "SELECT * FROM banda WHERE codigo = (?) ";
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
			configBD.cerrarConexion(conexion);
		}
	}
	public static boolean claveAjenaMusico(int codigo) throws ClassNotFoundException, SQLException{
		Connection conexion = null;
		try {
			conexion = configBD.abrirConexion();
			String sentenciaSQL = "SELECT * FROM musico WHERE codigo = (?) ";
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
			configBD.cerrarConexion(conexion);
		}
	}
	public static boolean albumCodigo(int codigo) throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		try {
			conexion = configBD.abrirConexion();
			String sentenciaSQL = "SELECT * FROM album WHERE codigo = (?) ";
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
			configBD.cerrarConexion(conexion);
		}
	}

	/*Caso 1: Insertar una fila en la tabla.*/
	public static boolean insertarAlbum(Album album) throws SQLException, ClassNotFoundException {
		Connection conexion = null;
		boolean booleano = false;
		try {
			conexion = configBD.abrirConexion();
			if(album.getAutor().equalsIgnoreCase("banda")) {
				String sentenciaSQL ="INSERT INTO album (autor, titulo, año_publicacion, tipo, duracion, codigo_banda) "
						+"VALUES (?, ?, ?, ?, ? , ?)";
				PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL);
				sentenciaPreparada.setString(1, album.getAutor());
				sentenciaPreparada.setString(2,album.getTitulo());
				sentenciaPreparada.setInt(3, album.getAnioPublicacion());
				sentenciaPreparada.setString(4,album.getTipo());
				sentenciaPreparada.setString(5,album.getDuracion());
				sentenciaPreparada.setInt(6, album.getBanda().getCodigo());

				sentenciaPreparada.executeUpdate();
				booleano = true;
			}
			else {

				String sentenciaSQL ="INSERT INTO album (autor, titulo, año_publicacion, tipo, duracion ,codigo_banda, codigo_musico) "
						+"VALUES (?, ?, ?, ?, ? , null, ?)";
				PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL);
				sentenciaPreparada.setString(1, album.getAutor());
				sentenciaPreparada.setString(2,album.getTitulo());
				sentenciaPreparada.setInt(3, album.getAnioPublicacion());
				sentenciaPreparada.setString(4,album.getTipo());
				sentenciaPreparada.setString(5,album.getDuracion());
				sentenciaPreparada.setInt(6, album.getMusico().getCodigo());

				sentenciaPreparada.executeUpdate();
				booleano =  true;
			}
		}
		finally {
			configBD.cerrarConexion(conexion);
		}
		return booleano;
	}
	/*Caso 2:  Hacer dos metodos uno elimina todas las canciones con el codigo album que le pasemos y LUEGO borra el album*/
	/*Este metodo se encarga de borrar todas las canciones deun album que pasamos con codigo, como un album puede no tener canciones
	 * uso un booleano para que me muestre que ejecuta la sentencia*/
	public static boolean eliminarCancionAlbum(int codigo) throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		boolean booleano = false;
		try {
			conexion = configBD.abrirConexion();
			String sentenciaSQL ="DELETE FROM cancion WHERE codigo_album = ?";
			PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL);
			sentenciaPreparada.setInt(1, codigo);
			sentenciaPreparada.executeUpdate();
			booleano = true;
		}
		finally {
			configBD.cerrarConexion(conexion);
		}
		return booleano;
	}
	public static int eliminarAlbum(int codigo) throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		try {
			conexion = configBD.abrirConexion();
			String sentenciaSQL ="DELETE FROM album WHERE codigo = ?";
			PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL);
			sentenciaPreparada.setInt(1, codigo);
			return sentenciaPreparada.executeUpdate();
		}
		finally {
			configBD.cerrarConexion(conexion);
		}
	}
	/*Caso 3*/
	public static int actualizarAlbum(Album album) throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		try {
			conexion = configBD.abrirConexion();
			if(album.getAutor().equalsIgnoreCase("banda")) {
				String sentenciaSQL ="UPDATE album SET autor = ?, titulo = ?, año_publicacion = ?, "
						+ " tipo = ?, duracion = ?, codigo_banda = ?, codigo_musico = null WHERE codigo = ?";
				PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL);
				sentenciaPreparada.setString(1, album.getAutor());	
				sentenciaPreparada.setString(2, album.getTitulo());
				sentenciaPreparada.setInt(3, album.getAnioPublicacion());
				sentenciaPreparada.setString(4, album.getTipo());
				sentenciaPreparada.setString(5, album.getDuracion());
				sentenciaPreparada.setInt(6, album.getBanda().getCodigo());
				sentenciaPreparada.setInt(7, album.getCodigo());
				return sentenciaPreparada.executeUpdate();
			}
			else {
				String sentenciaSQL ="UPDATE album SET autor = ?, titulo = ?, año_publicacion = ?, "
						+ " tipo = ?, duracion = ?, codigo_banda = null, codigo_musico = ? WHERE codigo = ?";
				PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL);
				sentenciaPreparada.setString(1, album.getAutor());	
				sentenciaPreparada.setString(2, album.getTitulo());
				sentenciaPreparada.setInt(3, album.getAnioPublicacion());
				sentenciaPreparada.setString(4, album.getTipo());
				sentenciaPreparada.setString(5, album.getDuracion());
				sentenciaPreparada.setInt(6, album.getMusico().getCodigo());
				sentenciaPreparada.setInt(7, album.getCodigo());

				return sentenciaPreparada.executeUpdate();
			}
		}
		finally {
			configBD.cerrarConexion(conexion);
		}
	}
	/*Caso 4*/
	public static Album consultarFila(int codigo) throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		Album albumAux = null;
		Banda bandaAux;
		Musico musicoAux;
		try {
			conexion = configBD.abrirConexion();
			String sentenciaSQL= "SELECT a.codigo, a.autor, a.titulo, a.año_publicacion, a.tipo, a.duracion, "
					+ "       m.codigo AS codigo_musico, m.nombre AS nombre_musico, m.fecha_nacimiento, m.lugar_residencia, m.nacionalidad, m.instrumento, "
					+ "       b.codigo AS codigo_banda, b.nombre AS nombre_banda, b.años_actuacion, b.lugar_origen, b.genero "
					+ " FROM album a"
					+ " LEFT JOIN musico m ON a.codigo_musico = m.codigo "
					+ " LEFT JOIN banda b ON a.codigo_banda = b.codigo"
					+ "	WHERE a.codigo = ?;";


			PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL);
			sentenciaPreparada.setInt(1, codigo);

			ResultSet resultadoAlbum = sentenciaPreparada.executeQuery();

			while(resultadoAlbum.next()) {
				String autor = resultadoAlbum.getString("autor");
				String titulo = resultadoAlbum.getString("titulo");
				int anioPublicacion = resultadoAlbum.getInt("año_publicacion");
				String tipo = resultadoAlbum.getString("tipo");
				String duracion = resultadoAlbum.getString("duracion");
				int codigoBanda = resultadoAlbum.getInt("codigo_banda");
				String nombreBanda = resultadoAlbum.getString("nombre_banda");
				int codigoMusico = resultadoAlbum.getInt("codigo_musico");
				String nombreMusico = resultadoAlbum.getString("nombre_musico");
				bandaAux = new Banda(codigoBanda, nombreBanda);
				musicoAux = new Musico(codigoMusico, nombreMusico);
				albumAux = new Album(codigo,autor,titulo,anioPublicacion, tipo, duracion, bandaAux, musicoAux);


			}
		}
		finally{
			configBD.cerrarConexion(conexion);

		}
		return albumAux;
	}
	/*caso para elegir entre los albumes*/
	public static List<Album> consultarTodosAlbumes() throws ClassNotFoundException, SQLException{
		Connection conexion = null;
		List<Album> listaAux = new ArrayList<>();
		Album albumAux;
		Banda bandaAux;
		Musico musicoAux;
		try {
			conexion = configBD.abrirConexion();
			String sentenciaSQL= "SELECT a.codigo, a.autor, a.titulo, a.año_publicacion, a.tipo, a.duracion, "
					+ "       m.codigo AS codigo_musico, m.nombre AS nombre_musico, m.fecha_nacimiento, m.lugar_residencia, m.nacionalidad, m.instrumento, "
					+ "       b.codigo AS codigo_banda, b.nombre AS nombre_banda, b.años_actuacion, b.lugar_origen, b.genero "
					+ " FROM album a"
					+ " LEFT JOIN musico m ON a.codigo_musico = m.codigo "
					+ " LEFT JOIN banda b ON a.codigo_banda = b.codigo;";
			PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL);
			ResultSet resultadoAlbum = sentenciaPreparada.executeQuery();

			while(resultadoAlbum.next()) {
				int codigo = resultadoAlbum.getInt("codigo");
				String autor = resultadoAlbum.getString("autor");
				String titulo = resultadoAlbum.getString("titulo");
				int anioPublicacion = resultadoAlbum.getInt("año_publicacion");
				String tipo = resultadoAlbum.getString("tipo");
				String duracion = resultadoAlbum.getString("duracion");
				int codigoBanda = resultadoAlbum.getInt("codigo_banda");
				String nombreBanda = resultadoAlbum.getString("nombre_banda");
				int codigoMusico = resultadoAlbum.getInt("codigo_musico");
				String nombreMusico = resultadoAlbum.getString("nombre_musico");

				bandaAux = new Banda(codigoBanda, nombreBanda);
				musicoAux = new Musico(codigoMusico, nombreMusico);
				albumAux = new Album(codigo,autor,titulo,anioPublicacion, tipo, duracion, bandaAux, musicoAux);
				listaAux.add(albumAux);
			}
		}
		finally {
			configBD.cerrarConexion(conexion);
		}
		return listaAux;
	}
	/*Caso 5*/
	public static List<Album> consultarTodosAlbumesOrdenados() throws ClassNotFoundException, SQLException{
		Connection conexion = null;
		List<Album> listaAux = new ArrayList<>();
		Album albumAux;
		Banda bandaAux;
		Musico musicoAux;
		try {
			conexion = configBD.abrirConexion();
			String sentenciaSQL= "SELECT a.codigo, a.autor, a.titulo, a.año_publicacion, a.tipo, a.duracion, "
					+ "       m.codigo AS codigo_musico, m.nombre AS nombre_musico, m.fecha_nacimiento, m.lugar_residencia, m.nacionalidad, m.instrumento, "
					+ "       b.codigo AS codigo_banda, b.nombre AS nombre_banda, b.años_actuacion, b.lugar_origen, b.genero "
					+ " FROM album a"
					+ " LEFT JOIN musico m ON a.codigo_musico = m.codigo "
					+ " LEFT JOIN banda b ON a.codigo_banda = b.codigo"
					+ " ORDER BY titulo desc;";
			PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL);
			ResultSet resultadoAlbum = sentenciaPreparada.executeQuery();

			while(resultadoAlbum.next()) {
				int codigo = resultadoAlbum.getInt("codigo");
				String autor = resultadoAlbum.getString("autor");
				String titulo = resultadoAlbum.getString("titulo");
				int anioPublicacion = resultadoAlbum.getInt("año_publicacion");
				String tipo = resultadoAlbum.getString("tipo");
				String duracion = resultadoAlbum.getString("duracion");
				int codigoBanda = resultadoAlbum.getInt("codigo_banda");
				String nombreBanda = resultadoAlbum.getString("nombre_banda");

				int codigoMusico = resultadoAlbum.getInt("codigo_musico");
				String nombreMusico = resultadoAlbum.getString("nombre_musico");

				bandaAux = new Banda(codigoBanda, nombreBanda);
				musicoAux = new Musico(codigoMusico, nombreMusico);
				albumAux = new Album(codigo,autor,titulo,anioPublicacion, tipo, duracion, bandaAux, musicoAux);
				listaAux.add(albumAux);
			}
		}
		finally {
			configBD.cerrarConexion(conexion);
		}
		return listaAux;
	}

}
