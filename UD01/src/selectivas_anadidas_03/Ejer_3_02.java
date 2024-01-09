package selectivas_anadidas_03;

import java.util.Scanner;

public class Ejer_3_02 {

	public static void main(String[] args) {
		//
		int num;
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("¿Mes? ");
		num  =teclado.nextInt();
		
		if (num < 1 || num > 12) {
			System.out.print("El número debe estar comprendido entre 1 y 12.");
		}
		else if ( num == 1 || num == 3 || num == 5 || num == 7 || num == 8 || num == 10 || num == 12) {
			System.out.print("31 días");
		}
		else {
			System.out.print("30 días");
		}
			
	}

}
