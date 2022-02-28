package Dominio;

public class Mesa {

	private int numero;
	private Croupier croupier;
	private Jugador jugador;
	private int fichasApuesta;
	// setear fichas maxima de apuesta

	public Mesa(int numero) {

		this.numero = numero;

	}

	public int getFichasApuesta() {
		return fichasApuesta;
	}

	public void setFichasApuesta(int fichaApuesta) {
		this.fichasApuesta = fichaApuesta;
	}

	public int getNumero() {
		return numero;
	}

	public Croupier getCroupier() {
		return croupier;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setCroupier(Croupier croupier) {
		this.croupier = croupier;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

}
