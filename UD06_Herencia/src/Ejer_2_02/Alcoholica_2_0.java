package Ejer_2_02;
/*como esta clase es una clase abstracta heredada de otra clase abstracta definimos la clase con public abstract y
sirve como una clase intermediaria*/
public abstract class Alcoholica_2_0  extends Bebida_1_0{
	//atributo 
	protected double graduacion;
	
	//constructor 
	public Alcoholica_2_0( String nombre,
			double graduacion) {
		super(nombre);
		this.graduacion = graduacion;
	}
	//to string, no haria falta hacerlo ya que no lo usaremos a futuro
	@Override
	public String toString() {
		return "Alcoholica_2_0 [" + "graduacion=" + String.format(".1f", graduacion) + "]";
	}	
	
				
}
