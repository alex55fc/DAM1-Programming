package selectivas_02;

import java.util.Scanner;

public class Ejer_2_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dato;
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("¿Día de la semana? ");
		dato =  teclado.nextInt();
		
		switch (dato) {
			case 1:
				System.out.print("Lunes");
				break;
			case 2:
				System.out.print("Martes");
				break;
			case 3:
				System.out.print("Miércoles");
				break;
			case 4: 
				System.out.print("Jueves");
				break;
			case 5:
				System.out.print("Viernes");
				break;
			case 6:
				System.out.print("Sábado");
				break;
			case 7:
				System.out.print("Domingo");
				break;
			default:
				System.out.print("El dia de la semanadebe estar comprendidp entre 1 y 7");
		}
	}

}
