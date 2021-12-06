package Dominio;
public class Jugador {

	private Ficha ficha;
	private String nombre;	
	
	public Jugador(String nombre, Ficha ficha) {
		this.nombre = nombre;
		this.ficha = ficha;
			
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
