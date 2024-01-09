package Ejer_2_02;


import java.util.Random;

import entrada.Teclado;

public class Principal {
	public static void escribirMenu() {
		System.out.println();
		System.out.println("(0) salir ");
		System.out.println("(1) Opciones clasicas Insertar un refresco en inventario por refresco");
		System.out.println("(2) opcion estra Insertar una bebida aleatoria ");
		System.out.println("(3) opccion extra Rellenar todo el inventario con bebidas aleatorias");
		System.out.println("(4) opcion real Consultar todas las bebidas del inventario");
		System.out.println("(5) opcion real consultar los refrersco del inventario ");
		System.out.println("(6) opcion real consultar bebidas entre dos precio");
		System.out.println("(7) opcion opcion real Consultar el numero de refrescos gasesos del inventario");
		System.out.println();
	}

	public static void main(String[] args) {
		int opcion ;
		String nombre;
		double azucar;
		boolean gas;
		Refresco_2_0 refresco;
		Inventario inventario = new Inventario(20);
		Random aleatorio = new Random();
		int tipo;
		// con este objeto lo usaremos para insertar directamente la bebida aleatoria entre
		// refreco, fermentada y destilada
		Bebida_1_0 bebida;
		//contadores para contar el tipo de bebida que metemos
		int contRefrescos, contFermentadas, contDestiladas;
		//Inventario auxiliar para la cantidad de una bebida dentro de un objeto Inventario
		Inventario inventAux;
		//limites de precios caso 6
		double precioMin, precioMax;
		//para contar los refrescosgas
		int contRefrescosGas;
		do {
			escribirMenu();
			opcion = Teclado.leerEntero("¿opcion?");

			switch(opcion) {

//-----------------------------------------------------------
			case 0:
				break;
	//-----------------------------------------------------------
				//Opciones clasicas Insertar un refresco en inventario por teclado
			case 1:
				nombre = Teclado.leerCadena("¿nombre?");
				azucar = Teclado.leerReal("¿Azucar?");
				gas = Teclado.leerBooleano("¿gas?");
				refresco = new Refresco_2_0 ( nombre, gas, azucar);
				 //usamos el metodo insertar donde el parametro es una bebida, pero como refresco es una clase hija de bebida puede usar ese metodo
				if (inventario.insertar(refresco)) {
					System.out.println("Se ha insertado");
				}
				else {
					System.out.println("El vector esta lleno");
				}
				break;
	//-----------------------------------------------------------
			case 2:
				//insertar tipo de bebida aleatoria 
				tipo = aleatorio.nextInt(3); // entre 0 1 2
				if ( tipo == 0) {
					bebida = new Refresco_2_0();
				}
				else if (tipo == 1) {
					bebida = new Fermentada_2_1();
				}
				else {
					bebida = new Destilada_2_1();	
				}
				if(inventario.insertar(bebida)) {
					System.out.println("Bebida insertada");
				}
				else {
					System.out.println("No se ha insertado la bebida");
				}
				break;
	//-----------------------------------------------------------
			case 3:
				contRefrescos = 0;
				contFermentadas = 0;
				contDestiladas = 0;
				// este while es para que añada una bebida hasta que el vector de bebidas este lleno indice == bebidas.length
				while(! inventario.estaLLeno()) {
					tipo = aleatorio.nextInt(3); // entre 0 1 y 2
					if ( tipo == 0) {
						bebida = new Refresco_2_0();
						//este if es para ver si puede insertar la bebida, si la inserta sumamos al contador ya que lo a insertado cbien
						if(inventario.insertar(bebida)){
							contRefrescos++;
						}
					}
					else if (tipo == 1) {
						bebida = new Fermentada_2_1();
						if(inventario.insertar(bebida)){
							contFermentadas++;
						}
					}
					else {
						bebida = new Destilada_2_1();	
						if(inventario.insertar(bebida)){
							contDestiladas++;
						}
					}
	
				}
				System.out.println(contRefrescos +" refrescos insertados");
				System.out.println(contFermentadas +" refrescos fermentadas");
				System.out.println(contDestiladas +" refrescos destiladas");
				break;
	//-----------------------------------------------------------
			case 4:
				if(inventario.estaVacio()) {
					System.out.println("Inventario vacio");
				}
				else {
					System.out.println(inventario.toString());
					System.out.println("Se han insertador "+ inventario.obtenerNumeroBebidasGuardadas());
				}
				break;
	//-----------------------------------------------------------			
			case 5:
				inventAux = inventario.consultarRefresco();
				if (inventAux.estaVacio()) {
					System.out.println("Esta vacio");
				}
				else {
					System.out.println(inventAux.toString());
					System.out.println(inventAux.obtenerNumeroBebidasGuardadas() + " refrescos guardados");
				}
				break;	
	//-----------------------------------------------------------		
			case 6:
				precioMin = Teclado.leerReal("¿precio minimo?");
				precioMax = Teclado.leerReal("¿precio maximo?");
				inventAux = inventario.consultarEntredosPrecio(precioMin, precioMax);
				inventAux = inventAux.consultarRefresco();
				if (inventAux.estaVacio()) {
					System.out.println("No hay bebidas entre esos precios");
				}
				else {
					System.out.println(inventAux.toString());
					System.out.println(inventAux.obtenerNumeroBebidasGuardadas() + " bebidas entre esos precios");
				}
				break;
	//-----------------------------------------------------------		
			case 7:
				contRefrescosGas = inventario.contarRefrescosGaseosos();
				System.out.println(contRefrescosGas + " refrescos gaseosos");
				break;
	//-----------------------------------------------------------		
			default:
				System.out.println("Escoge una opcion correcta");
				break;
					
			}
		}while(opcion != 0);
		System.out.println("Programa acabado");

	}

}
