package iterativas_04;

import java.util.Scanner;

public class Ejer_4_15 {

	public static void main(String[] args) {
		// 
		final int LIMITE = 10;
		int contadorAlum = 1, contadorNotaF = 0;
		boolean error;
		double notaT, notaProblem, notaPrac;
		double notaFinal = 0, sumaNotaF = 0, mediaNotaF = 0;
		Scanner teclado = new Scanner (System.in);

		for (contadorAlum = 1 ; contadorAlum <= LIMITE ; contadorAlum++) {			
			System.out.println("ALUMNO " + contadorAlum);

			System.out.print("¿Nota de Teoría? ");
			notaT = teclado.nextDouble();
			System.out.print("¿Nota de Problemas? ");
			notaProblem = teclado.nextDouble();
			System.out.print("¿Nota de Prácticas? ");
			notaPrac = teclado.nextDouble();
			error = true;
			
			if (notaT < 0 || notaT > 10) {
				System.out.println("Lan nota de Teoría debe estar entre 0 y 10");
				error = false;
			}
			if (notaProblem < 0 || notaProblem > 10) {
				System.out.println("Lan nota de Problemas debe estar entre 0 y 10");
				error = false;
			}
			if (notaPrac < 0 || notaPrac > 10) {
				System.out.println("Lan nota de Prácticas debe estar entre 0 y 10");
				error = false;
			}
			if (error == true) {
				System.out.printf("Nota de Teoría:    %2.2f\n", notaT);
				System.out.printf("Nota de Problemas: %2.2f\n", notaProblem);
				System.out.printf("Nota de Prácticas: %2.2f\n", notaPrac);
				notaFinal = notaT * 0.3 + notaProblem *0.2 + notaPrac * 0.5;
				System.out.printf("Nota Final:        %2.2f\n", notaFinal);
				contadorNotaF++;
				sumaNotaF = sumaNotaF + notaFinal;
			}
		}
		mediaNotaF = sumaNotaF / contadorNotaF;
		System.out.println("RESUMEN");
		System.out.println("Alumnos con notas finales: " + contadorNotaF);
		System.out.printf("Suma Notas FInales: %.2f\n", sumaNotaF);
		System.out.printf("Media Aritmética de Notas finales: %.2f\n", mediaNotaF);
	}

}


