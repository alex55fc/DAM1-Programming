package iterativas_04;

import java.util.Scanner;

public class Ejer_4_06_A {

	public static void main(String[] args) {
		// 
		int num, suma = 0, contador = 0;
		double media;
		Scanner teclado = new Scanner(System.in);

		System.out.print("¿Número Entero (0 para salir)? ");
		num = teclado.nextInt();

		while (num != 0) {
			suma = suma + num;
			contador ++;
			System.out.print("¿Número Entero (0 para salir)? ");
			num = teclado.nextInt();
		}       
		if (contador == 0) {
			System.out.println("No hay media aritmetica");
		}
		else {
			media = suma / contador;
			System.out.printf("Media aritmetica: %.1f\n", media);
		}
	}

}
