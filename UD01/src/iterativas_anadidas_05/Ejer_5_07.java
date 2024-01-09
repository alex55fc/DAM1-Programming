package iterativas_anadidas_05;

import java.util.Scanner;

public class Ejer_5_07 {

	public static void main(String[] args) {
		// 
		int numA, numB, contador = 0;
		boolean error;
		Scanner teclado = new Scanner(System.in);

		System.out.print("¿Número A? ");
		numA = teclado.nextInt();
		System.out.print("¿Número B? ");
		numB = teclado.nextInt();
		error = true;

		if (numA > numB) {
			System.out.print("El número A debe ser menor o igual que el número B");
			error = false;
		}
		if (numA < 0) {
			System.out.print("El número A debe ser positivo");
			error = false;
		}
		if (error == true ) {
			while (numA <= numB) { 
				System.out.println("Tabla de multiplicar del número " + numA);
				contador = 0;
				while (contador <= 10) {
					System.out.println(numA + " * " + contador + "= " + (numA * contador));
					contador++;
				}
				numA++;
			}
		}
	}

}
