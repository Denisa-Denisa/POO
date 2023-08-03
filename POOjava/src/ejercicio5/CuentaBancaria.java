package ejercicio5;

public class CuentaBancaria {
	private CodigoCuentaCliente codigoCuentaCliente;
	private String titular;
	private double saldo;
	
	public CuentaBancaria(CodigoCuentaCliente codigoCuentaCliente, String titular, double saldo) {
		this(codigoCuentaCliente.getEntidadBancaria(),
						codigoCuentaCliente.getOficina(),
						codigoCuentaCliente.getControl(),
						codigoCuentaCliente.getNumeroCuenta(),
						titular, saldo);
	}
	public CuentaBancaria(String entidadBancaria, String oficina, String control, String numeroCuenta, String titular, double saldo) {
		super();
		this.codigoCuentaCliente = new CodigoCuentaCliente(entidadBancaria, oficina, control, numeroCuenta);
		this.titular = titular;
		this.saldo = saldo;
	}
	public CodigoCuentaCliente getCodigoCuentaCliente() {
		return codigoCuentaCliente.clone();
	}
	public void setCodigoCuentaCliente(CodigoCuentaCliente codigoCuentaCliente) {
		this.codigoCuentaCliente = codigoCuentaCliente;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public String getEntidadBancaria() {
		return codigoCuentaCliente.getEntidadBancaria();
	}

	public String getOficina() {
		return codigoCuentaCliente.getOficina();
	}
	
	public String getDigitosControl() {
		return codigoCuentaCliente.getControl();
	}
	
	public String getNumeroCuenta() {
		return codigoCuentaCliente.getNumeroCuenta();
	}
	
	public void retirar(double importe) {
		if (saldo >= importe) {
		   this.saldo -= importe;
		} else {
			System.out.println("No hay saldo suficiente.");
		}
	}
	
	public void ingresar(double importe) {
		if (importe > 0) {
			this.saldo += importe;
		} else {
			System.out.println("El importe debe ser positivo.");
		}
	}
	
	public String toString() {
		return "Titular: " + titular + "\nSaldo: " + saldo + " €\nCuenta: " + codigoCuentaCliente;
	}
}
