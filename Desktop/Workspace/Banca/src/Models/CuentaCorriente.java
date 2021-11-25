package Models;


public class CuentaCorriente {
	//Propiedades
	private int numeroCuenta;
	private double saldo;
	private Persona titular;	
	
	
	//Getters y setters
	public int getNumeroCuenta() {
		return numeroCuenta;
	}


	public double getSaldo() {
		return saldo;
	}


	public Persona getTitular() {
		return titular;
	}
	
	//Constructores

	public CuentaCorriente(int numeroCuenta, double saldo, Persona titular) {
		super();
		this.numeroCuenta = numeroCuenta;
		this.saldo = 0;
		this.titular = titular;
	}

	//Metodos
	
	public void cambiarPersona(Persona titular) {
		this.titular = titular;
	}
	
	public void sumarCantidad(double cantidad) {
		this.saldo += cantidad; 
	}
	
	public void restarCantidad(double cantidad) {
		this.saldo -= cantidad;
	}
	
	
	//toString

	@Override
	public String toString() {
		return "CuentaCorriente [numeroCuenta=" + numeroCuenta + ", saldo=" + saldo + ", titular=" + titular + "]";
	}
	


}
