package Ejer_ficheros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import entrada.Teclado;

public class ej1 {

	public static void main(String[] args) {
		String nombreFichero = Teclado.leerCadena("Nombre del fichero :");
		BufferedReader flujoLectura = null;
		try {
			flujoLectura = new BufferedReader(new FileReader(nombreFichero));
			
			int contLineas = 0;
			int contCaracteres = 0;
			String linea = flujoLectura.readLine();
			
			while (linea != null) {
				System.out.println(linea);
				contLineas++;
				//sumamos 2 al linea.length no cuenta el salto de linea en WINDOWS cuenta como 2 caracteres----------------------------------------------------
				contCaracteres = contCaracteres + linea.length() + 2;
				linea = flujoLectura.readLine();
			}
			System.out.println("Lineas en total "+ contLineas);
			System.out.println("Caracteres en total "+ contCaracteres);

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
