
//asi funciona la clase teclado, con estas excepciones

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Clase Teclado que incluye operaciones de entrada de datos primitivos
// desde el teclado, con salida de mensajes informativos en la consola.
// Utiliza las clases InputStreamReader y BufferedReader del paquete java.io de Java.
public class Teclado {

	// Lee un booleano 'boolean' por teclado.
	// Visualiza en consola un mensaje informativo para el usuario.
	// Devuelve el booleano le�do.
	public static boolean leerBooleano(String mensaje) {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		String lineaTexto = "";
		boolean error = true;
		while (error) {
			try {
				System.out.print(mensaje);
				lineaTexto = teclado.readLine();
				while (!lineaTexto.equals("true") && !lineaTexto.equals("false") &&
				       !lineaTexto.equals("verdadero") && !lineaTexto.equals("falso")) {
					System.out.println("El dato introducido debe ser verdadero o falso.");
					System.out.print(mensaje);
					lineaTexto = teclado.readLine();
				}
				error = false;
			} 
			catch (IOException ioe) {
				System.out.println("Se ha producido un error de entrada/salida.");
				error = true;
			}
		}
		return (lineaTexto.equals("true") || lineaTexto.equals("verdadero"));
	}
	
	// Lee un n�mero natural (entero 'int' positivo) por teclado.
	// Visualiza en consola un mensaje informativo para el usuario.
	// Devuelve el n�mero natural le�do.
	public static int leerNatural(String mensaje) {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		int numeroNatural = 0;
		boolean error = true;
		while (error) {
			try {
				System.out.print(mensaje);
				numeroNatural = Integer.parseInt(teclado.readLine());
				while (numeroNatural <= 0) {
					System.out.println("El dato introducido debe ser mayor que cero.");
					System.out.print(mensaje);
					numeroNatural = Integer.parseInt(teclado.readLine());
				}
				error = false;
			} 
			catch (NumberFormatException nfe) {
				System.out.println("El dato introducido no tiene formato de n�mero natural.");
				error = true;
			}
			catch (IOException ioe) {
				System.out.println("Se ha producido un error de entrada/salida.");
				error = true;
			} 
		}
		return numeroNatural;
	}
	
	// Lee un n�mero entero 'int' por teclado.
	// Visualiza en consola un mensaje informativo para el usuario. 
	// Devuelve el n�mero entero le�do.
	public static int leerEntero(String mensaje) {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		int numeroEntero = 0;
		boolean error = true;
		while (error) {
			try {
				System.out.print(mensaje);
				numeroEntero = Integer.parseInt(teclado.readLine());
				error = false;
			} 
			catch (NumberFormatException nfe) {
				System.out.println("El dato introducido no tiene formato de n�mero entero.");
				error = true;
			}
			catch (IOException ioe) {
				System.out.println("Se ha producido un error de entrada/salida.");
				error = true;
			} 
		}
		return numeroEntero;
	}
	
	// Lee un n�mero entero largo 'long' por teclado.
	// Visualiza en consola un mensaje informativo para el usuario. 
	// Devuelve el n�mero entero largo le�do.
	public static long leerEnteroLargo(String mensaje) {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		long numeroEnteroLargo = 0;
		boolean error = true;
		while (error) {
			try {
				System.out.print(mensaje);
				numeroEnteroLargo = Long.parseLong(teclado.readLine());
				error = false;
			} 
			catch (NumberFormatException nfe) {
				System.out.println("El dato introducido no tiene formato de n�mero entero largo.");
				error = true;
			}
			catch (IOException ioe) {
				System.out.println("Se ha producido un error de entrada/salida.");
				error = true;
			} 
		}
		return numeroEnteroLargo;
	}
	
	// Lee un n�mero real 'double' por teclado.
	// Visualiza en consola un mensaje informativo para el usuario.
	// Devuelve el n�mero real le�do.
	public static double leerReal(String mensaje) {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		double numeroReal = 0.0;
		boolean error = true;
		while (error) {
			try {
				System.out.print(mensaje);
				numeroReal = Double.parseDouble(teclado.readLine());
				error = false;
			} 
			catch (NumberFormatException nfe) {
				System.out.println("El dato introducido no tiene formato de n�mero real.");
				error = true;
			}
			catch (IOException ioe) {
				System.out.println("Se ha producido un error de entrada/salida.");
				error = true;
			} 
		}
		return numeroReal;
	}

	// Lee un car�cter 'char' por teclado.
	// Visualiza en consola un mensaje informativo para el usuario.
	// Devuelve el car�cter le�do.
	public static char leerCaracter(String mensaje) {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		String lineaTexto = "";
		boolean error = true;
		while (error) {
			try {
				System.out.print(mensaje);
				lineaTexto = teclado.readLine();
				while (lineaTexto.length() != 1) {
					System.out.println("El dato introducido debe ser un �nico car�cter.");
					System.out.print(mensaje);
					lineaTexto = teclado.readLine();
				}
				error = false;
			} 
			catch (IOException ioe) {
				System.out.println("Se ha producido un error de entrada/salida.");
				error = true;
			}
		}
		return lineaTexto.charAt(0);
	}
	
	// Lee una cadena de caracteres 'String' por teclado.
	// Visualiza en consola un mensaje informativo para el usuario.
	// Devuelve la cadena de caracteres le�da.
	public static String leerCadena(String mensaje) {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		String lineaTexto = "";
		boolean error = true;
		while (error) {
			try {
				System.out.print(mensaje);
				lineaTexto = teclado.readLine();
				error = false;
			} 
			catch (IOException ioe) {
				System.out.println("Se ha producido un error de entrada/salida.");
				error = true;
			}
		}
		return lineaTexto;
	}

}
