package Modelos;

public class Album {

	//para el toStringWithSeparator
	private static final String SEPARADOR = ";";

	private int codigo;
	private String autor;
	private Musico musico;
	private Banda banda;
	private String titulo;
	private int anioPublicacion;
	private String tipo;
	private String duracion;



	public Album( int codigo,String autor, String titulo, int anioPublicacion, String tipo, String duracion,
			Banda banda, Musico musico) {
		this.codigo = codigo;
		this.autor = autor;
		if(autor.equalsIgnoreCase("banda")) {
			this.titulo = titulo;
			this.anioPublicacion = anioPublicacion;
			this.tipo = tipo;
			this.duracion = duracion;
			this.banda = banda;

		}
		else if(autor.equalsIgnoreCase("musico")) {
			this.titulo = titulo;
			this.anioPublicacion = anioPublicacion;
			this.tipo = tipo;
			this.duracion = duracion;
			this.musico = musico;
		}
	}



	public Album( String autor, String titulo, int anioPublicacion, String tipo, String duracion,
			Banda banda, Musico musico) {
		this.autor = autor;
		if(autor.equalsIgnoreCase("banda")) {
			this.titulo = titulo;
			this.anioPublicacion = anioPublicacion;
			this.tipo = tipo;
			this.duracion = duracion;
			this.banda = banda;

		}
		else if(autor.equalsIgnoreCase("musico")) {
			this.titulo = titulo;
			this.anioPublicacion = anioPublicacion;
			this.tipo = tipo;
			this.duracion = duracion;
			this.musico = musico;
		}
	}



	@Override
	public String toString() {
		String cadena = "";
		cadena = cadena + "Album [codigo= " + codigo + ", autor= " + autor;
		if (autor.equalsIgnoreCase("banda")) {
			cadena = cadena + ", Codigo banda " + banda.getCodigo()+ ", Nombre Banda " + banda.getNombre();
		}
		else {
			cadena = cadena + ", Codigo musico " + musico.getCodigo()+ ", Nombre Musico "+ musico.getNombre();

		}
		cadena = cadena +", titulo= " + titulo + ", anioPublicacion= " + anioPublicacion + ", tipo= " + tipo
				+ ", duracion= " + duracion + "]";
		return cadena;
	}
	// Se utiliza para escribir el album en un fichero de texto.
	public String toStringWithSeparators() {
		String cadena = "";
		cadena = cadena + this.codigo + SEPARADOR + this.autor + SEPARADOR + this.titulo + SEPARADOR 
				+ this.anioPublicacion + SEPARADOR + this.tipo + SEPARADOR + this.duracion + SEPARADOR ;
		if (autor.equalsIgnoreCase("banda")) {
			cadena = cadena + this.getBanda().getCodigo();
		}
		else {
			cadena = cadena + this.getMusico().getCodigo();
		}
		return cadena;
	}
	
	//Se utiliza para leer la linea del fichero y separarlo en datos con el valor de Album
	public Album(String linea) {
		//este split separa los datos de la linea separandolos con el separador(;)
		//dejario asi dato[pos 0] 1, dato[pos 1] "juan", datos[pos 3] 3.20
		String[] datos = linea.split(SEPARADOR);
		this.codigo = Integer.parseInt(datos[0]);
		this.autor = datos[1];
		this.titulo = datos[2];
		this.anioPublicacion = Integer.parseInt(datos[3]);
		this.tipo = datos[4];
		this.duracion = datos[5];
		//probar que funciona para usar esto 
		if(autor.equalsIgnoreCase("banda")) {
			this.banda = Integer.parseInt(datos[6]);
			this.musico = null;

		}
		else {
			this.banda = null;
			this.musico = Integer.parseInt(datos[6]);

		}

	}
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAnioPublicacion() {
		return anioPublicacion;
	}

	public void setAnioPublicacion(int anioPublicacion) {
		this.anioPublicacion = anioPublicacion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDuracion() {
		return duracion;
	}
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public Musico getMusico() {
		return musico;
	}

	public void setMusico(Musico musico) {
		this.musico = musico;
	}

	public Banda getBanda() {
		return banda;
	}

	public void setBanda(Banda banda) {
		this.banda = banda;
	}




}
