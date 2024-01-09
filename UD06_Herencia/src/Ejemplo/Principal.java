package Ejemplo;

public class Principal {

	public static void main(String[] args) {
		//         |Estudiante -- Delegado
		// Persona |
		//         | Empleado -- jefeDepartamento
		Persona p1 = new Persona("12345678X", "Juan");
		
		Estudiante e1 = new Estudiante("22345678D", "Vadzim", 1, "Informatica");
		Estudiante e2 = new Estudiante("33345678F", "Alex", 2, "Cocina");
		
		//System.out.println(p1.toString());
		//System.out.println(e1.toString());
		//System.out.println(e2.toString());
		
		Empleado emp1 = new Empleado("44445678J", "Youssef ", "Programador ", false, 1426.10);
		Empleado emp2 = new Empleado("55555678J", "Tobias ", "Futbolista ", true, 1426.10);
		
		//System.out.println();
		//System.out.println(emp1.toString());
		//System.out.println(emp2.toString());
		
		//System.out.println();
		Delegado d1 = new Delegado("66666678T", "Alissa", 1 , "Informatica ","DAM1B" );
		//System.out.println(d1.toString());
		
		jefeDepartamento jd1 = new jefeDepartamento("77777778N", "Antonio", "Administradir base dato" , 2500.12 , "Sistemas");
		//System.out.println(jd1.toString());
		
		//podemos instaciar un objeto de la clasess hijas(jefeDepartamento de la clase padre(Empleado
		Empleado empleado = new jefeDepartamento("77777778N", "Antonio", "Administradir base dato" , 2500.12 , "Sistemas");
		Persona persona1 = new Delegado ("66666678T", "Alissa", 1 , "Informatica ","DAM1B" );
		/*vamos a guardarlo en un vector de personas donde ponemos un limite de 7 personas
		al declarar un obejto de Persona(que es la clase padre de todas) se podra guardan los objetos de clases hijas de Personas */
		 
		Persona[] personas = new Persona[7];
		personas[0] = p1;
		personas[1] = e1;
		personas[2] = e2;
		personas[3] = emp1;
		personas[4] = emp2;
		personas[5] = d1;
		personas[6] = jd1;
		//para saber de que tipò de objeto es el que comparamos
		for (int pos = 0 ; pos < personas.length ; pos++) {
			System.out.print("el Objeto "+ pos ); 
			if(personas[pos] instanceof Delegado) {
				//este metodo compara el objeto del vector para ver si es de los objetos instanciados en  Delegado, devuelve booleano true o false
				System.out.println(" es un delegado.");
			}
			else if(personas[pos] instanceof jefeDepartamento) {
				System.out.println(" es un jefe de Departamento.");
			}
			else if(personas[pos] instanceof Estudiante) {
				System.out.println(" es un Estudiante.");
			}
			else if(personas[pos] instanceof Empleado) {
				System.out.println(" es un Empleado.");
			}
			else {
				System.out.println(" es una persona");
			}
			System.out.println(personas[pos].toString());
		}
		
	}

}
