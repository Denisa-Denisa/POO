package ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class Afluente {
	private int id;
	private String nombre = "";
	private double longitud = 0;
	private List<CiudadPasaRio> ciudades = new ArrayList<>();
	private String lugarNacimiento = "";
	private int desembocadura = 0;
	private List<Afluente> afluentes = new ArrayList<>();

	public Afluente(int id, String nombre, double longitud, String lugaNacimiento, int desembocadura) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.longitud = longitud;
		this.lugarNacimiento = lugaNacimiento;
		this.desembocadura = desembocadura;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public String getLugarNacimiento() {
		return lugarNacimiento;
	}

	public void setLugaNacimiento(String lugaNacimiento) {
		this.lugarNacimiento = lugaNacimiento;
	}

	public int getDesembocadura() {
		return desembocadura;
	}

	public void setDesembocadura(int desembocadura) {
		this.desembocadura = desembocadura;
	}

	public int getId() {
		return id;
	}

	public String toString() {
		String misCiudades = "";
		String misAfluentes = "";
		for (CiudadPasaRio c : ciudades) {
			misCiudades += c + "\n";
		}
		for (Afluente f : afluentes) {
			misAfluentes += f.getId() + " " + f.getNombre() + "\n";
		}
		return "Afluente: " + id + " " + nombre + " " + longitud + " " + lugarNacimiento + " " + desembocadura
				+ "\nCiudades por las que pasa: \n" + misCiudades + "\n" + "Afluentes:\n" + misAfluentes + "\n";
	}

	public void crearAfluente(int id, String nombre, double longitud, String lugarNacimiento, int desembocadura) {
		if (!equals(id) && !existeAfluente(id)) {
			Afluente afluente = new Afluente(id, nombre, longitud, lugarNacimiento, desembocadura);
			afluentes.add(afluente);
		} else {
			System.out.printf("El afluente ya existe (%d)%n", id);
		}
	}

	public void crearAfluente(int idAfluentePadre, int id, String nombre, double longitud, String lugarNacimiento,
			int desembocadura) {
		if (equals(idAfluentePadre)) {
			crearAfluente(id, nombre, longitud, lugarNacimiento, desembocadura);
		} else {
			if (existeAfluente(idAfluentePadre)) {
				for (Afluente af : afluentes) {
					if (af.equals(idAfluentePadre)) {
						af.crearAfluente(id, nombre, longitud, lugarNacimiento, desembocadura);
					} else if (af.existeAfluente(idAfluentePadre)) {
						af.crearAfluente(idAfluentePadre, id, nombre, longitud, lugarNacimiento, desembocadura);
					}
				}
			}
		}
	}

	private void insertarAfluente(Afluente afluente) {
		afluentes.add(afluente);
	}

	public void actualizarAfluente(int idAfluente, String nombre, double longitud, String lugarNacimiento,
			int desembocadura) {
		Afluente af = encontrarAfluente(idAfluente);
		if (af != null) {
			af.setNombre(nombre);
			af.setLongitud(longitud);
			af.setLugaNacimiento(lugarNacimiento);
			af.setDesembocadura(desembocadura);
		} else {
			for (Afluente a : afluentes) {
				if (a.existeAfluente(idAfluente)) {
					a.actualizarAfluente(idAfluente, nombre, longitud, lugarNacimiento, desembocadura);
				}
			}
		}
	}

	public void eliminarAfluente(int idAfluente) {
		Afluente af = encontrarAfluente(idAfluente);
		if (af != null) {
			afluentes.remove(af);
		} else {

			for (Afluente a : afluentes) {
				if (a.existeAfluente(idAfluente)) {
					a.eliminarAfluente(idAfluente);
				}
			}
		}
	}

	public Afluente getAfluente(int idAfluente) {
		Afluente af = encontrarAfluente(idAfluente);
		if (af == null) {
			for (Afluente f : afluentes) {
				if (f.existeAfluente(idAfluente)) {
					af = f.getAfluente(idAfluente);
				}
			}
		}

		return af.clone();
	}

	public Afluente[] getAfluentes() {
		Afluente[] aa = new Afluente[afluentes.size()];
		return afluentes.toArray(aa);
	}

	private Afluente encontrarAfluente(int idAfluente) {
		for (Afluente af : afluentes) {
			if (af.equals(idAfluente)) {
				return af;
			}
		}
		return null;
	}

	public void crearCiudad(Ciudad ciudad, double km) {
		ciudades.add(new CiudadPasaRio(ciudad, km));
	}

	public void eliminarCiudad(int idCiudad) {
		CiudadPasaRio cr = null;
		do {
			cr = encontrarCiudad(idCiudad);
			if (cr != null) {
				ciudades.remove(cr);
			}
		} while (cr != null);
	}

	private CiudadPasaRio encontrarCiudad(int idCiudad) {
		for (CiudadPasaRio cr : ciudades) {
			if (cr.existeCiudad(idCiudad)) {
				return cr;
			}
		}
		return null;
	}

	public boolean existeAfluente(int idAfluente) {
		for (Afluente af : afluentes) {
			if (af.equals(idAfluente) || af.existeAfluente(idAfluente)) {
				return true;
			}
		}
		return false;
	}

	public boolean equals(int idAfluente) {
		return id == idAfluente;
	}

	public Afluente clone() {
		Afluente a = new Afluente(getId(), getNombre(), getLongitud(), getLugarNacimiento(), getDesembocadura());

		for (Afluente af : afluentes) {
			a.insertarAfluente(af.clone());
		}

		return a;
	}

	public void escribirAfluentes(String separador) {
		for (Afluente a : afluentes) {
			System.out.printf("%s%d %s%n", separador, a.getId(), a.getNombre());
			a.escribirAfluentes("\t" + separador);
		}
	}
}
