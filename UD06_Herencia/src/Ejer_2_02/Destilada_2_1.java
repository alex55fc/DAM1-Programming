package Ejer_2_02;

import java.util.Random;

public class Destilada_2_1 extends Alcoholica_2_0{
	//atributo estativo
	protected static final String [] NOMBRES = {
			"anís", "pacharán", "ginebra", "cognac",
			"ron", "vodka", "hisky","tequila"
	};

	//constructor 
	public Destilada_2_1(String nombre, double graduacion) {
		super(nombre, graduacion);
	}

	@Override
	public String toString() {
		return "Fermentada_2 [ codigo=" + codigo +  
				", nombre=" + nombre + ", graduacion "+  String.format(".1f", graduacion) +"]";
	}

	@Override
	public double calcularPrecio() {
		return 12+ (graduacion / 10) ;
	}
	//-------------------------------------------------------------------------------------------------------------------------------------
	//constructor de parametros con forma aleatoria
	public Destilada_2_1() {
		super(generarNombre(),generarGraduacion());
	}
	public static String generarNombre() {
		Random aleatorio = new Random();
		return NOMBRES[aleatorio.nextInt(NOMBRES.length)];
	}

	public static double generarGraduacion() {
		Random aleatorio = new Random();
		int max = 45, min = 15;
		return aleatorio.nextInt(max - min + 1)+ min ;// entre 15 y 45
	}
	//-------------------------------------------------------------------------------------------------------------------------------------


}
