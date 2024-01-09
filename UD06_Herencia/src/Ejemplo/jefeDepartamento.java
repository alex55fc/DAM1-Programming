package Ejemplo;

public class jefeDepartamento extends Empleado {
	//atributo
	private String departamento;
	
	//constructor
	public jefeDepartamento(String dni, String nombre, String profesion , Double salario, 
			String departamento) {//no ponemos el booleano ya que en este caso para ser jefeDepartamento es true, si lo ponemos en super
		super(dni, nombre, profesion, true, salario);
		this.departamento = departamento;
	}
	
	//devuelve una cadena de caracterres con el estado del jefe de departamento
	@Override 
	public String toString() {
		return
				"Jefe departamento ["+ super.obtenerEstado()+
				", departamento "+ departamento +"]";
	}
	
}
