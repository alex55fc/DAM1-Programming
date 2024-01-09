package secuenciales_01;

import java.util.Scanner;

public class Ejer_1_06 {

	public static void main(String[] args) {
		// 
		Scanner teclado = new Scanner(System.in);
		int numChicos, numChicas;
		double porcentajeChicos, porcentajeChicas;
		
		
		System.out.print("¿Número de Chicos? ");
		numChicos = teclado.nextInt();
		System.out.print("¿Número de chicas? ");
		numChicas = teclado.nextInt();
		
		porcentajeChicos = numChicos * 100.0 / (numChicos + numChicas); 
		porcentajeChicas = 100.0 - porcentajeChicos;
		
		System.out.printf("Porcentaje de chicos: %.2f%%\n", porcentajeChicos);
		System.out.printf("porcentaje de chicas: %.2f%%\n", porcentajeChicas);
	}

}
