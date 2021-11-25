package Models;

public class Persona {
	// Propiedades
	private String nombre;
	private String apellidos;
	private String dni;
	private double sueldo;
	private CuentaCorriente cuenta;
	private double saldo;

	// Getters y setters
	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getDni() {
		return dni;
	}

	public double getSueldo() {
		return sueldo;
	}

	public CuentaCorriente getCuenta() {
		return cuenta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setCuenta(CuentaCorriente cuenta) {
		this.cuenta = cuenta;
	}

	// Constructores

	public Persona(String nombre, String apellidos, String dni, double sueldo, CuentaCorriente cuenta) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.sueldo = sueldo;
		this.cuenta = cuenta;

	}

	// Metodos

	public void cambiarSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public void cobrarSueldo() {
		cuenta.sumarCantidad(sueldo);
	}

	public void sacarPasta(double cantidad) {
		if (cantidad < cuenta.getSaldo()) {
			cuenta.restarCantidad(cantidad);
		} else {
			System.out.println("ERROR. Tienes menos dinero del que vas a sacar");
		}
	}

	public void subirSueldo(double nuevoSueldo) {
			this.sueldo += nuevoSueldo;
	}

	// toString

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", saldo=" + cuenta.getSaldo() + ", numeroCuenta=" + cuenta.getNumeroCuenta()
				+ ", sueldo=" + sueldo + "]";
	}
	
	public String seleccionar() {
		return dni + " " + nombre;
	}

}
