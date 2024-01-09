package funciones_01;

import java.util.Scanner;

public class Ejer_1_03 {

	public static void main(String[] args) {
		// 
		int numeroInicial, numeroFinal, numero, contadorCapicuas;
		boolean error;
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Numero Inical? ");
		numeroInicial = teclado.nextInt();
		System.out.print("Numero Final? ");
		numeroFinal = teclado.nextInt();
		
		error = false;
		if (numeroInicial <= 0) {
			System.out.println("El número incial debe ser positivo.");
		error = true; 
		}
		if (numeroFinal <= 0) {
			System.out.println("El número final debe ser positivo. ");
		error = true;
		}
		if (numeroInicial > numeroFinal) {
			System.out.println("El número final debe ser positivo.");
			error = true;
		}
		
		// si es capicua
		if (! error) {
			contadorCapicuas = 0;
			for (numero = numeroInicial ; numero <= numeroFinal ; numero++) {
				if (esCapicua(numero)) {
					System.out.print(numero + " ");
					contadorCapicuas++;
				}
			}
		}
		
	}

	 	// duelve el numero invertido
	public static int invertir(int numero) {
		int numeroInvertido = 0;
		int digito;
		while (numero > 0) {
			digito = numero % 10;
			numeroInvertido = numeroInvertido * 10 + digito;
			numero = numero / 10;
		}
		return numeroInvertido;
		
}
		
	
		// Devuelve verdadero si es un número naturlas escrito en base 10 es capicua
		//Devuelve falso en caso contrario
		// Un número es capicua si, se lee igual de izq a drcha que de drcha a izq
	public static boolean esCapicua(int numero) {
		int numeroInvertido = invertir(numero);
		if (numero == numeroInvertido) {
			return true;
		}
		else {
			return false;
		}
		
		
	}
}

	

