package secuenciales_01;

import java.util.Scanner;

public class Ejer_1_03 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		int numA, numB;
		System.out.print("¿Número Entero A? ");
		numA = teclado.nextInt();
		
		System.out.print("¿Número Entero B? ");
		numB = teclado.nextInt();
		
		System.out.println("ANTES del intercambio");
		System.out.printf("A = %d y B = %d\n" ,numA ,numB);
		 
		System.out.println("DESPUES del intercambio");
		System.out.printf("A = %d y B = %d\n" ,numB ,numA);
	}

}
