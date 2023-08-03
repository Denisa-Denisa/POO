package ejercicio4;
import static java.lang.Math.*;

public class Circunferencia extends Figura {
	int radio;

	public Circunferencia(int radio) {
		this.radio = radio;
	}

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}



	public double getArea() {
		return PI*pow(radio, 2);
	}
	public double getPerimetro() {
		return 2*PI*radio;
	}
	

	
}
