package selectivas_02;

import java.util.Scanner;

public class Ejer_2_08 {

	public static void main(String[] args) {
		// 
		double descuento, num, precio;
		Scanner teclado = new Scanner(System.in);
		
		System.out.printf("¿Importe de la carga?  ");
		num = teclado.nextDouble();

		if (num < 0) {
			System.out.print("El importe de la carga debe ser positivo.");
		}
		else if (num < 200) {
			descuento = 0;
			System.out.printf("Rebaja: %20.2f euros\n", descuento);
			System.out.printf("Importe con descuento: %.2f euros\n", num);
		}
		else if (num <= 800) {
			descuento = 0.1 * num;
			precio = num - descuento;
			System.out.printf("Rebaja: %20.2f euros\n", descuento);
			System.out.printf("Importe con descuento: %.2f euros\n", precio);
		}
		else if (num > 800) {
			descuento = 0.15 * num;
			precio = num - descuento;
			System.out.printf("Rebaja: %20.2f euros\n", descuento);
			System.out.printf("Importe con descuento: %.2f euros\n", precio);
		}
	
	}

}
