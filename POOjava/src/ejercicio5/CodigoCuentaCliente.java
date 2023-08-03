package ejercicio5;

public class CodigoCuentaCliente {
	private String entidadBancaria;
	private String oficina;
	private String control;
	private String numeroCuenta;

	public CodigoCuentaCliente(String entidadBancaria, String oficina, String control, String numeroCuenta) {
		super();
		this.setEntidadBancaria(entidadBancaria);
		this.oficina = oficina;
		this.control = control;
		this.numeroCuenta = numeroCuenta;
	}

	public String getEntidadBancaria() {
		return entidadBancaria;
	}

	public void setEntidadBancaria(String entidadBancaria) {
		if (entidadBancaria.length() == 4) {
			this.entidadBancaria = entidadBancaria;
		} else {
			System.out.println("La entidad bancaria no es valida. Se requiere 4 digitos.");
		}
	}

	public String getOficina() {
		return oficina;
	}

	public void setOficina(String oficina) {
		this.oficina = oficina;
	}

	public String getControl() {
		return control;
	}

	public void setControl(String control) {
		this.control = control;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public CodigoCuentaCliente clone() {
		return new CodigoCuentaCliente(this.entidadBancaria, this.oficina, this.control, this.numeroCuenta);
	}

	public String toString() {
		return entidadBancaria + " " + oficina + " " + control + " " + numeroCuenta;
	}
}
