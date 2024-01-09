package Modelos;

public class Musico {

	private int codigo;
	private String nombre;
	private String fechaNacim;
	private String lugarResi;
	private String nacionalidad;
	private String instrumento;
	private int cod_banda;
	
	public Musico(int codigo, String nombre, String fechaNacim, String lugarResi, String nacionalidad,
			String instrumento, int cod_banda) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.fechaNacim = fechaNacim;
		this.lugarResi = lugarResi;
		this.nacionalidad = nacionalidad;
		this.instrumento = instrumento;
		this.cod_banda = cod_banda;
	}

	public Musico(int codigo) {
		this.codigo = codigo;
	}
	public Musico(int codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "musico [codigo=" + codigo + ", nombre=" + nombre + ", fechaNacim=" + fechaNacim + ", lugarResi="
				+ lugarResi + ", nacionalidad=" + nacionalidad + ", instrumento=" + instrumento + ", cod_banda="
				+ cod_banda + "]";
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

	public String getFechaNacim() {
		return fechaNacim;
	}

	public void setFechaNacim(String fechaNacim) {
		this.fechaNacim = fechaNacim;
	}

	public String getLugarResi() {
		return lugarResi;
	}

	public void setLugarResi(String lugarResi) {
		this.lugarResi = lugarResi;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getInstrumento() {
		return instrumento;
	}

	
	public void setInstrumento(String instrumento) {
		this.instrumento = instrumento;
	}

	public int getCod_banda() {
		return cod_banda;
	}

	public void setCod_banda(int cod_banda) {
		this.cod_banda = cod_banda;
	}
	
	
	
}
