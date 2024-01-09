package selectivas_02;

import java.util.Scanner;

public class Ejer_2_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double numA, numB, numC;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Dime tres numeros enteros: ");
		numA = teclado.nextInt();
		numB = teclado.nextInt();
		numC = teclado.nextInt();
		
		if (numA > numB && numA > numC) {
			System.out.printf("El número mayor es el "+ numA );
		}
		else if (numB > numC) {
			System.out.printf("El número mayor es el "+ numB);
		}
		else {
			System.out.printf("El número mayor es el "+ numC);
		}
	}

}
