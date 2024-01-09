package iterativas_04;

import java.util.Scanner;

public class Sol_4_15{

	public static void main(String[] args) {
		double notaTeoria = 0;
		double notaProblemas = 0;
		double notaPracticas = 0;
		double notaFinal = 0;
		double mediaNotasFinales = 0; 
		int alumnosNotaFinal = 0;
		
		boolean comprobacion = false;
		
		Scanner teclado = new Scanner(System.in);
		
		for (int alumnos = 1; alumnos <= 10; alumnos++) {
			System.out.println("ALUMNO " + alumnos);
			System.out.print("¿Nota Teoria? ");
			notaTeoria = teclado.nextDouble();
			System.out.print("¿Nota Problemas? ");
			notaProblemas = teclado.nextDouble();
			System.out.print("¿Nota Practicas? ");
			notaPracticas = teclado.nextDouble();
			
			if (notaTeoria > 10 && notaPracticas > 10 && notaProblemas > 10) {
				System.err.println("La nota de teoria debe estar comprendida entre 0 y 10");
				System.err.println("La nota de problemas debe estar comprendida entre 0 y 10");
				System.err.println("La nota de problemas debe estar comprendida entre 0 y 10");
				continue;
			} else {
				comprobacion = true;
			}
			
			if (comprobacion) {
				if (notaTeoria > 10 ) {
					System.err.println("La nota de teoria debe estar comprendida entre 0 y 10");
					continue;
				} else {
					System.out.printf("Nota Teoria : %.2f\n", notaTeoria);
				}
				
				if (notaProblemas > 10 ) {
					System.err.println("La nota de problemas debe estar comprendida entre 0 y 10");
					continue;
				} else {
					System.out.printf("Nota Problemas : %.2f\n", notaProblemas);
				}
				
				if (notaPracticas > 10 ) {
					System.err.println("La nota de problemas debe estar comprendida entre 0 y 10");
					continue;
				} else {
					System.out.printf("Nota Practicas : %.2f\n", notaPracticas);
					notaFinal = ((notaTeoria * 0.3) + (notaProblemas * 0.2) + (notaPracticas * 0.5));
					System.out.print("Nota Final: " + notaFinal + "\n");
					mediaNotasFinales = mediaNotasFinales + notaFinal;
					alumnosNotaFinal++;
				}
				
			}
		}
		System.out.println("RESUMEN");
		System.out.println("Alumnos con nota final : " + alumnosNotaFinal);
		System.out.println("Suma de notas finales : " + mediaNotasFinales);
		System.out.println("Media aritmetica notas finales : " + mediaNotasFinales / alumnosNotaFinal);
	}
}

