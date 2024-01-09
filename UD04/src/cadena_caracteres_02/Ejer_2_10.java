package cadena_caracteres_02;

import entrada.Teclado;

public class Ejer_2_10 {
	
	public static String leerFrase(String mensaje, int longitudMinima, int longitudMaximo) {
		String frase = Teclado.leerCadena(mensaje);
		int longitud = frase.length();
		
		while(longitud < longitudMinima || longitud > longitudMaximo){
			System.out.println("La frase debe tener "+ longitudMinima + " como minimo");
			System.out.println("La frase debe tener "+ longitudMaximo + " como maximo");
			frase = Teclado.leerCadena(mensaje);
		}
		return frase;
	}
	
	public static int contarEspacios (String mensaje) {
		int contadorEspacios = 0;
		for (int posicion = 0 ; posicion < mensaje.length() ; posicion++) {
			char caracter = mensaje.charAt(posicion);
			if (caracter == ' ') {
				contadorEspacios++;
			}
		}
		return contadorEspacios;		
	}
	
	

	public static void main(String[] args) {
		String frase = leerFrase("¿Frase?", 10, 60);
		
		//elimina los espacios al principio y al final
		frase = frase.trim();
		
		// en un while busco dos espacio en blanco seguidos con index.of
		//luego con replace sustituimos dos espacios en blanco por uno
		while (frase.indexOf("  ") != -1) { // mientras nos devuelva -1(osea cuando encuentre solo un espacio en blanco) hace el bucle
			frase = frase.replace("  ", " ");
		}
		int numeroEspacios = contarEspacios(frase);
		if (frase.length() > 0) {
			int numeroPalabras = numeroEspacios + 1;
			System.out.println("La frase tiene " + numeroPalabras + " plabras.");
		}
		else {
			System.err.println("La frase no tiene palabras.");
		}
		
		
		
		
		
		
	}
//podemos usar un replace para muchis espacios en blanco, remplazmos 2 espacios por 1 en bucle hasta q all solo uno0
}
