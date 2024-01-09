package iterativas_04;

import java.util.Scanner;

public class Ejer_4_05_B {

	public static void main(String[] args) {
		//
		int num, suma = 0, contador = 1;
		Scanner teclado = new Scanner(System.in);
		
		do {
			System.out.print("Número Entero " + contador + ": ");
			num = teclado.nextInt();
			suma = suma + num;
			contador ++;
		}while (contador < 10);
		System.out.println("Suma total = "+ suma);
	}
}
