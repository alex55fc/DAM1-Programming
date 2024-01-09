package Ejer_practico;

public class Serie extends Video{
	
	//atributo 
	protected int inicioEmision;
	protected int finEmision;
	protected int numTemporadas;
	protected int numCapitulos;
	
	//constructor 
	public Serie(String titulo,
			int inicioEmision,int finEmision,int numTemporadas, int numCapitulos  ) {
		super(titulo);
		this.inicioEmision = inicioEmision;
		this.finEmision = finEmision;
		this.numTemporadas = numTemporadas;
		this.numCapitulos = numCapitulos;
	}
	//toSstring
	@Override
	public String toString() {
		return "Serie [Codigo= " + codigo + ", Titulo= " + titulo + ""
				+ ", inicioEmision= " + inicioEmision + ", finEmision= " + finEmision + ", numTemporadas= "	+ numTemporadas + ", numCapitulos= " + numCapitulos;
	}
	
	public double calcularPuntuacion() {
		return 1.4 +2.1;
	}
	public int getInicioEmision() {
		return inicioEmision;
	}
	

}
