package Ejemplos;

public class metodos_de_objeto_String {

	public static void main(String[] args) {
	 
		// int length()
		/*nos da la longitud total con espacios incluidos, devuelve dicho valor en numero */
		String frase1 = "Hola loco";
		System.out.println("longitud frase " + frase1.length());;
		
		System.out.println();
		// char charAt(int posicionQueBuscamos) 
		/*devuelve la poosicion que indicamos siempre con un INT.
		 * hay que tener en cuenta que el rango de la frase debe ser desde 0 porque charAt empieza a 
		 * contar por 0 hasta su longitud total (int length() -1{ya que int length() cuenta empezando por 
		 * el 1 entonce si contamos hola tiene longitud 4 con int legth pero con el charAt cuenta 0 1 2 3 hasta la 3 posicion */
		String frase2 = "como lo sabes";
		System.out.println("posicion 4: "+ frase2.charAt(4)); // posicion en vacio
		System.out.println("posicion 5: "+ frase2.charAt(5));
		
		System.out.println();
		// int indexOf(char caracter)
		//nos devuelve la posicion del primer caracter marcado en la frase,
		String frase3 = "Quiero patatas bravas";
		System.out.println("posicion done hay una 'o' que sera la 5: "+ frase3.indexOf('o'));
		
		System.out.println();
		// string toUpperCase()
		/*Devuelve la frase en Mayusculas(tambien cuenta la Ñ)
		 * string toLowerCase()
		 * Devuelve la frase en minuculas(tamben cuenta la ñ)*/
		String frase4 = "hacer Mayusculas";
		System.out.println(frase4.toUpperCase());
		String frase5 = "HACER mINUSCULAS";
		System.out.println(frase5.toLowerCase());
		
		System.out.println();
		//String substring(int posicionInicial, int posicionFinal)
		/*se utiliza para obtener una subcadena de una cadena de texto. La subcadena comienza 
		 * en la posición posicionInicial y termina en la posición anterior a la posicionFinal */
		String frase6 = "Hola mundo";
		System.out.println("visualiza Hola: "+ frase6.substring(0,5));
		
		System.out.println();
		//String trim()
		/* eleminna los espacios en blancos del string por delate y por detras */
		String frase7 = "   Espacios en blanco   ";
		System.out.println( frase7);
		System.out.println(frase7.trim());
		
		System.out.println();
		//String replace (char caracterBuscar, char caracterRemplazo
		/*busca en un string el caracter que queremos sustituir y lo sustituye por el que pongamso en el metodo*/
		String frase8 = "hola jaja";
		System.out.println(frase8+ "Sustituimos la h por una B");
		System.out.println(frase8.replace('h','B'));
	}

}
