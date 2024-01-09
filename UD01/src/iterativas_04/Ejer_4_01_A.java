package iterativas_04;

import java.util.Scanner;

public class Ejer_4_01_A {

	public static void main(String[] args) {
		// 
		int num; 
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduce un número(0 para salir) ");
		num = teclado.nextInt();
		
		while (num != 0) {
			System.out.println("Introduce un número (0 para salir)");
			num = teclado.nextInt();
		}
	}
	

}
