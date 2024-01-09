package Ejemp4_fichero_alumnos;

public class Alumno {
	
	private static final String SEPARADOR = ";";
	
	private int codigo;
	private String nombre;
	private double nota;
	
	public Alumno(int codigo, String nombre, double nota) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.nota = nota;
	}
	
	public Alumno(String linea) {
		//este split separa los datos de la linea separandolos con el separador(;)
		//dejario asi dato[pos 0] 1, dato[pos 1] "juan", datos[pos 3] 3.20
		String[] datos = linea.split(SEPARADOR);
		//aqui usamos las clases Intger y Duble para transformar los datos 
		this.codigo = Integer.parseInt(datos[0]);
		this.nombre = datos[1];
		this.nota = Double.parseDouble(datos[2].replace(',', '.'));
	}
	
	// Se utiliza para visualizar el alumno en consola.
	@Override
	public String toString() {
		return 
			String.format("Alumno [Codigo = %d, Nombre = %s, Nota = %.2f]", 
			              this.codigo, this.nombre, this.nota);
	}
	
	// Se utiliza para escribir el alumno en un fichero de texto.
	public String toStringWithSeparators() {
		return 
			this.codigo + SEPARADOR + 
			this.nombre + SEPARADOR + 
			String.format("%.2f", this.nota).replace(',', '.');
		//esto es para reemplazar las comas de la notas por puntos. 7,5 --> 7.5
	}
		
}
