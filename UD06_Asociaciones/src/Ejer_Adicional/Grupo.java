package Ejer_Adicional;

public class Grupo {
	
	//atributos
	private String nombreAlumno;
	private Alumno[] vectorAlumnos;
	private int indice;
	
	//constructor
	public Grupo(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
		this.vectorAlumnos = new Alumno[30];
		this.indice = 0;
	}
	
	
	public boolean insertar(Alumno x) {
		boolean insertado = false;
		if (indice < vectorAlumnos.length) {
			vectorAlumnos[indice] = x;
			indice++;
			
			insertado = true;
		}
		return insertado;
	}
	
	
	public Alumno  consultarNotasAlumno(String numeroExpediente) {
		Alumno alumnoEncontrado = null;
		boolean encontrado = false;
		for (int pos = 0; pos < indice && !encontrado ; pos++) {
			Alumno x = vectorAlumnos[pos];
			if (x.getNumeroExpediente().equals(numeroExpediente));
			alumnoEncontrado = x;
			encontrado = true;
		}
		return alumnoEncontrado;
	}

	
	public static void main(String[] args) {
		Grupo grupo = new Grupo("DAM1B");
		Alumno alumno1 = new Alumno("Juan", "001");
		alumno1.insertar(new Calificacion ("P", 7));
		alumno1.insertar(new Calificacion ("BD", 6));
		alumno1.insertar(new Calificacion ("SI", 5));
		alumno1.insertar(new Calificacion ("ED", 4));
		alumno1.insertar(new Calificacion ("IN", 9));
		alumno1.insertar(new Calificacion ("LM", 8));
		alumno1.insertar(new Calificacion ("FOL", 5));
		grupo.insertar(alumno1);
		
		Alumno alumno2 = new Alumno("Maria", "001");
		alumno2.insertar(new Calificacion ("P", 7));
		alumno2.insertar(new Calificacion ("BD", 6));
		alumno2.insertar(new Calificacion ("SI", 5));
		alumno2.insertar(new Calificacion ("ED", 4));
		alumno2.insertar(new Calificacion ("IN", 9));
		alumno2.insertar(new Calificacion ("LM", 8));
		alumno2.insertar(new Calificacion ("FOL", 5));
		grupo.insertar(alumno2);
		
		Alumno alumnoBuscar = grupo.consultarNotasAlumno("001");
		if(alumnoBuscar == null) {
			System.out.println("Alumno no encontrado.");
		}
		else {
			System.out.println(alumnoBuscar.toString());
		}
	}
	

}
