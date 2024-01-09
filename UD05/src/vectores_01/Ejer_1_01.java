package vectores_01;

import entrada.Teclado;

public class Ejer_1_01 {
	// por q es public static void
	public static void leerVector(int[] vector) {
		for (int pos = 0 ; pos < vector.length ; pos++) {
			vector[pos] = Teclado.leerEntero("¿Numero Entero "+ pos + "?");
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
		System.out.print("]");
	}
	
	public static void main(String[] args) {
		final int LONGITUD = 10;
		// int [] = vector de enteros, double[] = vector de 
		int[] vector = new int[LONGITUD];
		
		leerVector(vector);
		System.err.println("VECTOR:");
		escribirVector(vector);
		
		int minimo = vector[0];
		int posicionMinimo = 0;
		int maximo = vector[0];
		int posicionMaximo = 0;
		
		//ponemos la pos = 1 ya que en la pos = 0 estamos comparando el vector[pos0] con la pos 0 y es lo mismo, es comparar los mismo,
		// por lo q ponerlo no cambia nada solo hace una comparacion demas.
		for (int pos = 1 ; pos < vector.length ; pos++) {
			if (vector[pos] < minimo){
				minimo = vector[pos];
				posicionMinimo = pos;
			}
			if (vector[pos] > maximo) {
				maximo = vector[pos];
				posicionMaximo = pos;
			}

		}
		System.out.println();
		System.out.println("Minimo "+ minimo);
		System.out.println("Primera posicion del minimo"+ posicionMinimo);
		System.out.println("Maximo "+ maximo);
		System.out.println("Primera posicion del maximo"+ posicionMaximo);
	}

}
