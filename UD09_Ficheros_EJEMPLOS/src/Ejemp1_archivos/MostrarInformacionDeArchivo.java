package Ejemp1_archivos;

import java.io.File;
import entrada.Teclado;

public class MostrarInformacionDeArchivo {
	
	public static void main(String[] args) {
		String rutaConNombre = Teclado.leerCadena("�Ruta y Nombre del Archivo? ");
		File archivo = new File(rutaConNombre);  
		if (archivo.exists()) {
			System.out.println("Informaci�n sobre el archivo \'" + rutaConNombre + "\':");
			System.out.println("Nombre:                      " + archivo.getName());
			System.out.println("Nombre del Directorio Padre: " + archivo.getParent());
			System.out.println("Ruta:                        " + archivo.getPath());
			System.out.println("Ruta Absoluta:               " + archivo.getAbsolutePath());
			System.out.println("Tama�o:                      " + archivo.length() + " bytes");
			System.out.println("�Se Puede Leer?              " + archivo.canRead());
			System.out.println("�Se Puede Escribir?          " + archivo.canWrite());
			System.out.println("�Se Puede Ejecutar?          " + archivo.canExecute());
			System.out.println("�Es Directorio?              " + archivo.isDirectory()); 
			System.out.println("�Es Fichero?                 " + archivo.isFile());
			System.out.println("�Est� Oculto?                " + archivo.isHidden());
		}
		else {
			System.out.println("El archivo no existe.");
		}
	}
	
}
