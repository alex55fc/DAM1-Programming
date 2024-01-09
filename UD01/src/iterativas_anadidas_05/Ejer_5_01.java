package iterativas_anadidas_05;

import java.util.Scanner;

public class Ejer_5_01 {

	public static void main(String[] args) {

		boolean error;
		int altura, anchura, i,j;
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("¿Altura del rectangulo? ");
		altura = teclado.nextInt();
		System.out.print("Anchura del rectángulo? ");
		anchura = teclado.nextInt();
		error = true;
		
		if ( altura <= 0) {
			System.out.println("La altura del rectangulo debe ser positiva");
			error = false;
		}
		if ( anchura <= 0) {
			System.out.print("La anchura del rectangulo debe ser positiva");
			error = false;
			}
		else {
			error = true;
			for (i = 1 ; i <= altura ; i++) {
				for (j = 1 ; j <= anchura ; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
	}

}
