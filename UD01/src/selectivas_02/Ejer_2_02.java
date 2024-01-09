package selectivas_02;

import java.util.Scanner;

public class Ejer_2_02 {

	public static void main(String[] args) {
		// 
		int num;
		Scanner teclado = new Scanner(System.in);
// if el primero, luego else if y por ultimo el else.
// funciona si no cumple la `primera funcion pasa a la siguiente y asi hasta el else 
// else tiene que ir solo, si no da error, ademas de que else demuestra el resto de posibilidades
		System.out.print("Introduce un número entero: ");
		num = teclado.nextInt();

		if (num > 0) {
			System.out.print("El numero es positivo");
		}
		else if (num < 0) {
			System.out.print("El número es negativo");
		}		
		else {
			System.out.print("El número es neutro");
		}
	}

}
