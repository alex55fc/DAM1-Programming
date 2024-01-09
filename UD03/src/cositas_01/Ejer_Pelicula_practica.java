package cositas_01;

import entrada.Teclado;

public class Ejer_Pelicula_practica {
	
	//Lee una película por teclado.
	public static Pelicula leerPelicula() {
		//static usa el nombre de la clase;
		
		String nombre = Teclado.leerCadena("Introduce un nombre: ");
		int duracion = Teclado.leerNatural("Introducir una duracion ");	
		boolean dobladaCastellano = Teclado.leerBooleano("Esta doblada al castellano? ");
		double puntuacion = Teclado.leerReal("Introduce la puntutacion: ");
		Pelicula pelicula = new Pelicula(nombre, duracion, dobladaCastellano, puntuacion);
		
		return pelicula;
	}

	public static void main(String[] args) {
		
		/*Pelicula pelicula1 = new Pelicula();
		System.out.println(pelicula1.getNombre());
		System.out.println(pelicula1.getDuracion());
		System.out.println(pelicula1.getDobladaCastellano());
		System.out.println(pelicula1.getPuntuacion());
		
		pelicula1.setNombre("El señor de los Anillos : El retorno del rey");
		pelicula1.setDuracion(205);
		pelicula1.setDobladaCastellano(true);
		pelicula1.setPuntuacion(9.7);
		
		System.out.println(pelicula1.getNombre());
		System.out.println(pelicula1.getDuracion());
		System.out.println(pelicula1.getDobladaCastellano());
		System.out.println(pelicula1.getPuntuacion());*/
		
		
		Pelicula peli = leerPelicula();			
		System.out.println(peli.obtenerEstado());
		
	}
	

}
