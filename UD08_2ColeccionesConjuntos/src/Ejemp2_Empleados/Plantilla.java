package Ejemp2_Empleados;

import java.util.Set;
import java.util.TreeSet;

public class Plantilla {

	private Set<Empleado> conjuntoEmpleados;

	public Plantilla() {
		this.conjuntoEmpleados = new TreeSet<Empleado>();
	}
	
	public boolean insertar(Empleado empleado) {
		return conjuntoEmpleados.add(empleado);
	}
	
	public boolean buscarPorDni(String dni) {
		//Empleado empleado = new Empleado(dni,"",0);
		//return conjuntoEmpleados.contains(empleado);
		for (Empleado emp : conjuntoEmpleados) {
			if (emp.getDni().equals(dni)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean estaVacia() {
		return conjuntoEmpleados.isEmpty();
	}
	
	public Set<Empleado> obtenerEmpleados() {
		return conjuntoEmpleados;
	}
	
	
	
	
	
}
