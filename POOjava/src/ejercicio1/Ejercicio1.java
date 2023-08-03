package ejercicio1;

public class Ejercicio1 {
	/*
	 * Modelar un sistema donde se guarda informaci�n sobre perros. A�adir
	 * comportamiento como ladrar, nadar, andar, correr...
	 * 
	 */

	public static void main(String[] args) {
		Perro perro = new Perro("Kuki", "Doberman", 32.5f, 60.3f, 8, true, false);

		System.out.printf(
				"El perro llamado %s de la raza %s con peso %.2f y "
						+ "altura %.2f y cuya edad es %d, %s esta vacunado y %s tiene el chip.",
				perro.getNombre(), perro.getRaza(), perro.getPeso(), perro.getAltura(), perro.getEdad(),
				getSiNo(perro.isVacunado()), getSiNo(perro.isChip()));
	}

	public static String getSiNo(boolean ok) {
		return ok ? "si" : "no";
	}
}
