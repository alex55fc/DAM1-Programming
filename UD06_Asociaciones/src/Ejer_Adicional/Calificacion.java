package Ejer_Adicional;

public class Calificacion {
	//para el ejercicio hacemos primero  esta clase.
	
	//atributos
	private String modulo;
	private double nota;
	
	//constructor.
	public Calificacion(String modulo, double nota) {
		this.modulo = modulo;
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Calificacion [modulo=" + modulo + ", nota=" + nota + "]";
	}

	public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}
	
	
	
}
