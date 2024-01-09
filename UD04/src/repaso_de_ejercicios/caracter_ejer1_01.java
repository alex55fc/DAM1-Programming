package repaso_de_ejercicios;

import entrada.Teclado;

public class caracter_ejer1_01 {
	public static boolean esNumeroArabigo(char alissa) {
		if (alissa >= '0' && alissa <= '9') {
			return true;
		}
		else {
			return false;
		}
		
	}

	public static void main(String[] args) {

		char caracter = Teclado.leerCaracter("¿caracter? ");
		
		if(esNumeroArabigo(caracter)) {
			System.out.println("es arabigo");
		}
		else {
			System.out.println("no lo es");
		}

	}

}
