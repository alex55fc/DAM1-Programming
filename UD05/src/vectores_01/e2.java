package vectores_01;

import entrada.Teclado;

public class e2 {
	public static void leerVector(int[]vector) {
		for(int pos= 0; pos < vector.length; pos++) {
			vector[pos] = Teclado.leerEntero("Numero entero "+ pos+":");	
		}
	}

	
	public static void escribirVector(int[]vector) {
		System.out.print("[");
		for(int pos= 0; pos < vector.length; pos++) {
			System.out.print(vector[pos]);
			if (pos != vector.length -1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}
	public static void main(String[] args) {
	final int LONGITUD = 10;
	int[] vectorA = new int[LONGITUD];
	int[] vectorB = new int[LONGITUD];
	
	System.out.println("VECTOR A");
	leerVector(vectorA);
	System.out.println();
	
	System.out.println("VECTOR B");
	leerVector(vectorB);
	
	System.out.println("VECTOR A");
	escribirVector(vectorA);
	
	System.out.println("VECTOR B");
	escribirVector(vectorB);
	
	int [] vectorSuma = new int[LONGITUD];
	for(int pos = 0; pos < vectorSuma.length ; pos++) {
		vectorSuma[pos] = vectorA[pos] + vectorB[pos];
		
	}
	int [] vectorProducto = new int [LONGITUD];
	for (int pos = 0; pos < vectorProducto.length ; pos++) {
		vectorProducto[pos] = vectorA[pos] * vectorB[pos];
	}
	System.out.println("VECTOR SUMA	");
	escribirVector(vectorSuma);
	System.out.println("VECTOR PRODUCTO");
	escribirVector(vectorProducto);
	
	}
	

}
