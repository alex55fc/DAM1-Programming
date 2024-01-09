package Acceso;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import Modelos.MultiTablaAlbum;

public class ConsultasMultiTabla {
    
    public static List<MultiTablaAlbum> consultaMultiTabla() throws ClassNotFoundException, SQLException {
        Connection conexion = null;
        List<MultiTablaAlbum> listaMultiTabla = new LinkedList<>();
        MultiTablaAlbum multiTablaCancion = null;

        try{	
        	conexion = configBD.abrirConexion();
            String sentenciaSQL = "SELECT a.titulo as Album, a.año_publicacion as Fecha_Album, c.titulo as Cancion, c.duracion as Duracion_Cancion " +
                                                "FROM album a " +
                                                "JOIN cancion c ON a.codigo = c.codigo_album " +
                                                "ORDER BY a.año_publicacion asc";
			PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL);
			ResultSet resultadoAlbum = sentenciaPreparada.executeQuery();

            while (resultadoAlbum.next()){
                String tituloAlbum = resultadoAlbum.getString("Album");
                int anioPublicacionAlbum = resultadoAlbum.getInt("Fecha_Album");
                String tituloCancion = resultadoAlbum.getString("Cancion");
                String duracionCancion = resultadoAlbum.getString("Duracion_Cancion");
                multiTablaCancion = new MultiTablaAlbum(tituloAlbum, anioPublicacionAlbum, tituloCancion, duracionCancion);
                listaMultiTabla.add(multiTablaCancion);
            }
            return listaMultiTabla;
        }
        finally {
            configBD.cerrarConexion(conexion);
        }
    } 
}
