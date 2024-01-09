package repaso_de_ejercicios;

import entrada.Teclado;

public class cadena_car_ejer2_01 {
	public static String longitudCadena (int longitudMaxima, String cadena) {
		// porque hacemos asi el mensaje ? 
		String frase = Teclado.leerCadena(cadena);
	
		while (frase.length() > longitudMaxima) {
			System.err.println("La frase debe tener " + longitudMaxima + "como maximo");
			frase = Teclado.leerCadena(cadena);
		}
		return frase;
	}

	public static void main(String[] args) {
		// porque es con un igual y no con un frase.longitudCadena
		 String frase = longitudCadena(60, "¿Frase?: " );
		 
		 int contadorMayus = 0;
		 int contadorMinus = 0;
		 // inicializamos este String para guardas las mayusculas que vayamos sacando al recorrer la frase
		 String mayusculas = "";
		 String minusculas = "";
		 
		 /*creamos este bucle para que recorra toda la frase. Creamos un int posicion para poder usarlo en 
		  * el charAt, como el int lentgh() cuenta empezando por 1 la longitud total y 
		  * el charAt empieza por 0 hacemos que recorra la frase hasta la penultima posicion del int length()
		  * que sera posicion < frase.length.
		  * si pusieramos <= abria un problema ya que la ultima posicion del length() es una posicion mas que no existe en el charAt
		  */
		
		 for (int posicion = 0; posicion < frase.length() ; posicion++) {
			 frase.charAt(posicion);
			 
			 // hacemos un char caracter para tener en la variable la letra en la posicion que este en el momento
			 // y porque no podemos poner  mayuscula = mayuscula + posicion; porque da error
			 char caracter = frase.charAt(posicion); 
			 
			 //porque no podemos poner en vez de caracter poner posicion ??
			 if ((caracter >= 'A' && caracter <= 'Z') || caracter == 'Ñ') {
				contadorMayus++;
				mayusculas = mayusculas + caracter;
			 }
			 else if ((caracter >= 'a' && caracter <= 'z') ||caracter == 'ñ') {
				 contadorMinus++;
				 minusculas = minusculas + caracter;
			 }
			 

		 }
		 System.out.println("La frase tiene "+ contadorMinus + " minusculas");
		 System.out.println("Minusculas = "+  minusculas);
		 System.out.println("La frase tiene "+ contadorMayus + " mayusculas");
		 System.out.println("Mayusculas = "+  mayusculas);


	}

}
