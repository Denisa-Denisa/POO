package ejercicio3;

public class CiudadPasaRio {
	private Ciudad ciudad;
	private double km;

	public CiudadPasaRio(Ciudad ciudad, double km) {
		super();
		this.ciudad = ciudad;
		this.km = km;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public double getKm() {
		return km;
	}

	public void setKm(double km) {
		this.km = km;
	}
	public int getId() {
		return ciudad.getId();
	}
	
	public String getNombre() {
		return ciudad.getNombre();
	}
	
	public boolean existeCiudad(int idCiudad) {
		return ciudad.equals(idCiudad);		
	}
	
	public String toString() {
		return ciudad + " " + km;
	}
}
