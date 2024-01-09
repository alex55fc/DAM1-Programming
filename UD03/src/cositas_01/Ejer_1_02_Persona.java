package cositas_01;

import entrada.Teclado;

public class Ejer_1_02_Persona {

	public static void main(String[] args) {
		
		String nombre, apellidos;
		int altura;
		boolean trabajo;
		
		System.out.println("PERSONA 1");
		nombre = Teclado.leerCadena("¿Nombre? ");
		apellidos = Teclado.leerCadena("¿Apellidos? ");
		altura = Teclado.leerNatural("¿Altura? ");
		trabajo = Teclado.leerBooleano("Esta en activo? ");
		
		Persona persona1 = new Persona(nombre, apellidos, altura, trabajo);
		System.out.println(persona1.obtenerEstado());
		
		System.out.println("PERSONA 2");
		nombre = Teclado.leerCadena("¿Nombre? ");
		apellidos = Teclado.leerCadena("¿Apellidos? ");
		altura = Teclado.leerNatural("¿Altura? ");
		
		Persona persona2 = new Persona(nombre, apellidos, altura);
		System.out.println(persona2.obtenerEstado());
		
		System.out.println("PERSONA 3");
		
		Persona persona3 = new Persona();
		System.out.println(persona3.obtenerEstado());

	}

}
