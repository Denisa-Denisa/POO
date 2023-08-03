package ejercicio4;
import static java.lang.Math.*;

public class TrianguloRectangulo extends Figura {
	int cateto1;
	int cateto2;
	
	public TrianguloRectangulo(int cateto1, int cateto2) {
		super();
		this.cateto1 = cateto1;
		this.cateto2 = cateto2;
	}
	
	public int getCateto1() {
		return cateto1;
	}
	public void setCateto1(int cateto1) {
		this.cateto1 = cateto1;
	}
	public int getCateto2() {
		return cateto2;
	}
	public void setCateto2(int cateto2) {
		this.cateto2 = cateto2;
	}
	
	public double getHipotenusa() {
		return sqrt(pow(cateto1, 2) + pow(cateto2, 2));
	}
	
	public double getArea() {
		return (double)cateto1*cateto2 / 2;
	}
	
	public double getPerimetro() {
		return cateto1 + cateto2 + getHipotenusa();
	}
	
}
