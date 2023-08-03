package ejercicio3;

public class Ejercicio3 {
	/*
	 * Nos piden hacer una aplicaci�n donde necesitamos saber los rios de Espa�a.
	 * Los datos del rios que debemos guardar son: - nombre - longitud - principales
	 * ciudades por las que pasa - km del rio por donde pasa por la ciudad - lugar
	 * de nacimiento. - desembocadura
	 * 
	 * - listado de los afluentes del rio - la info. de los afluentes que
	 * necesitamos es la misma que la de los rios
	 */
	public static void main(String[] args) {
		Rios rios = new Rios("España");

		rios.crearRio(1, "Tajo", 1000, "Albarracin", "Atlantico");
		rios.crearRio(2, "Duero", 900, "lejos", "Atlantico");
		rios.crearRio(3, "Ebro", 900, "mas lejos", "Mediterraneo");
		// System.out.println(rios);
		// rios.eliminarRio(3);
		System.out.println(rios);
		rios.actualizarRio(3, "Ebrooooo", 999, "arriba", "a la derecha");
		System.out.println(rios);

		System.out.println(rios.getRio(2));
		System.out.println(rios.getRios()[0]);

		rios.crearAfluente(3, 1, "fffff", 333, "ffffff", 23);
		rios.crearAfluente(3, 3, "zzzzz", 999, "zzzzzz", 99);
		rios.crearAfluenteAlAfluente(1, 2, "gggg", 4444, "ggggg", 54);
		Rio r3 = rios.getRio(3);
		r3.escribirAfluentes();
		rios.eliminarAfluente(1);
		r3 = rios.getRio(3);
		r3.escribirAfluentes();

	}

	public void pruebasAfluentes() {
		Ciudad c = new Ciudad(1, "Madrid");
		System.out.println(c);

		Afluente a = new Afluente(1, "afluente1", 100, "Pepino", 6);
		// System.out.println(a);
		a.crearCiudad(c, 25);
		// System.out.println(a);
		a.crearCiudad(c, 50);
		// System.out.println(a);
		// a.eliminarCiudad(c.getId());
		// System.out.println(a);

		a.crearAfluente(2, "alberche", 30, "donde sea", 23);
		// System.out.println(a);
		a.crearAfluente(3, "ssdsa", 33, "dfdfds", 11);
		System.out.println(a);
		a.crearAfluente(3, 4, "ttttt", 44, "ttttt", 44);
		a.crearAfluente(4, 5, "yyyyy", 55, "yyyyyy", 55);
		// a.eliminarAfluente(2);
		System.out.println(a);

		a.actualizarAfluente(2, "alberche plis", 33, "donde plus", 33);
		a.actualizarAfluente(4, "ttyyy", 444, "ttyyy", 444);
		a.escribirAfluentes("");

		Afluente f = a.getAfluente(4);
		System.out.println(f);
		Afluente[] afluentes = a.getAfluentes();
		System.out.println("Cantidad de afluentes: " + afluentes.length);

		f.setNombre("GGGGGGG");
		System.out.println("SUPUESTO CLONE: \n" + f);
		System.out.println("ORIGINAL: \n");
		a.escribirAfluentes("");
	}

	public void pruebasRio() {
		Rio rio = new Rio(1, "Tajo", 1000, "Sierra albarracin", "Atlantico");

		rio.crearAfluente(1, "aaaa", 100, "aaaa", 10);
		rio.crearAfluente(1, 2, "abbbb", 100, "abbbbbb", 10);
		System.out.println(rio);
		rio.escribirAfluentes();
	}
}
