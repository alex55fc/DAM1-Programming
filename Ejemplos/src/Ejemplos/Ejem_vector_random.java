package Ejemplos;

import java.util.Random;

public class Ejem_vector_random {

	//Ecribe en consola un vector de enteros
	public static void escribirVector(int[] vector) {
		System.out.print("[");
		for(int pos = 0 ; pos < vector.length ; pos++) {
			if (pos == vector.length -1 ) {
				System.out.print(vector[pos]);
			}
			else {

				System.out.print(vector[pos] + ", ");
			}
		}
		System.out.print("]");
	}
	
	//primero incializamos Random aleatorio = new Random();
	// y lo usamos en el vctor con los limites, preguntar la formula cuando es +1 ytal
	public static int[]	generarVector(int capacidad, int minimo, int maximo) {
		Random aleatorio = new Random();
		int[] vector = new int[capacidad];
		
		for (int pos = 0 ; pos < vector.length ; pos++) {
			vector[pos] = aleatorio.nextInt(minimo, maximo + 1);			
		}
		return vector;
	}

	public static void main(String[] args) {
		Random aleatorio = new Random();
		
		int [] notas = {7, 8, 4, 3, 5, 10};

		// mostramos el orden dado
		for (int pos = 0 ; pos < notas.length ; pos++) {
			System.out.print(notas[pos] + " ");
		}	 
		System.out.println(); 


		// rellenar el vector con notas aleatorias entre 0 y 10
		for (int pos = 0 ; pos < notas.length ; pos++) {
			notas[pos] = aleatorio.nextInt(0, 11); // pongo 11 porque si no no lee el 20

			
		}	 
		escribirVector(notas);	
		
		//calcular la media del vector
		int suma = 0;
		for (int pos = 0 ; pos < notas.length ; pos++) {
			suma = suma + notas[pos];
		}
		double media = (double) suma / notas.length;
		System.out.printf(" media=  " + media);
		
		
		System.out.println();
		//recorrer el vector en orden al reves del orden random 
		for (int pos = notas.length -1 ; pos >= 0 ; pos--) {
			System.out.print(notas[pos] + " ");
		}
		
		//
		System.out.println();
		int[] numero = generarVector(20, -10, 15);
		escribirVector(numero);
	}	
}


