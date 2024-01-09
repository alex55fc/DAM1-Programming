package Ejemplos;

public class Ejem_CuentaRegresiva {

	public static void main(String[] args) {
		// Hacer una cuenta regresiva desde 100 hasta 20 restando 5 cada rato
		
		for (int num = 100 ;  num >= 20 ; num = num -5 ) {
			System.out.println(num);
		}
	}

}
