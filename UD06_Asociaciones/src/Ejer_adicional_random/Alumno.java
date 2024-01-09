package Ejer_adicional_random;

import java.util.Random;

public class Alumno {

	// atributo est�tico para contar alumnos
	private static int total = 0;
	
	// atributos
	private String nombre;
	private int numeroExpediente;    // clave primaria: �nico y autoincremental
	private Calificacion[] calificaciones;
	private int indice;
	
	// atributo est�tico con un vector de nombres
	private static final String[] NOMBRES = {
		"Hugo", "Mart�n", "Lucas", "Mateo", "Leo", "Daniel", "Alejandro",
		"Pablo", "Manuel", "�lvaro", "Adri�n", "David", "Diego", "Javier",
		"Luc�a", "Sof�a", "Martina", "Mar�a", "Julia", "Paula", "Valeria",
		"Emma", "Carla", "Alba", "Sara", "Carmen", "Pilar", "Isabel"
	};
	
	// Crea un alumno a partir de 1 par�metro.
	public Alumno(String nombre) {
		total++;
		this.numeroExpediente = total;
		this.nombre = nombre;
		this.calificaciones = new Calificacion[7];
		this.indice = 0;
	}
	
	// Crea un alumno por defecto con nombre aleatorio.
	public Alumno() {
		Random aleatorio = new Random();
		total++;
		this.numeroExpediente = total;
		this.nombre = NOMBRES[aleatorio.nextInt(NOMBRES.length)];
		this.calificaciones = new Calificacion[7];
		this.indice = 0;
	}
	
	// Devuelve una cadena de caracteres con el estado del alumno.
	@Override
	public String toString() {
		String cadena = "Alumno [Nombre = " + nombre +
				       ", N�meroExpediente = " + numeroExpediente +
				       "]:\n";
		if (indice == 0) {
			cadena = cadena + "No tiene calificaciones.";
		}
		else {
			for (int pos = 0 ; pos < indice ; pos++) {
				Calificacion calificacion = calificaciones[pos];
				cadena = cadena + calificacion.toString() + " ";
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

	public int getNumeroExpediente() {
		return this.numeroExpediente;
	}

	public void setNumeroExpediente(int numeroExpediente) {
		this.numeroExpediente = numeroExpediente;
	}

	// Inserta una calificaci�n en el alumno.
	// Devuelve verdadero si ha insertado la calificaci�n en el alumno.
	// Devuelve falso en caso contrario (vector lleno).
	public boolean insertar(Calificacion calificacion) {
		if (indice < calificaciones.length) {
			calificaciones[indice] = calificacion;
			indice++;
			return true;
		}
		else {
			return false;
		}
	}
	
	// Inserta varias calificaciones con datos aleatorios en el alumno.
	public void insertarVarias() {
		Random aleatorio = new Random();
		String[] modulos = {"P", "BD", "SI", "ED", "LM", "FOL", "I"};
		for (int pos = 0 ; pos < modulos.length ; pos++) {
			String modulo = modulos[pos];
			double nota = aleatorio.nextDouble() * 10.0;
			Calificacion calificacion = new Calificacion(modulo, nota);
			this.insertar(calificacion);
		}
	}
	
	// Consulta la mejor calificaci�n del alumno.
	// Devuelve la calificaci�n del alumno con la mayor nota, si existe.
	// Devuelve null en caso contrario (vector vac�o).
	public Calificacion consultarMejorCalificacion() {
		if (indice == 0) {
			return null;
		}
		else {
			Calificacion mejorCalif = calificaciones[0];
			for (int pos = 1 ; pos < indice ; pos++) {
				Calificacion calificacion = calificaciones[pos];
				if (calificacion.getNota() > mejorCalif.getNota()) {
					mejorCalif = calificacion;
				}
			}	
			return mejorCalif;
		}
	}
	
	// Consulta una calificaci�n, por m�dulo, del alumno.
	// Devuelve la calificaci�n del alumno con el m�dulo dado, si existe.
	// Devuelve null en caso contrario (m�dulo no encontrado).
	public Calificacion consultar(String modulo) {
		Calificacion califEncontrada = null;
		boolean encontrada = false;
		for (int pos = 0 ; pos < indice && !encontrada ; pos++) {
			Calificacion calificacion = calificaciones[pos];
			if (calificacion.getModulo().equals(modulo)) {
				califEncontrada = calificacion;
				encontrada = true;
			}
		}
		return califEncontrada;
	}
	
}
