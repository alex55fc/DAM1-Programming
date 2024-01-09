package Ejer_tobi;

public class Administrador extends Usuario {
	private String categoria;
	private boolean revisa;
	
	public Administrador(String nombre, String correoElectrónico, String contraseña, String categoria, boolean revisa) {
		super(nombre, correoElectrónico, contraseña);
		this.categoria = categoria;
		this.revisa = revisa;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public boolean isRevisa() {
		return revisa;
	}

	public void setRevisa(boolean revisa) {
		this.revisa = revisa;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", correoElectrónico=" + correoElectrónico + ", contraseña=" + contraseña +
				 " [Administrador [categoria=" + categoria + ", revisa=" + revisa + "]";
	}
	
	
	
	
}