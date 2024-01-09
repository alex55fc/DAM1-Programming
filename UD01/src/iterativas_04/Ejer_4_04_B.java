package iterativas_04;

public class Ejer_4_04_B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int contador = 1, suma = 0;
		
		do {
			suma = suma + contador;
			System.out.println(suma);
			contador++;
		}while (contador <= 50);
		System.out.println("Total suma= "+ suma);
	}
}
