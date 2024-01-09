package Ejer_Empleados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Plantilla {

	//atributos
	private Set<Empleados> conjuntoEmpleados;

	//constructor
	public Plantilla() {
		this.conjuntoEmpleados = new LinkedHashSet<Empleados>();

	}
	// devuleve una lista con el conjunto de Empleados
	public List<Empleados> listaConjunto(){
		List<Empleados> listaAux = new ArrayList<>();
		listaAux.addAll(conjuntoEmpleados);
		return listaAux;
	}
	// devuleve un conjunto con el conjunto de Empleados
	public Set<Empleados> conjunto(){
		Set<Empleados> conjuntoAux = new LinkedHashSet<>();
		conjuntoAux.addAll(conjuntoEmpleados);
		return conjuntoAux;
	}


	//consultar DNi
	public boolean buscarPorDni(String dni) {
		for (Empleados p : conjuntoEmpleados) {
			if(p.getDni().equalsIgnoreCase(dni)){
				return true;
			}
		}
		return false;
	}
	//1-insertar
	public boolean insertarPordni(Empleados e) {
		return conjuntoEmpleados.add(e);
	}
	//2-CONJUNTO VACIO
	public boolean estaVacio() {
		return conjuntoEmpleados.isEmpty();
	}
	//2- devuelve una lista ordenada por nombre ascendente 
	public List<Empleados> ordenNombreAscendente(List<Empleados> listaAux){
		Collections.sort(listaAux, new OrdenNombreAsc());
		return listaAux;
	}
	//3- devuelve una lista ordenada por nombre ascendente 
	public List<Empleados> ordenPrecioDesc(List<Empleados> listaAux){
		Collections.sort(listaAux, new OrdenPrecioDesc());
		return listaAux;
	}
	//4-eliminar un Empledo por DNI
	public boolean eliminarUsuarioDni(String dni) {
		for(Empleados e : conjuntoEmpleados) {
			if(e.getDni().equals(dni)) {
				if (conjuntoEmpleados.remove(e)) {
					return true;
				}
			}
		}
		return false;
	}
	//5- 
	public List<Empleados> listaEmpleadosDepartamento(String departamento){
		List<Empleados> listaAux = new ArrayList<>();
		for(Empleados e : conjuntoEmpleados) {
			if(e.getDepartamento().equalsIgnoreCase(departamento)) {
				listaAux.add(e);
			}
		}
		return listaAux;
	}
	//6- 
	public List<Empleados> listaEmpleadosPorNombre(String nombre){
		List<Empleados> listaAux = new ArrayList<>();
		for(Empleados e : conjuntoEmpleados) {
			if(e.getNombre().contains(nombre)) {
				listaAux.add(e);
			}
		}
		return listaAux;
	}
	//8-
	/*hacemos un conjunto de departamento donde recorremos el conjunto de empleados y sacamos los departamentos
	y lo guardamos en un conjuntoDepartamento en minusculas, al usar un conjunto sabesmo que no habra departamentos repetidos*/
	public Set<String> obtenerDepartamento(){
		Set<String> conjuntoDepartamento = new HashSet<>();
		for(Empleados e : conjuntoEmpleados) {
			String departamento = e.getDepartamento().toLowerCase();
			conjuntoDepartamento.add(departamento);
		}
		return conjuntoDepartamento;
	}
	/*hacemos un string departamento que recorra el conjuntoDepartamentos y use el metodo auxiliar
	  luego creamos una lista intermedia que guarde el empleado que vuelve con el metodo consultarEmpleadosPorSalarioMax
	  y luego simplemente añadimos a la lista que devolveremos la listaEmpPorDepartAux */
	public List<Empleados> consultarEmpleadosPorDept(){
		Set<String> conjuntoDepartamento = new HashSet<>();
		List<Empleados> listaAux = new ArrayList<>();

		for(String departamento : conjuntoDepartamento) {
			List<Empleados>listaEmpPorDepartAux = consultarEmpleadosPorSalarioMax(departamento);
			listaAux.addAll(listaEmpPorDepartAux);
		}
		return listaAux;
	}
	//en este metodo guarda en una lista del salario maximo de un departamento 
	public List<Empleados> consultarEmpleadosPorSalarioMax(String departamento){
		double salarioMax = 0.0, salario;
		for(Empleados e : conjuntoEmpleados) {
			if(e.getDepartamento().equalsIgnoreCase(departamento) ){
				salario = e.getSalario();
				if(salario > salarioMax) {
					salarioMax = salario;
				}
			}
		}
		List<Empleados> listaAux = new ArrayList<>();
		for(Empleados e : conjuntoEmpleados) {
			if(e.getDepartamento().equalsIgnoreCase(departamento) && e.getSalario() == salarioMax) {
				listaAux.add(e);
			}
		}
		return listaAux;
	}
	
	
	//9-
	public List<Empleados>listaEmpleadosDepNomAsc(List<Empleados> listaAux){
		Collections.sort(listaAux, new OrdenDepNomAsc());
		return listaAux;
	}
	
	//11-
	public List<Empleados> incrementa5PorCienDeDepartamento(String departamento){
		List<Empleados> listaAux = new ArrayList<>();
		for(Empleados e : conjuntoEmpleados) {
			if(e.getDepartamento().equalsIgnoreCase(departamento)) {
				double num = e.getSalario();
				num = num +(num *0.05);
				e.setSalario(num);
				listaAux.add(e);
			}
		}
		return listaAux;
	}
	//12-

	//13-
	/*con el Iterador recorremos el conjunto  podemos eliminar mientras recorremos*/
	public int eliminarEmpleadoDepar(String departamento){
		int empleadosEliminados = 0;
		Iterator<Empleados> iterador = conjuntoEmpleados.iterator();
		while(iterador.hasNext()) {
			Empleados e = iterador.next();
			if(e.getDepartamento().equalsIgnoreCase(departamento))	{
				iterador.remove();
				empleadosEliminados++;
			}
		}
		return empleadosEliminados;
	}
	/*en esta recorremos con for each lo metemos dentro de una lista y luego eliminamos del conjunto los empleados de 
	 * la listaAux donde estan almacenados los empleados del departamento a eliminar*/
	public boolean eliminarEmpleadoDepar2(String departamento){
		List<Empleados> listaAux = new ArrayList<>();
		for (Empleados e : conjuntoEmpleados) {
			if(e.getDepartamento().equalsIgnoreCase(departamento))	{
				listaAux.add(e);
			}
		}
		return conjuntoEmpleados.removeAll(listaAux);
	}	

}
