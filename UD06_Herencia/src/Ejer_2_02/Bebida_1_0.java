package Ejer_2_02;

public abstract class Bebida_1_0 {
	
	//atributo estatico, private ya que solo lo usaremos en esta clasde
	private static int contador = 0;
	
	//atributo, los definimos protected ya que los va a heredar las clases hijas y asi es mas sencillo
	protected String nombre;
	protected int codigo;

	//constructor
	//¿porque usamos solo el nombre?
	public Bebida_1_0(String nombre)  {
		contador++;
		this.codigo = contador;
		this.nombre = nombre;
		
	}

	//toString	
	
	@Override
	public String toString() {
		return "Bebida [nombre=" + nombre + ", codigo=" + codigo + "]";
	}
	/*al ser metodo abstracto solo tiene la cabezera, no ponemos parametros 
	ya que usaremos este metodo cambiando los parametros dependiendo de las clases hijas*/
	public abstract double calcularPrecio() ;
	
	
	
	
	
	
}
