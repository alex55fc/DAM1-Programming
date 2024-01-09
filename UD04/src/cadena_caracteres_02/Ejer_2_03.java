package cadena_caracteres_02;

import entrada.Teclado;

public class Ejer_2_03 {
	public static String leerFrase (String mensaje, int longitudMaxima) {
		String frase = Teclado.leerCadena(mensaje);
		
		while  (frase.length () > longitudMaxima) {
			System.out.println("La frase debe tener " + longitudMaxima + " caracteres como");
			frase = Teclado.leerCadena(mensaje);	
		}
		return frase;
	}

	public static void main(String[] args) {
		String frase = leerFrase("¿Frase? ", 60);

		final String LETRAS_VOCALES_PERMITIDAS = "AEIOUaeiou";
		int contadorLetrasVocales = 0;
		String letrasVocales = "";
		
		int contadorLetrasConsonantes = 0;
		String letrasConsonantes = "";

		for(int posicion = 0 ; posicion < frase.length() ; posicion++) {
			char caracter = frase.charAt(posicion);
			
			if ((caracter >= 'A' && caracter <= 'Z') || (caracter >= 'a' && caracter <= 'z')) {
				if (LETRAS_VOCALES_PERMITIDAS.indexOf(caracter) >= 0) {
					contadorLetrasVocales++;
					letrasVocales = letrasVocales + caracter;
				}
				else {
					contadorLetrasConsonantes++;
					letrasConsonantes = letrasConsonantes + caracter;
				}
			}
			else if (caracter == 'Ñ' || caracter == 'ñ') {
				contadorLetrasConsonantes++;
				letrasConsonantes = letrasConsonantes + caracter;
			}


		}
		System.out.println("La frase tiene " + contadorLetrasVocales +  " vocales");
		System.out.println("Letras vocales " + letrasVocales);
		System.out.println("La frase tiene " + contadorLetrasConsonantes +  " vocales");
		System.out.println("Letras vocales " + letrasConsonantes);
	}

}
