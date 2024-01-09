package Ejemp1_Turismo;

import java.util.Comparator;

public class OrdenTurismoPorPrecioDesc implements Comparator<Turismo> {

	@Override
	public int compare(Turismo t1, Turismo t2) {
		Double precio1 = t1.getPrecio();
		Double precio2 = t2.getPrecio();
		return precio2.compareTo(precio1);
	}

}
