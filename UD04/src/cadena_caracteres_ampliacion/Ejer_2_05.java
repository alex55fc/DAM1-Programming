package cadena_caracteres_ampliacion;

import entrada.Teclado;

public class Ejer_2_05 {
	public static String longitudMaxima(int longitud, String mensaje) {
		String frase = Teclado.leerCadena(mensaje);
		
		while (frase.length() > longitud) {
			System.out.println("No debe superar los "+ longitud + " caracteres.");
			frase = Teclado.leerCadena(mensaje);
		}
		return frase;
	}
	public static void escribirMenuOpciones() {
		System.out.println();
		System.out.println("(0) Salir del programa.");
		System.out.println("(1) Convertir todos los caracter de las frase en mayusculas");
		System.out.println("(2) Convertir todos los caracter de las frase en minusculas");
		System.out.println();
	}

	public static void main(String[] args) {
		int opcion;

		do {
			escribirMenuOpciones();
			opcion = Teclado.leerEntero("Elige una opcion");
			
			switch (opcion) {
			case 0:
				break;
			case 1 :
				String frase = longitudMaxima(60, "Frase:");
				System.out.println(frase.toUpperCase());
				
				break;
			case 2: 
				String frase1 = longitudMaxima(60, "Frase:");
				System.out.println(frase1.toLowerCase());  
				break;
			default:
				System.out.println("Elige una opcion correcta");
				break;
					
			}
		}while (opcion != 0);
		System.out.println("programa finalizado.");
	}
}