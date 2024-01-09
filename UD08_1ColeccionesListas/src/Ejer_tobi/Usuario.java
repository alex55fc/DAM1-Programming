package Ejer_tobi;

public class Usuario {
	protected String nombre; 
	protected String correoElectrónico;
	protected String contraseña;
	
	public Usuario(String nombre, String correoElectrónico, String contraseña) {
		this.nombre = nombre;
		this.correoElectrónico = correoElectrónico;
		this.contraseña = contraseña;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreoElectrónico() {
		return correoElectrónico;
	}

	public void setCorreoElectrónico(String correoElectrónico) {
		this.correoElectrónico = correoElectrónico;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", correoElectrónico=" + correoElectrónico + ", contraseña=" + contraseña
				+ "]";
	}
	
	
	
	
}