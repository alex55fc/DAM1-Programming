package Ejer_usuario_prof;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Coleccion {

	private List<Usuario> listaUsuarios;

	// OJO CUIDAO: ESTO NO
	//private List<Administrador> la;
	//private List<Comprador> lc;
	
	public Coleccion() {
		this.listaUsuarios = new LinkedList<Usuario>();
	}
	
	public boolean insertar(Usuario usuario) {
		return listaUsuarios.add(usuario);
	}
	
	public Usuario consultarPorCorreo(String correo) {
		for (int pos = 0 ; pos < listaUsuarios.size() ; pos++) {
			Usuario usuario = listaUsuarios.get(pos);
			if (usuario.getCorreo().equals(correo)) {
				return usuario;
			}
		}
		return null;
	}
	
	public List<Usuario> ordenarPorNombreAsc() {
		List<Usuario> listaAux = new LinkedList<Usuario>();
		listaAux.addAll(listaUsuarios);
		Collections.sort(listaAux, new OrdenUsuarioPorNombreAsc());
		return listaAux;
	}
	
	public List<Usuario> consultarCompradoresPorCiudad(String ciudad) {
		List<Usuario> listaAux = new LinkedList<Usuario>();
		for (Usuario usuario : listaUsuarios) {
			if (usuario instanceof Comprador) {
				Comprador comprador = (Comprador) usuario;
				if (comprador.getDireccion().contains(ciudad)) {
					listaAux.add(usuario);
				}
			}
		}
		return listaAux;
	}
	
	public List<Usuario> consultarCompradoresPorTamagnoLista() {
		int tamagnoMaximoLista = 0;
		for (Usuario usuario : listaUsuarios) {
			if (usuario instanceof Comprador) {
				Comprador comprador = (Comprador) usuario;
				int tamagnoListaComprador = comprador.obtenerTamagnoLista();
				if (tamagnoListaComprador > tamagnoMaximoLista) {
					tamagnoMaximoLista = tamagnoListaComprador;
				}
			}
		}
		List<Usuario> listaAux = new LinkedList<Usuario>();
		for (Usuario usuario : listaUsuarios) {
			if (usuario instanceof Comprador) {
				Comprador comprador = (Comprador) usuario;
				int tamagnoListaComprador = comprador.obtenerTamagnoLista();
				if (tamagnoListaComprador == tamagnoMaximoLista) {
					listaAux.add(usuario);
				}
			}
		}
		return listaAux;
	}
	
}







