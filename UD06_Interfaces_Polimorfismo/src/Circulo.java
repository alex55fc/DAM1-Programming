
public class Circulo implements Figura {
	
	/*el implements significa que nosotros en la clase Circula vamos a implementar datos de los metodos
	abtractos de la interfaz Figura*/
	
	//atributo
	private double radio;
	
	public Circulo(double radio) {
		this.radio = radio;
	}

	@Override
	public double calcularPerimetro() {
		return  2.0 * Math.PI * radio;
	}

	@Override
	public double calcularArea() {
		return Math.PI *radio * radio;
	}
	
	@Override
	public String toString() {
		return "Cuadrado [radio=" + radio + ", perimetro= "
				+ this.calcularPerimetro()+ ", area= " + this.calcularArea()+ "]";
	}
}
