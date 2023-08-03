package ejercicio8;

enum Estado {
	ALQUILADO, LIBRE
}

public class Coche {
	private String matricula = "";
	private String marca = "";
	private String modelo = "";
	private int kilometros = 0;
	private Estado estado = Estado.LIBRE;
	
	public Coche(String matricula, String marca, String modelo) {
		this(matricula, marca, modelo, 0);
	}
	public Coche(String matricula, String marca, String modelo, int kilometros) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.kilometros = kilometros;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getKilometros() {
		return kilometros;
	}
	public void setKilometros(int kilometros) {
		this.kilometros = kilometros;
	}
	
	public boolean estaLibre() {
		return estado == Estado.LIBRE;
	}
	
	public void alquilar() {
		estado = Estado.ALQUILADO;
	}
	
	public void devolver() {
		estado = Estado.LIBRE;
	}
	
	public String toString() {
		return matricula + " - " + marca + " - " + modelo + 
					" - " + kilometros + " - " + estado.name();
	}
	
	public boolean equals(String matricula) {
		return this.matricula.equals(matricula);
	}
}
