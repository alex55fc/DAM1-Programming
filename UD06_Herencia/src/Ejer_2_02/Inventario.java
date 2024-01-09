package Ejer_2_02;

public class Inventario {
	
	//atributo 
	private Bebida_1_0[] bebidas;
	private int indice;
	
	//constructor
	public Inventario (int capacidad) {
		this.bebidas = new Bebida_1_0[capacidad];
		this.indice = 0;
	}
	
	//metodo insertar
	public boolean insertar(Bebida_1_0 bebida) {
		if ( indice < bebidas.length) {
			bebidas [indice] = bebida;
			indice++;
			return true;
		}
		else {
			return false;
		}
	}
	
	//metodo mostrar todas las bebidas
	@Override
	public String toString() {
		String cadena = "";
		for (int pos = 0; pos < indice ; pos++) {
			Bebida_1_0 x = bebidas[pos]; // aqui la bebida x ejecutara el toString del tipo de bebida es(clase hija) e igualmente con calcularProecio()
			cadena = cadena + "("+ pos +")"	+ x.toString() + "\nPrecio= " + x.calcularPrecio() + "\n";
		}
		return cadena;
	}
	// metodo vacio
	public boolean estaVacio() {
		return (indice == 0);
	}
	//metodo que usaremos para ver si esta lleno 
	public boolean estaLLeno() {
		return (indice == bebidas.length);
	}
	//
	public int obtenerNumeroBebidasGuardadas() {
		return indice;
	}
	/*en este metodo creamos un objeto de inventario donde insertaremos la bebida en la pos si es un Refresco_2_0
	y lo insertamos en inventariorefrescos. Luego o devolvemos */
	//preguntaar bien este metodo
	public Inventario consultarRefresco() {
		Inventario inventarioRefrescos = new Inventario(bebidas.length);
		for(int pos = 0; pos < indice ; pos++) {
			Bebida_1_0 bebida = bebidas[pos];
			if (bebida instanceof Refresco_2_0) {
				inventarioRefrescos .insertar(bebida);
			}
		}
		return inventarioRefrescos;
	}
	//metodo consultar por dos precio
	public Inventario consultarEntredosPrecio(double precioMin, double precioMax) {
		Inventario inventPrecio = new Inventario(bebidas.length);
		double precio;
		for (int pos = 0; pos < indice ; pos++) {
			Bebida_1_0 bebida = bebidas[pos];
			precio = bebida.calcularPrecio();
			if (precio >= precioMin && precio <= precioMax) {
				inventPrecio.insertar(bebida);
			}
		}
		return inventPrecio;
	}
	
	//esto es necesario si o si el instanceof y el transformas bebida a un objeto de refresco para usar su getter
	public int contarRefrescosGaseosos() {
		int contRefrescosGas = 0;
		for (int pos = 0; pos < indice ; pos++) {
			Bebida_1_0 bebida = bebidas[pos];
			if (bebida instanceof Refresco_2_0) {
				//para usar el get de refersco tranformamos la bebeiba a un objeto de Refresco haciendo esto (operador casting)
				Refresco_2_0 refresco = (Refresco_2_0) bebida;
				if(refresco.esGaseoso()) {
					contRefrescosGas++;
				}
			}
		}
		return contRefrescosGas;
	}
}
