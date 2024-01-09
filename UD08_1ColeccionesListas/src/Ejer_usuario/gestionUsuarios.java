package Ejer_usuario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class gestionUsuarios {

	//atributos
	private List<Usuario> listaUsuarios;

	//constructor 
	public gestionUsuarios() {
		this.listaUsuarios = new ArrayList<Usuario>();
	}

	//toString 
	@Override 
	public String toString() {
		String cadena = "";
		if (listaUsuarios.isEmpty()) {
			System.out.println("La lista esta vacia ");
		}
		else {
			for (int pos = 0; pos < listaUsuarios.size(); pos++) {
				Usuario usuario = listaUsuarios.get(pos);
				cadena = cadena + "("+ pos +")" + usuario.toString() + "\n";
			}
			cadena = cadena + "Usuarios consultados "+ listaUsuarios.size();
		}

		return cadena;
	}
	//4-Consultar el correo, lohacemos antes porq asi usamos este metodo para comparar el correo en el 1
	public Usuario consultar(String correo) {
		for(Usuario usuariox : listaUsuarios) {
			if(usuariox.getCorreo().equals(correo)) {
				return usuariox;
			}
		}
		return null;
		/*otro metodo para consultar por correo 
		 * for (int pos = 0; pos < listaUsuarios.size() ; pos++
		 * 	Usuario usuario = listaUsuarios.get(pos) 
		 * if(usuario.getCorreo().equals(correo){
		 * return usuario}...etc
		 * */
	}
	//1-insertar un admin,comprador
	public boolean insertarUsuario(Usuario usuario) {
		listaUsuarios.add(usuario);
		return true;
		/*if(usuario instanceof Administradores) {
			listaUsuarios.add(usuario);
			return true;
		}
		else if(usuario instanceof Comprador) {
			listaUsuarios.add(usuario);
			return true;
		}
		else {
			return false;
		}*/
	}
	//5-cambiar el nombre de un usuario por correo.
	//buscamos el correo con el metodo de consultar por correo
	public Usuario cambiarNombContra(String nombre, String contrasenia,Usuario usuario) {

		usuario.setNombre(nombre);
		usuario.setContrasenia(contrasenia);

		return usuario;
	}
	//6-Eliminar un usuario, por correo, de la colección
	public boolean elminarUsuario (Usuario usuario) {
		if  (listaUsuarios.remove(usuario)) {
			return true;
		}
		else {
			return false;
		}
	}

	/*7- en este metodo vamos a llevar la listaUsuarios a una lista auxiliar par poder ordenarla ahi
	en este metodo podemos hacerlo asi para igualar listas pero en el metodo lo hacemos igual de arpido q usando un metodo auxiliar
	public List<Usuario> transformarLista(List<Usuario> lista){
		lista.addAll(listaUsuarios);
		return lista;
	}*/
	//7-Consultar todos los usuarios de la colección, ordenados por nombre ascendente.
	public  List<Usuario> ordenarPorNombreAsc(){
		List<Usuario> listaAux = new ArrayList<>();
		listaAux.addAll(listaUsuarios);
		Collections.sort(listaAux, new ordenNombreAsc());

		return listaAux;
	}
	//8-Consultar los usuarios que tengan una contraseña débil (6 o menos caracteres), de la colección
	public List<Usuario> contraDebil() {
		List<Usuario> listaAux = new ArrayList<>();
		for (Usuario usuariox : listaUsuarios) {
			String frase = usuariox.getContrasenia();
			if (frase.length() <= 6) {
				listaAux.add(usuariox);
			}

		}

		return listaAux;
	}
	//9-Consultar los compradores de la colección
	public List<Usuario> consultarComprador() {
		List<Usuario> listaAux = new ArrayList<>();
		for(Usuario usuariox : listaUsuarios) {
			if(usuariox instanceof Comprador) {
				listaAux.add(usuariox);
			}
		}
		return listaAux;
	}
	//10-Consultar los compradores que incluyan una ciudad en la dirección de envío, de la colección
	//usamos el contains para ver la  direccion de los comprador en la ciudad que pasemos 
	public List<Usuario> ciudadComprador(String ciudad){
		List<Usuario> listaAux = new ArrayList<>();
		for(Usuario usuariox : listaUsuarios) {
			if (usuariox instanceof Comprador) {
				Comprador comprador = (Comprador) usuariox;
				if(comprador.getDireccion().contains(ciudad));
			}
		}
		return listaAux;
	}
	//11-
	//para esto creamos un metodo en Comprador que nos devuleta el tamaño de la lista de favoritos 
	//recorremos los compradores y comparamos los precio hasta encontrar el mas alto
	//luego volvemos a recorrer los compradores y los compradores que tengan el tamanioLista igual al tamaño maximo  añadiremos ese usuario
	public List<Usuario> consultarCompradorPorTamanioLista(){
		int tamanioMaximoLista = 0;
		List<Usuario> listaAux = new ArrayList<>();
			for(Usuario usuario : listaUsuarios) {
				if(usuario instanceof Comprador) {
					Comprador comprador = (Comprador) usuario;
					int tamanioListaComprador = comprador.obtenerTamanioLista();
					if(tamanioListaComprador > tamanioMaximoLista) {
						tamanioMaximoLista = tamanioListaComprador;
					}
				}
			}
			for(Usuario usuario : listaUsuarios) {
				if(usuario instanceof Comprador) {
					Comprador comprador = (Comprador) usuario;
					int tamanioListaComprador = comprador.obtenerTamanioLista();
					if(tamanioListaComprador == tamanioMaximoLista) {
						listaAux.add(usuario);
					}
				}
			}
		return listaAux;
	}
	//12-
	public List<Usuario> consultarAdministradores(){
		List<Usuario> listaAux = new ArrayList<>();
		for(Usuario usuariox : listaUsuarios) {
			if(usuariox instanceof Administradores) {
				listaAux.add(usuariox);
			}
		}
		return listaAux;
	}
	
	//13-
	public List<Usuario> consultarAdminCategoria(String categoria){
		List<Usuario> listaAux = new ArrayList<>();
		for(Usuario usuariox : listaUsuarios) {
			if(usuariox instanceof Administradores) {
				Administradores admin = (Administradores) usuariox;
				if(admin.getCategoria().equals(categoria)) {
					listaAux.add(admin);
				}
			}
		}
		return listaAux;
	}
}
