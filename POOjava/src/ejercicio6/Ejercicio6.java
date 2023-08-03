package ejercicio6;

public class Ejercicio6 {
/*
	Modela el funcionamiento de un coche. 
	Debe poder 
		arrancar, 
		acelerar,
		frenar, 
		parar. 
	También debería poder comprobar la 
		- velocidad a la que va el coche, 
		- la gasolina que le queda, 
		- si está arrancado o no
 */
	public static void main(String[] args) {

		Coche coche = new Coche(40);
		
		System.out.println(coche);
		
		//coche.parar();
		coche.arrancar();
		System.out.println(coche);
		coche.acelerar();
		coche.acelerar(25);
		coche.acelerar(15);
		coche.acelerar(15);
		//System.out.println(coche);
		coche.frenar();
		//System.out.println(coche);
		coche.frenar(20);
		//System.out.println(coche);
		coche.frenar(30);
		System.out.println(coche);
		coche.frenar(30);
		System.out.println(coche);
		coche.arrancar();
		coche.parar();
		System.out.println(coche);
	}

}
