package Ejer_adicional_random;

public class Grupo {

	// atributos
	private String nombre;
	private Alumno[] alumnos;
	private int indice;
	
	// Crea un grupo a partir de 1 par�metro.
	public Grupo(String nombre) {
		this.nombre = nombre;
		this.alumnos = new Alumno[30];
		this.indice = 0;
	}
	
	// Devuelve una cadena de caracteres con el estado del grupo.
	@Override
	public String toString() {
		String cadena = "Grupo [Nombre = " + nombre + "]:\n";
		if (indice == 0) {
			cadena = cadena + "El grupo no tiene alumnos.";
		}
		else {
			for (int pos = 0 ; pos < indice ; pos++) {
				Alumno alumno = alumnos[pos];
				cadena = cadena + "(" + pos + ") " + alumno.toString() + "\n";
			}
		}
		return cadena;
	}
	
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// Inserta un alumno en el grupo.
	// Devuelve verdadero si ha insertado el alumno en el grupo.
	// Devuelve falso en caso contrario (vector lleno).
	public boolean insertar(Alumno alumno) {
		if (indice < alumnos.length) {
			alumnos[indice] = alumno;
			indice++;
			return true;
		}
		else {
			return false;
		}
	}
	
	// Inserta varios alumnos con datos aleatorios en el grupo.
	// Devuelve el n�mero de alumnos insertados en el grupo.
	public int insertarVarios(int numeroAlumnos) {
		int contadorAlumnosInsertados = 0;
		for (int contador = 1 ; contador <= numeroAlumnos ; contador++) {
			Alumno alumno = new Alumno();
			alumno.insertarVarias();
			if (this.insertar(alumno)) {
				contadorAlumnosInsertados++;
			}
		}
		return contadorAlumnosInsertados;
	}
	
	// Consulta un alumno, por n�mero de expediente, del grupo.
	// Devuelve el alumno del grupo con el n�mero de expediente dado, si existe.
	// Devuelve null en caso contrario (n�mero de expediente no encontrado).
	public Alumno consultar(int numeroExpediente) {
		Alumno alumnoEncontrado = null;
		boolean encontrado = false;
		for (int pos = 0 ; pos < indice && !encontrado ; pos++) {
			Alumno alumno = alumnos[pos];
			if (alumno.getNumeroExpediente() == numeroExpediente) {
				alumnoEncontrado = alumno;
				encontrado = true;
			}
		}
		return alumnoEncontrado;
	}
	
}
