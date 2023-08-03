package ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		/*
		 * Modelar un sistema que maneje informaci�n sobre Comunidades Autonomas de
		 * Espa�a, las provincias que tiene cada comunidad y las ciudades de cada
		 * provincia.
		 * 
		 * Alguna informaci�n requerida podr�a ser: - Id - Nombre de la ciudad,
		 * provincia o comunidad - N�mero de habitantes - Capital - idiomas oficiales.
		 */

		/*
		 * ComunidadAutonoma madrid = new ComunidadAutonoma(1, "Madrid", "Madrid");
		 * madrid.crearProvincia(1, "Madrid", "Madrid", 3000000);
		 * madrid.crearProvincia(2, "Madrid2", "Madrid", 2000000); madrid.crearCiudad(1,
		 * 1, "Madrid", 3000000); madrid.crearCiudad(1, 2, "Madrid", 3000000);
		 * madrid.escribeInfo(); madrid.escribeProvincias();
		 * madrid.escribeInfoProvincia(1); comunidades.add(madrid);
		 */
		Pais spain = new Pais("España");
		Scanner sc = new Scanner(System.in);

		spain.crearComunidadAutonoma(1, "Madrid", "Madrid");
		spain.crearComunidadAutonoma(2, "Castilla La Macha", "Toledo");
		spain.crearComunidadAutonoma(3, "Extremadura", "Mérida");

		spain.crearProvincia(1, new Provincia(1, "Madrid", "Madrid", 4_000_000));
		spain.crearProvincia(2, new Provincia(2, "Toledo", "Toledo", 80_000));
		spain.crearProvincia(2, new Provincia(3, "Albacete", "Albacete", 110_000));
		spain.crearProvincia(3, new Provincia(4, "C�ceres", "M�rida", 100_000));
		spain.crearProvincia(3, new Provincia(5, "Badajoz", "Badajoz", 90_000));

		spain.crearCiudad(3, new Ciudad(1, "Albacete", 110_000));

		InterfazUsuario.mostrarPantallaInicio(sc, spain);
	}

}
