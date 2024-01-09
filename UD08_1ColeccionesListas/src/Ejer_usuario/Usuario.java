package Ejer_usuario;

import java.util.Objects;

/*Dudas
 * -En el caso 8 en gestionUsuarios no s3 que poner en el else para que cuando el usuario no tenga contra debil no devulva nada solo pase
 * -En el caso 6 gestionUsuario metodo puede haber un error para que haya un else?
 * -En el caso 9 gestionUsuario se puede usar ese metodo para consultar comprador y administradores en el mismo metodo?
 * -DUDA STRING FRASE en el caso 8 no pongo un null y en el caso 10 si, es importante o no?*/
public abstract class Usuario {
	//atributo 
	protected String correo;// unico
	protected String nombre;
	protected String contrasenia;
	
	//constructor de un solo parametro 
	public Usuario(String correo) {
		this.correo = correo;
	}
	//constructor 
	public Usuario(String correo,String nombre, String contrasenia ) {
		this.correo = correo;
		this.nombre = nombre;
		this.contrasenia = contrasenia;
	}

	public String getCorreo() {
		return correo;
	}
	
	//toString 
	@Override
	public String toString() {
		return "Usuario [correo=" + correo + ", nombre=" + nombre + ", contrasenia=" + contrasenia + "]";
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	//4-para comparar el correo
	@Override
	public int hashCode() {
		return Objects.hash(correo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Usuario)) {
			return false;
		}
		Usuario other = (Usuario) obj;
		return Objects.equals(correo, other.correo);
	}
	
	
	
}
