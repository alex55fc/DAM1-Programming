package matrizes_02;

import java.util.Random;

import entrada.Teclado;

public class Ejer_2_03 {
	public static void rellenar(int matriz[][], int maximo, int minimo) {
		Random aleatorio = new Random();
		int intervalosMaxMin = maximo - minimo + 1;

		for (int fila = 0 ; fila < matriz.length ; fila++) {
			for(int columna = 0; columna < matriz[fila].length ; columna++) {
				matriz[fila][columna] = aleatorio.nextInt(intervalosMaxMin) + minimo;
			}
		}
	}
	public static void leerMatriz(int matriz[][]) {
		for(int fila = 0 ; fila < matriz.length ; fila++) {
			System.out.print("[");
			for (int columna = 0 ; columna < matriz[fila].length ; columna++) {
				System.out.printf("%3d", matriz[fila][columna]);
				if (columna != matriz[fila].length -1) {
					System.out.print(", ");
				}
			}
			System.out.println("]");
		}
	}

	public static void main(String[] args) {
		final int COLUMNAS = 8;
		final int FILAS = 8;
		int[][]matriz = new int [FILAS][COLUMNAS];

		rellenar(matriz,100,1);
		System.out.println("MATRIZ ANTES DE INTERCAMBIO DE FILAS");
		leerMatriz(matriz);

		int fila1 = Teclado.leerEntero("¿fila 1?");
		                   //largo de la fila 
		while (fila1 < 0 || fila1 >= matriz.length) {
			System.out.println("La fila debe estar conpprendida entre 0 y "+ (matriz.length -1) + ".");
			fila1 = Teclado.leerEntero("¿fila 1?");
		}
		
		int fila2 = Teclado.leerEntero("¿fila 2?");
		while (fila2 < 0 || fila2 >= matriz.length) {
			System.out.println("La fila debe estar conpprendida entre 0 y "+ (matriz.length -1) + ".");
			fila2 = Teclado.leerEntero("¿fila 2?");
		}
		
		/*1 posible solucion
		 * int [] fila = matriz[fila1];
		 * matriz[fila1] = matriz[fila2];
		 * matriz[fila2] = fila;
		 */
		int elemento ;
		for(int columna = 0 ; columna < COLUMNAS ; columna++) {
			elemento = matriz[fila1][columna];
			matriz[fila1][columna] = matriz[fila2][columna];
			matriz[fila2][columna] = elemento;
		}
		System.out.println("MATRIZ DESPUES DE INTERCAMBIO DE FILAS");
		leerMatriz(matriz);
	}

}
