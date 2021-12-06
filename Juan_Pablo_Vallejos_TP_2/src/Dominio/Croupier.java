package Dominio;

public class Croupier {

	private Ficha ficha;
	private String nombre;
	
	public Croupier(String nombre, Ficha ficha) {
		this.ficha = ficha;
		this.nombre = nombre;
	}


	public Ficha getFicha() {
		return ficha;
	}


		
	public void setFicha(Ficha ficha) {
		this.ficha = ficha;
	}


	public String getNombre() {
		return nombre;
	}
	
	
}
