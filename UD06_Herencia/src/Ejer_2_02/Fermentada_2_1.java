package Ejer_2_02;

import java.util.Random;

public class Fermentada_2_1 extends Alcoholica_2_0 {
	
	//atributo estatico
	protected static final String[] NOMBRES = {
			 "sidra", "cerveza", "vino", "sake","hidromiel"
	};
	//constructor
	public Fermentada_2_1(String nombre, double graduacion) {
		super(nombre,graduacion );
	}

	@Override
	public String toString() {
		return "Fermentada_2 [ codigo=" + codigo +  
				", nombre=" + nombre + ", graduacion "+  String.format(".1f", graduacion) +"]";
	}

	//metodo heredado, como heredamos atributos podemos usar el atributo directamente y no con un getter(si fuera private)
	@Override
	public double calcularPrecio() {
		return 5+(graduacion / 10) ;
	}
	
	//-------------------------------------------------------------------------------------------------------------------------------------
	//constructor de parametros con forma aleatoria
	public Fermentada_2_1() {
		super(generarNombre(),generarGraduacion());
			
	}
	public static String generarNombre() {
		Random aleatorio = new Random();
		return NOMBRES[aleatorio.nextInt(NOMBRES.length)];
	}
	
	public static double generarGraduacion() {
		Random aleatorio = new Random();
		return aleatorio.nextDouble() * (15-3.5) + 3.5;// entre 3,5 y 15
	}
	//-------------------------------------------------------------------------------------------------------------------------------------
	
	
}
