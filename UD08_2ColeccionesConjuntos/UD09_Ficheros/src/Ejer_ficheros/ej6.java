package Ejer_ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import entrada.Teclado;

public class ej6 {
	/*Usaremos un fichero auxiliar para hacer el ejercicio
	 * entre este ejercicio y el 5 haremos cosas distintas por ejemplo muchas cosas en el main */
	//aqui hacemos el throes IOexception pero sin ningun catch, eso lo getionara JAVA sola
	public static void main(String[] args) throws IOException {
		BufferedReader flujoLectura = null;
		BufferedWriter flujoEscritura = null;
		File ficheroLectura = null;
		File ficheroEscritura = null;
		try {
			String nombreFichero = Teclado.leerCadena("Nombre del fichero :");
			ficheroLectura = new File(nombreFichero);

			if (ficheroLectura.exists()) {
				String palabra = Teclado.leerCadena("Palabra ");
				ficheroEscritura = new File ("temporal.txt");
				flujoLectura = new BufferedReader(new FileReader(ficheroLectura));
				flujoEscritura = new BufferedWriter (new FileWriter(ficheroEscritura));

				String linea = flujoLectura.readLine();
				while(linea !=  null) {
					if(!linea.contains(palabra)) {
						flujoEscritura.write(linea);
						flujoEscritura.newLine();
					}
					linea = flujoLectura.readLine();

				}
				System.out.println("El fichero se ha modificado");
			}
			else {
				System.out.println("El fichero no existe");
			}
			
			flujoLectura.close();
			flujoEscritura.close();
			ficheroLectura.delete();
			ficheroEscritura.renameTo(ficheroLectura);
		}
		//este finally lo usamos solo por siacaso pasa algun error que no controlemos que se cierren los fichero.
		finally {
			try {
				if(flujoLectura != null) {
					flujoLectura.close();
				}
			}
			catch(IOException ioe1) {
				ioe1.printStackTrace();

			}
			try {
				if (flujoEscritura != null){
					flujoEscritura.close();
				}
			}
			catch(IOException ioe2) {
				ioe2.printStackTrace();
			}
		}
	}

}
/*6) Eliminar de un fichero de texto las líneas que contengan una palabra leída por teclado.
 * para hacer esto crearemos un fichero aparte donde guardaremos las lineas que no hay que eliminar asi borramos el 
 * fichero original y al fichero auxiliar lo remonbraremos con el nombre del fichero original. Asi da la ilusion
 * de que borramos las lineas dentro del fichero origuinal pero solo creamos otro fichero con las lineas que quereamos y lo remobramos*/
