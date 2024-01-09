import java.util.HashSet;

public class Ejemp_HashSet {

	public static void main(String[] args) {
		
		//crear un hash set de cadenas 
		HashSet<String> conjunto = new HashSet<>();
		conjunto.add("Jaime");
		conjunto.add("Tobias");
		conjunto.add("Alvaro");
		conjunto.add("Pedro");
		conjunto.add("Jaime");
		
		/*for (String nombre : conjunto) {
			System.out.println(nombre);
		}*/
		System.out.println(conjunto.toString());
		
	}

}
