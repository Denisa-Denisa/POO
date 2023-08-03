package ejercicio5;

public class Ejercicio5 {
/*
 Crea una clase para modelar una cuenta bancaria. 
 Esta tendr� asociada un 
 	- C�digo Cuenta Cliente (CCC), 
 	- un titular y 
 	- un saldo. 
 El CCC est� formado por 20 d�gitos, de los cuales, 
 	- 4 d�gitos representan la entidad bancaria, 
 	- otros 4 d�gitos para la oficina, 
 	- 2 d�gitos de control y 
 	- 10 para el n�mero de cuenta. Se debe poder retirar o ingresar efectivo.
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
