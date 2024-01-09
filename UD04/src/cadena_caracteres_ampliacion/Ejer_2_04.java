package cadena_caracteres_ampliacion;

import entrada.Teclado;

public class Ejer_2_04 {
	public static String longitudFrase (int longitudMaxima, String mensaje){

		String frase = Teclado.leerCadena(mensaje);
		while(frase.length() > longitudMaxima) {
			System.err.println("La frase debe tener "+ longitudMaxima + " como maximo.");
			frase = Teclado.leerCadena(mensaje);
		}
		return frase;
	}

	public static void main(String[] args) {
		
		String frase = longitudFrase(10, "¿Frase? ");
		String par = "";
		String impar = "";
		
		for (int posicion = 0 ; posicion < frase.length(); posicion++) {
			char caracter = frase.charAt(posicion);
			if (posicion % 2 == 0) {
				par = par + caracter;
			}
			else {
				impar = impar + caracter;
			}
		}
		System.out.println("Los caracter  de posicion pares son:");
		System.out.println(par);
		System.out.println("Los caracter  de posicion impares son:");
		System.out.println(impar);
	}

}
