package Service;

import Dominio.Ficha;

public class FichaService {
	
	/*
	 * en vez de que entren los objetos desde los jugadores van a entrar las Fichas firectamente  
	 * y despues el Jugador y Croupier van a tener un metodo para saber las fichas
	 *  o talvez se van a ver desde los mismos objetos
	 * de las fichas 
	 * 
	 */
	
//	public Ficha apostarFichasJugador(Ficha fichaJugador, int fichaJugadorApuesta) {
//
//		int fichasTotalJugador = (Integer) fichaJugador.getCantidad() - fichaJugadorApuesta;
//
//		fichaJugador.setCantidad(fichasTotalJugador);
//
//		return fichaJugador;
//
//	}
//
//	public Ficha apostarFichasCroupier(Ficha fichaCroupier, int fichaCroupierApuesta) {
//
//		int fichasTotalCroupier = (Integer) fichaCroupier.getCantidad() - fichaCroupierApuesta;
//
//		fichaCroupier.setCantidad(fichasTotalCroupier);
//
//		return fichaCroupier;
//
//	}
//
//	public Ficha ganarApuestaJugador(Ficha fichaJugador, int fichaJugadorApuesta, Ficha fichaCroupier,
//			int fichaCroupierApuesta) {
//		
//		int apuestaTotal = 0;
//		
//		apuestaTotal = fichaJugadorApuesta + fichaCroupierApuesta;
//		
//		int apuestaGanada = (Integer)fichaJugador.getCantidad() + apuestaTotal;
//		int apuestaPerdida = (Integer)fichaCroupier.getCantidad() - apuestaTotal;
//		
//		fichaJugador.setCantidad(apuestaGanada);
//		fichaCroupier.setCantidad(apuestaPerdida);
//				
//		return fichaJugador;	
//		
//	}
//	
//	public Ficha ganarApuestaCroupier(Ficha fichaJugador, int fichaJugadorApuesta, Ficha fichaCroupier,
//			int fichaCroupierApuesta) {
//		
//		int apuestaTotal = 0;
//		
//		apuestaTotal = fichaJugadorApuesta + fichaCroupierApuesta;
//		
//		int apuestaGanada = (Integer)fichaCroupier.getCantidad() + apuestaTotal;
//		int apuestaPerdida = (Integer)fichaJugador.getCantidad() - apuestaTotal;
//		
//		fichaCroupier.setCantidad(apuestaGanada);
//		fichaJugador.setCantidad(apuestaPerdida);
//		
//		return fichaCroupier;	
//		
//	}
//
//	
	
	public int apostarFichasJugador(int fichasJugador, int fichasJugadorApuesta) {
		
		int fichasJugadorTotal = 0;
		
		fichasJugadorTotal = fichasJugador - fichasJugadorApuesta;
		
		return fichasJugadorTotal;
		
	}
	
	public int apostarFichasCroupier(int fichasCroupier, int fichasCroupierApuesta) {
		
		int fichasCroupierTotal = 0;
		
		fichasCroupierTotal = fichasCroupier - fichasCroupierApuesta;
		
		return fichasCroupierTotal;
		
	}
	
	
	public int ganarApuesta(int fichasJugadorApostadas, int fichasCroupierApostadas) {
	
		int fichasGanadas = 0;
		
		fichasGanadas = fichasJugadorApostadas + fichasCroupierApostadas;
		
		return fichasGanadas;		
		
		
	}
	
	
	
	
	
	
	
	
}
