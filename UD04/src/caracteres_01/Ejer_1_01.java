package caracteres_01;

import entrada.Teclado;

public class Ejer_1_01 {
	public static boolean esNumeroArabigo(char caracter) {
		if (caracter >= '0' && caracter <= '9') {
			return true;
		}
		else {
			return false;
		}
	}

	public static void main(String[] args) {
		char caracter = Teclado.leerCaracter("¿Carácter? ");
		if (esNumeroArabigo(caracter)) {
			System.out.println("El carácter " + caracter + " es numero arabico.");
		}
		else {
			System.out.println("El carácter " + caracter + " no es un numero arabico.");
		}
		
	}

}
