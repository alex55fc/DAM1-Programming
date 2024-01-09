package selectivas_02;

import java.util.Scanner;

public class Ejer_2_01 {

	public static void main(String[] args) {
		// 
		Scanner teclado = new Scanner(System.in);
		int dato1;
		System.out.println("Dime un número entero: ");
		dato1 = teclado.nextInt();
		
		if (dato1%2 == 0) {
			System.out.println("El número es par");
		}
		else {
			System.out.println("El número es impar");
		}
			
		
	}

}
