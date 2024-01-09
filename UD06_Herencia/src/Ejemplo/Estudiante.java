package Ejemplo;

//como es una clase hija de Persona lo definimos con: extends Persona
public class Estudiante extends Persona {
	
	//atributos 
	private int numeroExpediente;
	private String estudios;
	
	//constructor     al ser clase hija son los parametros heredados del constructor de la calse padre
	public Estudiante(String dni, String nombre,
			int numeroExpediente, String estudios) {
		super(dni,  nombre);//ponemos super ya que hacemos llamada al ------------
		this.numeroExpediente = numeroExpediente;
		this.estudios = estudios;
	}
	
	@Override
	public String toString() {
		return
			"Estudiante ["+ super.obtenerEstado()+ 
			", Numero Expediente = "+ numeroExpediente +", Estudios "+ estudios +"]";
	}
	@Override
	public String obtenerEstado() {
		return 
			super.obtenerEstado() + 
			", NumeroExpediente "+ numeroExpediente +", estudios "+ estudios;	
	}
	
}
