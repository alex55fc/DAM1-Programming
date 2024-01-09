package Ejemplos;

import java.util.Random;

public class Ejem_random {

	public static void main(String[] args) {
		//instanciar un objeto de la clase random
		Random aleatorio = new Random();
		
		//generar un entero entre 20 y 30
		//formula= int numeroEnt = aleatorio.nextInt(maximo - minimo + 1) + minimo;
		int num = aleatorio.nextInt(30 - 20 +1 ) + 20;
		System.out.println("Entero entre 30 y 20: "+ num);
		
		//para no hacernos un lio declaramos variables y aplicamos 
		int min = -50;
		int max = 50;
		int num2 = aleatorio.nextInt(max - min +1) + min;
		System.out.println("Entero entre -50 y 50: "+ num2);
		
		
		
		
		// esta es la formula , la de las dos u ltimas lineas 
		int maximo = 0, minimo = 0;
		int anchuraIntervalo = maximo - minimo +1;
		System.out.println(aleatorio.nextInt(anchuraIntervalo) + minimo);
		
		//para numero enteros esta fromula
		double a = 2.5;
		double b = 12.5;
		double dato = aleatorio.nextDouble() * (b-a) + a;
		
		
		
		
		
		
		
		
		
		// en numero REALES no podemos + 1 en la fomula
		//double real = aleatorio.nextDouble(maximo - minimo) + minimo;
		//genear un real entre 25.6 y 37.8
		double real = aleatorio.nextDouble(37.8 - 25.6) + 25.6;
		System.out.println("Real entre 25.6 y 37.8: "+ real);
		
		// asi hacemos que el 37.8*
		double real2 = aleatorio.nextDouble(37.8 - 25.6) + 25.6;
		System.out.println("Real entre 25.6 y 37.8*: "+ real2);
		
		//MAth para el numero minimo maximo;
		Math.min(30, 23);
		System.out.println(Math.min(20, 30));
		
	}

}
