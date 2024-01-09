package Ficheros_texto_02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import entrada.Teclado;

public class ej3 {

	public static void main(String[] args) {
		String nombreFichero = Teclado.leerCadena("Nombre del fichero :");
		BufferedReader flujoLectura = null;
		
		Set<String> conjuntoLineas = new HashSet<>();
		
		try {
			flujoLectura = new BufferedReader(new FileReader(nombreFichero));
			String linea = flujoLectura.readLine();
			int contLineas = 0;

			while (linea != null) {
				System.out.println(linea);
				contLineas++;
				conjuntoLineas.add(linea);
				linea = flujoLectura.readLine();
			}
			System.out.println("Lineas en total "+ contLineas);
			System.out.println("Lineas diferentes " + conjuntoLineas.size());
			//escribimos con un for each el conjunto o con un toString
			System.out.println(conjuntoLineas.toString());
		}
		catch(IOException ioe) {
			System.out.println("Error al acceder al fichero");
			//escribir el printStackTrace para que muestre los mensajes de error
			ioe.printStackTrace();
		}	
		finally {
			try {
				if (flujoLectura != null) {
					flujoLectura.close();
				}	
			}
			catch(IOException ioe) {
				System.out.println("Error al cerrar el fichero.");
				ioe.printStackTrace();
			}
		}
	}

}
