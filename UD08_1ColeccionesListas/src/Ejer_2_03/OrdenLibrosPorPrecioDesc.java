package Ejer_2_03;

import java.util.Comparator;

public class OrdenLibrosPorPrecioDesc implements Comparator <Libro>{

	@Override
	public int compare(Libro libro1, Libro libro2) {
		Double precio1 = libro1.getPrecio();
		Double precio2 = libro2.getPrecio();
		return precio2.compareTo(precio1);
	}

	
}
