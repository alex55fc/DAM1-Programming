package Ejer_2_02;

import java.util.Random;

//como esta clase vamos a sobreescribir los metodos heredados de la clase padre ponemos public class y los metodos public a secas
public class Refresco_2_0 extends Bebida_1_0{
	/*atributos, puedo definirlos privados ya que solo lo usaremos en esta clase
	pero al definirlos protected nos hace mas facil si a futuro hacemos clases hijas de bebidas asi ya es protected*/
	protected double azucar;
	protected boolean gas;	
	
	protected  static final String[] NOMBRES = {//es un vector de nombres, que fundion donde el primer nombre ocupa posicion 0
			"limonada", "cola","gaseosa","té helado","granizado" ," ponche"
	};
	
//--//constructor con datos por teclado
	public Refresco_2_0(String nombre, 
			boolean gas, double azucar) {
		super(nombre);
		this.azucar = azucar;
		this.gas = gas;
	}
	
	//-------------------------------------------------------------------------------------------------------------------------------------
//--//constructor que generar datos de forma aleatoria
	public Refresco_2_0() {
		super(generarNombre());
		Random aleatorio = new Random();
		this.azucar = aleatorio.nextDouble() * (35 -4)+ 4; // entre 4 y 35
		this.gas = aleatorio.nextBoolean();
		
	}

	//con este metodo auxiliar es donde generamos un nombre aleatorio del vector de nombre dond hemos puesto los nombres que queremos
	public static String generarNombre() {
		Random aleatorio = new Random();
		return NOMBRES[aleatorio.nextInt(NOMBRES.length)];
	}
	//-------------------------------------------------------------------------------------------------------------------------------------
	
	// toString
	public String toString() {
		return
				"Refresco[Codigo "+ codigo + ", nombre " + nombre + 
				", Tiene gas= "+ gas +", Cantidad de azucar" + String.format("%.2f", azucar);
	}
	//Metodo abstract heredado pero, cuando sobreescribimos el metodo abstracto quitamos el abstract
	@Override
	public double calcularPrecio() {
		double precio = 1 + (azucar / 10);
		return precio; //o devolvemos directamente return 1 + (azucar / 10);
	}

	public boolean esGaseoso() {
		return gas;
	}
	
}

