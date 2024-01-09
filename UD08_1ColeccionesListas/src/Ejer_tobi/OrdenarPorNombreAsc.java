package Ejer_tobi;

import java.util.Comparator;

public class OrdenarPorNombreAsc implements Comparator<Usuario> {

	// Compara dos usuarios por nombre ascendente 
	@Override
	public int compare(Usuario user1, Usuario user2) {
		String nombre1 = user1.getNombre();
		String nombre2 = user2.getNombre();
		return nombre1.compareTo(nombre2);
	}

}