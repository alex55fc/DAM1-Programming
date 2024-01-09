package matrizes_02;

import java.util.Arrays;

import entrada.Teclado;

public class Ejer_2_01 {
	public static void leerMatriz(int[][]matriz) {
		//matriz.length = numero de filas
		for(int fila = 0 ; fila < matriz.length ; fila++) {
			for (int columna = 0; columna < matriz[fila].length ; columna++) {
				matriz[fila][columna] = Teclado.leerEntero("Numero entero ("+fila+ ","+columna+")?");
			}
		}
	}

	public static void main(String[] args) {
		int[][] matriz = new int [4][4];
		leerMatriz(matriz);
		System.out.println("Matriz: ");

		int minimo = matriz[0][0];
		int maximo = matriz[0][0];

		int filaMinimo = 0;
		int columnaMinimo = 0;
		
		int filaMaximo = 0;
		int columnaMaximo = 0;
		
		for(int fila = 0; fila < matriz.length ; fila++) {	
			System.out.println(Arrays.toString(matriz[fila]));
		}
		
		for(int fila = 0 ; fila < matriz.length ; fila++) {
			for (int columna = 0; columna < matriz[fila].length ; columna++) {
				if (matriz[fila][columna] < minimo) {
					minimo = matriz[fila][columna];
					filaMinimo = fila;
					columnaMinimo = columna;
					
				}
				if (matriz[fila][columna] > maximo) {
					maximo = matriz[fila][columna];
					filaMaximo = fila;
					columnaMaximo = columna;
					
				}
			}
		}
		System.out.println("Minimo: "+ minimo);
		System.out.println("Primera posicion del minimo ("+filaMinimo+","+columnaMinimo+")");
		System.out.println("Maximo: "+ maximo);
		System.out.println("Primera posicion del minimo ("+filaMaximo+","+columnaMaximo+")");
	}
}
