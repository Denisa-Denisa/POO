package ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Pais {
	private String nombre = "";
	private List<ComunidadAutonoma> comunidades = new ArrayList<>();

	public Pais(String nombre) {
		super();
		this.nombre = nombre;
	}

	private ComunidadAutonoma encontrarComunidadAutonoma(int id) {
		for (ComunidadAutonoma ca : comunidades) {
			System.out.println("econtrar: " + ca.getId());
			System.out.println("econtrar provincias: " + ca.getCantidadProvincias());
			if (ca.es(id)) {
				return ca;
			}
		}
		return null;
	}

	private ComunidadAutonoma encontrarComunidadAutonoma(Provincia provincia) {
		for (ComunidadAutonoma ca : comunidades) {
			if (ca.existeProvincia(provincia.getId())) {
				return ca;
			}
		}
		return null;
	}

	public ComunidadAutonoma buscarComunidadAutonoma(int id) {
		System.out.println("id comuniad: " + id);
		ComunidadAutonoma c = encontrarComunidadAutonoma(id);
		System.out.println("busca: " + c.getCantidadProvincias());
		return c != null ? c.clone() : null;
	}

	public Provincia buscarProvincia(int id) {
		for (ComunidadAutonoma ca : comunidades) {
			Provincia p = ca.buscarProvincia(id);
			if (p != null) {
				return p;
			}
		}
		return null;
	}

	public void crearComunidadAutonoma(int id, String nombre, String capital) {
		if (!existeComunidadAutonoma(id)) {
			comunidades.add(new ComunidadAutonoma(id, nombre, capital));
		}
	}

	public void crearComunidadAutonoma(ComunidadAutonoma comunidad) {
		crearComunidadAutonoma(comunidad.getId(), comunidad.getNombre(), comunidad.getCapital());
	}

	public void crearProvincia(int idComunidadAutonoma, int idProvincia, String nombre, String capital,
			int numeroHabitantes) {
		if (!existeProvincia(idProvincia)) {
			ComunidadAutonoma ca = encontrarComunidadAutonoma(idComunidadAutonoma);
			if (ca != null) {
				ca.crearProvincia(idProvincia, nombre, capital, numeroHabitantes);
			}
		}
	}

	public void crearProvincia(int idComunidadAutonoma, Provincia provincia) {
		crearProvincia(idComunidadAutonoma, provincia.getId(), provincia.getNombre(), provincia.getCapital(),
				provincia.getNumeroHabitantes());
	}

	public void crearCiudad(int idProvincia, int idCiudad, String nombre, int numeroHabitantes) {
		if (!existeCiudad(idCiudad)) {
			ComunidadAutonoma ca = encontrarComunidadAutonoma(buscarProvincia(idProvincia));
			if (ca != null) {
				System.out.printf("PAIS - crearCiudad - comunidad autonoma: %s", ca.getNombre());
				ca.crearCiudad(idProvincia, idCiudad, nombre, numeroHabitantes);
			} else {
				System.out.printf("La provincia con id %d no existe.%n", idProvincia);
			}
		} else {
			System.out.printf("La ciudad con id %d ya existe.%n", idCiudad);
		}
	}

	public void crearCiudad(int idProvincia, Ciudad ciudad) {
		crearCiudad(idProvincia, ciudad.getId(), ciudad.getNombre(), ciudad.getNumeroHabitantes());
	}

	public void eliminarComunidadAutonoma(ComunidadAutonoma comunidad) {
		if (comunidad != null) {
			eliminarComunidadAutonoma(comunidad.getId());
		}
	}

	public void eliminarComunidadAutonoma(int id) {
		ComunidadAutonoma comunidad = encontrarComunidadAutonoma(id);
		if (comunidad != null) {
			comunidades.remove(comunidad);
		}
	}

	public void eliminarProvincia(Provincia provincia) {
		if (provincia != null) {
			ComunidadAutonoma ca = encontrarComunidadAutonoma(provincia);
			ca.eliminarProvincia(provincia);
		}
	}

	public void actualizarProvincia(Provincia provincia) {
		if (provincia == null) {
			return;
		}

		ComunidadAutonoma ca = encontrarComunidadAutonoma(provincia);
		if (ca == null) {
			return;
		}
		ca.actualizarProvincia(provincia);
	}

	public boolean existeComunidadAutonoma(int idComunidadAutonoma) {
		for (ComunidadAutonoma ca : comunidades) {
			if (ca.es(idComunidadAutonoma)) {
				return true;
			}
		}
		return false;
	}

	public boolean existeProvincia(int idProvincia) {
		for (ComunidadAutonoma ca : comunidades) {
			if (ca.existeProvincia(idProvincia)) {
				return true;
			}
		}
		return false;
	}

	public boolean existeCiudad(int idCiudad) {
		for (ComunidadAutonoma ca : comunidades) {
			if (ca.existeCiudad(idCiudad)) {
				return true;
			}
		}
		return false;
	}

	public List<ComunidadAutonoma> getComunidadesAutonomas() {

		return comunidades;
	}
}
