package AccesoFichero;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Acceso.configBD;
import Modelos.Album;

public class AccesoFicheroAlbum {
	public static final String NOMBRE_FICHERO = "src/FicherosTXT/album.txt";
	public static final String NOMBRE_FICHERO2 = "src/FicherosTXT/importarAlbum.txt";

	/*caso 6:*/
	public static boolean escribirEnFichero(List<Album> listaAux) throws IOException {
		BufferedWriter flujoEscritura = null;
		Boolean booleano= false;
		try {
			flujoEscritura = new BufferedWriter(new FileWriter(NOMBRE_FICHERO));
			for(Album x : listaAux) {
				flujoEscritura.write(x.toStringWithSeparators());
				flujoEscritura.newLine();
			}
			booleano = true;
		}
		finally {
			try {
				if(flujoEscritura != null) {
					flujoEscritura.close();
				}
			}
			catch(IOException ioe){
				System.out.println("Erroral cerrar el fichero: "+ ioe.getMessage());
				ioe.printStackTrace();
			}
		}
		return booleano;
	}
	/*Caso 7: eliminamos primero las canciones ya que son una foreign key de album*/
	public static boolean eliminarCancionAlbumes() throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		boolean booleano = false;
		try {
			conexion = configBD.abrirConexion();
			String sentenciaSQL ="DELETE FROM cancion ";
			PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL);
			sentenciaPreparada.executeUpdate();
			booleano = true;
		}
		finally {
			configBD.cerrarConexion(conexion);
		}
		return booleano;
	}
	/*Ahora borramos todos los albumes para poder insertaren la base dedatos los albumes del fichero*/
	public static int eliminarAlbumes() throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		try {
			conexion = configBD.abrirConexion();
			String sentenciaSQL ="DELETE FROM album ";
			PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL);
			return sentenciaPreparada.executeUpdate();
		}
		finally {
			configBD.cerrarConexion(conexion);
		}
	}
	
	public static List<Album> importarFichero() throws IOException{
		List<Album> listaAux = new ArrayList<>();
		BufferedReader flujoLectura = null;
		try {
			flujoLectura = new BufferedReader(new FileReader(NOMBRE_FICHERO2));
			String linea = flujoLectura.readLine();
			while(linea!= null) {
				Album x = new Album(linea);
				listaAux.add(x);
				linea = flujoLectura.readLine();
			}
		}
		finally {
			try {
				if(flujoLectura != null) {
					flujoLectura.close();
				}
			}
			catch(IOException ioe){
				System.out.println("Erroral cerrar el fichero: "+ ioe.getMessage());
				ioe.printStackTrace();
			}
		}


		return listaAux;
	}
	public static boolean insertarListaEnBaseDatos(List<Album> listaAux) throws SQLException, ClassNotFoundException{
		Connection conexion = null;
		boolean booleano = false;
		try {
			conexion = configBD.abrirConexion();
			for(Album album : listaAux) {
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

		}
		finally {
			configBD.cerrarConexion(conexion);
		}
		return booleano;
	}
}