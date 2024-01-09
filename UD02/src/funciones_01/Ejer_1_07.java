package funciones_01;

public class Ejer_1_07 {

	public static void main(String[] args) {

		for (int a = 1; a <= 10000; a++) {
			if (esPerfecto(a)) {
				System.out.println("El numero " + a + " es perfecto.");
			}
		}
	}
	
	public static boolean esPerfecto(int numero) {
		int suma = 0;
		for (int a = 1; a < numero; a++) {
			if (numero % a == 0) {
				suma = suma + a;
			}
		}
		
		if (suma == numero) {			
			return true;
		} else {
			return false;
		}
	}

}
