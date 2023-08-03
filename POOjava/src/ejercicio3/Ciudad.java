package ejercicio3;

public class Ciudad {
	private int id;
	private String nombre;

	Ciudad(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public boolean equals(int id) {
		return this.id == id;
	}
	
	public String toString() {
		return "Ciudad: " + id + " " + nombre;
	}
}
