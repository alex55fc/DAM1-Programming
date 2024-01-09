package selectivas_02;

import java.util.Scanner;

public class Ejer_2_09 {

	public static void main(String[] args) {
		// 
		int horario, horaOr, horaEx, turno;
		double salario;
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("¿Turno de trabajo (1-diurno, 2-vespertino)? ");
		turno = teclado.nextInt();
		System.out.print("¿Número de horas Ordinarias? ");
		horaOr = teclado.nextInt();
		System.out.print("¿Número de horas Extraordinarias? ");
		horaEx = teclado.nextInt();
		
		if (turno > 2) {
			System.out.print("El turno de trabajo debe estar comprendido entre 1 y 2.");
		}
		else if (turno == 1) {
			horario = (horaOr * 5) + (horaEx * 7);
			salario = horario;
			System.out.printf("Salario semanal: %.2f\n", salario);
		}
		else if (turno == 2) {
			horario = (horaOr * 8) + (horaEx * 11);
			salario = horario;
			System.out.printf("Salario semanal: %.2f\n", salario);
		}
	}

}
