package repaso_de_ejercicios;

import entrada.Teclado;

public class cadena_car_ejer2_07 {
	public static String longitudMinMax(int minima,int maxima, String mensaje) {
		String frase = Teclado.leerCadena(mensaje);

		while (frase.length() < minima || frase.length() > maxima) {
			System.out.println("La longitud debe estar comprendida entre "+ minima + " y "+ maxima);
			frase = Teclado.leerCadena(mensaje);
		}
		return frase;
	}

	public static void main(String[] args) {
		String frase = longitudMinMax(2, 60, "Rotaciona la derecha: ");

		//rotacion derecha
		for (int posicion = 0 ; posicion < frase.length() ; posicion++) {
			System.out.println(frase);
			
			char caracter = frase.charAt(frase.length() -1);
			//explicar el ultimo frase.length -1, porque era el -1 y porq no dejarlo sin mas por el substring
			String restoFrase = frase.substring(0 , frase.length() - 1);
			
			frase = caracter + restoFrase;
		}
		
		//rotacion izquierda
		System.out.println("Rotacion a la izquierda: ");
		for (int posicion1 = 0 ; posicion1 < frase.length() ; posicion1++) {
			System.out.println(frase);
			
			char caracter1 = frase.charAt(0);
			String restoFrase1 = frase.substring(1, frase.length());
			
			frase = restoFrase1 + caracter1;
		}
	}

}
