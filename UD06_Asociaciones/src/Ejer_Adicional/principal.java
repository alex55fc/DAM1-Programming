package Ejer_Adicional;

import entrada.Teclado;

public class principal {
	public static void escribirMenu() {
		System.out.println();
		System.out.println("(0) Salir del Programa");
		System.out.println("(1) Insertar un alumno en el grupo");
		System.out.println("(2) Consultar un alumno del grupo");
		System.out.println("(3) Insertar una calificacion en un alumno");
		System.out.println("(4) consultar una califacion de un alumno del grupo");
		System.out.println("(5) Actualizar una calificacion de un alumno del grupo");
		System.out.println("(6) Consultar al mejor calificacion de un alumno");
		System.out.println();
	}

	public static void main(String[] args) {
		Grupo grupo = new Grupo("GrupoDAM1b");
		Alumno alumno;
		Calificacion calificacion;
		double nota;
		String nombre,numeroExpediente, modulo ;

		int opcion;
		do {
			escribirMenu();
			opcion = Teclado.leerEntero("¿opcion?");

			switch(opcion) {
			case 0:
				break;

				//Insertar un alumno en el grupo
			case 1:
				nombre = Teclado.leerCadena("nombre");
				numeroExpediente = Teclado.leerCadena("¿numero?");
				alumno = new Alumno(nombre, numeroExpediente);
				if(grupo.insertar(alumno)) {
					System.out.println("Alumno insertado.");
				}
				else {
					System.out.println("Error al insertar");
				}
				break;

				//Consultar un alumno del grupo
			case 2:
				numeroExpediente = Teclado.leerCadena("¿numero?");
				alumno = grupo.consultarNotasAlumno(numeroExpediente);
				if(alumno == null) {
					System.out.println("Alumno no encontrado");
				}
				else {
					System.out.println(alumno.toString());
				}
				break;

				//Insertar una calificacion en un alumno
			case 3:
				numeroExpediente = Teclado.leerCadena("¿numero? ");
				alumno = grupo.consultarNotasAlumno(numeroExpediente);
				if(alumno == null) {
					System.out.println("Alumno no encontrado ");
				}
				else {
					modulo = Teclado.leerCadena("¿modulo? ");
					nota = Teclado.leerReal("¿nota ");
					calificacion = new Calificacion(modulo, nota);
					if(alumno.insertar(calificacion)) {
						System.out.println("Calificacion insertada en un alumno");
					}
					else {
						System.out.println("El vector esta lleno");
					}
				}
				break;

				//consultar una califacion de un alumno del grupo
			case 4:
				numeroExpediente = Teclado.leerCadena("¿numero?");
				alumno = grupo.consultarNotasAlumno(numeroExpediente);
				if(alumno == null) {
					System.out.println("Alumno no encontrado");
				}
				else {
					modulo = Teclado.leerCadena("¿modulo? ");
					calificacion = alumno.consultarCalificacion(modulo);
					if (calificacion == null) {
						System.out.println("Calificacion no encontrada");
					}
					else {
						System.out.println(calificacion.toString());
					}
					
				}
				break;
			case 5:
				numeroExpediente = Teclado.leerCadena("Numero expediente");
				alumno = grupo.consultarNotasAlumno(numeroExpediente);
				if(alumno == null) {
					System.out.println("Alumno no encontrado ");
				}
				else {
					modulo = Teclado.leerCadena("¿modulo? ");
					calificacion = alumno.consultarCalificacion(modulo);
					if(calificacion == null) {
						System.out.println("Calificacion no encontrada");
					}
					else{
					nota = Teclado.leerReal("¿nota ");
					calificacion.setNota(nota);
					System.out.println("Calificacion acatualizada de un alumno");
					}
				}
				break;
			case 6:
				numeroExpediente = Teclado.leerCadena("Numero expediente");
				alumno = grupo.consultarNotasAlumno(numeroExpediente);
				if(alumno == null) {
					System.out.println("Alumno no encontrado ");
				}
				else {
					calificacion = alumno.consultarMejorCalificacion();
					if(calificacion == null) {
						System.out.println("El alumno no tiene calificaciones");
					}
					else {
						System.out.println(calificacion.toString());
					}
				}
				break;
			}

		}while(opcion != 0);
		System.out.println("Programa finalizado");

	}

}
