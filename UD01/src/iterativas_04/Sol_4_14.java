package iterativas_04;

import java.util.Scanner;

public class Sol_4_14 {

	public static void main(String[] args) {
		// bien hecho 
		final int NUMERO_SECRETO = 19;
		final int NUMERO_INTENTO = 5;
		int contador = 0, numero;
		boolean acierto = false;
		Scanner teclado = new Scanner(System.in);
			
	while (contador < NUMERO_INTENTO && !acierto) {
			System.out.print("¿Numero? ");
			numero = teclado.nextInt();
			
			if (numero == NUMERO_SECRETO) {
				System.out.println("Has acertado el numero secreto");
				acierto = true;
			}
			else {
				System.out.println("Has fallado el número secreto.");
				if (numero < NUMERO_SECRETO) {
					System.out.println("El número " + numero + " es menor que el número secreto.");
				}
				else {
					System.out.println("El número " + numero + " es mayor que el número secreto.");
				}
			}
			contador++;
		}
		if (contador == NUMERO_INTENTO && acierto == false) {
			System.out.println("Has agotado los " + NUMERO_INTENTO + " intentos.");
		}
	}

}
