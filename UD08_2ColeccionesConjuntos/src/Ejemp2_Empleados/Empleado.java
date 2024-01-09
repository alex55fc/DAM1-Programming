package Ejemp2_Empleados;

public class Empleado implements Comparable<Empleado> {

	private String dni;
	private String nombre; // nombres y apellidos
	private String departamento;
	private double salario;

	public Empleado(String dni, String nombre, 
					String departamento, double salario) {
		this.dni = dni;
		this.nombre = nombre;
		this.departamento = departamento;
		this.salario = salario;
	}

	@Override
	public String toString() {
		return 
			"Empleado [dni=" + dni + 
			", nombre=" + nombre + 
			", departamento=" + departamento +
			", salario=" + String.format("%.2f", salario) + 
			"]";
	}

	// Compara dos empleados por DNI
	@Override
	public int compareTo(Empleado otro) {
		return this.dni.compareToIgnoreCase(otro.dni);
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDepartamento() {
		return departamento;
	}

	public double getSalario() {
		return salario;
	}
	
	
	
}
