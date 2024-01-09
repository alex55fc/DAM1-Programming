package Modelos;

public class Banda {

	private int codigo;
	private String nombre;
	private String anio_actuacion;
	private String lugar_origen;
	private String genero;
	
	public Banda(int codigo, String nombre, String anio_actuacion, String lugar_origen, String genero) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.anio_actuacion = anio_actuacion;
		this.lugar_origen = lugar_origen;
		this.genero = genero;
	}

	//AÑADIR A ALVARO Y ESMERALDA
	public Banda(int codigo) {
		this.codigo = codigo;
	}
	//AÑADIR ALVARO Y ESMERALDA
	public Banda(int codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Banda [Código = " + codigo + ", Nombre = " + nombre + ", Año de actuación = " + anio_actuacion
				+ ", Lugar de Origen = " + lugar_origen + ", Género = " + genero + "]";
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAnio_actuacion() {
		return anio_actuacion;
	}

	public void setAnio_actuacion(String anio_actuacion) {
		this.anio_actuacion = anio_actuacion;
	}

	public String getLugar_origen() {
		return lugar_origen;
	}

	public void setLugar_origen(String lugar_origen) {
		this.lugar_origen = lugar_origen;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	
	
	
}
