package vectores_01;

import entrada.Teclado;

public class e1 {
	public static void leerVector(int[]vector) {
		for(int pos = 0; pos < vector.length; pos++) {
			vector[pos] = Teclado.leerEntero("¿Numero entero "+ pos + "?");		
		}
	}
	public static void escribirVector(int[] vector) {
		System.out.print("[");
		for(int pos = 0; pos < vector.length; pos++) {
			System.out.print(vector[pos]);
			if (pos != vector.length -1) {
				System.out.print(", ");
			}
		}
		System.out.print("]");
	}
	public static void main(String[] args) {
		final int LONGITUD = 10;
		int[] vector = new int[LONGITUD];
		
		leerVector(vector);
		System.out.println("Vector:");
		escribirVector(vector);
		
		int posMin = 0;
		int posMax = 0;
		int max = vector[0];
		int min = vector[0];
		
		for (int pos = 1; pos <vector.length; pos++) {
			if(vector[pos] < min) {
				min = vector[pos];
				posMin = pos;
			}
			if(vector[pos] >  max) {
				max = vector[pos];
				posMax = pos;
			}
		}
		System.out.println();
		System.out.println("Vector con mayor valor :"+max+ " y su posicion es la "+ posMax);
		System.out.println("Vector con menor valor :"+min+ " y su posicion es la "+ posMin);
	}

}
