package Ejemp_asocioaciones;

public class Ejemp_Persona {
		private String nombre;
		private Ejemp_Fecha fechaNacimiento;
		
		public Ejemp_Persona(String nombre, int dia, int mes, int agno) {
			this.nombre = nombre;
			this.fechaNacimiento = new Ejemp_Fecha(dia, mes, agno);
		}
		@Override
		public String toString() {
			return "Persona [nombre = "+ nombre +", fecha de nacimiento = "+ fechaNacimiento+ "]";
		}

}
