package Ejemplos;

import entrada.Teclado;

public class Ejem_PasoMayusculas {

	public static void main(String[] args) {
		int i;
		char caracter;
		String cadena;
		String cadenaMayusculas = "";
		
		cadena = Teclado.leerCadena("Introduce cadena: ");
		for(i = 0; i < cadena.length() ; i++) {
			caracter = cadena.charAt(i);
			if (caracter >= 'a' && caracter <= 'z') {
				caracter = (char) (caracter -32 );
				
			}
			else if (caracter == 'ñ'){
				cadenaMayusculas = cadenaMayusculas + caracter;
			}
			System.out.println(cadenaMayusculas );
		}
		

	}

}
