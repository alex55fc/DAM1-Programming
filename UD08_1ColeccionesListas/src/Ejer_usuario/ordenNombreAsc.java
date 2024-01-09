package Ejer_usuario;

import java.util.Comparator;

public class ordenNombreAsc implements Comparator <Usuario>{

	@Override
	public int compare(Usuario usuario1, Usuario usuario2) {
		String nombre1 = usuario1.getNombre();
		String nombre2 = usuario2.getNombre();
		return nombre1.compareTo(nombre2);
	}
	
}
