package iterativas_04;

import java.util.Scanner;

public class Ejer_4_02_A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduce un número (1 a 5 para salir) ");
		num = teclado.nextInt();
		
		while (num < 1 ||  num > 5) {
			System.out.println("Introduce un número (1 a 5 para salir)");
			num = teclado.nextInt();
		}
	}

}
