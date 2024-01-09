package Ejer_2_01;

public class Limpiador_2 extends Empleado_1 {
	//atributos del obejto
	private boolean limpiaOficinas;
	private boolean limpiaAutobuses;
	private boolean limpiaGaragjes;
	
	//construcytor 
	public Limpiador_2(String nif, String nombre, String fechaNacimiento, String direccion, String numero, String correo,
			boolean limpiaOficinas, boolean limpiaAutobuses, boolean limpiaGaragjes) {
		super(nif, nombre, fechaNacimiento, direccion, numero, correo);
		this.limpiaOficinas = limpiaOficinas;
		this.limpiaAutobuses = limpiaAutobuses;
		this.limpiaGaragjes = limpiaGaragjes;
	}
	
	
	
	
}
