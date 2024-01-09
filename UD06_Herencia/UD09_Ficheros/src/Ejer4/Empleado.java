package Ejer4;

public class Empleado {
	
	private static final String SEPARADOR = " ; ";
	
	//atributos 
	private int codigo; //unico
	private String nombre;
	private String fechaNac;
	private String departamento;
	private double salario;
	
	//constructor 
	public Empleado(int codigo, String nombre, String fechaNac, String departamento, double salario) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.fechaNac = fechaNac;
		this.departamento = departamento;
		this.salario = salario;
	}
			
	@Override
	public String toString() {
		return 
			String.format("Alumno [Codigo = %d, Nombre = %s, Fecha Nacimiento = %s, Departamento %s Salario = %.2f]", 
			              this.codigo, this.nombre, this.fechaNac, this.departamento, this.salario);
	}
	
	//este metodo
	public String toStringWithSeparators() {
		return 
				this.codigo + SEPARADOR +
				this.nombre + SEPARADOR +
				this.fechaNac + SEPARADOR +
				this.departamento + SEPARADOR +
				String.format("%.2f", this.salario);
				
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

	public String getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

		//caso 1
	//constructor linea texto 
		public Empleado(String linea) {
			String [] datos = linea.split(SEPARADOR);
			this.codigo = Integer.parseInt(datos[0]);
			this.nombre = datos[1];
			this.fechaNac = datos[2];
			this.departamento = datos[3];
			this.salario = Double.parseDouble(datos[4].replace(',', '.'));
		}

}
