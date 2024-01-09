package Ejer_lista_persona;

import java.util.Objects;

public class Persona {
	//atributo
	private String dni; //unico, utilizado para identificar 
	private String nombres;
	private String apellidos;
	private int edad;
	
	//constructor
	public Persona(String dni, String nombres, String apellidos, int edad) {
		
		this.dni = dni;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.edad = edad;
	}

	
	/**
	 * @return the nombres
	 */
	public String getNombres() {
		return nombres;
	}

	
	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}


	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}


	//toString
	@Override
	public String toString() {
		return "Persona [dni= " + dni + ", nombres= " + nombres + ", apellidos= " + apellidos + ", edad= " + edad + "]";
	}

	//SOLO PARA LISTAS, con el HashCode and equals marcamos lo que queremos comparar y seleccionamos todas las opciones de debajo
	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}
	//SOLO PARA LISTAS
	//compara persona con el DNI
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Persona)) {
			return false;
		}
		Persona other = (Persona) obj;
		return Objects.equals(dni, other.dni);
	}
	
	
	
	
	
	
	
}	
