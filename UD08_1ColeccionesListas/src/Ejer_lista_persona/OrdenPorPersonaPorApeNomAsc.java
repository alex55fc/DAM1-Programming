package Ejer_lista_persona;

import java.util.Comparator;

public class OrdenPorPersonaPorApeNomAsc implements Comparator<Persona>{

	//
	@Override
	public int compare(Persona persona1, Persona persona2) {
		//de donde salen los apellidos no son los mismo?---------------------------------------------------
		String apellido1 = persona1.getApellidos();
		String apellido2 = persona2.getApellidos();
		
		//comparamos apellidos por si son los mismos y si son los mismos ordenador por nombre
		if(apellido1.equals(apellido2)) {
			String nombre1 = persona1.getNombres();
			String nombre2 = persona2.getNombres();
			return nombre1.compareTo(nombre2);
		}
		else {
			return apellido1.compareTo(apellido2);
		}
	}

}
