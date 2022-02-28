package Dominio;

public class Ficha {

	/*
	 * las apuestas de las fichas van a jugarse desde este objeto ver fichaService
	 * 
	 */
	
	private int cantidad;
	private int apuesta;

	public Ficha( int cantidad) {
		
		this.cantidad = cantidad;

		
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getApuesta() {
		return apuesta;
	}

	public void setApuesta(int apuesta) {
		this.apuesta = apuesta;
	}
	
	

}
