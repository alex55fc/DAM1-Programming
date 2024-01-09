package selectivas_02;

import java.util.Scanner;

public class Ejer_2_03 {

	public static void main(String[] args) {
		// 
		double numero, cuadrado, raizCuadrada;
		Scanner teclado = new Scanner(System.in);
		// Math.sqrt() para hacer raices cuadradas.
		System.out.print("Escriba un número real: ");
		numero = teclado.nextDouble();
		cuadrado = numero * numero;
		raizCuadrada = Math.sqrt(numero);
				
		if (numero < 0) {
			System.out.print("El número debe ser mayor o igual que 0");
		}
		else if (numero >= 0) {
			System.out.println("Cuadrado de " + numero + " = " + cuadrado );
			System.out.print("Raíz cuadrada de " + numero + " = " + raizCuadrada);
		} 
	}

}
