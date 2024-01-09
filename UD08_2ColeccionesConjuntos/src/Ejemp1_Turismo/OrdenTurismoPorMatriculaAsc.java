package Ejemp1_Turismo;

import java.util.Comparator;

public class OrdenTurismoPorMatriculaAsc implements Comparator<Turismo> {

	@Override
	public int compare(Turismo t1, Turismo t2) {
		String matricula1 = t1.getMatricula();
		String matricula2 = t2.getMatricula();
		return matricula1.compareToIgnoreCase(matricula2);
	}
	

}
