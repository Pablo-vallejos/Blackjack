package Dominio;

public class MaquinaDeCambio {

	private double cantidadPlata;
	private double valorDeCambio;

	public MaquinaDeCambio(double cantidadPlata, double valorDeCambio) {

		this.cantidadPlata = cantidadPlata;
		this.valorDeCambio = valorDeCambio;

	}

	public double getCantidadPlata() {
		return cantidadPlata;
	}

	public void setCantidadPlata(double cantidadPlata) {
		this.cantidadPlata = cantidadPlata;
	}

	public double getValorDeCambio() {
		return valorDeCambio;
	}

}
