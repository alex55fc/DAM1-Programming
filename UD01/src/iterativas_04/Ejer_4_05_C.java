package iterativas_04;

import java.util.Scanner;

public class Ejer_4_05_C {

	public static void main(String[] args) {
		// 
		int num = 0, suma = 0, contador = 1;
		Scanner teclado = new Scanner(System.in);
		
		for (num = 0 ; contador < 10 ; contador++) {
			System.out.print("Numero entero " + contador + ": ");
			num = teclado.nextInt();
			suma = suma + num;
		}
		System.out.println("Suma total " + suma);
	}

}
