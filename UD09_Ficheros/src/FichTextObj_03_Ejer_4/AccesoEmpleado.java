package FichTextObj_03_Ejer_4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class AccesoEmpleado {
	/*creamos una constante para no tener que escribir la direccion del fichero 
	por lo que hacemos los siguiente y tambn creamos un folder en el proyecto llamado data que sera donde tengaos eel fichro */
	private static final String NOMBRE_FICHERO = "data/empleados.txt";

	/*Devuelve el empleado del fichero que tiene el codigo dado 
	 devuelve null si el fichero no teine ningun empleado con ese codigo */
	// este metodo lanza excepciones FileNotFoundException y IOException, como IOException es padre de la otra excepcion ponemos ese throws
	//usamos otro constructor como parametro una linea en Empleado para comparar las lineas para ver si contiene el codigo 
	public static Empleado consultar(int codigo) throws IOException {
		BufferedReader flujoLectura = null;
		try {
			//vamos a comprobar si existe el fichero al que queremos acceder 
			File fichero = new File(NOMBRE_FICHERO);
			if(fichero.exists()){
				flujoLectura = new BufferedReader(new FileReader(NOMBRE_FICHERO));

				String linea = flujoLectura.readLine();
				while (linea != null) {
					Empleado empleado = new Empleado(linea);
					//aqui asignamos al empleado la primera linea del fichero y ahora comparmos si el mismo codigo que padamos com parametro
					//comparamos con un getCodigo
					if(empleado.getCodigo() == codigo) {
						return empleado;
					}
					linea=flujoLectura.readLine();
				}
			}

			return null;
		}
		finally {
			if(flujoLectura != null) {
				flujoLectura.close();
			}
		}
	}

	/*caso 1*/
	public static void insertar(Empleado empleado) throws IOException {
		BufferedWriter flujoEscritura = null;
		try {
			//como escrbio la linea de texto al final usamos el constructor con 2 parametros y uno es true
			flujoEscritura = new BufferedWriter(new FileWriter(NOMBRE_FICHERO, true));
			//para escribir
			flujoEscritura.write(empleado.toStringWithSeparators());
			flujoEscritura.newLine();
		}
		finally {
			if(flujoEscritura != null ) {
				flujoEscritura.close();
			}
		}
	}

	/*caso 2. Devuleve una lista con los datos del fichero*/
	public static List<Empleado> consultarTodos() throws IOException {
		BufferedReader flujoLectura = null;
		try {
			List<Empleado> lista = new LinkedList<>();

			flujoLectura = new BufferedReader(new FileReader(NOMBRE_FICHERO));
			String linea = flujoLectura.readLine();
			while (linea != null) {
				Empleado empleado = new Empleado(linea);
				lista.add(empleado);
				linea=flujoLectura.readLine();
			}
			return lista;
		}

		finally {
			if(flujoLectura != null) {
				flujoLectura.close();
			}
		}
	}

	/*No se que caso es */
	// Inserta los empleados de una lista al principio del fichero.
	public static void insertarTodos(List<Empleado> listaEmpleados) 
			throws IOException {
		BufferedWriter flujoEscritura = null;
		try {
			flujoEscritura = new BufferedWriter(new FileWriter(NOMBRE_FICHERO));
			for (Empleado empleado : listaEmpleados) {
				flujoEscritura.write(empleado.toStringWithSeparators());
				flujoEscritura.newLine();
			}
		}
		finally {
			if (flujoEscritura != null) {
				flujoEscritura.close();
			}
		}
	}

	/*Caso 4.Actualiza un empleado, por c�digo, del fichero.*/
	// Devuelve verdadero si ha actualizado el empleado del fichero que tiene el c�digo dado.
	// Devuelve falso si el fichero no tiene ning�n empleado con el c�digo dado.
	public static boolean actualizar(int codigo, Empleado nuevoEmpleado) 
			throws IOException {
		BufferedReader flujoLectura = null;
		BufferedWriter flujoEscritura = null;
		try {
			File ficheroEmpleados = new File(NOMBRE_FICHERO);
			flujoLectura = new BufferedReader(new FileReader(ficheroEmpleados));
			File ficheroTemporal = new File("data/temporal.txt");
			flujoEscritura = new BufferedWriter(new FileWriter(ficheroTemporal));
			boolean encontrado = false;
			String linea = flujoLectura.readLine();
			while (linea != null) {
				Empleado empleado = new Empleado(linea);
				if (empleado.getCodigo() == codigo) {
					encontrado = true;
					flujoEscritura.write(nuevoEmpleado.toStringWithSeparators());
					flujoEscritura.newLine();
				}
				else {
					flujoEscritura.write(linea);
					flujoEscritura.newLine();
				}
				linea = flujoLectura.readLine();
			}
			flujoLectura.close();
			flujoEscritura.close();
			ficheroEmpleados.delete();
			ficheroTemporal.renameTo(ficheroEmpleados);
			return encontrado;
		}
		finally {
			try {
				if (flujoLectura != null) {
					flujoLectura.close();
				}
			}
			catch (IOException ioe) {
				ioe.printStackTrace();
			}
			try {
				if (flujoEscritura != null) {
					flujoEscritura.close();
				}
			}
			catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}

	/*caso 5: Eliminar un empleado, por c�digo, del fichero.*/
	// Devuelve verdadero si ha eliminado el empleado del fichero que tiene el c�digo dado.
	// Devuelve falso si el fichero no tiene ning�n empleado con el c�digo dado.
	public static boolean eliminar(int codigo) 
			throws IOException {
		BufferedReader flujoLectura = null;
		BufferedWriter flujoEscritura = null;
		try {
			File ficheroEmpleados = new File(NOMBRE_FICHERO);
			flujoLectura = new BufferedReader(new FileReader(ficheroEmpleados));
			File ficheroTemporal = new File("data/temporal.txt");
			flujoEscritura = new BufferedWriter(new FileWriter(ficheroTemporal));
			boolean encontrado = false;
			String linea = flujoLectura.readLine();
			while (linea != null) {
				Empleado empleado = new Empleado(linea);
				if (empleado.getCodigo() == codigo) {
					encontrado = true;
				}
				else {
					flujoEscritura.write(linea);
					flujoEscritura.newLine();
				}
				linea = flujoLectura.readLine();
			}
			flujoLectura.close();
			flujoEscritura.close();
			ficheroEmpleados.delete();
			ficheroTemporal.renameTo(ficheroEmpleados);
			return encontrado;
		}
		finally {
			try {
				if (flujoLectura != null) {
					flujoLectura.close();
				}
			}
			catch (IOException ioe) {
				ioe.printStackTrace();
			}
			try {
				if (flujoEscritura != null) {
					flujoEscritura.close();
				}
			}
			catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}
}
