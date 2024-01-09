package funciones_01;

import java.util.Scanner;

public class Ejer_1_01 {
	
	public static int obtenerMaximo(int num1, int num2, int num3) {
		int maximo;
		maximo = num1;
		if (num2 > num1) {
			maximo = num2;
			return maximo;
		}
		if (num3 > num1) {
			maximo = num3;
			return maximo;
		}
		return maximo;
	}
	public static int obtenerMinimo(int num4, int num5, int num6) {
		int minimo;
		minimo = num4;
		if (num5 < num4) {
			minimo = num5;
			return minimo;
		}
		if (num6 < num4) {
			minimo = num6;
			return minimo;
		}
		return minimo;
	}

	public static void main(String[] args) {
		// 
		int numA, numB, numC, min, max;
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("¿Número Entero A? ");
		numA = teclado.nextInt();
		System.out.print("¿Número Entero B? ");
		numB = teclado.nextInt();
		System.out.print("¿Número Entero C? ");
		numC = teclado.nextInt();
		
		min = obtenerMinimo(numA, numB, numC);
		max = obtenerMaximo(numA, numB, numC);
		
		System.out.println("Mínimo " + min);
		System.out.println("Máximo " + max);
		
	}
	

}
