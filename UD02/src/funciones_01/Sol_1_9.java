package funciones_01;

import java.util.Scanner;

public class Sol_1_9 {

	public static void main(String[] args) {
		// 
		int numeroConductores, contador;
		double tiempoHoras, cargoEstacionar;
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("¿Numero de Conductores? ");
		numeroConductores = teclado.nextInt();
		
		for (contador = 1 ; contador <= numeroConductores ; contador++) {
			System.out.println("CONDUCTOR " + contador + ":");
			System.out.print("¿Tiempo en horas? ");
			tiempoHoras = teclado.nextDouble();
			
			if (tiempoHoras >= 0.0 && tiempoHoras <= 24.0) {
				cargoEstacionar = calcularCargoPorEstacionar(tiempoHoras);
				System.out.printf("Cargo por estacionar: %.2f euros\n",cargoEstacionar);
			}
			else {
				System.out.println("El tiempo debe estar comprendido entre 0 y 20");
			}
		}

	}
	public static double calcularCargoPorEstacionar(double horas) {
		double cargo = 2.0;
		if  (horas == 24.0) {
			cargo = 10.0;
		}
		else if ( horas > 3.0) {
			horas = horas - 3.0;
			while (horas >= 1.0) {
				cargo = cargo +0.5;
				horas = horas - 1.0;
			}
			if (horas > 0.0) {
				cargo = cargo + 0.5;
			}
		}
		return cargo;
	}

}
