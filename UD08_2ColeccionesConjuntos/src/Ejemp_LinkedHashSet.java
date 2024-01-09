import java.util.TreeSet;

public class Ejemp_LinkedHashSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeSet<String> conjunto = new TreeSet<>();
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
