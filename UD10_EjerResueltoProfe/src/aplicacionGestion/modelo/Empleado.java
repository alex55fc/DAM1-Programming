package aplicacionGestion.modelo;

import java.util.Objects;

public class Empleado {
	private int codigo;
	private String nombre;
	private String fechaAlta;
	private double salario;
	private Departamento departamento;
	
	public Empleado(int codigo, String nombre, String fechaAlta, double salario, Departamento departamento) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.fechaAlta = fechaAlta;
		this.salario = salario;
		this.departamento = departamento; 
	}
	
	
	/**
	 * CONSTRUCTOR SIN CODIGO COMO PARAMETRO
	 * @param nombre
	 * @param fechaAlta
	 * @param salario
	 * @param codigoDepartamento
	 */
	public Empleado(String nombre, String fechaAlta, double salario, Departamento departamento) {
		super();
		this.nombre = nombre;
		this.fechaAlta = fechaAlta;
		this.salario = salario;
		this.departamento = departamento;
	}



	@Override
	public String toString() {
		return "Empleado [Codigo = " + codigo + ", Nombre = " + nombre + ", Fecha de Alta = " + fechaAlta + String.format(", Salario = %.2f", salario)
				+ ", Departamento: " + departamento + "]";
	}


	public int getCodigo() {
		return codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public String getFechaAlta() {
		return fechaAlta;
	}


	public double getSalario() {
		return salario;
	}


	public Departamento getDepartamento() {
		return departamento;
	}

}
