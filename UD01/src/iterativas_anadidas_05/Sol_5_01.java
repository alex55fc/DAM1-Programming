package iterativas_anadidas_05;
import java.util.Scanner;

public class Sol_5_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int altura, anchura, i, j;
		boolean dimensionesValidas;
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Altura del rectángulo ");
		altura = teclado.nextInt();
		System.out.print("¿Anchura del rectangulo? ");
		anchura = teclado.nextInt();
		
		dimensionesValidas = true;
		if (altura <= 0) {
			System.out.println("La altura del rectangulo debe ser positiva");
			dimensionesValidas = false;
		}
		if (dimensionesValidas) {
			//cada linea 
			for ( i = 1 ; i <= altura ; i++) { // aqui estamos en la primera linea	
// i coge el valor 1 y al ser <= a la altura(valor q da el usuario) hace la primer asterisco 
// y luego pasa al siguiente for
				// para cada columna
				for (j = 1 ; j <= anchura ; j++) { // aqui hacemos la anchura de asterisco
// j coge valor 1 y al ser <= anchura (valor q da el usuario) hace un asterisco y vuelve a repetir este for
					System.out.print('*'); // una vez que i sea mayor que altura pasa a la siguiete linea y se repite el bucle 
				}
				System.out.println();
			}
		}
	}

}
