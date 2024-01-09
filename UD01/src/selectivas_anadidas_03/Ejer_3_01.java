package selectivas_anadidas_03;

import java.util.Scanner;

public class Ejer_3_01 {

	public static void main(String[] args) {

		int num;
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("¿Año? ");
		num = teclado.nextInt();
		
		if (num < 1583) {
			System.out.print("El año debe ser mayor o igual a 1583");
		}
		else if (num % 4 == 0 || num %  400 == 0) {
			System.out.print("Es bisiesto.");
		}
		else {
			System.out.print("No es bisiesto");
		}
	}

}
