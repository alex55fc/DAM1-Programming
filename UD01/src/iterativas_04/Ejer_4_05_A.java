package iterativas_04;

import java.util.Scanner;

public class Ejer_4_05_A {

	public static void main(String[] args) {
		// 
		int contador = 0, num, suma = 0;
		Scanner teclado = new Scanner(System.in);
		
		while(contador < 10) {
			System.out.print("¿Número entero "+ contador + "?");
			num = teclado.nextInt();
			suma = suma + num;
			contador++;
		}
		System.out.println("Suma " + suma);

	}

}
