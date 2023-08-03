package ejercicio2;

public class Ciudad {
	private int id=0;
	private String nombre = "";
	private int numeroHabitantes = 0;
	
	public Ciudad(int id, String nombre, int numeroHabitantes) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.numeroHabitantes = numeroHabitantes;
	}
	
	public Ciudad(int id, String nombre) {
		this(id, nombre, 0);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumeroHabitantes() {
		return numeroHabitantes;
	}

	public void setNumeroHabitantes(int numeroHabitantes) {
		this.numeroHabitantes = numeroHabitantes;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void escribeInfo() {
		System.out.printf("%s tiene %d habitantes.%n", 
				nombre, numeroHabitantes);
	}
	
	public boolean es(int idCiudad) {
		return id == idCiudad;
	}

}
