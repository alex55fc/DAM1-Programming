package funciones_01;

import java.util.Scanner;

public class Ejer_1_06 {
	public static int contarNumerosDivisores(int num) {
		int contador, contadorDivisores = 0;
		for (contador = 1 ; contador <= num ; contador++) {			
			if ( num % contador == 0) {						
				contadorDivisores++;
			}
		}
		return contadorDivisores;		
	}
	
	public static boolean esPrimo(int num1) {
		int divisores;
		divisores = contarNumerosDivisores(num1);
		 if (divisores == 2) {
			 return true;
		 }
		 else {
			 return false;
		 }
	}

	public static void main(String[] args) {
		int numInicial, numFinal, contador = 0;
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("¿Número inicial? ");
		numInicial = teclado.nextInt();
		System.out.print("¿Número final? ");
		numFinal = teclado.nextInt();
		
//introducimos a = numeroInicial, para que empieze el bucle desde el númeroInicial
// y asi no empieze desde un valor numInicial = 1, ya que asi empieza a contar desde 1 no el numInical
		for (int a = numInicial ; numInicial <= numFinal; numInicial++) {
			if(esPrimo(numInicial)) {
				System.out.print(numInicial + " ");
				contador++;
			}
		}
		System.out.println();
		System.out.println("Número de primos: "+ contador);
		
	}
		

}
