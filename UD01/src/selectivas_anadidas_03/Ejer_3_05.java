package selectivas_anadidas_03;

import java.util.Scanner;

public class Ejer_3_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num;
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("¿Número entero (Entre 0 y 99999)? ");
		num = teclado.nextInt();

		if (num < 0 || num > 99999) {
			System.out.print("El número entero debe estar comprendido entre 0 y 99999.");
		}
		else {
			
			if (num <= 9) {
				System.out.print("El "+ num + " tiene 1 cifra");
			}
			
			else if (num <= 99) {
				System.out.print("El "+ num + " tiene 2 cifras");
		}
			else if (num <= 999) {
				System.out.print("El "+ num + " tiene 3 cifras");
			}
			else if (num <= 9999) {
				System.out.print("El "+ num + " tiene 4 cifras");
			}
			else {
				System.out.print("El "+ num + " tiene 5 cifras");
			}
		}
	}

}
