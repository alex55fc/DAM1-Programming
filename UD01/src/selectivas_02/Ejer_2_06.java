package selectivas_02;

import java.util.Scanner;

public class Ejer_2_06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num;
		int horas, minutos, segundos;
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Tiempo en segundos: ");
		num = teclado.nextInt();
		
		if (num <= 0) {
			System.out.print("El tiempo en segundos debe ser mayor o igual a cero.");
		}
		else {
			//el % es como si usaramos un dividir pero devuelve el resto de la division 
			horas = num / 3600;
			minutos = (num % 3600) / 60;
			segundos = (num % 3600)%60;
			System.out.println(""+ horas + " horas " + minutos + " minutos " + segundos + " segundos ");
		} 
	}

}
