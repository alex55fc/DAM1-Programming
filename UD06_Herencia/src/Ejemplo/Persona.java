package Ejemplo;

public class Persona {
	
	//atributos 
	private String dni;
	private String nombre;
	
	//constructor
	
	public Persona(String dni, String nombre){
		this.dni = dni;
		this.nombre = nombre;
	}
	
	//con este toString escribimos    "Persona[Dni=... etc 
	//con obtener estado solo escribe "Dni= ..etc
	@Override
	public String toString() {
		return "Persona[Dni= " + dni + ", nombre= " + nombre+ "]";
	}
	//Los METODOS de la clase padre NO se HEREDAN
	/*este metodo lo usamos en estudiante para llamar a este metodo y no al toString para que solo se vea esto y 
	en el toString salga el mensaje completo y al llamar a obtenerEstado salgo este cadena mas corta*/
	
	

	public String obtenerEstado() {
		return 
			"Dni= " + dni + ", nombre= " + nombre;
	}
}
