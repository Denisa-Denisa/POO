package Ejercicio2pdf;

public abstract class Vehiculo {

	static final double IMPUESTO = 0; 
	
	public Vehiculo() {
		super();
	}

	 

	  public abstract double getImpuesto();
		  
	  public String toString() {
		  return this.getClass().getSimpleName();
	  }
	  
                 	 
	
}
