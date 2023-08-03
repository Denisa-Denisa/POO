package ejercicio6;

enum EstadoCoche {
	ARRANCADO, PARADO
}

public class Coche {
	// final static boolean ARRANCADO = true;
	// final static boolean PARADO = false;
	private final static float ACELERACION_POR_DEFECTO = 5;
	private final static float DESACELERACION_POR_DEFECTO = 5;

	private float velocidad = 0;
	private float gasolina = 0;
	private EstadoCoche estado = EstadoCoche.PARADO;

	public Coche(float gasolina) {
		super();
		this.gasolina = gasolina;
	}

	public float getGasolina() {
		return gasolina;
	}

	public float getVelocidad() {
		return velocidad;
	}

	public boolean estaArrancado() {
		return estado == EstadoCoche.ARRANCADO;
	}

	public String toString() {
		return "Velocidad: " + velocidad + "\nGasolina: " + gasolina + "\nEsta arrancado: "
				+ (estado == EstadoCoche.ARRANCADO ? "Si" : "No");
	}

	public void arrancar() {
		if (gasolina > 0 && estado == EstadoCoche.PARADO) {
			estado = EstadoCoche.ARRANCADO;
		} else {
			System.out.println("No se puede arrancar.");
		}
	}

	public void parar() {
		if (velocidad <= 0 && estado == EstadoCoche.ARRANCADO) {
			estado = EstadoCoche.PARADO;
		} else {
			System.out.println("No se ha podido parar el coche.");
		}
	}

	public void acelerar() {
		acelerar(ACELERACION_POR_DEFECTO);
	}

	public void acelerar(float aceleracion) {
		if (estaArrancado() && gasolina >= aceleracion) {
			velocidad += aceleracion;
			gasolina -= aceleracion;
		} else {
			System.out.println("No se puede acelerar.");
		}
	}

	public void frenar() {
		frenar(DESACELERACION_POR_DEFECTO);
	}

	public void frenar(float desaceleracion) {
		if (estaArrancado() && velocidad >= desaceleracion) {
			velocidad -= desaceleracion;
		} else {
			System.out.println("No se puede frenar.");
		}
	}
}
