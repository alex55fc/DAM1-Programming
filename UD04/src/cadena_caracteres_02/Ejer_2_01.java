package cadena_caracteres_02;

import entrada.Teclado;

public class Ejer_2_01 {
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
	 
	 int contadorLetrasMayusculas = 0;
	 String letrasMayusculas = "";
	 int contadorLetrasMinusculas = 0;
	 String letrasMinusculas = "";
	 
	 for(int posicion = 0 ; posicion < frase.length() ; posicion++) {
		 char caracter = frase.charAt(posicion);
		 
		 if ((caracter >= 'A' && caracter <= 'Z') ||caracter == 'Ñ') {
			 contadorLetrasMayusculas++;
			 letrasMayusculas = letrasMayusculas + caracter;
		 }
		 else if ((caracter >= 'a' && caracter <= 'z') ||caracter == 'ñ') {
			 contadorLetrasMinusculas++;
			 letrasMinusculas = letrasMinusculas + caracter;
		 }
		 
	 }	 
	 System.out.println("La frase tiene "+ contadorLetrasMayusculas + " letras mayusculas.");
	 System.out.println("Letras Mayúsculas: " + letrasMayusculas);
	 System.out.println("La frase tiene "+ contadorLetrasMinusculas + " letras minusculas.");
	 System.out.println("Letras Mayúsculas: " + letrasMinusculas);
	}

}

