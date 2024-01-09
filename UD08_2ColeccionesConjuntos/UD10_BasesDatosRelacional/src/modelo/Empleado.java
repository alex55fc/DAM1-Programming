package modelo;

public class Empleado {

	//atributo 
	private int codigo;
	private String nombre;
	private String fecha_alta;
	private double salario;
	private int codigoDepartamento;

	//constructor
	public Empleado(int codigo, String nombre, String fecha_alta, double salario, int codigoDepartamento) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.fecha_alta = fecha_alta;
		this.salario = salario;
		this.codigoDepartamento = codigoDepartamento;
	}

	//toString 
	@Override
	public String toString() {
		return "Empleado [codigo=" + codigo + ", nombre=" + nombre + ", fecha_alta=" + fecha_alta + ", salario="
				+ salario + ", codigoDepartamento=" + codigoDepartamento + "]";
	}
	








}
