package disenio_clases_02;

public class Tiempo {

	//ATRIBUTO
	private int horas;
	private int minutos;
	private int segundos;

	//constructor 
	public Tiempo(int horas, int minutos, int segundos) {
		this.horas = horas;
		this.minutos = minutos;
		this.segundos = segundos;

	}
	// este metodo es static porque es metodo de clase
	public static boolean validar(int horas, int minutos, int segundos) {
		if(horas >= 0 && horas <= 23 && minutos >= 0 && minutos <= 59 && segundos >= 0 && segundos <= 59) {
			return true;
		}
		else {
			return false;
		}
	}
	public String obtenerEstado() { 
		return                  //FIJARSE EN X.Xf o X.Xd
				String.format("%02d:%02d:%02d", horas, minutos, segundos);
	}

	public boolean sumar(Tiempo otroTiempo) {
		this.horas = this.horas + otroTiempo.horas;
		this.minutos = this.minutos + otroTiempo.minutos;
		this.segundos = this.segundos + otroTiempo.segundos;

		if (this.segundos > 59) {
			this.segundos = this.segundos - 60;
			this.minutos = this.minutos + 1/* o tambien poner this.minutos-- */
					;		
		}
		if (this.minutos > 59) {
			this.minutos = this.minutos -60;
			this.horas = this.horas + 1;	
		}
		
		if (/*this.segundos <= 59 && this.minutos <= 59&& (esto no es necesario) */this.horas <= 23) {
			return true;
		}
		else {
			return false;
		}

	}
	
	public boolean restar(Tiempo otroTiempo2) {
		this.horas = this.horas - otroTiempo2.horas;
		this.minutos = this.minutos - otroTiempo2.minutos;
		this.segundos = this.segundos - otroTiempo2.segundos;
		
		if (this.segundos < 0) {
			this.minutos = this.minutos - 1;
			this.segundos = this.segundos + 60  ;	
			
		}
		if (this.minutos < 0) {
			this.horas = this.horas - 1;
			this.minutos = this.minutos + 60  ;	
			
		}
		
		if (/* */this.horas >= 0) {
			return true;
		}
		else {
			return false;
		}
		
	}


}

