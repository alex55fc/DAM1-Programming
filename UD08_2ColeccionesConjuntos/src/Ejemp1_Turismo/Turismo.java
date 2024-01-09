package Ejemp1_Turismo;

import java.util.Objects;

public class Turismo {
	//atributos
	private String matricula; //identificador
	private String marca;
	private String modelo;
	private int agno;
	private double precio;
	//constructor
	public Turismo(String matricula, String marca, String modelo, int agno, double precio) {
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.agno = agno;
		this.precio = precio;
	}

	//tostring
	@Override
	public String toString() {
		return "Turismo [matricula=" + matricula + ", marca=" + marca +
				", modelo=" + modelo + ", agno=" + agno + ", precio "+ String.format("%.2f", precio)+ "]";
	}
	
	
	public double getPrecio() {
		return precio;
	}

	public String getMatricula() {
		return matricula;
	}

	//hashcode equals
	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Turismo)) {
			return false;
		}
		Turismo other = (Turismo) obj;
		return Objects.equals(matricula, other.matricula);
	}
	
	
	
}
