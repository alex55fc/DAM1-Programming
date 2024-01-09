package Ejer_usuario;

public class Administradores extends Usuario {
	
	//atributos 
	private String categoria ;
	private boolean revisaComentarios;
	
	//constructor 
	public Administradores(String correo,String nombre, String contrasenia,
			String categoria, boolean revisaComentarios) {
		super(correo, nombre, contrasenia);
		this.categoria = categoria;
		this.revisaComentarios = revisaComentarios;
	}
	
	//toString 
	@Override
	public String toString() {
		return "Administradores [correo=" + correo + " nombre=" + nombre + ", contrasenia=" + contrasenia +
				 ", Categoria "+ categoria +", Revisa comentarios "+ revisaComentarios +"]";
	}

	/**
	 * @return the categoria
	 */
	public String getCategoria() {
		return categoria;
	}
	
}
