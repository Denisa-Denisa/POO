package ejercicio2;

import java.util.Scanner;

public class InterfazUsuario {

	public static void mostrarPantallaInicio(Scanner sc, Pais pais) {
		String op;
		do {
			InterfazUsuario.limpiarPantalla(25);
			Menu menu1 = new Menu("Comunidades Autonomas", "Elige una opcion: ");
			for (ComunidadAutonoma ca : pais.getComunidadesAutonomas()) {
				menu1.crearOpcion(ca.getId() + ". " + ca.getNombre());
			}
			menu1.crearOpcion("");
			menu1.crearOpcion("N. Nueva Comnidad Autonoma");
			menu1.crearOpcion("S. Salir");
			menu1.dibujar();
			op = menu1.pedirOpcion(sc);
			if (op.equalsIgnoreCase("S")) {
				System.out.println("Adios, muy buenas.");
				System.exit(0);
			} else if (op.equalsIgnoreCase("N")) {
				ComunidadAutonoma ca = InterfazUsuario.mostrarPantallaCreacionComunidadAutonoma(sc);
				pais.crearComunidadAutonoma(ca);
			} else {
				InterfazUsuario.mostrarPantallaComunidadAutonoma(sc, pais, Integer.parseInt(op));
			}
		} while (!op.equalsIgnoreCase("S"));
	}

