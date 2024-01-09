package Modelos;

public class Cancion {

	private int codigo;
	private int posicion; //posicion en el album
	private String titulo;
	private String compositor;
	private String duracion;
	private int codigo_album;
	
	public Cancion(int codigo, int posicion, String titulo, String compositor, String duracion, int codigo_album) {
		this.codigo = codigo;
		this.posicion = posicion;
		this.titulo = titulo;
		this.compositor = compositor;
		this.duracion = duracion;
		this.codigo_album = codigo_album;
	}

	@Override
	public String toString() {
		return "cancion [codigo=" + codigo + ", posicion=" + posicion + ", titulo=" + titulo + ", compositor="
				+ compositor + ", duracion=" + duracion + ", codigo_album=" + codigo_album + "]";
	}

	/**
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the posicion
	 */
	public int getPosicion() {
		return posicion;
	}

	/**
	 * @param posicion the posicion to set
	 */
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the compositor
	 */
	public String getCompositor() {
		return compositor;
	}

	/**
	 * @param compositor the compositor to set
	 */
	public void setCompositor(String compositor) {
		this.compositor = compositor;
	}

	/**
	 * @return the duracion
	 */
	public String getDuracion() {
		return duracion;
	}

	/**
	 * @param duracion the duracion to set
	 */
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	/**
	 * @return the codigo_album
	 */
	public int getCodigo_album() {
		return codigo_album;
	}

	/**
	 * @param codigo_album the codigo_album to set
	 */
	public void setCodigo_album(int codigo_album) {
		this.codigo_album = codigo_album;
	}
	
	
}
