package iterativas_04;
import java.util.Scanner;

public class Ejer_4_07_A {

	public static void main(String[] args) {
		// hay que hacer que lea por teclado 10 nums enteros y 
		// que visualice el menor y el mayor de ellos.
		// para eso al primer número que pongamos le daremos el valor min y max a la vez;
		// y lo compararemos con los siguientes todo el rato, asi se hace.
		final int LIMITE = 9;
		int num, numMin, numMax, contador = 0;
		Scanner teclado = new Scanner (System.in);
		
		System.out.print("¿Número entero " + contador + "?");
		num = teclado.nextInt();
		contador ++;
		numMin = num;
		numMax = num;
		
		while (contador <= LIMITE) {
			System.out.print("¿Número entero " + contador + "?");
			num = teclado.nextInt();
			contador ++;
		if (num < numMin) {
			numMin = num;
		}
		if (num > numMax){
			numMax = num;
		}
		}
		System.out.println("Mínimo " + numMin);
		System.out.print("Máximo " + numMax);
	}

}
