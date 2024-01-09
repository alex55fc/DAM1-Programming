package secuenciales_01;

import java.util.Scanner;

public class Ejer_1_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		double numA, numB; 
		System.out.print("¿Número real A? ");
		numA = teclado.nextDouble();
		
		System.out.print("¿Número real B? ");
		numB = teclado.nextDouble();
		
		System.out.println("NÚMEROS CON 2 DÍGITOS DECIMALES");
		System.out.printf("A = %.2f\n", numA);
		System.out.printf("B = %.2f\n", numB);
		
		System.out.println("NÚMEROS CON 1 DÍGITO DECIMAL");
		System.out.printf("A = %.1f\n", numA);
		System.out.printf("B = %.1f\n", numB);
		
		System.out.println("NÚMEROS CON NINGÚN DIGITO DECIMAl");
		System.out.printf("A = %.0f\n",numA);
		System.out.printf("B = %.0f\n",numB);
		
	}

}
