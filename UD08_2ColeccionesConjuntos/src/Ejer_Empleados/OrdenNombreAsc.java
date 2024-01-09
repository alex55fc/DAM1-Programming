package Ejer_Empleados;

import java.util.Comparator;

public class OrdenNombreAsc implements Comparator<Empleados> {

	@Override
	public int compare(Empleados e1, Empleados e2) {
		String nom1 = e1.getNombre();
		String nom2 = e2.getNombre();
		return nom1.compareToIgnoreCase(nom2);
	}

}
