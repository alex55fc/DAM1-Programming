package procedimientos_02;

import java.util.Scanner;

public class Sol_2_03 {
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			boolean check = true;
			int altura, anchura, numero = 1;
			
			
			Scanner teclado = new Scanner(System.in);
			
			while (numero != 0) {
				System.out.println("¿Altura Rectangulo? ");
				altura = teclado.nextInt();
				System.out.println("¿Altura Rectangulo? ");
				anchura = teclado.nextInt();
				
				if (altura < 0) {
					System.out.println("La anchura debe ser positiva");
					check = false;
				}
				
				if (anchura < 0) {
					check = false;
					System.out.println("La anchura debe ser positiva");
				}
				
				if (check) {
					System.out.println("RECTANGULO CON RELLNO");
					dibujarRectangulo(altura, anchura, true);
					System.out.println("RECTANGULO CON BORDERS");
					dibujarRectangulo(altura, anchura, false);
				}
				
				System.out.println("¿Desea procesar otro rectangulo (0 para salir)? ");
				numero = teclado.nextInt();
			}
		}
		
		public static void dibujarRectangulo(int altura, int anchura, boolean modo) {
			if (modo) {
				for (int a=1; a <= altura; a++) {
					for (int b = 1; b <= anchura; b++) {
						System.out.print("*");
					}
					System.out.println();
				}
			} else {
				for (int a=1; a <= altura; a++) {
					System.out.print("*");
					for (int b = 1; b <= anchura; b++) {
						if (a == 1 || a == altura || b == anchura) {
							System.out.print("*");
						} else {
							System.out.print(" ");
						}
					}
					System.out.println();
				}
			}
		}
	}


