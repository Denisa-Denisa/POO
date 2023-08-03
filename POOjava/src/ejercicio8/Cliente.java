package ejercicio8;

public class Cliente {
	private String dni;
	private String nombre;
	private String apellidos;
	private Coche coche = null;
	
	public Cliente(String dni, String nombre, String apellidos) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public void alquilar(Coche coche) {
		if (this.coche == null) {
			this.coche = coche;
		} else {
			System.out.println("El cliente ya tiene un coche alquilado");
		}
	}
	
	public Coche devolver() {
		if (coche != null) {
			Coche c = coche;	
			coche = null;
			
			return c;
		}
		return null;
	}
	
	public boolean equals(String dni) {
		return this.dni.equals(dni);
	}
	
	public String toString() {
		return dni + " - " + nombre + " - " + apellidos + "\n Coche: " + coche;
	} 
}
