package Ejer_usuario;

import java.util.ArrayList;
import java.util.List;

public class Comprador extends Usuario{

	//atributos 
	private String tarjetaPago;
	private String direccion;
	private List<String> listaFavoritos;
	
	//constructor
	public Comprador(String correo,String nombre, String contrasenia, 
			String tarjetaPago, String direccion) {//-------------porque no poniamos aqui la lista, no es para cada comprador una lista
		super(correo, nombre, contrasenia);
		this.tarjetaPago = tarjetaPago;
		this.direccion = direccion;
		this.listaFavoritos = new ArrayList<String>();
	}
	
	 //toString
	@Override
	public String toString() {
		return
				 "Comprador[correo=" + correo + ", nombre=" + nombre + ", contrasenia=" + contrasenia 
				 + ", Tarjeta de pago " + tarjetaPago +" , Direccion "+ direccion+ " Lista de favoritos "+ listaFavoritos;
	}

	public String getDireccion() {
		return direccion;
	}
	//insertar un producto por nombre a la lista
	//comprobamos si hay un producto con ese nombre devuelva false 
	//solo hace falta oner este return ya que si lo añade da true y si no devulve false
	public  boolean insertarFavorito(String nombre){
		if(listaFavoritos.contains(nombre)) {
			return false;
		}
		else {
			return listaFavoritos.add(nombre);
		}		 
	}
	
	//11-
	public int obtenerTamanioLista() {
		return listaFavoritos.size();
	}
	//16-
	/* por nombre 
	public boolean eliminarNombre(String nombre) {
		return listaFavoritos.remove(nombre);
	}*/
	public boolean eliminarNombre(int pos) {
		return listaFavoritos.remove(listaFavoritos.get(pos));
	}
	
	

	
	
		
		
	
	
}
