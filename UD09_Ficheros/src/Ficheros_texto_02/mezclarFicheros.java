package Ficheros_texto_02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import entrada.Teclado;

public class mezclarFicheros {

	public static void main(String[] args) {
		BufferedReader flujoLectura1 = null;
		BufferedReader flujoLectura2 = null;

		BufferedWriter flujoEscritura = null;
		try {
			String nombreFich1 = Teclado.leerCadena("Nombre del primer fichero");
			String nombreFich2 = Teclado.leerCadena("Nombre del segundo fichero");
			flujoLectura1 = new BufferedReader(new FileReader(nombreFich1));
			flujoLectura2 = new BufferedReader(new FileReader(nombreFich2));
			
			flujoEscritura = new BufferedWriter(new FileWriter("mezcla.txt"));
			
			String lineaFich1 = flujoLectura1.readLine();
			String lineaFich2 = flujoLectura2.readLine();

			while (lineaFich1 != null || lineaFich2 != null) {
				if(lineaFich1 != null) {
					flujoEscritura.write(lineaFich1);
				flujoEscritura.newLine();
				}
				if (lineaFich2 != null) {
					flujoEscritura.write(lineaFich2);
				flujoEscritura.newLine();
				}
				lineaFich1 = flujoLectura1.readLine();
				lineaFich2 = flujoLectura2.readLine();

			}
			System.out.println("Se han mezclado los dos ficheros.");
			
		}
		catch(IOException ioe){
			System.out.println("Error de entrada/salida");
			ioe.printStackTrace();
		}
		finally {
			try {
				if(flujoLectura1 != null) {
					flujoLectura1.close();
				}
			}
			catch(IOException ioe){
				ioe.printStackTrace();
			}
			try {
				if(flujoLectura2 != null) {
					flujoLectura2.close();
				}
			}
			catch(IOException ioe){
				ioe.printStackTrace();
			}
			try {
				if(flujoEscritura != null) {
					flujoEscritura.close();
				}
			}
			catch(IOException ioe){
				ioe.printStackTrace();
			}
		}
	}

}
/**/