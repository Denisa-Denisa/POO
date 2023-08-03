package ejercicio8;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
	private String nombre;
	private List<Cliente> clientes = new ArrayList<>();
	private List<Coche> coches = new ArrayList<>();
	
	public Empresa(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void crearCoche(String matricula, String marca, String modelo, int kilometros) {
		Coche coche = new Coche(matricula, marca, modelo, kilometros);
		if (!existeCoche(matricula)) {
			coches.add(coche);
		} else {
			System.out.println("El coche ya existe.");
		}
	}
	public void crearCoche(String matricula, String marca, String modelo) {
		crearCoche(matricula, marca, modelo, 0);
	}
	public void crearCliente(String dni, String nombre, String apellidos) {
		if (!existeCliente(dni)) {
			Cliente cliente = new Cliente(dni, nombre, apellidos);
			clientes.add(cliente);
		} else {
			System.out.println("El cliente ya existe.");
		}
		
	}
	public boolean existeCoche(String matricula) {
		for(Coche c : coches) {
			if (c.equals(matricula)) {
				return true;
			}
		}
		return false;
	}
	public boolean existeCliente(String dni) {
		for(Cliente c : clientes) {
			if (c.equals(dni)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean estaCocheLibre(String matricula) {
		for(Coche c: coches) {
			if (c.estaLibre()) {
				return true;
			}
		}
		return false;
	}
	
	public void alquilar(String dni, String matricula) {
		Cliente c = encontrarCliente(dni);
		Coche ch = encontrarCoche(matricula);
		if (c != null && ch != null) {
			c.alquilar(ch);
			ch.alquilar();
		}
	}
	public void devolver(String dni) {
		Cliente cliente = encontrarCliente(dni);
		if (cliente != null) {
			Coche coche = cliente.devolver();
			coche.devolver();
		} else {
			System.out.println("El cliente no existe.");
		}
	}
	
	private Cliente encontrarCliente(String dni) {
		for(Cliente c : clientes) {
			if(c.equals(dni)) {
				return c;
			}
		}
		return null;
	}
	
	private Coche encontrarCoche(String matricula) {
		for(Coche c : coches) {
			if(c.equals(matricula)) {
				return c;
			}
		}
		return null;
	}
	public String toString() {
		String misCoches = "";
		String misClientes = "";
		
		for(Coche c : coches) {
			misCoches += c + "\n";
		}
		for(Cliente c : clientes) {
			misClientes += c + "\n";
		}
		return nombre + "\nCoches : " + misCoches + "\nClientes: " + misClientes;
	}
}
