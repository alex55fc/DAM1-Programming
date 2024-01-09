package procedimientos_02;

import java.util.Scanner;

public class Sol_2_01 {
	
	public static void escribirTablaMultiplicar(int numero) {
		for (int a = 0; a <= 10; a++) {
			System.out.printf("%2d x %2d = %2d\n", a, numero, a*numero);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numero;
		Scanner teclado = new Scanner(System.in);
		System.out.print("¿Numero? ");
		numero = teclado.nextInt();
		if (numero > 0) {			
			System.out.println("Tabla de multiplicar del Numero " + numero);
			escribirTablaMultiplicar(numero);
		} else {
			System.out.println("El numero debe ser positivo");
		}
		
	}
	
	

}
