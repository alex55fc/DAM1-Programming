package vectores_01;

import java.util.Arrays;

import java.util.Random;

import entrada.Teclado;

public class Ejer_1_06 {


	public static void rellenar(int[] vector, int minimo, int maximo) {
		Random aleatorio = new Random();

		for (int pos = 0; pos < vector.length; pos++) {
			// este esta bien?
			vector[pos] = aleatorio.nextInt(minimo, maximo);
		}

	}
	
	public static int[] fusionar(int[]vectorA, int[]vectorB) {

		int[] vectorFusion = new int [vectorA.length + vectorB.length];
		int posicionResultado = 0;

		for (int pos = 0 ; pos < vectorA.length ; pos++) {
			vectorFusion[posicionResultado] = vectorA[pos];
			posicionResultado++;
		}
		for (int pos = 0 ; pos < vectorB.length ; pos++) {
			vectorFusion[posicionResultado] = vectorB[pos];
			posicionResultado++;
		}
		return vectorFusion;
	}
	
	public static void main(String[] args) {

		int longitudA = Teclado.leerNatural("¿Capacidad del vector A?");
		int [] vectorA = new int [longitudA];
		rellenar(vectorA, -1000, 1000);

		int longitudB = Teclado.leerNatural("¿Capacidad del vector B?");
		int[]vectorB = new int [longitudB];
		rellenar(vectorB, -1000, 1000);

		System.out.println("vector A");
		System.out.println(Arrays.toString(vectorA));
		System.out.println("vector B");
		System.out.println(Arrays.toString(vectorB));
		
		int [] vectorFusion = fusionar(vectorA, vectorB);
		System.out.println("vector fusion:");
		System.out.println(Arrays.toString(vectorFusion));
		
	}

}
