package Ejercicio2pdf;

public class Peaje {

	
	public void Cobrar(Vehiculo vehiculo) {
		System.out.printf("Cobrando %5.2f $ de impuesto a %s\n" , vehiculo.getImpuesto(), vehiculo);
	}
	
	
	
}
