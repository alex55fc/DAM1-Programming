package procedimientos_02;

import java.util.Scanner;

public class Sol_2_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int altura, opcion = 1;
		Scanner teclado = new Scanner(System.in);
				
		while (opcion != 0) {			
			System.out.println("0) Salir");
			System.out.println("1) Dibujar triangulo Izquierda");
			System.out.println("2) Dibujar triangulo Derecha");
			System.out.println("3) Dibujar triangulo Centro");
			System.out.print("Opcion (1-3) : ");
			opcion = teclado.nextInt();
			switch(opcion) {
			case 1:
				System.out.println("¿Altura? ");
				altura = teclado.nextInt();
				dibujarTrianguloIzquierda(altura);
				break;
			case 2:
				System.out.println("¿Altura? ");
				altura = teclado.nextInt();
				dibujarTrianguloDerecha(altura);
				break;
			case 3:
				System.out.println("¿Altura? ");
				altura = teclado.nextInt();
				dibujarTrianguloCentro(altura);
				break;
			default:
				System.out.println("Opcion no valida!");
			}
		}
	}
	
	public static void dibujarTrianguloDerecha(int altura) {
		for (int a = 0; a < altura; a++) {
			// dentro del for metemos otro for que comprueba el valor de a para saber cuantos asteriscos imprimir
			for (int b = 0; b <= a ; b++) {
				System.out.print("*");
			}
			// cuando acaba el for imprime un salto de linea
			System.out.print("\n");
		}
	}

	public static void dibujarTrianguloIzquierda(int altura) {
		for (int a = 1; a <= altura; a++) {
			
			// hacemos un bucle que coge el valor de a y lo compara con la altura, agrega lo restante con espacios
			for (int b = a; b < altura; b++) {
				System.out.print(" ");
			}
			
			// declaramos otro for con una variable c, comprueba si c es menor que a y lo completa con *
			for (int c = 0; c < a; c++) {
				System.out.print("*");
			}
			
			System.out.print("\n");
		}
	}
	
	public static void dibujarTrianguloCentro(int altura) {
		for(int a = 1; a <= altura; a++) {
			
			for (int b = a; b < altura; b++) {
				System.out.print(" ");
			}
			
			for (int c = 0; c < a * 2 -1; c++) {
				System.out.print("*");
			}
			
			System.out.print("\n");
		}
	
	}

}
