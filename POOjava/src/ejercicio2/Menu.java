package ejercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
	private String titulo;
	private List<String> opciones = new ArrayList<>();
	private String eleccionTexto = "";

	public Menu(String titulo, String eleccionTexto) {
		super();
		this.titulo = titulo;
		this.eleccionTexto = eleccionTexto;
	}

	public void crearOpcion(String opcion) {
		opciones.add(opcion);
	}

	public void dibujar() {
		if (!titulo.isEmpty()) {
			System.out.println(repetir('*', titulo.length()));
			System.out.println(titulo.toUpperCase());
			System.out.println(repetir('*', titulo.length()));
		}
		System.out.println();
		for (String op : opciones) {
			System.out.println(op);
		}
		System.out.println();
		System.out.print(eleccionTexto);

	}

	public String pedirOpcion(Scanner sc) {
		String op = sc.nextLine();
		return op;
	}

	private String repetir(char c, int cantidad) {
		String str = "";
		for (int i = 1; i <= cantidad; i++) {
			str += c;
		}

		return str;
	}

}
