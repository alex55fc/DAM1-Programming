package selectivas_anadidas_03;

import java.util.Scanner;

public class Ejer_3_09 {

	public static void main(String[] args) {
		//
		double numA, numB, numC, minimo, maximo;;

		Scanner teclado = new Scanner(System.in);

		System.out.print("¿Número real A? ");
		numA = teclado.nextDouble();
		System.out.print("¿Número real B? ");
		numB = teclado.nextDouble();
		System.out.print("¿Número real C? ");
		numC = teclado.nextDouble();

		maximo = numA;
		minimo = numA;

		if (numB < minimo) {
			minimo = numB;
		}
		if (numB > maximo) {
			maximo = numB;
		}
		if (numC < minimo) {
			minimo = numC;
		}
		if (numC > maximo) {
			maximo = numC;
		}
		System.out.printf("Mínimo: %.1f\n", minimo);
		System.out.printf("Máximo: %.1f\n", maximo);
	}
}
