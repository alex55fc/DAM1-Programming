package iterativas_04;

import java.util.Scanner;

public class Ejer_4_08_A {

	public static void main(String[] args) {
		// escribir un num por teclado y que visualize la suma de los número impares menores o iguales al num
		int num, impar = 1, suma = 0;
		Scanner teclado = new Scanner(System.in);

		System.out.print("¿Número natural N? ");
		num = teclado.nextInt();
		if (num < 0 ) {
			System.out.println("El número natural N debe ser positivo.");
		}
		else {
			while (impar <= num) {
				suma = suma + impar;
				impar = impar + 2;
			}
			System.out.print("Suma de número impares  menores o iguales que " + num + " es: " + suma);
		}

	}
}
