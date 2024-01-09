package disenio_clases_02;

public class Cuenta {

	//atributos de una cuenta bancara
	private int numero;
	private String cliente;
	private double saldo;

	//constructor de una cuenta bancaria a apartir de 2 parametros.
	public Cuenta(int numero, String cliente) {
		this.numero = numero;
		this.cliente = cliente;
		this.saldo = 0.0;
	}


	//metodos
	public String obtenerCuenta() {
		return
				"Cuenta[Numero cuenta =  "+ numero+
				", Cliente = "+ cliente +
				", Saldo = "+ String.format("%.2f", saldo);
	}

	public boolean ingresar(double importe) {
		if (importe >= 0) {
			saldo = saldo + importe;
			return true;
		}
		else {
			return false;
		}
	}

	public boolean retirar(double importe) {
		if (importe > 0.0 && importe <= saldo) {
			saldo = saldo - importe;
			return true;
		}
		else {
			return false;
		}	
	}
	//creamos un objeto de Cuenta llamada destino, y definimos destino.saldo 
	public boolean transferir(double importe, Cuenta destino) {
		if(importe > 0.0 && importe <= saldo) {
			saldo = saldo - importe;
			destino.saldo = destino.saldo + importe; 
			return true;
		}
		else {
			return false;
		}
	}
}
