package ejercicio4;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio4 {

	public static void main(String[] args) {
		
		List<Figura> figuras = new ArrayList<>();
		
		figuras.add(new Circunferencia(7));
		figuras.add(new TrianguloRectangulo(4,7));
		figuras.add(new Rectangulo(10,25));
		figuras.add(new Cuadrado(34));
		
		for(Figura f : figuras) {
			System.out.printf("%s%n", f.getClass().getSimpleName());
			System.out.printf("Area: %.2f%n", f.getArea());
			System.out.printf("Perimetro: %.2f%n", f.getPerimetro());
		}

	}

}
