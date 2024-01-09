package Ejer_empleados_prof;

import java.util.Comparator;

public class OrdenEmpleadoPorDepartamentoAscYNombreAsc
	implements Comparator<Empleado> {

	@Override
	public int compare(Empleado e1, Empleado e2) {
		String dep1 = e1.getDepartamento();
		String dep2 = e2.getDepartamento();
		if (dep1.equalsIgnoreCase(dep2)) {
			String nombre1 = e1.getNombre();
			String nombre2 = e2.getNombre();
			return nombre1.compareToIgnoreCase(nombre2);
		}
		else {
			return dep1.compareToIgnoreCase(dep2);
		}
	}
	
}
