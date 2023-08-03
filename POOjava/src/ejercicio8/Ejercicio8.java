package ejercicio8;

public class Ejercicio8 {
/*
	Crear las clases necesarias para modelar una empresa de alquiler de
	coches. (coches, clientes). 
	Un cliente debe poder alquilar o devolver un coche.
 */
	public static void main(String[] args) {
		Empresa empresa = new Empresa("XXXXXX");
		empresa.crearCoche("aa", "aaa", "aaaaa");
		empresa.crearCliente("12345678L", "aaaa", "aaaaa");
		
		System.out.println(empresa);
		System.out.println("Libre: " + empresa.estaCocheLibre("aa"));
		
		empresa.alquilar("12345678L", "aa");
		System.out.println("Libre: " + empresa.estaCocheLibre("aa"));
		System.out.println(empresa);
		
		empresa.devolver("1234567L");
		empresa.devolver("12345678L");
		System.out.println(empresa);
	}

	public void testCoche() {
		Coche coche = new Coche("1111111", "Seat", "Panda");
		
		System.out.println(coche);
		
		System.out.println(coche.estaLibre());
		
		coche.alquilar();
		
		System.out.println(coche.estaLibre());
		System.out.println(coche);
		
		coche.setKilometros(30);
		System.out.println(coche);
		coche.devolver();
		System.out.println(coche);
	}
	
	public void testCliente() {
		Cliente cliente = new Cliente("12345678L", "aaaa", "aaaaa");
		System.out.println(cliente);
		Coche coche = new Coche("1111111", "Seat", "Panda");
		cliente.alquilar(coche);
		System.out.println(cliente);
		Coche devuelto = cliente.devolver();
		System.out.println(cliente);
		System.out.println(devuelto);
	}
}
