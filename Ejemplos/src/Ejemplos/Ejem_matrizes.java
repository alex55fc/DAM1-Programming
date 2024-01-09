package Ejemplos;

import java.util.Arrays;
import java.util.Random;

public class Ejem_matrizes {

	public static void main(String[] args) {
		
		//matriz 3x4 de enteros y recorrer cualquier matriz Da igual si es regular o irregular ya que lo hacemos de este modo
		//metemos un valor aleatorio a cada 
		Random aleatorio = new Random();
		
		
		int [][] matriz = new int [3][4];
								//matriz.length nos da el tamaño de la matriz (numero de filas)
		for(int fila = 0; fila < matriz.length ; fila++) {
			                             // de este modo recorremos cada fila de inicio a fin y asi vemos cuan larga es
			for(int columna = 0; columna < matriz[fila].length ; columna++) {
	
				 matriz[fila][columna] = aleatorio.nextInt(11)+10; // entero entre 10 y 20
			}
		}
		System.out.println("Matriz: ");
		//como cada fila de la matriz es un vector
		for(int fila = 0; fila < matriz.length ; fila++) {	
			System.out.println(Arrays.toString(matriz[fila]));
		}
		
		// dar valor a una matriz irregular
		int [][]matrizIrregular = {
				{0, 1, 6 ,8},
				{75, 1, 12, 5, 4}
		};
	}

}
