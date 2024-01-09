package vectores_01;

import java.util.Random;

public class Ejer_1_03 {
	//creamos este metodo para generar el vector aleatorio lo seguimos haciendo igual q antes solo q con un random
	public static void generarVectorAleatorio(int[] vector, int minimo, int maximo) {
		Random aleatorio = new Random();
		for (int pos = 0; pos < vector.length; pos++) {
			vector[pos] = aleatorio.nextInt(maximo-minimo +1) + minimo;
		}
	}
	public static void escribirVector(int[] vector) {
		System.out.print("[");
		for (int pos = 0 ; pos < vector.length ; pos++) {
			System.out.print(vector[pos]);
			if (pos != vector.length -1){
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}
	public static void main(String[] args) {
		//declaro el vector y lo instancio con la capacidad quee me dicen 
		final int LONGITUD = 15;
		int[] vector = new int[LONGITUD];

		generarVectorAleatorio(vector, -100, 100);
		System.out.println("Vector:");
		escribirVector(vector);

		int contadorNumNeg = 0;
		int contadorNumNeu = 0;
		int contadorNumPos = 0;

		for ( int pos = 0; pos < vector.length ; pos++) {
			if(vector[pos] < 0) {
				contadorNumNeg++;
			}
			else if (vector[pos] > 0) {
				contadorNumPos++;
			}
			else {
				contadorNumNeu++;
			}

		}
		System.out.println("Numeros de elementos Negativos: "+ contadorNumNeg);
		System.out.println("Numeros de elementos Positivos: "+contadorNumNeu );
		System.out.println("Numeros de elementos Neutros: "+contadorNumPos );
	}
}
