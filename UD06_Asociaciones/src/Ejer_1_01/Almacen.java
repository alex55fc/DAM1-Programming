package Ejer_1_01;

public class Almacen {
	//atributos
	private Videojuego[] vectorVideojuegos;
	private int contadorVideojuegos;
	
	//constructor, crear almacen a partir de in parametro
	public Almacen(int cantidad) {
		this.vectorVideojuegos = new Videojuego[cantidad];
		this.contadorVideojuegos = 0;
	}
	
	//Consulta TODOS los videojuegos del almacen.
	@Override 
	public String toString() {
		String cadena = "";
		if(contadorVideojuegos == 0) {
			cadena = "El almacen esta vacio.";
		}
		else {
			Videojuego x ;          //recorremos solo las posiciones donde hay objetos.
			for(int pos = 0 ; pos < contadorVideojuegos ; pos++) {
				x = vectorVideojuegos[pos];
				cadena = cadena + "("+ pos +")" + x.toString() + "\n";
			}
			cadena = cadena +"Se han consultado "+ contadorVideojuegos +" videojuegos del almacen";
		}
		return cadena;
	}
	
	public Videojuego consultar(int pos) {
		Videojuego videojuegoEnPosicion = null;
		if (pos >= 0 && pos < contadorVideojuegos ) {
			videojuegoEnPosicion = vectorVideojuegos[pos];
			
		}
		return videojuegoEnPosicion;
	}
	
	public boolean insertar(Videojuego x) {
		boolean insertado = false;
		//estoes asi ya que el contador muestra el esiguiente espacio vacio en el vector
		//por eso agregamos ese valor al vector de videojuego y lo igualamos al objeto de videojuego
		if (contadorVideojuegos < vectorVideojuegos.length) {
			vectorVideojuegos[contadorVideojuegos] = x;
			contadorVideojuegos++;
			
			insertado = true;
		}
		return insertado;
	}
	
	public boolean eliminar(int pos) {
		boolean eliminado = false;
		//nos aseguramos que sea una posicion aceptable
		if (pos >= 0 && pos < contadorVideojuegos) {
			//este contador es para la ultima posicion
			while ( pos < contadorVideojuegos - 1) {
				vectorVideojuegos[pos] = vectorVideojuegos[pos + 1];
				pos++;
			}
			vectorVideojuegos[pos] = null;
			contadorVideojuegos--;
			eliminado = true;
		}
		return eliminado;
	}

}
