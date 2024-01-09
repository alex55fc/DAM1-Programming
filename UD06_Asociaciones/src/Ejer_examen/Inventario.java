package Ejer_examen;


public class Inventario {
	private Producto[] productos;
	private Producto[] vecCaducados;
	private int contadorProductos;
	
	//crear inventario
	public Inventario(int capacidadMax) {
		productos = new Producto[capacidadMax];
		vecCaducados= new Producto[capacidadMax];
		contadorProductos = 0;
	}
	
	@Override
	public String toString() {

		if (contadorProductos == 0) {
			return ("El inventario esta vacio.");
		} else {
			String cadena = "";
			for (int i = 0; i < contadorProductos; i++) {
				Producto producto = productos[i];
				cadena += "(" + i + ") " + productos[i].toString() + "\n";
			}
			return cadena;
		}
	}
	
	public boolean insertar(Producto producto) {
		if (contadorProductos >= productos.length) {
			return false;
		} else {
			productos[contadorProductos] = producto;
			contadorProductos++;
			return true;
		}
	}
	
	public Producto consultar(int posicion) {
		if (posicion < productos.length && posicion >= 0) {
			Producto producto = productos[posicion];
			return producto;
		} else {
			return null;
		}
	}
	
	
	public Producto[] recorrerProductos( ) {
		int contador=0;
		vecCaducados=new Producto[contadorProductos];
		for(int pos=0;pos<contadorProductos;pos++) {
			Producto caducados = productos [pos];
			if(caducados.caducado()) {
				vecCaducados[contador]=caducados;
				contador++;
			}
		}
		return vecCaducados;
	
	}
	

}
