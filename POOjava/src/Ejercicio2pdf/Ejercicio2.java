package Ejercicio2pdf;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio2 {

	public static void main(String[] args) {
 /*
  * Crea un programa que simule un peaje, por un peaje pasan distintos
tipos de vehículos: una moto, un camión, un bus y un auto, cada uno
paga impuestos diferentes. Lo que queremos hacer es que la clase
Peaje, implemente el cobro para los distintos tipos de vehículos. (Debes
aplicar polimorfismo).
  * 
  * 
  */
		
		Peaje peaje= new Peaje();
		Camion Camion = new Camion();
		Bus Bus = new Bus();
		Coche Coche = new Coche();
		Moto Moto = new Moto(); 
	       
		
		
		peaje.Cobrar(Moto);
		peaje.Cobrar(Coche);
		peaje.Cobrar(Bus);
		peaje.Cobrar(Camion);
		
		
	
		
		
	}
	
	}
	


