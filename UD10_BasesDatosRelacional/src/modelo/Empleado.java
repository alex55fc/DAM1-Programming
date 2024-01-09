package modelo;

public class Empleado {
	//atributos 
	private int codigo;
	private String nombre;
	private String fechAlta;
	private double salario;
	private Departamento departamento;
	
	//constructor
	public Empleado(int codigo, String nombre, String fechAlta, double salario,Departamento departamento ) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.fechAlta = fechAlta;
		this.salario = salario;
		this.departamento = departamento;
	}
	//constructor sin parametro codigo
	public Empleado( String nombre, String fechAlta, double salario,Departamento departamento ) {

		this.nombre = nombre;
		this.fechAlta = fechAlta;
		this.salario = salario;
		this.departamento = departamento;
	}
	//toString
	@Override
	public String toString() {
		return "Empleado [codigo=" + codigo + ", nombre=" + nombre + ", fechAlta=" + fechAlta + ", salario=" + salario
				+ ", Departamento=" + departamento + "]";
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechAlta() {
		return fechAlta;
	}

	public void setFechAlta(String fechAlta) {
		this.fechAlta = fechAlta;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	
}
