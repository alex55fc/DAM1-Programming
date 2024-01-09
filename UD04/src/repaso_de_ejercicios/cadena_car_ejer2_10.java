package repaso_de_ejercicios;

import entrada.Teclado;

public class cadena_car_ejer2_10 {
	public static String longitudFrase(int longitudMin, int longitudMax, String mensaje) {
		//siigo sin entender porque de esta frase aqui y no en el main
		String frase = Teclado.leerCadena(mensaje);

		while(frase.length() < longitudMin ||  frase.length() > longitudMax) {
			System.err.println("La frase debe tener	"+ longitudMin + " como minimo.\n"
					+ "La frase debe tener "+ longitudMax + " como máximo\n");
			frase = Teclado.leerCadena(mensaje);
		}
		return frase;
	}

	public static int contarEspacios(String frase) {
		int contadorEspacios = 0;
		frase = frase.trim();
		
		//no se como poner este raeplace bien en bucle.
		
		
		
		
		
		frase.replace("  ", " ");
		for (int pos= 0 ; pos < frase.length() ; pos++) {
			char caracter = frase.charAt(pos);
			if (caracter == ' ') {
				contadorEspacios++;
			}
		}
		return contadorEspacios;
	}
	public static void main(String[] args) {
		String frase = longitudFrase(10, 60, "¿Frase?: ");
		int palabras = contarEspacios(frase) + 1;

		System.out.println("La frase tiene "+ palabras);




	}

}
