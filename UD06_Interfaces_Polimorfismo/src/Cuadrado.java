
public class Cuadrado implements Figura{
	
	//atributos 
	private double lado;
	
	public Cuadrado(double lado) {
		this.lado = lado;
	}

	@Override
	public double calcularPerimetro() {
		return lado * 4;
	}

	@Override
	public double calcularArea() {
		return lado * lado;
	}

	@Override
	public String toString() {
		return "Cuadrado [lado=" + lado + ", perimetro= "
				+ this.calcularPerimetro()+ ", area= " + this.calcularArea()+ "]";
	}
	
}
