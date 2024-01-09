package Ejemplos;

public class Ejem_vector {

	public static void main(String[] args) {
/*		
		//Declarar un vector de 10 numero enteros 
		int[] vector;
		
		//Instanciar el vector con 10 posiciones(empieza a contar desde 0 las posiciones
		vector = new int[10];
		
		//instanciar y declarar en la misma linea
		int[] vector2 = new int[20];
		
		//instanciar y declarar en la misma linea vector reales
		double[] vectorReales = new double[12];
		
		//vector de cadenas
		//       nombre                     siempre positivo si no error
		String[] vectorCadenas = new String[3];
		
		//inicializar con unos valores concretos con {}, con relacion a su clase String = cadena caracteres " "
		 String[] nombres = {"Juan", "Maria", "Pablo", "Isabel"}; 
*/		
		
		//inicializar con unos valores concretos con {}, con relacion a su clase int = numero
		 int [] notas = {7, 8, 4, 3, 5, 10};
		 		 
		 //para mostrar los datos del vector lo recorremos, mostramos los datos de notas
		 //en notas.length no hay parentesis ya que es un atributo de notas
		 for (int pos = 0 ; pos < notas.length ; pos++) {
			 System.out.print(notas[pos] + " ");
		 }
		 System.out.println();
		 notas[0] = 9; // le da un valor a la posicion 0 que ahora sea 9
		 notas[1] = 9; // le da un valor a la posicion 1 que ahora sea 9
		 
		 for (int pos = 0 ; pos < notas.length ; pos++) {
			 System.out.print(notas[pos] + " ");
		 }
		

	}

}
