package iterativas_04;

public class Ejer_4_04_C {

	public static void main(String[] args) {
		// 
		int contador = 1, suma = 0;
		
		while (contador <= 50) {
			suma = suma + contador;
			System.out.println(suma);
			contador++;
		}
		System.out.println("suma total =" + suma);
	}

}
