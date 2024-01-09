package Ejemplos;

import entrada.Teclado;


public class PruebaTecladoJava {

	public static void main(String[] args) {
		
		boolean continuar = Teclado.leerBooleano("¿Quieres continuar?");	
		int natural = Teclado.leerNatural("Introduce un número natural");
		int entero = Teclado.leerEntero("Introduce un númeroo entero: ");
		double precio = Teclado.leerReal("Cuanto compraste?");
		char diaSemana = Teclado.leerCaracter("Que dia es hoy (LMXJVSD)? ");
		String frase = Teclado.leerCadena("Dime una frase ");
			

		System.out.println("Resumen de tus respuestas: ");
		System.out.println("continuar " + continuar);
		System.out.println("Natural : "+ natural);
		System.out.println("Entero :" + entero);
		System.out.println("compre: "+ precio);
		System.out.println("Dia " + diaSemana);
		System.out.println("Frase: " + frase);
	}

}
