package Ejemp3_fichero_texto_buffer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerTextoDeFicheroConBuffer {

	public static void main(String[] args) {
		BufferedReader flujoEntrada = null;
		try {
			File fichero = new File("frases.txt");
			flujoEntrada = new BufferedReader(new FileReader(fichero));
			int contador = 0;
      		String linea = flujoEntrada.readLine(); 
      		while (linea != null) { 	 
      			System.out.println(linea);
      			contador++;
      			linea = flujoEntrada.readLine();
      		}
      		System.out.println("Se han le�do " + contador + " frases del fichero de texto.");
		}
		catch (FileNotFoundException fnfe) {                      
			System.out.println("Error al abrir el fichero: " + fnfe.getMessage());
			fnfe.printStackTrace();
		}
		catch (IOException ioe) {
			System.out.println("Error al leer del fichero: " + ioe.getMessage());
			ioe.printStackTrace();
		}
		finally {
			try {
				if (flujoEntrada != null) {
					flujoEntrada.close();
				}
			}
			catch (IOException ioe) {
				System.out.println("Error al cerrar el fichero: " + ioe.getMessage());
				ioe.printStackTrace();
			}
		}
	}
	
}
