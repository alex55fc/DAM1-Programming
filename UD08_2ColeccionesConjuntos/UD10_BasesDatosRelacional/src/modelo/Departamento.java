package modelo;

public class Departamento {
	//atributo 
	private int codigo;
	private String nombre;
	private String ubicacion;
	
	//constructor
	public Departamento(int codigo, String nombre, String ubicacion) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
	}

	//toString 
	@Override
	public String toString() {
		return "Departamento [codigo=" + codigo + ", nombre=" + nombre + ", ubicacion=" + ubicacion + "]";
	}

	
	public int getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}
	
	
}
