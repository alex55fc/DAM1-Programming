package Ejer_2_01;

public class Oficinista_2 extends Empleado_1 {
	//atributos
	private String titulacion;
	private String turno; //diurno, vespertino o nocturno

	//constructor
	public Oficinista_2(String nif, String nombre, String fechaNacimiento, String direccion, String numero, String correo,
			String titulacion, String turno) {
		super(nif, nombre, fechaNacimiento, direccion, numero, correo);
		this.titulacion = titulacion;
		if (turno.equals("diurno")|| turno.equals("vespertino")|| turno.equals("nocturno")) {
			this.turno = turno;	
		}
		else {
			this.turno = "diurno";
		}
	}

	//modifica la titulacion del oficinista
	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}
	//modifica el turno del oficinista
	public void setTurno(String turno) {
		if (turno.equals("diurno")|| turno.equals("vespertino")|| turno.equals("nocturno")) {
			this.turno = turno;	
		}
		else {
			this.turno = "diurno";
		}
	}

	@Override
	public String toString() {
		return "Oficinista [" + super.toString() + "\nTitulacion " + titulacion + ", turno=" + turno + "]";
	}
	
	//devuelve una cadena de caracterers con el estado del oficinista
	
}
