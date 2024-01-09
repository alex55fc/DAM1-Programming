package cadena_caracteres_02;

import entrada.Teclado;
// repaso 
// frase.length() cuenta todos los caracteres de la frase ejemplo hola = 4 caracteres
// cadena de caracteres empieza desde 0 hasta el final 
public class Ejer_2_07 {
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

	public static void main(String[] args) {
	
		String frase = leerFrase("¿Frase?", 2, 40);
		
		//rotacion derecha
		System.out.println("Rotacion a la derecha");
		for(int posicion = 0; posicion < frase.length(); posicion++) { 
			System.out.println(frase);
			
			char ultimoCaracter = frase.charAt(frase.length() -1);
			String restoCaracteres = frase.substring(0, frase.length() -1);
			
			frase = ultimoCaracter + restoCaracteres;
		}
		//rotacion izquierda
		System.out.println("Rotacion a la izquierda");
		for(int posicion = 0; posicion < frase.length(); posicion++) { 
			System.out.println(frase);
			
			char primerCaracter = frase.charAt(0);
			String restoCaracteres = frase.substring(1, frase.length());
			
			frase =  restoCaracteres + primerCaracter ;
		}
	}

}
