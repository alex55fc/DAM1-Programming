package Ejer_empleados_prof;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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
	
	public List<Empleado> ordenarPorDepartamentoYNombreAsc() {
		List<Empleado> listaEmpleadosAux = new ArrayList<>();
		listaEmpleadosAux.addAll(conjuntoEmpleados);
		Collections.sort(listaEmpleadosAux, 
				new OrdenEmpleadoPorDepartamentoAscYNombreAsc());
		return listaEmpleadosAux;
	}
	
	private List<Empleado> consultarEmpleadosPorSalarioMax(String departamento) {
		double salarioMaximo = 0.0, salario;
		for (Empleado emp : conjuntoEmpleados) {
			if (emp.getDepartamento().equalsIgnoreCase(departamento)) {
				salario = emp.getSalario();
				if (salario > salarioMaximo) {
					salarioMaximo = salario;
				}
			}
		}
		List<Empleado> lista = new ArrayList<Empleado>();
		for (Empleado emp : conjuntoEmpleados) {
			if (emp.getDepartamento().equalsIgnoreCase(departamento) &&
					emp.getSalario() == salarioMaximo) {
				lista.add(emp);
			}
		}
		return lista;
	}
	
	private Set<String> obtenerDepartamentos() {
		Set<String> conjuntoDepartamentos = new HashSet<String>();
		for (Empleado emp : conjuntoEmpleados) {
			String departamento = emp.getDepartamento().toLowerCase();
			conjuntoDepartamentos.add(departamento);
		}
		return conjuntoDepartamentos;
	}
	
	public List<Empleado> consultarEmpleadosPorDept() {
		Set<String> conjuntoDepartamentos = obtenerDepartamentos();
		List<Empleado> listaEmpleados = new ArrayList<Empleado>();
		for (String departamento : conjuntoDepartamentos) {
			List<Empleado> listaEmpPorDepartAux = 
					consultarEmpleadosPorSalarioMax(departamento);
			listaEmpleados.addAll(listaEmpPorDepartAux);
		}
		return listaEmpleados;
	}
	
	public int eliminarEmpleadosPorDepartamento(String departamento) {
		Iterator<Empleado> iterador = conjuntoEmpleados.iterator();
		int empleadosEliminados = 0;
		while (iterador.hasNext()) {
			Empleado emp = iterador.next();
			if (emp.getDepartamento().equalsIgnoreCase(departamento)) {
				iterador.remove();
				empleadosEliminados++;
			}
		}
		return empleadosEliminados;
	}
	
	public boolean eliminarEmpleadosPorDepartamento2(String departamento) {
		List<Empleado> empleadosBorrar = new ArrayList<Empleado>();
		for (Empleado emp : conjuntoEmpleados) {
			if (emp.getDepartamento().equalsIgnoreCase(departamento)) {
				empleadosBorrar.add(emp);
			}
		}
		return conjuntoEmpleados.removeAll(empleadosBorrar);
	}
	
}





