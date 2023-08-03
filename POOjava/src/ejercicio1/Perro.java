package ejercicio1;

public class Perro {
	String nombre;
	String raza;
	float peso;
	float altura;
	int edad;
	boolean vacunado;
	boolean chip;

	public Perro(String nombre, String raza, float peso, float altura, int edad, boolean vacunado, boolean chip) {
		super();
		this.nombre = nombre;
		this.raza = raza;
		this.peso = peso;
		this.altura = altura;
		this.edad = edad;
		this.vacunado = vacunado;
		this.chip = chip;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public boolean isVacunado() {
		return vacunado;
	}

	public void setVacunado(boolean vacunado) {
		this.vacunado = vacunado;
	}

	public boolean isChip() {
		return chip;
	}

	public void setChip(boolean chip) {
		this.chip = chip;
	}

	public void nadar() {
		System.out.println(this.nombre + " esta nadando.");
	}

	public void ladrar() {
		System.out.println(this.nombre + " esta ladrando.");
	}

	public void andar() {
		System.out.println(this.nombre + " esta andado.");
	}

	public void correr() {
		System.out.println(this.nombre + " esta corriendo.");
	}
}
