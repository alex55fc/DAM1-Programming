package modelo;

public class Empleado {

	private int codigo;
	private String nombre;
	private String fechaAlta;
	private double salario;
	private int codigoDepartamento;
	
	public Empleado(int codigo, String nombre, String fechaAlta, 
	                double salario, int codigoDepartamento) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.fechaAlta = fechaAlta;
		this.salario = salario;
		this.codigoDepartamento = codigoDepartamento;
	}

	@Override
	public String toString() {
		return 
			"Empleado [Código = " + codigo + 
			", Nombre = " + nombre + 
			", FechaAlta = " + fechaAlta + 
			", Salario = " + String.format("%.2f", salario) + 
			", CódigoDepartamento = " + codigoDepartamento + 
			"]";
	}
	
}
