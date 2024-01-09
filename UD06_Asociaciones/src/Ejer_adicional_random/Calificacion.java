package Ejer_adicional_random;

public class Calificacion {

	// atributos
	private String modulo;
	private double nota;
	
	// Crea una calificaci�n a partir de 2 par�metros.
	public Calificacion(String modulo, double nota) {
		this.modulo = modulo;
		this.nota = nota;
	}

	// Devuelve una cadena de caracteres con el estado de la calificaci�n.
	@Override
	public String toString() {
		return 
			"[M�dulo = " + this.modulo + 
			", Nota = " + String.format("%.1f", this.nota) + 
			"]";
	}

	public String getModulo() {
		return this.modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	public double getNota() {
		return this.nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}
	
}
