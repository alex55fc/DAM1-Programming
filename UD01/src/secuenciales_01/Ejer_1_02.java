package secuenciales_01;

import java.util.Scanner;

public class Ejer_1_02 {

	public static void main(String[] args) {
		// que es ese archivo quue sale al lado de la linea 9 
	Scanner teclado = new Scanner(System.in);
	int numeroEnteroA, numeroEnteroB, numeroEnteroC;
	
	System.out.print("¿Número entero A? ");
	numeroEnteroA = teclado.nextInt();
	
	System.out.print("¿Número entero B? ");
	numeroEnteroB = teclado.nextInt();
	
	System.out.print("¿Número entero C? ");
	numeroEnteroC = teclado.nextInt();
	
	System.out.println("Números a la derecha");

	System.out.printf("%5d\n", numeroEnteroA);
	System.out.printf("%5d\n", numeroEnteroB);
	System.out.printf("%d\n", numeroEnteroC);
	
	System.out.println("Números a la izquierda");
	System.out.printf("%d\n", numeroEnteroA);
	System.out.printf("%d\n", numeroEnteroB);
	System.out.printf("%d\n", numeroEnteroC);
	}

}
