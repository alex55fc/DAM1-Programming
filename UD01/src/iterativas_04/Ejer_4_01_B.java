package iterativas_04;

import java.util.Scanner;

public class Ejer_4_01_B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num;
		Scanner teclado = new Scanner(System.in);
		
		do {
			System.out.println("Introduce un número (0 para salir) ");
			num = teclado.nextInt();
			
		}while (num != 0);
	}

}
