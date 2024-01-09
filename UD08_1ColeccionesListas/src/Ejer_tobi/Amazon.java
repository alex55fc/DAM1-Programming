package Ejer_tobi;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class Amazon {
	private String nombre;
	private List<Usuario> lista;
	//constructor
	public Amazon(String nombre) {
		this.nombre = nombre;
		this.lista = new ArrayList <Usuario>();
	}

	private static final String[] CIUDADES = {
			"Zaragoza", "Madrid", "Barcelona", "Sevilla", "Valencia", "Toledo", "Cordoba",
			"Segovia", "Mallorca", "Murcia", "Salamanca", "Canaria", "Avila", "Burgos",
			"Lucía", "Sofía", "Martina", "María", "Julia", "Paula", "Valeria",
			"Granada", "Bilbao", "Caceres", "Cadiz", "Cuenca", "Tarragona", "Huesca"
	};

	//insertar usuario
	public boolean insertar(Usuario us) {
		return lista.add(us);
	}


	public Usuario consultarPorCorreo(String correo) {
		for(Usuario user : lista) {
			if(user.getCorreoElectrónico().equals(correo)) {
				return user;
			}
		}
		return null;
	}

	public void cambiarNombreyContrasenia(String correo, String nombre, String contrasenia) {
		for(Usuario user : lista) {
			if(user.getCorreoElectrónico().equals(correo)) {
				user.setNombre(nombre);
				user.setContraseña(contrasenia);
			}
		}
	}

	//PREGUNTAR PORQUE NO FUNCIONA ESTA DE ELIMINAR
	/*public boolean eliminar(String correo) {
		Usuario correoBuscar = new Usuario("", correo,"");
		return lista.remove(correoBuscar);
	}*/

	public boolean eliminarPorCorreo(String correo) {
		Usuario usuario;
		usuario = this.consultarPorCorreo(correo);
		if(usuario != null) {
			lista.remove(usuario);
			return true;
		}
		return false;
	}

	public List<Usuario> contraseniaDebil(){
		List<Usuario> listaAux = new ArrayList <Usuario>();
		for(Usuario user : lista) {
			if (user.getContraseña().length()<6) {
				listaAux.add(user);
			}
		}
		return listaAux;
	}

	public List<Usuario> direccionConCiudad(){
		String ciudad;
		List<Usuario> listaAuxCiudad = new ArrayList <Usuario>();
		for(int i = 0; i<CIUDADES.length; i++) {
			ciudad = CIUDADES[i];
			for(Usuario user : lista) {
				Comprador comprador  = (Comprador)user;
				if (comprador.getDirección().contains(ciudad)) {
					listaAuxCiudad.add(user);
				}
			}
		}
		return listaAuxCiudad;
	}

	public boolean añadirProducto (String correo, String producto) {
		Usuario usuario;
		usuario = this.consultarPorCorreo(correo);
		for(Usuario user : lista) {
			if(usuario!=null) {
				Comprador comprador  = (Comprador)usuario;
				comprador.getLista().add(producto);
				return true;
			}

		}
		return false;
	}

	public List<Usuario> consultarAdminPorCategoria(String categoria) {
		List<Usuario> listaAuxCategoria = new ArrayList <Usuario>();
		for(Usuario user : lista) {
			Administrador admin  = (Administrador)user;
			if (admin.getCategoria().equalsIgnoreCase(categoria)) {
				listaAuxCategoria.add(user);
			}
		}
		return listaAuxCategoria;
	}

	public List<Usuario> adminsQueNoRevisan() {
		List<Usuario> listaAuxNoRevisan = new ArrayList <Usuario>();
		for(Usuario user : lista) {
			Administrador admin  = (Administrador)user;
			if (!admin.isRevisa()) {
				listaAuxNoRevisan.add(user);
			}
		}
		return listaAuxNoRevisan;
	}

	public List<Usuario> listaMasLarga() {
		int maxTamanoLista = 0;
		List<Usuario> listaMasLarga = new ArrayList <Usuario>();
		for(Usuario user : lista) {
			Comprador comp  = (Comprador)user;
			int tamanoLista = comp.getLista().size();
			if (tamanoLista > maxTamanoLista) {
				maxTamanoLista = tamanoLista;
				listaMasLarga.clear();
				listaMasLarga.add(comp);
			} 
		}
		return listaMasLarga;
	}

	public List<Usuario> listaMasLarga2() {
		int maxTamanoLista = this.listaMasLarga().size();
		List<Usuario> listaMasLarga = new ArrayList <Usuario>();
		//listaMasLarga.addAll(this.listaMasLarga());
		for(Usuario user : lista) {
			Comprador comp  = (Comprador)user;
			int tamanoLista = comp.getLista().size();
			if (tamanoLista == maxTamanoLista) {
				listaMasLarga.add(comp);
			} 
		}
		return listaMasLarga;
	}

	public boolean eliminarProducto(String correo, String producto) {
		Usuario usuario;
		usuario = this.consultarPorCorreo(correo);
		if(usuario != null) {
			Comprador comprador  = (Comprador)usuario;
			comprador.getLista().remove(producto);
			return true;
		}
		return false;
	}

	public String generarContraseniaSegura() {    
		String cadena ="";
		Random ale = new Random();
		cadena+= (char) ale.nextInt(66,68);
		
		int contrasenia = ale.nextInt(0,4);
		if(contrasenia == 0) {
			cadena ="RIV";
		}
		else if(contrasenia == 1) {
			cadena ="MAD";
		}
		else if(contrasenia == 2) {
			cadena ="BUE";
		}
		else {
			cadena ="BAR";
		}

		int numero = ale.nextInt(100,9999);
		cadena+=numero;

		return cadena;
	}
	
	//FUNCIONA, PERO PREGUNTAR PORQUE NO SE PUEDE PONER EN EL FOR listaAuxContSegura.
	public boolean cambiarContrasenia () {
		String contraseniaSegura;
		List<Usuario> listaAuxContSegura= new ArrayList <Usuario>();
		listaAuxContSegura = this.contraseniaDebil();
		for(Usuario user : this.contraseniaDebil()) {
			contraseniaSegura = this.generarContraseniaSegura();
			user.setContraseña(contraseniaSegura);
			//listaAuxContSegura.clear();
		}
		return true;
	}

	@Override
	public String toString() {
		String cadena ="";
		for(int pos = 0; pos < lista.size(); pos++) {
			Usuario user = lista.get(pos);
			cadena=cadena+ 
					user.toString() + "\n";
		}
		return cadena;
	}









}