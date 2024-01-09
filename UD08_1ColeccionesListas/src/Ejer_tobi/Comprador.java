package Ejer_tobi;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Comprador extends Usuario {
	private String tarjetaPago;
	protected String dirección;
	private List<String> lista;
	
	public Comprador(String nombre, String correoElectrónico, String contraseña, String tarjetaPago, String dirección) {
		super(nombre, correoElectrónico, contraseña);
		this.tarjetaPago = tarjetaPago;
		this.dirección = dirección;
		this.lista = new ArrayList <String>();
	}

	public String getTarjetaPago() {
		return tarjetaPago;
	}

	public void setTarjetaPago(String tarjetaPago) {
		this.tarjetaPago = tarjetaPago;
	}

	public String getDirección() {
		return dirección;
	}

	public void setDirección(String dirección) {
		this.dirección = dirección;
	}

	public List<String> getLista() {
		return lista;
	}

	public void setLista(List<String> lista) {
		this.lista = lista;
	}
	
	@Override
	//compara los compradores por lista
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comprador other = (Comprador) obj;
		return Objects.equals(lista, other.lista);
	}
	
	@Override
	public String toString() {
		return " Usuario [nombre=" + nombre + ", correoElectrónico=" + correoElectrónico + ", contraseña=" + contraseña 
				+ " [Comprador [tarjetaPago=" + tarjetaPago + ", dirección=" + dirección + ", lista=" + lista + "]";
	}
	
	
	
	
}
