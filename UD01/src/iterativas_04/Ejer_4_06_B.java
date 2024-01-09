package iterativas_04;

import java.util.Scanner;

public class Ejer_4_06_B {

	public static void main(String[] args) {
		// 
		int num = 0, suma = 0, contador = -1;
		double media;
		Scanner teclado = new Scanner(System.in);
			
		do {
			contador++;
			suma = suma + num;
			System.out.print("Escribe un número (0 para salir) ");
			num = teclado.nextInt();
		}while (num != 0);
		
		if (contador == 0) {
			System.out.print("No hay media aritmética");
		}
		else {
			media = suma / contador;
			System.out.printf("La media aritmética es %.1f\n", media);
			
		}
	}

}
