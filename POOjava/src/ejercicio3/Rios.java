package ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class Rios {
	private String nombre;
	private List<Rio> rios = new ArrayList<>();

	Rios(String nombre) {
		this.nombre = nombre;
	}

	public void crearRio(int id, String nombre, double longitud, String lugarNacimiento, String desembocadura) {
		if (!existeRio(id)) {
			Rio r = new Rio(id, nombre, longitud, lugarNacimiento, desembocadura);
			rios.add(r);
		} else {
			System.out.printf("El rio ya existe (%d)%n", id);
		}
	}

	public void eliminarRio(int idRio) {
		Rio r = encontrarRio(idRio);
		if (r != null) {
			rios.remove(r);
		} else {
			System.out.printf("No se ha encontrado el rio (%d).%n", idRio);
		}
	}

	public void actualizarRio(int idRio, String nombre, double longitud, String lugarNacimiento, String desembocadura) {
		Rio r = encontrarRio(idRio);
		if (r != null) {
			r.setNombre(nombre);
			r.setLongitud(longitud);
			r.setLugarNacimiento(lugarNacimiento);
			r.setDesembocadura(desembocadura);
		} else {
			System.out.printf("No se ha encontrado el rio (%d)%n", idRio);
		}
	}

	public Rio getRio(int idRio) {
		Rio r = encontrarRio(idRio);
		return r != null ? r.clone() : null;
	}

	public Rio[] getRios() {
		Rio[] rs = new Rio[rios.size()];
		return rios.toArray(rs);
	}

	private Rio encontrarRio(int idRio) {
		for (Rio r : rios) {
			if (r.equals(idRio)) {
				return r;
			}
		}
		return null;
	}

	public boolean existeRio(int idRio) {
		for (Rio r : rios) {
			if (r.equals(idRio)) {
				return true;
			}
		}
		return false;
	}

	public void crearAfluente(int idRio, int id, String nombre, double longitud, String lugarNacimiento,
			int desembocadura) {
		Rio r = encontrarRio(idRio);
		if (r != null) {
			r.crearAfluente(id, nombre, longitud, lugarNacimiento, desembocadura);
		} else {
			System.out.printf("No se ha encontrado el rio (%d).%n");
		}
	}

	public void crearAfluenteAlAfluente(int idAfluente, int id, String nombre, double longitud, String lugarNacimiento,
			int desembocadura) {
		for (Rio r : rios) {
			if (r.existeAfluente(idAfluente)) {
				r.crearAfluente(idAfluente, id, nombre, longitud, lugarNacimiento, desembocadura);
			}
		}
	}

	public void eliminarAfluente(int idAfluente) {
		for (Rio r : rios) {
			if (r.existeAfluente(idAfluente)) {
				r.eliminarAfluente(idAfluente);
			}
		}
	}

	public String toString() {
		String misRios = "";
		for (Rio r : rios) {
			misRios += r.getId() + " " + r.getNombre() + "\n";
		}
		return nombre + "\nRios:\n" + misRios + "\n";
	}
}
