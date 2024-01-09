import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejer_1_01 {

	//Devuelve una cadena de caracteres leida desde teclado
	//Lanza una excepcion de entrada/salida si ocurre un erro en la lectura
	public static String solicitarCadena(String mensaje) throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader teclado = new BufferedReader(isr);
		//con este print es la unica forma d mostrar en pantalla 
		System.out.print(mensaje);
		String cadena = "";
		cadena = teclado.readLine(); //este metodo lee un String

		return cadena;
	}
	//numberFormateException
	public static short solicitarEnteroCorto(String mensaje,int numMaxErrores) throws IOException {
		short num = 0;
		int contador = 0;
		boolean error = true;//iniciamnos un boolean a true para poder entrar al bucle while
		String cadena = "";
		while(error && contador <= numMaxErrores  ) {
			try {
				cadena = solicitarCadena(mensaje); //esta cadena se la envio a solicitarCadena para que lea una linea por teclado con readLine();
				num = Short.parseShort(cadena); /* de este modo tranformamos la cadena de texto donde tiene que haber un short a un short xd, el 
				problema es que en la cadena de texto puede haber datos que no sean short y puede saltar error numberFormateException, este error no se propaga con un throws se propaga solo*/
				//si al tranformar una cadena a short salta un error por ejemplo NumberFormatException no leerea el error = false e ira directo al catch NumberFormatException
				error = false;
			}
			catch(NumberFormatException nfe){
				contador++;
				System.err.println("El dato introducido no tiene formato de número entero corto.");
				System.out.println(nfe.toString());
				System.out.println("Error numero "+ contador);
			}		
		}
		if (contador > numMaxErrores) {
			System.out.println("Se ha superado el número de errores permitidos, que es "+ numMaxErrores);
			// num = 0 no es necesario ya que si ocurre un error en la transformacion de string a short no se asigna el valor por lo q num sera 0;
		}

		return num;
	}


	public static void main(String[] args) {
		
		try {
			short dividendo = solicitarEnteroCorto("¿dividendo? ", 3);
			short divisor = solicitarEnteroCorto("¿dividendo? ", 3);
			
			if ( dividendo % divisor == 0) {
				System.out.println("es divisible entre");
			}
			else {
				System.out.println(" no es divisible entr ");
			}
			System.out.println("Cociente "+ (dividendo / divisor));
			System.out.println("Resto "+ (dividendo % divisor));

		}
		catch(ArithmeticException ae){
			System.out.println("Error aritmetico");
			System.out.println(ae.toString());
		}
		catch(IOException ioe) {
			System.out.println("Se ha producido un erro de entrada/salida");
			System.out.println(ioe.toString());
		}

	}

}
