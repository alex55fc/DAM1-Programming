package Ejer_lista_persona;

import java.util.Comparator;
//implementamos una interfaz definida Comparator<>
public class OrdenPersonaPorEdadDescendente implements Comparator<Persona>{

	//compara dos personas por la edad de forma descendente
	@Override
	public int compare(Persona persona1, Persona persona2) {//  de donde salen estas edades y como se comparan de forma descendente---------------------
		//guardamos la edad en una clase envoltorio para usar sus metodos
		Integer edad1 = persona1.getEdad();
		Integer edad2 = persona2.getEdad();
		
		//asi es descendente ya que va edad2 y uego edad1
		return edad2.compareTo(edad1);
	}

}
