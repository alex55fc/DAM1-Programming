package selectivas_anadidas_03;

import java.util.Scanner;

public class Ejer_3_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numH, numM, numS;
		int contador = 0;
		boolean error;
		Scanner teclado = new Scanner(System.in);

		System.out.print("¿Horas? ");
		numH = teclado.nextInt();
		System.out.print("¿Minutos? ");
		numM = teclado.nextInt();
		System.out.print("¿Segundos? ");
		numS = teclado.nextInt();
		error = true;

		if (numH < 0 || numH > 23) {
			System.out.println("Las horas deben de estar comprendidas entre 0 y 23.");
			error = false;
		}
		if (numM < 0 || numM > 59) {
			System.out.println("Los minutos deben de estar comprendidas entre 0 y 59.");
			error = false;
		}
		if (numS < 0 || numS > 59) {
			System.out.println("Los segundos deben de estar comprendidos entre 0 y 59.");
			error = false;
		}

		if (error = true) {
			if (numS == 59 && numM == 59 && numH == 23) {
				System.out.print(numH + "h " + numM + "m " + numS + "s + 1 =");
				System.out.print(" 1 día 0h 0m 0s");
			}
			else if (numS == 59 && numM == 59) {
				System.out.print(numH + "h " + numM + "m " + numS + "s + 1 = ");
				System.out.print((numH + 1) + "h " + contador + "m " + contador + "s");
			}
			else if (numS == 59) {
				System.out.print(numH + "h " + numM + "m " + numS + "s + 1s = ");
				System.out.print(numH  + "h " + (numM + 1) + "m " + contador + "s");
			}
			
		}
	}

}
