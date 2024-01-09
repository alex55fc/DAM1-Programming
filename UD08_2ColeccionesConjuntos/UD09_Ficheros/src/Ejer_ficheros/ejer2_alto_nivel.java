package Ejer_ficheros;

import java.io.File;

import entrada.Teclado;

public class ejer2_alto_nivel {

	public static void main(String[] args) {
		String nombreDirectorio = Teclado.leerCadena("Nombre del directorio ");
		File directorio = new File(nombreDirectorio);
		if (directorio.exists() && directorio.isDirectory()) {
			File[] vectorArchivos = directorio.listFiles();
			for (int pos = 0 ; pos < vectorArchivos.length; pos++) {
				File archivo = vectorArchivos[pos];
				if (archivo.isFile()) {
					String nombreModif = archivo.getName().toUpperCase();
					File archivoModif = new File(nombreModif);
					if (archivo.renameTo(archivoModif)) {
						System.out.println("Fichero modificado "+ archivoModif.getName());
					}
				}
			}

		}
		else {
			System.out.println("El archivo no es existe ");
		}
	}

}
