package secuenciales_01;

import java.util.Scanner;

public class Ejer_1_04 {

	public static void main(String[] args) {
		// 
		Scanner teclado = new Scanner(System.in);
		double numA, numB, resultado;
		
		System.out.print("¿Número real A? ");
		numA = teclado.nextDouble();
		
		System.out.print("¿Número real B? ");
		numB = teclado.nextDouble();
		
		resultado = numA + numB;
		System.out.println(numA + " + " + numB + " = " + resultado) ;
		
		resultado = numA - numB;
		System.out.println(numA + " - " + numB + " = " + resultado);
		
		resultado = numA * numB;
		System.out.println(numA + " * " + numB + " = " + resultado);
		
		resultado = numA / numB;
		System.out.println(numA + " / " + numB + " = " + resultado);

	}

}
