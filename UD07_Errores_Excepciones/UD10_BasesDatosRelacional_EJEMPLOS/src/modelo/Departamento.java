package modelo;

public class Departamento {

	private int codigo;
	private String nombre;
	private String ubicacion;
	
	public Departamento(int codigo, String nombre, String ubicacion) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
	}

	@Override
	public String toString() {
		return 
			"Departamento [Código = " + codigo + 
			", Nombre = " + nombre + 
			", Ubicación = " + ubicacion + 
			"]";
	}
	
}
