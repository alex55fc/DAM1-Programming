package vectores_01;

import java.util.Random;

public class Ejer_1_05 {
	// este modo de devolver el vector es otra forma de hacerlo, la otra es solo con
	//un public static void generarVectorAleatorio( int[] vector); hecho en anteriores ejercicios
	public static int[] generarVectorAleatorio(int longitud, int minimo, int maximo) {
		
		int[] vector = new int[longitud];
		Random aleatorio = new Random();
		int anchuraIntervalo =(maximo-minimo +1);
		for (int pos = 0; pos < vector.length; pos++) {
			vector[pos] = aleatorio.nextInt(anchuraIntervalo) + minimo;
		}
		return vector;
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
		final int LONGITUD = 8;
		int[] vectorA = generarVectorAleatorio(LONGITUD,1,5);
		int[] vectorB = generarVectorAleatorio(LONGITUD,1,5);
		
		System.out.println("VECTOR A");
		escribirVector(vectorA);
		
		System.out.println("VECTOR B");
		escribirVector(vectorB);
		
		for (int posA = 0; posA < vectorA.length ; posA++) {
			int contador = 0; // este contador lo usaremos para cuando el vectoA[posA] sea igual vectorB[posB]
			//asi recorre toda eol vectorB buscando q coincidsa el vectorA[posA] y cuando coincide suma el contador
			for(int posB = 0; posB < vectorA.length ; posB++) {
				if(vectorA[posA] == vectorB[posB]) {
					contador++;
				}
			}
			System.out.println("El elemento en la posicion "+ posA +" aparece "+ contador +" veces  en el vector B");
		}

	}

}
