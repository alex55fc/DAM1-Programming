package iterativas_anadidas_05;

import java.util.Scanner;

public class Ejer_5_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int altura, anchura, i, j;
		boolean error;
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("¿Altura del triángulo? ");
		altura = teclado.nextInt();
		
		error = true;
		
		if ( altura <= 0) {
			System.out.print("La altura del triángulo debe ser positiva.");
		}
		if (error = true) {
			for (i = 1 ; i <= altura; i++) {
				for (j = 1; j <= i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
	}

}
