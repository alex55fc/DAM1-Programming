package Ejer_2_01;

public class Empleado_1 {

	//atributos
	private String nif;
	private String nombre;
	private String fechaNacimiento;
	private String direccion;
	private String numero;
	private String correo;

	//constructor 
	public Empleado_1(String nif, String nombre, String fechaNacimiento, String direccion, String numero, String correo) {
		this.nif = nif;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.numero = numero;
		this.correo = correo;
	}
	
	public String obtenerEstado() {
		return
				"nif=" + nif + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", direccion="
				+ direccion + ", numero=" + numero + ", correo=" + correo;
	}
	@Override
	public String toString() {
		return "Empleado [nif=" + nif + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", direccion="
				+ direccion + ", numero=" + numero + ", correo=" + correo + "]";
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	


}
