package iterativas_04;

public class Ejer_4_12 {

	public static void main(String[] args) {
		// visualizar ejemplo con su fórmula y quede igual sin usar introducir teclado
		final int LIMITE = 100;
		int num = -20;
		double fahren, kelvin;

		System.out.println("Celsius  Fahrenheit  Kelvin");
		
		while (num <= LIMITE) {	
			fahren = num * 1.8 + 32;
			kelvin = num + 273.15;
			System.out.printf("    %3d         %3.0f     %3.0f\n", num, fahren, kelvin );
			num = num +10;
		}


	}

}
