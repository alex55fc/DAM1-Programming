package Ejer_Empleados;

import java.util.Objects;

//preg double Double diferencia
public class Empleados {

	//atributos 
	private String dni; //identidicador 
	private String nombre;
	private String departamento;
	private double salario;

	//constructor
	public Empleados(String dni, String nombre, String departamento, double salario) {
		this.dni = dni;
		this.nombre = nombre;
		this.departamento = departamento;
		this.salario = salario;
	}

	//toString
	@Override
	public String toString() {
		return "Empleados [dni=" + dni + ", nombre=" + nombre + ", departamento=" + departamento + ", salario="
				+ String.format("%.2f", salario) + "]";
	}

	//hashcode & equals
	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Empleados)) {
			return false;
		}
		Empleados other = (Empleados) obj;
		return Objects.equals(dni, other.dni);
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getDepartamento() {
		return departamento;
	}
	/*
	public void incrementarSalario5PorCiento() {
		salario = (salario * 1.05);
		 
	}*/
	/*
	public int dniLength() {
		return dni.length();
	}*/

}
