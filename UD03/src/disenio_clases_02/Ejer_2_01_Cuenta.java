package disenio_clases_02;

import entrada.Teclado;

public class Ejer_2_01_Cuenta {
	
	public static void escribirMenuOpciones(){
		System.out.println();
		System.out.println("(0) Salir del programa.");
		System.out.println("(1) Visualizar en consola las dos cuentas.");
		System.out.println("(2) Ingresar un importe en la cuenta 1.");
		System.out.println("(3) Retirar un importe de la cuenta 1.");
		System.out.println("(4) Ingresar un importe en la cuenta 2.");
		System.out.println("(5) Retirar un importe de la cuenta 2.");
		System.out.println("(6) Transferir un importe de la cuenta 1 a la cuenta 2.");
		System.out.println("(7) Transferir un importe de la cuenta 2 a la cuenta 1.");
		System.out.println();
	}

	public static void main(String[] args) {
		int opcion;
		double importe;
		Cuenta cuenta1 = new Cuenta(1, "Francisco Gomez");
		System.out.println("Se ha creado la cuenta bancaria 1");
		Cuenta cuenta2 = new Cuenta(2, "Victoria Serrano");
		System.out.println("Se ha creado la cuenta bancaria 2");
		do {
			escribirMenuOpciones();
			opcion = Teclado.leerEntero("Introduce una opcion.");
			
			switch(opcion) {
			
				//Salir del programa
			case 0:
				break;
				
				//Visualizar en consola las dos cuentas
			case 1:
				System.out.println(cuenta1.obtenerCuenta());
				System.out.println(cuenta2.obtenerCuenta());
				break;
				
				//Ingresar un importe en la cuenta 1
			case 2:
				importe = Teclado.leerReal("Ingresa el importe ");
				if(cuenta1.ingresar(importe)) {
				System.out.println("Se ha ingresado importe en la cuenta 1");
				}
				else {
					System.out.println("Error al ingresar un importe en la cuenta 1 ");
					System.out.println("El importe debe ser positivo.");
				}
				break;
				
				 //Retirar un importe de la cuenta 1
			case 3:
				importe = Teclado.leerReal("Ingresa el importe a retirar");
				if(cuenta1.retirar(importe)) {
					System.out.println("Se ha retirado el importe");
				}
				else {
					System.out.println("Error al retirar el importe");
					System.out.println("El importe debe ser positivo");
					System.out.println("El importe debe ser menor o igual que el saldo");
				}
				break;
				
				//Ingresar un importe en la cuenta 2
			case 4:
				importe = Teclado.leerReal("Ingresa el importe a ingresar ");
				if(cuenta2.ingresar(importe)) {
					System.out.println("Se ha ingresado importe en la cuenta 2");
				}
				else {
					System.out.println("Error al ingresar un importe en la cuenta 2 ");
					System.out.println("El importe debe ser positivo.");
				}
				break;
			
				//Retirar un importe de la cuenta 2
			case 5:
				importe = Teclado.leerReal("Ingresa el importe a retirar.");
				if (cuenta2.retirar(importe)) {
					System.out.println("Se ha retirado el importe");
				}
				else {
					System.out.println("Error al retirar el importe");
					System.out.println("El importe debe ser positivo");
					System.out.println("El importe debe ser menor o igual que el saldo");
				}
				break;
				
				//Transferir un importe de la cuenta 1 a la cuenta 2
			case 6:
				importe = Teclado.leerReal("¿Importe? ");
				if (cuenta1.transferir(importe, cuenta2)) {
					System.out.println("Se ha hecho la transferencia correctamente;");
				}
				else {
					System.out.println("Error al transferir un importe");
					System.out.println("El importe debe ser positivo");
					System.out.println("El importe debe ser menor o igual que el saldo de la cuenta 1");
				}
				break;
				
				//Transferir un importe de la cuenta 2 a la cuenta 1
			case 7:
				importe = Teclado.leerReal("¿Importe?");
				if (cuenta2.transferir(importe, cuenta1)) {
					System.out.println("Se ha hecho la transferencia correctamente;");
				}
				else {
					System.out.println("Error al transferir un importe");
					System.out.println("El importe debe ser positivo");
					System.out.println("El importe debe ser menor o igual que el saldo de la cuenta 1");
				}
				break;
			}
		}while (opcion != 0);
		System.out.println("El programa ha finalizado.");
	}

}


