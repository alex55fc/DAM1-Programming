package Ejemp1_archivos;

import java.io.File;
import java.io.IOException;

public class CrearDirectorioConFicheros {
	
	public static void main(String[] args) {
		File directorio = new File("DIR");
		File fichero1 = new File(directorio, "FICH1.TXT");
		File fichero2 = new File(directorio, "FICH2.TXT");
		File ficheroRenombrado = new File(directorio, "FICHRENOMBRADO.TXT");
		try { 
			// Crear directorio DIR
			if (directorio.mkdir()) {
				System.out.println("Directorio DIR creado con �xito.");
			}
			else {
				System.out.println("No se ha podido crear directorio DIR.");
			}
			// Crear fichero FICH1.TXT
			if (fichero1.createNewFile()) {
				System.out.println("Fichero FICH1.TXT creado con �xito.");
			}
			else {
				System.out.println("No se ha podido crear fichero FICH1.TXT");
			}
			// Crear fichero FICH2.TXT
			if (fichero2.createNewFile()) {
				System.out.println("Fichero FICH2.TXT creado con �xito.");
			}
			else {
				System.out.println("No se ha podido crear fichero FICH2.TXT");
			}
			// Renombrar fichero FICH1.TXT por FICHRENOMBRADO.TXT
			if (fichero1.renameTo(ficheroRenombrado)) {
				System.out.println("Fichero FICH1.TXT renombrado con �xito.");
			}
			else {
				System.out.println("No se ha podido renombrar fichero FICH1.TXT");
			}
			// Eliminar fichero FICH2.TXT
			if (fichero2.delete()) {
				System.out.println("Fichero FICH2.TXT eliminado con �xito.");
			}
			else {
				System.out.println("No se ha podido eliminar fichero FICH2.TXT");
			}
		} 
		catch (IOException ioe) {
			System.out.println("Error de entrada/salida: " + ioe.toString());
			ioe.printStackTrace();
		}  
	}
	
}
