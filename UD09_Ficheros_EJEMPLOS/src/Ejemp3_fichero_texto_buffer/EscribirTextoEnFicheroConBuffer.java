package Ejemp3_fichero_texto_buffer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import entrada.Teclado;

public class EscribirTextoEnFicheroConBuffer {

	public static void main(String[] args) {
		BufferedWriter flujoSalida = null;
		try {
			File fichero = new File("frases.txt");
			flujoSalida = new BufferedWriter(new FileWriter(fichero, true));
			String frase = Teclado.leerCadena("�Frase? ");
			flujoSalida.write(frase);
			flujoSalida.newLine();
			System.out.println("Se ha escrito la frase \'" + frase + "\' en el fichero de texto.");
		} 
		catch (IOException ioe) {
			System.out.println("Error al escribir en el fichero: " + ioe.getMessage());
			ioe.printStackTrace();
		}
		finally {
			try {
				if (flujoSalida != null) {
					flujoSalida.close();
				}
			}
			catch (IOException ioe) {
				System.out.println("Error al cerrar el fichero: " + ioe.getMessage());
				ioe.printStackTrace();
			}
		}
	}
	
}
