package funciones_01;

public class Ejer_1_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int BASE_LIMITE = 9;
		final int EXPONENTE_LIMTE = 6;
		int base, exponente, potencia;
		for (base = 1 ; base <= BASE_LIMITE ; base++) {
			for (exponente = 2 ; exponente <= EXPONENTE_LIMTE  ; exponente++) {
				potencia = elevar(base, exponente);
				System.out.printf("%d ^ %d = %6d, ", base, exponente, potencia);
			}
			System.out.println();
		}
	}
	
	public static int elevar (int base, int exponente) {
		int potencia = 1;
		while (exponente > 0) {
			potencia = potencia * base;
			exponente--;
			
		}
		return potencia;		
	}
	

}
