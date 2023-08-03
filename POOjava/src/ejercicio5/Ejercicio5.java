package ejercicio5;

public class Ejercicio5 {
/*
 Crea una clase para modelar una cuenta bancaria. 
 Esta tendrá asociada un 
 	- Código Cuenta Cliente (CCC), 
 	- un titular y 
 	- un saldo. 
 El CCC está formado por 20 dígitos, de los cuales, 
 	- 4 dígitos representan la entidad bancaria, 
 	- otros 4 dígitos para la oficina, 
 	- 2 dígitos de control y 
 	- 10 para el número de cuenta. Se debe poder retirar o ingresar efectivo.
 */
	public static void main(String[] args) {
		CuentaBancaria cuenta = new CuentaBancaria(
				new CodigoCuentaCliente("1111", "1111", "22", "1234567890"), 
				"Pepe", 
				1000);
				
		System.out.println(cuenta);
		cuenta.retirar(50);
		System.out.println(cuenta);
		cuenta.ingresar(-50);
		cuenta.ingresar(550);
		System.out.println(cuenta);
		cuenta.retirar(3000);
		System.out.println(cuenta);
	}

}
