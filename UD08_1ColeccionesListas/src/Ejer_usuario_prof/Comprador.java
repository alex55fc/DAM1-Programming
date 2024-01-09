package Ejer_usuario_prof;
import java.util.ArrayList;
import java.util.List;

public class Comprador extends Usuario {

	private String tarjeta;
	private String direccion;
	private List<String> listaProductos;
	
	public Comprador(String nombre, String correo, String contrasegna, 
			String tarjeta, String direccion) {
		super(nombre, correo, contrasegna);
		this.tarjeta = tarjeta;
		this.direccion = direccion;
		this.listaProductos = new ArrayList<String>();
	}

	@Override
	public String toString() {
		return 
			"Comprador [nombre=" + nombre + 
			", correo=" + correo + 
			", contrasegna=" + contrasegna + 
			", tarjeta=" + tarjeta + 
			", direccion=" + direccion + 
			", listaProductos=" + listaProductos + 
			"]";
	}

	public String getDireccion() {
		return direccion;
	}
	
	public boolean insertar(String producto) {
		if (listaProductos.contains(producto)) {
			return false;
		}
		else {
			return listaProductos.add(producto);
		}
	}
	
	public int obtenerTamagnoLista() {
		return listaProductos.size();
	}
	
}







