package Ejemplos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import Ejer_Empleados.Empleados;

public class metodosIMPORTANTES {
	
	//eliminar por posicion
	int contadorVideojuegos;
	int [] vectorVideojuegos = new int  [10];
	
	public boolean eliminar(int pos) {
		//definimos un booleano para devolverlo inicialmente false
		boolean eliminado = false;
		/*nos aseguramos que sea una posicion aceptable, posicion mayor que 0 y menor con el 
		contadorVIdeojuegos(//numero de objetos guardados y primera posicion libre del vector)*/
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
	//devuleve una lista con los ilbros que tengan el precio maximo 
		/*primero comparamos los precios hasta sacar el mayor y luego comparamos los precios de los libros
		 * vemos sio el precio es igual al precioMaximo y lo guardamos en una lista auxiliar */
	List<Libro>listaLibros;
		public List<Libro> consultarPorPrecioMaximo(){
			double precioMaximo = 0.0;
			for (Libro libro : listaLibros) {
				if (libro.getPrecio() > precioMaximo) {
					precioMaximo = libro.getPrecio();
				}
			}
			List<Libro> listaLibrosAux = new ArrayList<>();
			for (Libro libro : listaLibros) {
				if(libro.getPrecio() == precioMaximo) {
					listaLibrosAux.add(libro);
				}
			}
			return listaLibrosAux;
		}
	
		/*EN este metodo devolveremos un entero y no un booleanoo ya que hay mas de 2 casos posibles
		si el libro consultado por isbn no esxiste devolvemos -1, si existe y el stock es mayor a 0 devolvemos 0 
		y si no es mayor de 0 lo eliminamo.
		Luego en el principal tendremos que tener encuenta los 3 casos para mostrar mensajes distintos respectivamente*/
		public int vendedorPorIsbn(String isbn) {
			Libro libro = this.consultar2(isbn);
			
			if(libro == null) {
				return -1;//libro no econtrado
			}
			else {
				libro.decrementarNumeroUnidades();
				if (libro.getStock() > 0) {
					return 0; //libro vendido y quedan mas unidades 
				}
				else {
					this.eliminar(isbn);
					return 1;//si stock es 0 eliminamos el libro, con un metodo ya hecho,ya que no hay stock
				}
			}
			/*lo gestionamos en el principal asi:
			 * creamos parametro codigoVenta es donde devulve el resultado de vendedorPorIsbn y esos resultados devulven un dato depende del metodo
					//resultados posible -1, 0 y 1 eso lo pusimos en los metodos
					codigoVenta = libreria.vendedorPorIsbn(isbn);
					if (codigoVenta == -1) {
						System.out.println("No se ah encontrado ningun libro con ese ISBN");
					}	
					else if (codigoVenta == 0) {
						System.out.println("se ha vendido una unidad del libro con ese ISBN");
						System.out.println("Aun quedan mas unidades de ese libro en la lista");
					}
					else {
						System.out.println("Se ha vendido 1 unidad del libro con ese ISBN");
						System.out.println("No quedan mas unidades de ese libro en la lista ");
						System.out.println("Se ha eliminado ese libro de la libreria");
					}*/
		}
		
	//esto es necesario si o si el instanceof y el transformas bebida a un objeto de refresco para usar su getter
	int indice;
	Bebidas bebidas;
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
	
	//SOLO PARA LISTAS, con el HashCode and equuals marcamos lo que queremos comparar y seleccionamos todas las opciones de debajo
	String dni;
	Persona persona ;
	//este metodo de source compara un objeto de persona con otro atraves de un dni(string)
	//necesitamos hacer esto para el contains y el remove
		@Override
		public int hashCode() {
			return Objects.hash(dni);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (!(obj instanceof Persona)) {
				return false;
			}
			Persona other = (Persona) obj;
			return Objects.equals(dni, other.dni);
		}
		
		//asi ordenamos por apellido ascendente y si son iguales los apellidos los ordenamos por nombre ascendente 
		public class OrdenPorPersonaPorApeNomAsc implements Comparator<Persona>{

			//
			@Override
			public int compare(Persona persona1, Persona persona2) {
				//de donde salen los apellidos no son los mismo?---------------------------------------------------
				String apellido1 = persona1.getApellidos();
				String apellido2 = persona2.getApellidos();
				
				//comparamos apellidos por si son los mismos y si son los mismos ordenador por nombre
				if(apellido1.equals(apellido2)) {
					String nombre1 = persona1.getNombres();
					String nombre2 = persona2.getNombres();
					return nombre1.compareTo(nombre2);
				}
				else {
					return apellido1.compareToIgnoreCase(apellido2);
				}
			}

		}
		//COMPARATOR
		/*cuando implementamos una interfaz de ordenacion si es en otra clase serta Comparator, y si es 
		 * en la misma clase sera Comparable*/
	
		//orden por nombre departamento ascendente y nombre ascendete
		public class OrdenDepNomAsc implements Comparator<Empleados> {

			@Override
			public int compare(Empleados e1, Empleados e2) {
				String dep1 = e1.getDepartamento();
				String dep2 = e2.getDepartamento();
				
				if (dep1.equalsIgnoreCase(dep2)) {
					String  nom1 = e1.getNombre();
					String  nom2 = e2.getNombre();
					return nom1.compareToIgnoreCase(nom2);
				}
				else {
					return dep1.compareToIgnoreCase(dep2);
				}
				
			}

		}
		/*con el Iterador recorremos el conjunto  podemos eliminar mientras recorremos*/
		public int eliminarEmpleadoDepar(String departamento){
			int empleadosEliminados = 0;
			Iterator<Empleados> iterador = conjuntoEmpleados.iterator();
			while(iterador.hasNext()) {
				Empleados e = iterador.next();
				if(e.getDepartamento().equalsIgnoreCase(departamento))	{
					iterador.remove();
					empleadosEliminados++;
				}
			}
			return empleadosEliminados;
		}

}