	public static ComunidadAutonoma mostrarPantallaCreacionComunidadAutonoma(Scanner sc) {
		limpiarPantalla(25);
		System.out.println("NUEVA COMUNIDAD AUTONOMA");
		System.out.println("Id: ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.println("Nombre: ");
		String nombre = sc.nextLine();
		System.out.println("Capital: ");
		String capital = sc.nextLine();

		ComunidadAutonoma ca = new ComunidadAutonoma(id, nombre, capital);
		return ca;
	}

	public static void mostrarPantallaComunidadAutonoma(Scanner sc, Pais pais, int id) {
		// TODO
		ComunidadAutonoma ca = pais.buscarComunidadAutonoma(id);
		if (ca != null) {
			String op;
			do {
				limpiarPantalla(25);
				System.out.println(ca.getNombre().toUpperCase());
				System.out.println("Id: " + ca.getId());
				System.out.println("Capital: " + ca.getCapital());
				System.out.println("Numero de provincias: " + ca.getCantidadProvincias());

				Menu menu = new Menu("", "Elige una opci�n: ");
				for (Provincia p : ca.getProvincias()) {
					menu.crearOpcion(p.getId() + ". " + p.getNombre());
				}
				menu.crearOpcion("");
				menu.crearOpcion("N. Nueva Provincia");
				menu.crearOpcion("M. Modificar Comunidad Autonoma: ");
				menu.crearOpcion("E. Eliminar Comunidad Autonoma: ");
				menu.crearOpcion("S. Salir");
				menu.dibujar();
				op = menu.pedirOpcion(sc);
				if (op.equalsIgnoreCase("N")) {
					Provincia p = mostrarPantallaCreacionProvincia(sc);
					pais.crearProvincia(id, p);
				} else if (op.equalsIgnoreCase("M")) {
					ComunidadAutonoma editCa = mostrarPantallaModificacionComunidadAutonoma(sc, ca);
					ca.actualizar(editCa);
				} else if (op.equalsIgnoreCase("E")) {
					if (confirmar(sc, "Desea eliminar la Comunidad Autonoma? (S/N)")) {
						pais.eliminarComunidadAutonoma(ca);
					}
				} else if (op.equalsIgnoreCase("S")) {

					break; // salimos del bucle
				} else {
					InterfazUsuario.mostrarPantallaProvincia(sc, pais, Integer.parseInt(op));
				}
				ca = pais.buscarComunidadAutonoma(id); // recargo los datos por si ha habido modificaciones
				// ya que tengo una copia de los datos
			} while (!op.equalsIgnoreCase("S"));
		}

	}

	public static Provincia mostrarPantallaCreacionProvincia(Scanner sc) {
		limpiarPantalla(25);
		System.out.println("NUEVA PROVINCIA");
		System.out.println("Id: ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.println("Nombre: ");
		String nombre = sc.nextLine();
		System.out.println("Capital: ");
		String capital = sc.nextLine();
		System.out.println("Numero habitantes: ");
		int habitantes = Integer.parseInt(sc.nextLine());

		Provincia p = new Provincia(id, nombre, capital, habitantes);
		return p;
	}

	public static ComunidadAutonoma mostrarPantallaModificacionComunidadAutonoma(Scanner sc,
			ComunidadAutonoma comunidad) {
		String op;
		do {
			limpiarPantalla(25);
			System.out.println("MODIFICAR COMUNIDAD AUTONOMA");

			Menu menu = new Menu("", "Elige una opcion: ");
			menu.crearOpcion("2. Nombre: " + comunidad.getNombre());
			menu.crearOpcion("3. Capital: " + comunidad.getCapital());
			menu.crearOpcion("");
			menu.crearOpcion("S. Salir");
			menu.dibujar();

			op = menu.pedirOpcion(sc);
			if (op.equalsIgnoreCase("1")) {
				System.out.println("Nombre: ");
				comunidad.setNombre(sc.nextLine());
			} else if (op.equalsIgnoreCase("2")) {
				System.out.println("Capital: ");
				comunidad.setCapital(sc.nextLine());
			}

		} while (!op.equalsIgnoreCase("S"));

		return comunidad;
	}

	public static void mostrarPantallaProvincia(Scanner sc, Pais pais, int idProvincia) {
		// TODO
		Provincia p = pais.buscarProvincia(idProvincia);
		if (p != null) {
			String op;
			do {
				limpiarPantalla(25);
				System.out.println(p.getNombre().toUpperCase());
				System.out.println("Id: " + p.getId());
				System.out.println("Capital: " + p.getCapital());
				System.out.println("Numero de habitantes: " + p.getNumeroHabitantes());
				System.out.println("Numero de ciudades: " + p.getCantidadCiudades());

				Menu menu = new Menu("", "Elige una opci�n: ");
				for (Ciudad c : p.getCiudades()) {
					menu.crearOpcion(c.getId() + ". " + c.getNombre());
				}
				menu.crearOpcion("");
				menu.crearOpcion("N. Nueva ciudad");
				menu.crearOpcion("M. Modificar provincia: ");
				menu.crearOpcion("E. Eliminar provincia: ");
				menu.crearOpcion("S. Salir");
				menu.dibujar();
				op = menu.pedirOpcion(sc);
				if (op.equalsIgnoreCase("N")) {
					Ciudad c = mostrarPantallaCreacionCiudad(sc);
					pais.crearCiudad(p.getId(), c);
				} else if (op.equalsIgnoreCase("M")) {
					Provincia editProv = mostrarPantallaModificacionProvincia(sc, p);
					pais.actualizarProvincia(editProv);
				} else if (op.equalsIgnoreCase("E")) {
					if (confirmar(sc, "Desea eliminar la Provincia? (S/N)")) {
						pais.eliminarProvincia(p);
						op = "S";
					}
				}
				p = pais.buscarProvincia(idProvincia); // recargo los datos por si ha habido modificaciones
			} while (!op.equalsIgnoreCase("S"));

		}

	}

	public static Provincia mostrarPantallaModificacionProvincia(Scanner sc, Provincia provincia) {
		String op;
		do {
			limpiarPantalla(25);
			System.out.println("MODIFICAR PROVINCIA");

			Menu menu = new Menu("", "Elige una opci�n: ");
			menu.crearOpcion("1. Nombre: " + provincia.getNombre());
			menu.crearOpcion("2. Capital: " + provincia.getCapital());
			menu.crearOpcion("3. Numero de habitantes: " + provincia.getNumeroHabitantes());
			menu.crearOpcion("");
			menu.crearOpcion("S. Salir");
			menu.dibujar();

			op = menu.pedirOpcion(sc);
			if (op.equalsIgnoreCase("1")) {
				System.out.println("Nombre: ");
				provincia.setNombre(sc.nextLine());
			} else if (op.equalsIgnoreCase("2")) {
				System.out.println("Capital: ");
				provincia.setCapital(sc.nextLine());
			} else if (op.equalsIgnoreCase("3")) {
				System.out.println("Numero de habitantes: ");
				provincia.setNumeroHabitantes(Integer.parseInt(sc.nextLine()));
			}

		} while (!op.equalsIgnoreCase("S"));

		return provincia;
	}

	public static Ciudad mostrarPantallaCreacionCiudad(Scanner sc) {
		limpiarPantalla(25);
		System.out.println("NUEVA CIUDAD");
		System.out.println("Id: ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.println("Nombre: ");
		String nombre = sc.nextLine();
		System.out.println("Numero habitantes: ");
		int habitantes = Integer.parseInt(sc.nextLine());

		Ciudad c = new Ciudad(id, nombre, habitantes);
		return c;
	}

	public static void limpiarPantalla(int cantidad) {
		for (int i = 1; i <= cantidad; i++) {
			System.out.println();
		}
	}

	public static boolean confirmar(Scanner sc, String etiqueta) {
		String sn;
		do {
			System.out.print(etiqueta);
			sn = sc.nextLine();
		} while (!sn.toLowerCase().equals("s") && !sn.toLowerCase().equals("n"));

		return sn.toLowerCase().equals("s");
	}
}
