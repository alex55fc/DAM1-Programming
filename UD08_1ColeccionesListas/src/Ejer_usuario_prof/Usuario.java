package Ejer_usuario_prof;

public abstract class Usuario {

	protected String nombre;
	protected String correo;  // identificador �nico
	protected String contrasegna;
	
	public Usuario(String nombre, String correo, String contrasegna) {
		this.nombre = nombre;
		this.correo = correo;
		this.contrasegna = contrasegna;
	}

	@Override
	public String toString() {
		return 
			"Usuario [nombre=" + nombre + 
			", correo=" + correo + 
			", contrasegna=" + contrasegna + 
			"]";
	}

	public String getCorreo() {
		return correo;
	}

	public String getNombre() {
		return nombre;
	}
	
	
	
	
}
