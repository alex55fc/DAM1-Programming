package Ejer_Adicional;

import java.util.Arrays;

public class Alumno {
	private String nombreApellidos ;
	private String numeroExpediente;

	private Calificacion[] vectorCalificaciones;
	private int contadorCalificaciones;//o indice, es lo mismo

	public Alumno(String nombreApellidos, String numeroExpediente) {
		this.nombreApellidos = nombreApellidos;
		this.numeroExpediente = numeroExpediente;
		this.vectorCalificaciones = new Calificacion[7];
		this.contadorCalificaciones = 0; //Siempre solemos incicializarlo a 0 en el constructo
	}


	@Override
	public String toString() {
		String cadena = "Alumno [nombre "+nombreApellidos +", Numero expediente "+ numeroExpediente +"]";

		if(contadorCalificaciones == 0) {
			cadena = "El alumno no ";
		}
		else {
			for (int pos = 0; pos < contadorCalificaciones ; pos++) {
			Calificacion calif = vectorCalificaciones[pos];
				cadena = cadena + "("+ pos +")"+ calif.toString() + "\n";
			}

		}
		return cadena;
	}


	//para consultar notas de alumnos
	public String getNumeroExpediente() {
		return numeroExpediente;
	}


	public void setNumeroExpediente(String numeroExpediente) {
		this.numeroExpediente = numeroExpediente;
	}


	public Calificacion[] getVectorCalificaciones() {
		return vectorCalificaciones;
	}

	public void setVectorCalificaciones(Calificacion[] vectorCalificaciones) {
		this.vectorCalificaciones = vectorCalificaciones;
	}

	public boolean insertar(Calificacion x) {
		boolean insertado = false;
		if (contadorCalificaciones < vectorCalificaciones.length) {
			vectorCalificaciones[contadorCalificaciones] = x;
			contadorCalificaciones++;

			insertado = true;
		}
		return insertado;
	}

	//metodo que recorrera el vector para comparar las notas y devolver la Calificcacion maxima
	public Calificacion consultarMejorCalificacion() {
		if (contadorCalificaciones == 0) {
			return null;
		}
		else {
			Calificacion mejorCalif = vectorCalificaciones[0];
			for ( int pos = 0; pos < contadorCalificaciones ; pos++) {
				Calificacion calif = vectorCalificaciones[pos];
				if(mejorCalif.getNota() < calif.getNota()) {
					mejorCalif = calif;
				}
			}
			return mejorCalif;
		}

	}

	//consultar calificacion por modulo
	//lo que se pone despues de public es lo que va a devolver elmetodo
	public Calificacion consultarCalificacion(String modulo) {
		//lo primero definicmos un objeto de Calificacion
		Calificacion calif = null;
		boolean encontrada = false;//con esto recorremos el vector solo hasta encontrar el coso
		for (int pos = 0 ; pos < contadorCalificaciones && !encontrada ; pos++) {
			Calificacion calificacion = vectorCalificaciones[pos];

			//con el getModulo obtenemos el nombre del modulo de la posicion actual del vectorCalificacion
			// y como comparamos String usamos el metodo equals
			if(calificacion.getModulo().equals(modulo) ) {
				calif = calificacion;
				encontrada = true;
			}
		}
		return calif;
	}

	public boolean modificar(String modulo, double nuevaNota) {
		//definimos un objeto Calificacion y buscaremos por modulo, usaremos el metodo que usamos antes
		Calificacion calif = consultarCalificacion(modulo);
		if (calif != null) {
			calif.setNota(nuevaNota);
			return true;
		}
		else {
			return false;
		}
	}

	// TODO
	//main para ver si funcionan los metodos rapidamente
	public static void main(String[] args) {
		Alumno alumno1 = new Alumno("Juan", "001");
		alumno1.insertar(new Calificacion ("P", 7));
		alumno1.insertar(new Calificacion ("BD", 6));
		alumno1.insertar(new Calificacion ("SI", 5));
		alumno1.insertar(new Calificacion ("ED", 4));
		alumno1.insertar(new Calificacion ("IN", 9));
		alumno1.insertar(new Calificacion ("LM", 8));
		alumno1.insertar(new Calificacion ("FOL", 5));


		//consultar mejor calificacion
		Calificacion mejorCalificacion = alumno1.consultarMejorCalificacion();
		if(mejorCalificacion != null) {
			System.out.println(mejorCalificacion.toString());	
		}
		else {
			System.out.println("No hay mejor calificacion");
		}

		//consultarCalificacion por modulo
		Calificacion calif = alumno1.consultarCalificacion("LM");
		if (calif != null) {
			System.out.println(calif.toString());
		}
		else {
			System.out.println("no hay calificacion");
		}

		//modficar una calificacion
		if(alumno1.modificar("P",8.5)) {
			System.out.println("ACTUALIZADO");
			calif = alumno1.consultarCalificacion("P");
			System.out.println(calif.toString());
			System.out.println();
		}
		else {
			System.out.println("No actualizado");
		}

	}
}
