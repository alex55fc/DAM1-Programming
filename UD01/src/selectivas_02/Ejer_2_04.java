package selectivas_02;

import java.util.Scanner;

public class Ejer_2_04 {

	public static void main(String[] args) {
		// && = funciona como un "y" 
		// || tiene que cumplir con una de las dos opcciones "o"
		// 
		double numA, numB;
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("¿Número real A? ");
		numA = teclado.nextDouble();
		System.out.print("¿Número real B? ");
		numB = teclado.nextDouble();
		
		if (numA > numB) {
			System.out.print("El número real " + numA + " es mayor ");
		}
		else if (numA > numB) {
			System.out.print("El número real " + numB + " es mayor ");
		}
		else {
			System.out.print("Los números " + numA + " y " + numB + " son iguales ");
		}
	}

}
