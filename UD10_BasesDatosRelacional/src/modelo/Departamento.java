package modelo;

public class Departamento {

	//atributos 
	private int codigo;
	private String nombre;
	private String ubicacion;
	
	//constructor completo caso 2
	public Departamento(int codigo, String nombre, String ubicacion) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
	}

	//constructor con dos parametros caso 1
	public Departamento( String nombre, String ubicacion) {
		this.nombre = nombre;
		this.ubicacion = ubicacion;
	}
	//constructor caso 1 AccesoEmpleado
	public Departamento(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	//toString
	@Override
	public String toString() {
		return "Departamento [codigo=" + codigo + ", nombre=" + nombre + ", ubicacion=" + ubicacion + "]";
	}

	public String getUbicacion() {
		return ubicacion;
	}
	public String getNombre() {
		return nombre;
	}
	
	
	
}
