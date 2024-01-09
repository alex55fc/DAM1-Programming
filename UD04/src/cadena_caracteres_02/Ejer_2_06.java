package cadena_caracteres_02;

import entrada.Teclado;

public class Ejer_2_06 {

	public static String leerFrase (String mensaje,int longitudMinima, int longitudMaxima) {
		String frase = Teclado.leerCadena(mensaje);
		/* podemos dar valor int longitud = frase.length () para asi poner longotud y verlo de forma sencilla*/

		while  (frase.length () < longitudMinima || frase.length () > longitudMaxima) {
			System.out.println("La frase debe tener " + longitudMinima + " caracteres como minimo");
			System.out.println("La frase debe tener " + longitudMaxima + " caracteres como  maximo");

			frase = Teclado.leerCadena(mensaje);	
		}
		return frase;
	}
	
//frase entre 5 y 40 caracteres
	public static void main(String[] args) {
		String frase = leerFrase("¿Frase? ", 5, 40);
		String frase1 = "";

		for(int posicion = 0 ; posicion < frase.length() ; posicion++) {
			System.out.println(frase.substring(0, posicion +1));
			// este posicion +1 es porque el metodo de objeto substring va desde el inicio hasta el ultimo -1
			/*otra forma de hacer lo mismo 
			char caracter = frase.charAt(posicion);
			frase1 = frase1 + caracter;
			System.out.println(frase1); */

		}
	}
}
