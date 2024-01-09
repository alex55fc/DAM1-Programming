
public class principal {

	public static void main(String[] args) {

		Circulo cir1 = new Circulo (7.2);
		Circulo cir2 = new Circulo (14.5);

		Cuadrado cuad1 = new Cuadrado (3.7);
		Cuadrado cuad2 = new Cuadrado (11.3);

		/*podemos instanciar clases Circulo Cuadrado en un objeto de la Interfaz Figura
		Figura figura = new Cuadrado(7);*/

		Figura [] figuras = new Figura[4];
		figuras[0] = cir1; 
		figuras[1] = cir2;
		figuras[2] = cuad1;
		figuras[3] = cuad2;
		
		for (int pos = 0 ; pos < figuras.length ; pos++) {
			Figura figura = figuras[pos];
			System.out.println(figura.toString());
		}

	}

}
