package ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Provincia {
	private ComunidadAutonoma comunidad = null;
	private int id;
	private String nombre;
	private String capital;
	private int numeroHabitantes;
	private List<Ciudad> ciudades = new ArrayList<Ciudad>();

	public Provincia(int id, String nombre, String capital, int numeroHabitantes, ComunidadAutonoma comunidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.capital = capital;
		this.numeroHabitantes = numeroHabitantes;
		this.comunidad = comunidad;
	}

	public Provincia(int id, String nombre, String capital, int numeroHabitantes) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.capital = capital;
		this.numeroHabitantes = numeroHabitantes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCapital() {
		return capital;
	}

	public int getCantidadCiudades() {
		return ciudades.size();
	}

	public Ciudad[] getCiudades() {
		// devuelve un array con los objetos del ArrayList ciudades
		Ciudad[] cc = new Ciudad[ciudades.size()];
		return ciudades.toArray(cc);
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public int getNumeroHabitantes() {
		return numeroHabitantes;
	}

	public void setNumeroHabitantes(int numeroHabitantes) {
		this.numeroHabitantes = numeroHabitantes;
	}

	public void crearCiudad(int id, String nombre, int numeroHabitantes) {
		Ciudad c = new Ciudad(id, nombre, numeroHabitantes);
		ciudades.add(c);
	}

	public void crearCiudad(Ciudad c) {
		crearCiudad(c.getId(), c.getNombre(), c.getNumeroHabitantes());
	}

	public void escribeCiudades() {
		for (Ciudad c : ciudades) {
			System.out.println(c.getNombre());
		}
	}

	public void escribeInfo() {
		System.out.printf("%s tiene %d ciudades.%nTiene %d habitantes y su capital es %s.%n", nombre, ciudades.size(),
				numeroHabitantes, capital);
	}

	public boolean es(int id) {
		return this.id == id;
	}

	public boolean existeCiudad(int idCiudad) {
		for (Ciudad c : ciudades) {
			if (c.es(idCiudad)) {
				return true;
			}
		}
		return false;
	}

	public Provincia clone() {
		// Falta clonar el array de ciudades;
		Provincia p = new Provincia(getId(), getNombre(), getCapital(), getNumeroHabitantes());
		System.out.println("Provincia - clone - provinvia: " + p.getNombre());
		for (Ciudad c : ciudades) {
			System.out.println("Provincia - clone - ciudad: " + c.getNombre());
			p.crearCiudad(c);
		}
		return p;
	}
}
