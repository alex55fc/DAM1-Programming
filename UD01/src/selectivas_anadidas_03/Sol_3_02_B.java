package selectivas_anadidas_03;

import java.util.Scanner;

public class Sol_3_02_B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mes;
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("¿Mes?");
		mes = teclado. nextInt();
		
		if (0 < mes && mes <= 12) {
		switch (mes) {
		//febrero 
		case 2:
			System.out.println("28 días");
			break;
		// abril, junio, septiembre o noviembre
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("30 días");
			break;
		// enero, marzo, mayo, julio, agosto, octubre, o diciembre
		default:
			System.out.println("31 días");
		}
	}
	}

}
