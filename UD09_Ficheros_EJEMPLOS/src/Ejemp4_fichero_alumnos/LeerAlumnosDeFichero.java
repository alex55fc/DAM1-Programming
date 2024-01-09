package Ejemp4_fichero_alumnos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerAlumnosDeFichero {
	
	public static void main(String[] args) {
		BufferedReader flujoEntrada = null;
		try {
			File fichero = new File("alumnos.txt");
			flujoEntrada = new BufferedReader(new FileReader(fichero));
			
			int contador = 0;
      		String linea = flujoEntrada.readLine(); 
      		while (linea != null) { 	
      			//aqui creamos un objeto alumno, donde en alumno hacemos otro constructor con un string de parametro
      			Alumno alumno = new Alumno(linea);
      			System.out.println(alumno.toString());
      			contador++;
      			linea = flujoEntrada.readLine();
      		}
      		System.out.println("Se han le�do " + contador + " alumnos del fichero de texto.");
		}
		catch (FileNotFoundException fnfe) {                      
			System.out.println("Error al abrir el fichero: " + fnfe.getMessage());
			fnfe.printStackTrace();
		}
		catch (IOException ioe) {
			System.out.println("Error al leer del fichero: " + ioe.getMessage());
			ioe.printStackTrace();
		}
		catch (NumberFormatException nfe) {
			System.out.println("Error al convertir de cadena a numero: " + nfe.getMessage());
			nfe.printStackTrace();
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
