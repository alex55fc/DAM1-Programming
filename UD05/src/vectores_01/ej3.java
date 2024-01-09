package vectores_01;

import java.util.Random;

public class ej3 {
	public static void leerVector(int[]vector, int maximo, int minimo) {
		Random aleatorio = new Random()	;
		for (int pos = 0 ; pos < vector.length ; pos++) {
			vector[pos] = aleatorio.nextInt(maximo - minimo + 1)+ minimo;
		}
	}
	public static void escribirVector(int[]vector) {
		System.out.print("[");
		for (int pos = 0; pos <vector.length; pos++) {
			System.out.print(vector[pos]);
			if (pos != vector.length -1) {
				System.out.print(", ");
			}
		}
		System.out.print("]");
	}

	public static void main(String[] args) {
		final int LONGITUD = 15;
		int [] vector = new int[LONGITUD];

		int contNegativos = 0;
		int contNeutros = 0;
		int contPositivos = 0;

		leerVector(vector, 100, -100);
		System.out.println("VECTOR");
		escribirVector(vector);
		System.out.println();
		
		for (int pos = 0; pos < vector.length ;pos++) {
			if (vector[pos] > 0) {
				contPositivos++;
			}
			else if (vector[pos] < 0) {
				 contNegativos++;	
			}
			else {
				contNeutros++;
			}
		}
		System.out.println("Numeros de elementos Negativos: "+ contNegativos);
		System.out.println("Numeros de elementos Positivos: "+contPositivos );
		System.out.println("Numeros de elementos Neutros: "+contNeutros );
	}

}
