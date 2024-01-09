package Ejer_adicional_random;

import entrada.Teclado;

public class Principal {

	// Escribe en consola el men� de opciones del programa.
	public static void escribirMenu() {
		System.out.println();
		System.out.println("(0) Salir del programa.");
		System.out.println("(1) Insertar un alumno en el grupo.");
		System.out.println("(2) Insertar varios alumnos con datos aleatorios en el grupo.");
		System.out.println("(3) Consultar un alumno del grupo.");
		System.out.println("(4) Consultar todos los alumnos del grupo.");
		System.out.println("(5) Insertar una calificaci�n en un alumno del grupo.");
		System.out.println("(6) Consultar una calificaci�n de un alumno del grupo.");
		System.out.println("(7) Actualizar una calificaci�n de un alumno del grupo.");
		System.out.println("(8) Consultar la mejor calificaci�n de un alumno del grupo.");
		System.out.println();
	}
		
	public static void main(String[] args) {
		int opcion, numeroExpediente, numeroAlumnos;
		double nota;
		String nombre, modulo;
		Grupo grupo = new Grupo("DAM1B");  // instanciar grupo DAM1B
		Alumno alumno;
		Calificacion calificacion;
		do {
			escribirMenu();
			opcion = Teclado.leerEntero("�Opci�n (0-8)? ");
			switch (opcion) {
			// Salir del programa.
			case 0:
				break;
				
			// Insertar un alumno en el grupo.
			case 1:
				nombre = Teclado.leerCadena("�Nombre? ");
				alumno = new Alumno(nombre);
				if (grupo.insertar(alumno)) {
					System.out.println("Alumno insertado.");
				}
				else {
					System.out.println("Error al insertar alumno.");
				}
				break;
				
			// Insertar varios alumnos con datos aleatorios en el grupo.
			case 2:
				numeroAlumnos = Teclado.leerEntero("�N�mero de Alumnos? ");
				numeroAlumnos = grupo.insertarVarios(numeroAlumnos);
				System.out.println(numeroAlumnos + " alumnos insertados.");
				break;
				
			// Consultar un alumno del grupo.
			case 3:
				numeroExpediente = Teclado.leerEntero("�N�mero de Expediente? ");
				alumno = grupo.consultar(numeroExpediente);
				if (alumno == null) {
					System.out.println("Alumno no encontrado.");
				}
				else {
					System.out.println(alumno.toString());
				}
				break;
				
			// Consultar todos los alumnos del grupo.
			case 4:
				System.out.println(grupo.toString());
				break;
					
			// Insertar una calificaci�n en un alumno del grupo.
			case 5:
				numeroExpediente = Teclado.leerEntero("�N�mero de Expediente? ");
				alumno = grupo.consultar(numeroExpediente);
				if (alumno == null) {
					System.out.println("Alumno no encontrado.");
				}
				else {
					modulo = Teclado.leerCadena("�M�dulo? ");
					nota = Teclado.leerReal("�nota? ");
					calificacion = new Calificacion(modulo, nota);
					if (alumno.insertar(calificacion)) {
						System.out.println("Calificaci�n insertada en un alumno.");
					}
					else {
						System.out.println("Error al insertar calificaci�n en alumno.");
					}
				}
				break;
				
			// Consultar una calificaci�n de un alumno del grupo.
			case 6:
				numeroExpediente = Teclado.leerEntero("�N�mero de Expediente? ");
				alumno = grupo.consultar(numeroExpediente);
				if (alumno == null) {
					System.out.println("Alumno no encontrado.");
				}
				else {
					modulo = Teclado.leerCadena("�M�dulo? ");
					calificacion = alumno.consultar(modulo);
					if (calificacion == null) {
						System.out.println("Calificaci�n no encontrada.");
					}
					else {
						System.out.println(calificacion.toString());
					}
				}
				break;
				
			// Actualizar una calificaci�n de un alumno del grupo.
			case 7:
				numeroExpediente = Teclado.leerEntero("�N�mero de Expediente? ");
				alumno = grupo.consultar(numeroExpediente);
				if (alumno == null) {
					System.out.println("Alumno no encontrado.");
				}
				else {
					modulo = Teclado.leerCadena("�M�dulo? ");
					calificacion = alumno.consultar(modulo);
					if (calificacion == null) {
						System.out.println("Calificaci�n no encontrada.");
					}
					else {
						nota = Teclado.leerReal("�Nota nueva? ");
						calificacion.setNota(nota);
						System.out.println("Calificaci�n actualizada de un alumno.");
					}
				}
				break;
				
			// Consultar la mejor calificaci�n de un alumno del grupo.
			case 8:
				numeroExpediente = Teclado.leerEntero("�N�mero de Expediente? ");
				alumno = grupo.consultar(numeroExpediente);
				if (alumno == null) {
					System.out.println("Alumno no encontrado.");
				}
				else {
					calificacion = alumno.consultarMejorCalificacion();
					if (calificacion == null) {
						System.out.println("El alumno no tiene calificaciones.");
					}
					else {
						System.out.println(calificacion.toString());
					}
				}
				break;
				
			// opcion de men� inv�lida
			default:
				System.out.println("La opci�n de men� debe estar comprendida entre 0 y 8.");
			}
		}
		while (opcion != 0);
		System.out.println("Programa finalizado.");
	}

}
