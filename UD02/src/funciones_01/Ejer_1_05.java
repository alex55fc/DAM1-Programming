package funciones_01;

import java.util.Scanner;

public class Ejer_1_05 {

	public static void main(String[] args) {
		//
		int numero, numeroDivisores;
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("¿Número (0 para salir)");
		numero = teclado.nextInt();
		
		while (numero > 0) {
			System.out.println("Divisores del número " + numero + ": ");
			numeroDivisores = contadorDivisores(numero);
			System.out.println("El número " + numero + " tiene " + numeroDivisores + " divisores.");
			System.out.print("¿Número (0 para salir)");
			numero = teclado.nextInt();

		}
	}
	//Escribe en consola los divisores de un número natural
	//Devuelve el número de divisores que tiene un número naturla.
	public static int contadorDivisores (int numero) {
	int numeroDivisores = 0;
	int divisor;
	for (divisor = 1 ; divisor <= numero ; divisor++) {
		if (numero % divisor == 0)	{
			System.out.print(divisor + " ");
			numeroDivisores++;
		}
	}
	System.out.println();
	return numeroDivisores;
		
}
	

}
