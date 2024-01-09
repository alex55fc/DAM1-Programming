package Ejer_ficherosActividades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Ejer_1_01 {

	// Lee las líneas de un fichero de texto entrada.txt.
	// Escribe las líneas en orden inverso en un fichero de texto salida.txt.
	// Visualiza en consola el número de líneas leídas y escritas.
	public static void main(String[] args) {
		BufferedReader flujoEntrada = null;
		BufferedWriter flujoSalida = null;
		try {
			File ficheroEntrada = new File("entrada.txt");
			flujoEntrada = new BufferedReader(new FileReader(ficheroEntrada));
			List<String> lista = new LinkedList<String>();
      		String linea = flujoEntrada.readLine(); 
      		while (linea != null) { 	 
      			lista.add(linea);
      			linea = flujoEntrada.readLine();
      		}
      		
      		File ficheroSalida = new File("salida.txt");
      		flujoSalida = new BufferedWriter(new FileWriter(ficheroSalida, false));
      		for (int posicion = lista.size() - 1 ; posicion >= 0 ; posicion--) {
      			linea = lista.get(posicion);
      			flujoSalida.write(linea);
      			flujoSalida.newLine();
      		}
      		System.out.println("Se han copiado " + lista.size() + " líneas del fichero de entrada");
      		System.out.println("en orden inverso en el fichero de salida.");
		}
		catch (FileNotFoundException fnfe) {                      
			System.out.println("Error al abrir el fichero:");
			System.out.println(fnfe.getMessage());
		}
		catch (IOException ioe) {
			System.out.println("Error al leer/escribir de/en el fichero:");
			System.out.println(ioe.getMessage());
		}
		finally {
			try {
				if (flujoEntrada != null) {
					flujoEntrada.close();
				}
			}
			catch (IOException ioe) {
				ioe.printStackTrace();
			}
			try {
				if (flujoSalida != null) {
					flujoSalida.close();
				}
			}
			catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}

}
