package matrizes_02;

import java.util.Arrays;
import java.util.Random;

public class Ejer_2_02 {

	public static void rellenar(int[][] matriz, int maximo, int minimo) {
		Random aleatorio = new Random();
		int intervalo = maximo - minimo + 1;
		for (int fila = 0; fila < matriz.length; fila++) {
			for (int columna = 0; columna < matriz[fila].length; columna++) {
				matriz[fila][columna] = aleatorio.nextInt(intervalo) + minimo;
			}
		}

	}
	public static void escribirMatriz(int[][]matriz) {
		for (int fila = 0; fila < matriz.length; fila++) {
			System.out.print("[");
			for (int columna = 0; columna < matriz[fila].length; columna++) {
				System.out.printf("%3d", matriz[fila][columna]);
				if (columna != matriz[fila].length - 1) {
					System.out.print(", ");
				}
			}
			System.out.println("]");
		}
		
	}

	public static void main(String[] args) {
		final int NUMFILAS = 8;
		final int NUMCOLUM = 8;
		int[][] matriz = new int[NUMFILAS][NUMCOLUM];
		
		rellenar(matriz, 100, 1);
		System.out.println("Matriz");
		escribirMatriz(matriz);
	
		/*hacer la suma de las filas, para eso acumulamos el valor de la fila y la columna mientras recorremos la fila
		 * y mostramos el resultado al final de la longitud de la fila(osea despues de la ultima columna) en el caso de este ejercicio */
		int sumaFilas = 0;
		for (int fila = 0; fila < matriz.length; fila++) {
			for (int columna = 0; columna < matriz[fila].length; columna++) {
				sumaFilas = sumaFilas + matriz[fila][columna];
			}
			System.out.println("Suma de fila "+fila+": "+ sumaFilas);
			sumaFilas = 0;
		}
		 /*hacer la suma de las columnas
		  * mirar apuntes
		  */
		int sumaColumnas = 0;
		
		for (int columna = 0; columna < NUMFILAS ; columna++) {
			for(int fila = 0; fila < matriz.length ; fila++) {
				sumaColumnas = sumaColumnas + matriz[fila][columna];
			}
			System.out.println("Suma de Columnas "+ columna + ": "+ sumaColumnas);
			sumaColumnas = 0;
		}
		
	}
}