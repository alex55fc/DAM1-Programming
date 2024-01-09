package iterativas_04;

import java.util.Scanner;

public class Ejer_4_02_B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numero;
		Scanner teclado = new Scanner(System.in);
		
		do {
			System.out.println("Introduce un número (1 a 5 para salir) ");
			numero = teclado.nextInt();			
		} while (numero < 1 || numero > 5);
		
	}

}
