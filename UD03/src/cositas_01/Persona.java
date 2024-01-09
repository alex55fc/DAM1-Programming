package cositas_01;

public class Persona {

	// atributos
	private String nombre;
	private String apellidos;
	private int altura;
	private boolean trabajo;

	// constructor 1
	public Persona(String nombre, String apellidos, int altura, boolean trabajo ) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.altura = altura;
		this.trabajo = trabajo;
	}
	// constructor 2
	public Persona(String nombre, String apellidos, int altura) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.altura = altura;
		this.trabajo = false;
	}
	// constructor 3
	public Persona() {
		this.nombre = "recien";
		this.apellidos =" nacido";
		this.altura = 50;
		this.trabajo = false;
	}

	//metodo
	public String obtenerEstado(){
		return  //ponemos poner this.nombre para diferenciar funciones de variables(o algoa si xd)
				"Persona [Nombre " + nombre + ", Apellidos: "+ apellidos + 	
				", altura: "+ altura + ", Trabajo: "+ trabajo+ "]";

	}
}
