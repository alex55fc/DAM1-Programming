package Ejer_Empleados;

import java.util.Comparator;

public class OrdenPrecioDesc implements Comparator<Empleados>{

	@Override
	public int compare(Empleados e1, Empleados e2) {
		Double precio1 = e1.getSalario();
		Double precio2 = e2.getSalario();
		return precio2.compareTo(precio1);
	}

}
