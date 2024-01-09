package iterativas_04;

import java.util.Scanner;

public class Ejer_4_07_B {

	public static void main(String[] args) {
		// 
		final int LIMITE = 9;
		int num, numMin, numMax, contador = 0;
		Scanner teclado = new Scanner (System.in);
		
		System.out.print("¿Número entero " + contador + "?");
		num = teclado.nextInt();
		contador++;
		numMin = num;
		numMax = num;
		
		do {
			System.out.print("¿Número entero " + contador + "?");
			num = teclado.nextInt();
			contador ++;
			if (num < numMin) {
				numMin = num;
			}
			if (num > numMax) {
				numMax = num;
			}
		} while (contador <= LIMITE);
		System.out.println("Mínimo " + numMin);
		System.out.println("Máximo " + numMax);
	}

}
