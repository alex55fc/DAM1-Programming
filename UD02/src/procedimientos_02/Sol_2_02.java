package procedimientos_02;

import java.util.Scanner;

public class Sol_2_02 {
	public static void dibujarRectangulo(int altura, int anchura) {
		int i, j;
		for (i = 1 ; i <= altura ; i++) {
			for (j = 1 ; j <= anchura ; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		
		int altura, anchura, respuesta = 0;
		boolean dimensionesValidas;
		Scanner teclado = new Scanner(System.in);
		dimensionesValidas = true;
		
		do {
			System.out.print("¿Altura del rectangualo? ");
			altura = teclado.nextInt();
			System.out.print("¿Anchura del rectangualo? ");
			anchura = teclado.nextInt();
			
			if ( altura <= 0) {
				System.out.println("La altura del rectámgulo debe ser positiva.");
				dimensionesValidas = false;
			}
			if (anchura <= 0) {
				System.out.println("La anchura del rectángulo debe ser positiva.");
			}
			if (dimensionesValidas) {
				dibujarRectangulo(altura, anchura);
			}
			
		}while (respuesta > 0);
		
	}

}
