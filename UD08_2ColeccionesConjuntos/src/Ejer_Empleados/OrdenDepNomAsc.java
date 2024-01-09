package Ejer_Empleados;

import java.util.Comparator;

public class OrdenDepNomAsc implements Comparator<Empleados> {

	@Override
	public int compare(Empleados e1, Empleados e2) {
		String dep1 = e1.getDepartamento();
		String dep2 = e2.getDepartamento();
		
		if (dep1.equalsIgnoreCase(dep2)) {
			String  nom1 = e1.getNombre();
			String  nom2 = e2.getNombre();
			return nom1.compareToIgnoreCase(nom2);
		}
		else {
			return dep1.compareToIgnoreCase(dep2);
		}
		
	}

}
