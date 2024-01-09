package disenio_clases_02;

import entrada.Teclado;

public class Ejer_2_03_Tiempo {
	public static void escribirMenuOpciones() {
		System.out.println();
		System.out.println("(0) Salir del programa. ");
		System.out.println("(1) Leer por teclado un tiempo válido. ");
		System.out.println("(2) Visualizar en consola el tiempo. ");
		System.out.println("(3) Sumar al tiempo otro tiempo. ");
		System.out.println("(4) Restar al tiempo otro tiempo. ");
		System.out.println();
	}

	public static void main(String[] args) {
		int opcion;
		Tiempo tiempo1 = null; // aqui le ponemos un valor simp`lemente, para poder usarlo luego 
		Tiempo tiempo2 = null;
		int horas, minutos, segundos;
		do {
			escribirMenuOpciones();
			opcion = Teclado.leerEntero("Escribe la opccion: ");

			switch(opcion) {
				// PONER SALIDA
			case 0:
				break;

				// leer por teclado un tiempo valido
				// cuando diga Realizará el siguiente proceso iterativo hasta obtener unos datos válidos, hay que 
				//hacer un bucle hasta que el usuario de los datos correctos
			case 1:
				horas = Teclado.leerEntero("Escribe las horas: ");
				minutos = Teclado.leerEntero("Escribe los minutos: ");
				segundos = Teclado.leerEntero("Escribe los segundos: "); 

				// ponemos Tiempo porque es un metodo(validar) de la clase Tiempo
				while (! Tiempo.validar(horas, minutos, segundos)) {
					System.out.println("Las horas deben estar comprendidas entre 0 y 23.");
					System.out.println("Los minutos deben estar comprendidas entre 0 y 59.");
					System.out.println("Los hsegundos deben estar comprendidas entre 0 y 59.");
					horas = Teclado.leerEntero("Escribe las horas: ");
					minutos = Teclado.leerEntero("Escribe los minutos: ");
					segundos = Teclado.leerEntero("Escribe los segundos: "); 

				}
				tiempo1 = new Tiempo(horas, minutos, segundos);// cuando ponemos (tiempo1 = new Tiempo) se crea el objeto y 
				// se pierde el valor anterior(null)
				System.out.println("Se ha creado el tiempo valido.");
				break;

				// visualizar tiempo 
			case 2:
				if (tiempo1 == null) {
					System.out.println("No existe un tiempo creado");
				}
				else {
					System.out.println(tiempo1.obtenerEstado());
				}
				break;

				//Sumar al tiempo otro tiempo
			case 3:
				if (tiempo1 == null) {
					System.out.println("No existe un tiempo 1 creado");
				}
				else {
					System.out.println("Escribe otro tiempo.");
					horas = Teclado.leerEntero("Escribe las horas: ");
					minutos = Teclado.leerEntero("Escribe los minutos: ");
					segundos = Teclado.leerEntero("Escribe los segundos: "); 

					// ponemos Tiempo porque es un metodo(validar) de la clase Tiempo
					while (! Tiempo.validar(horas, minutos, segundos)) {
						System.out.println("Las horas deben estar comprendidas entre 0 y 23.");
						System.out.println("Los minutos deben estar comprendidas entre 0 y 59.");
						System.out.println("Los hsegundos deben estar comprendidas entre 0 y 59.");
						horas = Teclado.leerEntero("Escribe las horas: ");
						minutos = Teclado.leerEntero("Escribe los minutos: ");
						segundos = Teclado.leerEntero("Escribe los segundos: ");
					}
					tiempo2 = new Tiempo(horas, minutos, segundos);
					System.out.println("Se ha creado otro tiempo");

					System.out.println(tiempo1.obtenerEstado() + " + " + tiempo2.obtenerEstado());
					

					if (tiempo1.sumar(tiempo2)) {
						System.out.println("El resultado: ");
						System.out.println(tiempo1.obtenerEstado());
					}
					else {
						System.out.println("Error al sumar el tiempo más otro tiempo.");
						System.out.println("La suma debe ser igual o inferior a 23h:59m:59s.");
					}					
				}
				break;

				// Restar al tiempo otro tiempo
			case 4:
				if (tiempo1 == null) {
					System.out.println("No existe un tiempo creado");
				}
				else {
					System.out.println("Escribe otro tiempo.");
					horas = Teclado.leerEntero("Escribe las horas: ");
					minutos = Teclado.leerEntero("Escribe los minutos: ");
					segundos = Teclado.leerEntero("Escribe los segundos: "); 

					// ponemos Tiempo porque es un metodo(validar) de la clase Tiempo
					while (! Tiempo.validar(horas, minutos, segundos)) {
						System.out.println("Las horas deben estar comprendidas entre 0 y 23.");
						System.out.println("Los minutos deben estar comprendidas entre 0 y 59.");
						System.out.println("Los hsegundos deben estar comprendidas entre 0 y 59.");
						horas = Teclado.leerEntero("Escribe las horas: ");
						minutos = Teclado.leerEntero("Escribe los minutos: ");
						segundos = Teclado.leerEntero("Escribe los segundos: ");
					}
					tiempo2 = new Tiempo(horas, minutos, segundos);
					System.out.println("Se ha creado otro tiempo");

					System.out.println(tiempo1.obtenerEstado());
					System.out.println(tiempo2.obtenerEstado());
					
					System.out.println("resultado resta:");
					
					if (tiempo1.restar(tiempo2)) {
						System.out.println("El resultado: ");
						System.out.println(tiempo1.obtenerEstado());
					}
					else {
						System.out.println("Error al restar el tiempo menos otro tiempo");
						System.out.println("La resta debe ser igual o superior a 00h:00m:00s");
					}	

				}
				break;

				//usuario pulsa un boton que no es. PONERLO SIEMPRE
			default:
				System.out.println("Escoge una opccion correcta.");
				break;
			}
		}while(opcion != 0);
		System.out.println("Programa finalizado.");
	}

}

