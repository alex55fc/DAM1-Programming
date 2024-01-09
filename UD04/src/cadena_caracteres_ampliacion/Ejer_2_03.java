package cadena_caracteres_ampliacion;

import entrada.Teclado;

public class Ejer_2_03 {
	public static String longitudFrase(int longitudMaxima, String mensaje) {
		String frase = Teclado.leerCadena(mensaje);
		
		while (frase.length() > longitudMaxima) {
			System.out.println("La frase debe tener "+ longitudMaxima + " como maximo.");
			frase = Teclado.leerCadena(mensaje);
		}
		return frase;
	}

	public static void main(String[] args) {
		final String VOCALES_PERMITIDAS= "AEIOUaeiou";
		String frase = longitudFrase(60, "Frase?");
		
		int contVocales = 0;
		int contConsonantes = 0;
		
		String vocales = "";
		String consonantes = "";
		
		
		for (int posicion = 0 ; posicion < frase.length() ; posicion++) {
			char caracter = frase.charAt(posicion);
			
			if ((caracter >= 'A' && caracter <= 'Z') || (caracter >= 'a' && caracter <= 'z')){
				//no entiendo este  if del todo, el >= ??
				if ( VOCALES_PERMITIDAS.indexOf(caracter) >= 0) {
					contVocales++;
					vocales = vocales + caracter;
				}
				else {
					contConsonantes++;
					consonantes = consonantes + caracter;
					
				}
			}
			else if (caracter == 'Ñ' || caracter == 'ñ') {
				contConsonantes++;
				consonantes = consonantes + caracter;
	
			}
		}
		System.out.println("La frase tiene " + contVocales + " vocales.");
		System.out.println("La frase tiene " + contConsonantes + " consonantes.");
		System.out.println("Letras vocales " + vocales);
		System.out.println("Letras consonantes " + consonantes);

	}

}
