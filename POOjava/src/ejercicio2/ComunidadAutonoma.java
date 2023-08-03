package ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class ComunidadAutonoma {
	private int id;
	private String nombre = "";
	private String capital = "";

	private List<String> idiomasOficiales = new ArrayList<String>();
	private List<Provincia> provincias = new ArrayList<Provincia>();

	public ComunidadAutonoma(int id, String nombre, String capital) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.capital = capital;

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

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public int getNumeroHabitantes() {
		int numeroHabitantes = 0;

		for (Provincia p : provincias) {
			numeroHabitantes += p.getNumeroHabitantes();
		}

		return numeroHabitantes;
	}

	public void actualizar(int id, String nombre, String capital) {
		setId(id);
		setNombre(nombre);
		setCapital(capital);
	}

	public void actualizar(ComunidadAutonoma comunidad) {
		actualizar(comunidad.getId(), comunidad.getNombre(), comunidad.getCapital());
	}

	public void actualizarProvincia(Provincia provincia) {
		Provincia p = encontrarProvincia(provincia);
		if (p != null) {
			p.setNombre(provincia.getNombre());
			p.setCapital(provincia.getCapital());
			p.setNumeroHabitantes(provincia.getNumeroHabitantes());
		}
	}

	public void crearProvincia(int id, String nombre, String capital, int numeroHabitantes) {
		if (!existeProvincia(id)) {
			Provincia p = new Provincia(id, nombre, capital, numeroHabitantes, this);
			provincias.add(p);
		}
	}

	public void crearProvincia(Provincia provincia) {
		crearProvincia(provincia.getId(), provincia.getNombre(), provincia.getCapital(),
				provincia.getNumeroHabitantes());
	}

	public void crearCiudad(int idProvincia, int idCiudad, String nombreCiudad, int numeroHabitantesCiudad) {
		if (!existeCiudad(idCiudad)) {
			for (Provincia p : provincias) {
				if (p.es(idProvincia)) {
					p.crearCiudad(idCiudad, nombreCiudad, numeroHabitantesCiudad);
				}
			}
		}
	}

	public void crearCiudad(int idProvincia, Ciudad ciudad) {
		crearCiudad(idProvincia, ciudad.getId(), ciudad.getNombre(), ciudad.getNumeroHabitantes());
	}

	public void eliminarProvincia(int id) {
		Provincia p = encontrarProvincia(id);
		if (p != null) {
			provincias.remove(p);
		}
	}

	public void eliminarProvincia(Provincia provincia) {
		eliminarProvincia(provincia.getId());
	}

	public void escribeProvincias() {
		for (Provincia p : provincias) {
			System.out.println(p.getNombre());
		}
	}

	public void escribeInfo() {
		System.out.printf("%s tiene %d provincias.%nTiene %d habitantes y su capital es %s.%n", nombre,
				provincias.size(), getNumeroHabitantes(), capital);
	}

	public void escribeInfoProvincia(int idProvincia) {
		Provincia p = buscarProvincia(idProvincia);
		if (p != null) {
			p.escribeInfo();
		}
	}

	private Provincia encontrarProvincia(int idProvincia) {
		for (Provincia p : provincias) {
			if (p.es(idProvincia)) {
				return p;
			}
		}
		return null;
	}

	private Provincia encontrarProvincia(Provincia provincia) {
		return encontrarProvincia(provincia.getId());
	}

	public Provincia buscarProvincia(int idProvincia) {
		Provincia p = encontrarProvincia(idProvincia);
		return p != null ? p.clone() : null;
	}

	public boolean existeProvincia(int idProvincia) {
		return buscarProvincia(idProvincia) != null;
	}

	public boolean existeCiudad(int idCiudad) {
		for (Provincia provincia : provincias) {
			if (provincia.existeCiudad(idCiudad)) {
				return true;
			}
		}
		return false;
	}

	public Provincia[] getProvincias() {

		Provincia[] misProvincias = new Provincia[provincias.size()];
		return provincias.toArray(misProvincias);
	}

	public boolean es(int id) {
		return this.id == id;
	}

	public int getCantidadProvincias() {
		return provincias.size();
	}

	public ComunidadAutonoma clone() {
		ComunidadAutonoma ca = new ComunidadAutonoma(getId(), getNombre(), getCapital());
		System.out.println("clone - ca: " + ca.getNombre());
		for (Provincia p : provincias) {
			System.out.println("clone - p: " + p.getNombre());
			ca.crearProvincia(p);
			for (Ciudad c : p.getCiudades()) {
				ca.crearCiudad(p.getId(), c);
			}
		}
		return ca;
	}
}
