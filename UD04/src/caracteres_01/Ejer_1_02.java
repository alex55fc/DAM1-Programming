package caracteres_01;

import entrada.Teclado;

public class Ejer_1_02 {
	public static boolean esLetraMinuscula(char caracter) {
		//asi se pone para elegir entre dos opciones
		if ((caracter >= 'a' && caracter <= 'z') || caracter == 'ñ') {
			return true;
		}
		else {
			return false;
		}
	}
	public static boolean esLetraMayuscula(char caracter) {
		//asi se pone para elegir entre dos opciones
		if ((caracter >= 'A' && caracter <= 'Z') || caracter == 'Ñ') {
			return true;
		}
		else {
			return false;
		}
	}
 // para casos como ñ o letras con acento hay que hacer un caso aparte ya que esta situado en otro orden en la tabla ASCII
	
	public static void main(String[] args) {
		char caracter = Teclado.leerCaracter("¿Carácter? ");
		if (esLetraMinuscula(caracter)) {
			System.out.println("El caracter "+ caracter + " es minuscula");
		}
		else if (esLetraMayuscula(caracter)) {
			System.out.println("El caracter "+ caracter + " es mayuscula");
		}
		else {
			System.out.println("El caracter	"+ caracter + " no es una letra");
		}

	}

}
