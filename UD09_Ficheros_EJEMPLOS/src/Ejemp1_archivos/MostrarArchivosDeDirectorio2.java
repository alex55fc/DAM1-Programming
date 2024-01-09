package Ejemp1_archivos;

import java.io.File;
import entrada.Teclado;

public class MostrarArchivosDeDirectorio2 {
	
	public static void main(String[] args) {
		String nombreDirectorio = Teclado.leerCadena("�Nombre del Directorio? ");
		File directorio = new File(nombreDirectorio);
		if (directorio.exists()) {
			if (directorio.isDirectory()) {
				//obtengo los objetos del directorio
				File[] vectorArchivos = directorio.listFiles();	
				// directorio.list() saca los nombre de todos los ficheros y directorios del directorio que le pasamos por teclado
				//y al igualarlo a un vector de file obtengo los datos de lo que esta dentro del directorio
				System.out.println("El directorio \'" + nombreDirectorio + 
		                           "\' tiene " + vectorArchivos.length + " archivos.");
				for (int posicion = 0 ; posicion < vectorArchivos.length ; posicion++) {
					File archivo = vectorArchivos[posicion];
					System.out.printf("Nombre: %s, �Es Fichero? = %b, �Es Directorio? = %b \n", 
					                  archivo.getName(), archivo.isFile(), archivo.isDirectory());
				}
			}
			else {
				System.out.println("El archivo no es un directorio.");
			}
		}
		else {
			System.out.println("El archivo no existe.");
		}
	}
	
}
