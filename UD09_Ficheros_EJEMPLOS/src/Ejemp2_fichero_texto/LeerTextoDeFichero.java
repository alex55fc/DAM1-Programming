package Ejemp2_fichero_texto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerTextoDeFichero {
	
	public static void main(String[] args) {
		FileReader flujoEntrada = null;
		try {
			File fichero = new File("frases.txt");
			flujoEntrada = new FileReader(fichero);    
			int contador = 0;
			int codigo = flujoEntrada.read();
			while (codigo != -1) {
				System.out.print((char) codigo);
				contador++;
				codigo = flujoEntrada.read();
			}	
			System.out.println("Se han le�do " + contador + " caracteres del fichero de texto.");
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
