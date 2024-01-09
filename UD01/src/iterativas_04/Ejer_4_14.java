package iterativas_04;

import java.util.Scanner;

public class Ejer_4_14 {

	public static void main(String[] args) {
		// 
		int num,numSecreto = 19,intentos = 5,contador = 1;
		Scanner teclado = new Scanner (System.in);

		System.out.print("¿Número? ");
		num = teclado.nextInt();

		if (num != numSecreto) {
			while (intentos > contador && num != numSecreto) {
				System.out.println("Has fallado el número secreto");

				if  (numSecreto > num) {
					System.out.println("El número "+ num + " es menor que el número secreto");
				}
				if (numSecreto < num) {
					System.out.println("El número " + num + " es mayor que el número secreto");
				}

				System.out.print("¿Número? ");
				num = teclado.nextInt();
				contador++;
			}
			if  (numSecreto > num) {
				System.out.println("El número "+ num + " es menor que el número secreto");
				System.out.print("Has agotado los 5 intentos.");
			}
			if (numSecreto < num) {
				System.out.println("El número " + num + " es mayor que el número secreto");
				System.out.print("Has agotado los 5 intentos.");
			}

		}
		if (num == numSecreto) {
			System.out.print("Has acertado el número secreto ");
		}

	}
}

