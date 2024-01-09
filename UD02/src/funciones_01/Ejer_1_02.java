package funciones_01;

public class Ejer_1_02 {

	public static void main(String[] args) {
		// 
		final int LIMITE = 20;
		int numero;
		
		System.out.println("Números Pares entre 1 y " + LIMITE + ": ");
		for (numero = 1 ; numero <= LIMITE ; numero++) {
			if (esPar(numero)) {
				System.out.print(numero + " ");
			}
		}
		System.out.println();
		
		System.out.println("Número Múltiplos de 3 entre 1 y " + LIMITE + ": ");
		for (numero = 1 ; numero <= LIMITE ; numero++) {
			if (esMultiplo(numero, 3)) {
				System.out.print(numero + " ");
			}
		}
		System.out.println();
		
		System.out.println("Números Multiplos de 5 entre 1 y "+ LIMITE + ":");
		for (numero = 1 ; numero <= LIMITE ; numero++) {
			if (esMultiplo(numero, 5)) {
				System.out.print(numero + " ");
			}
		}
		System.out.println();
	}
	

	public static boolean esPar(int numero) {
		if (numero %2 == 0) {
			return true;
		}
		else {
			return false;
		}
}
	public static boolean esMultiplo (int dividendo, int divisor) {
		if (dividendo % divisor == 0) {
			return true;
		}
		else {
			return false;
		}
	}
}
