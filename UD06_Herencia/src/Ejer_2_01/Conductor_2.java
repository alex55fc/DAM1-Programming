package Ejer_2_01;

public class Conductor_2 extends Empleado_1 {
	
	//atributo de clase, los staticos se pueden aqui
	private static int numeroMaximoCarnets = 15;
	
	//atributos de objeto, se declaran en el constructor
	private int numeroCarnets;
	private int agnoCAP;
	
	//constructor
	public Conductor_2(String nif, String nombre, String fechaNacimiento, String direccion, String numero, String correo,
			int numeroCarnets, int agnoCAP) {
		super(nif, nombre, fechaNacimiento, direccion, numero, correo);
		if(numeroCarnets > 0 && numeroCarnets <= numeroMaximoCarnets) {
			this.numeroCarnets = numeroCarnets;
		}
		else {
			this.numeroCarnets = 1;
		}
		
		this.agnoCAP = agnoCAP;
	}

	@Override
	public String toString() {
		return "Conductor [numeroCarnets=" + numeroCarnets + ", agnoCAP=" + agnoCAP + "]";
	}
	
	
}
