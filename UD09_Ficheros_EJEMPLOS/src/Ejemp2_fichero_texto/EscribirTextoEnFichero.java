package Ejemp2_fichero_texto;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import entrada.Teclado;

public class EscribirTextoEnFichero {

	public static void main(String[] args) {
		FileWriter flujoSalida = null;
		try {
			File fichero = new File("frases.txt");
			//si usamos un constructor true escribe al final del texto y false escribe al principio
			//si escribimos falso o no ponemos nada por defecto sobreescribe todo el texto borrando y escribiendo encima lo q pongas
			
			flujoSalida = new FileWriter(fichero, true);
			String frase = Teclado.leerCadena("�Frase? ");
			flujoSalida.write(frase);
			flujoSalida.write("\r\n");  // salto de linea en Windows linux \n y MAC \r
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
