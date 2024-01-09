package Ejemplo;

public class Empleado extends Persona {
	//los constructores NO SE HEREDAN por eso siempre hay que creaarlo
	//atributos
	private String profesion;
	private boolean tieneCargo;
	private Double salario;
	
	//constructor
	public Empleado(String dni, String nombre,
			String profesion ,boolean tieneCargo, Double salario ) {
		super(dni, nombre);
		this.profesion = profesion;
		this.tieneCargo = tieneCargo;
		this.salario = salario;
	}
	
	@Override
	public String obtenerEstado() {
		return
				 super.obtenerEstado()+ 
				", Profesion "+ profesion + ", Tiene cargo "+ tieneCargo + ", Salario: "+ String.format("%.2f", salario);
	}
	// este obtener
	@Override
	public String toString() {
		return
			"Empleado[ "+ super.obtenerEstado()+ 
			", Profesion "+ profesion + ", Tiene cargo "+ tieneCargo + ", Salario: "+ String.format("%.2f", salario) + "]";
		
	}
}
