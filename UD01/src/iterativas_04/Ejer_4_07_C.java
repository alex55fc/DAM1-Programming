package iterativas_04;

import java.util.Scanner;

public class Ejer_4_07_C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int LIMITE = 9;
		int num = 0, numMax, numMin, contador = 0;
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("¿Numreo Entero " + contador + "?");
		num = teclado.nextInt();
		contador++;
		numMin = num;
		numMax = num;
		
		for (num = 0 ; contador <= LIMITE ; contador ++) {
			System.out.print("¿Número ENtero " + contador + "?");
			num = teclado.nextInt();
			if (num < numMin) {
				numMin = num;
			}
			if (num > numMax) {
				numMax = num;
			}
		}
		System.out.println("Mínimo " + numMin);
		System.out.println("Máximo " + numMax);
	}

}
