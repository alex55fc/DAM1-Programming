package Ejer_usuario_prof;

public class Administrador extends Usuario {

	private String categoria;
	private boolean revisaComentarios;
	
	
	public Administrador(String nombre, String correo, String contrasegna, 
			String categoria,
			boolean revisaComentarios) {
		super(nombre, correo, contrasegna);
		this.categoria = categoria;
		this.revisaComentarios = revisaComentarios;
	}


	@Override
	public String toString() {
		return 
			"Administrador [nombre=" + nombre + 
			", correo=" + correo + 
			", contrasegna=" + contrasegna + 
			", categoria=" + categoria + 
			", revisaComentarios=" + revisaComentarios + 
			"]";
	}
	

	
	
}
