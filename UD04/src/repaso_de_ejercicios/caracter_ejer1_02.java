package repaso_de_ejercicios;

import entrada.Teclado;

public class caracter_ejer1_02 {
	public static boolean esLetraMayuscula (char mayuscula) {
		if ((mayuscula >= 'A' && mayuscula <= 'Z') || mayuscula == 'Ñ') {
			return true;

		}
		else {
			return false;
		}
	}	
	public static boolean esLetraMinuscula (char minuscula) {
		if ((minuscula >= 'a' && minuscula <= 'z') || minuscula == 'ñ') {
			return true;
		}
		else {
			return false;
		}

	}
	public static void main(String[] args) {
		char caracter = Teclado.leerCaracter("¿Caracter? ");
		
		//porque lo ponemos asi?
		if (esLetraMayuscula(caracter)) {
			System.out.println(" es mayuscula ");
		}
		else if (esLetraMinuscula(caracter)) {
			System.out.println(" es minuscula ");
		}
		else {
			System.out.println(" no es una letra");
		}

	}

}
