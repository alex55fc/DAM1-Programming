package Ejer_ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

import entrada.Teclado;

public class ej5 {
	public static Set<String> leerLineasNoRepetidas(String nombreFichero)
			throws IOException{
		BufferedReader flujoLectura = null;

		try {
			flujoLectura = new BufferedReader(new FileReader(nombreFichero));
			Set<String> conuntoCadenas = new LinkedHashSet<>();
			String linea = flujoLectura.readLine();

			while (linea != null) {
				System.out.println(linea);
				conuntoCadenas.add(linea);
				linea = flujoLectura.readLine();
			}
			return conuntoCadenas;
		}
		finally {
			if (flujoLectura != null) {
				flujoLectura.close();
			}	
		}
	}
	public static void escribirLineas(Set<String> conjuntoCadenas, String nombreFichero)
	throws IOException{
		BufferedWriter flujoEscritura = null;
		try {
			/*podemos escribir
			 * flujoEscritura = new BufferedWriter(new FileWriter(nombreFichero, false));
			 * pero el por defecto ya lleva el booleano false por lo que escribe por defecto al principio */
			flujoEscritura = new BufferedWriter(new FileWriter(nombreFichero));
			for (String x : conjuntoCadenas) {
				flujoEscritura.write(x);
				flujoEscritura.newLine();
			}
		}
		finally {
			if (flujoEscritura != null) {
				flujoEscritura.close();
			}	
		}
	}

	public static void main(String[] args) {
		try {
			String nombreFichero = Teclado.leerCadena("Nombre del fichero :");
			Set<String> conjuntoCadenas = leerLineasNoRepetidas(nombreFichero);
			escribirLineas(conjuntoCadenas, nombreFichero);
		}
		//esta es la exceptcion del FileReader
		catch(IOException ioe){
			System.out.println("Error al acceder al fichero de texto");
			ioe.printStackTrace();
		}


	}

}
