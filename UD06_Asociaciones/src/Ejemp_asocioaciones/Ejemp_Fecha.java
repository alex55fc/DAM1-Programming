package Ejemp_asocioaciones;

public class Ejemp_Fecha {
	private int dia;
	private int mes;
	private int agno;
	
	public Ejemp_Fecha(int dia, int mes, int agno) {
		this.dia = dia;
		this.mes = mes;
		this.agno = agno;
	}
	
	@Override
	public String toString() {
		return "Fecha [dia = "+ dia +",mes = "+ mes+",año = "+ agno +"]";
	}

}
