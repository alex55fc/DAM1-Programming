package Ejer_examen;

import java.util.Random;

public class Producto {
	private int codigo;
	private String nombre;
	private int diasParaCaducar;
	private static int total = 0;

	public String getNombre() {
		return nombre;
	}


	public int getDiasParaCaducar() {
		return diasParaCaducar;
	}
	


	public int getCodigo() {
		return codigo;
	}

	@Override
	public String toString() {
		return "Producto [Codigo = " + codigo + ", Nombre = " + nombre + " ,DiasParaCaducar = " + diasParaCaducar + "]";
	}
	
	public static String pasoLetras(int letras) {    
		String numCadena="";
		for(int i =0;i<letras;i++) {
			Random ale = new Random();
			int numero = ale.nextInt(97,123);
			char caracter = (char) numero;
			numCadena+=caracter;
		}
		
		return numCadena;
	}
	
	public Producto ( String nombre, int diasParaCaducar) {
		total++;
		this.codigo = total;
		this.nombre = nombre;
		this.diasParaCaducar = diasParaCaducar;
	}
	
	public boolean caducado() {
		if (diasParaCaducar < 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	
	

}
