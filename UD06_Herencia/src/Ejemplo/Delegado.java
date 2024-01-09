package Ejemplo;
//clase hija de Estudiante
public class Delegado extends Estudiante {
	
	//atributo
	private String grupo;
	
	//constructor con todos los parametros de la clase padre que son los siguiente de Estudiante
	public Delegado(String dni, String nombre,int numeroExpediente, String estudios,
			String grupo) {
		super(dni, nombre, numeroExpediente, estudios);
		this.grupo = grupo;
	}
	
	//devuelve una cadena de caracteres con el estado del delegado
	@Override
	public String toString() {
		return 
			"Delegado["+ super.obtenerEstado() 
			+ ", grupo "+ grupo + "]";
	}
}
