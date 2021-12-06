import java.util.ArrayList;
import java.util.List;
import Dominio.Carta;
import Dominio.Croupier;
import Dominio.Ficha;
import Dominio.Jugador;
import Dominio.Mesa;
import Service.CartaService;

public class principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Creacion del mazo 
		CartaService cartaService = new CartaService();
		
		List<Carta> mazo = cartaService.crearMazo();
		
		for (Carta carta : mazo) {

			System.out.println(carta.getNumero() + " " + carta.getPalo());

		}

		System.out.println("---------------------------------------");
		
		Carta manoJugador = cartaService.pedirCarta();
		
		System.out.println(manoJugador.getNumero());
		
		List<Carta> cartasJugador = new ArrayList<Carta>();
		
		cartasJugador.add(manoJugador);
		
		manoJugador = cartaService.pedirCarta();
		
		cartasJugador.add(manoJugador);
		System.out.println("******************");
		
		for(Carta carta: cartasJugador) {
			System.out.println("---for each");
			System.out.println(carta.getNumero() + " " + carta.getPalo());
			
		}
		
		int puntosJugador = cartaService.sumarCartas(cartasJugador);
		
		System.out.println("sumando puntos " + puntosJugador);
		
		
		/*
		 * 
		 * 	PENSAR LOGICA, YA LO MAS CRUDO ESTA HECHO
		 * 
		 * 
		 */
		
		
		
		
		
		
		
		
		
		//////////////////////////////////////////////////////
		/*
		 * se crean las fichas y se dan el valor al croupier, el jugador, y la mesa en
		 * donde van a jugar las fichas del jugador son 1000, las del croupier 2000
		 */

		// se crean objetos de fichas a futuro crear un Objeto Maquina que cambie plata
		// por cantidad
		/* creacion de los objetos */

		Ficha fichaJugador = new Ficha(1000);
		Ficha fichaCroupier = new Ficha(2000);
		Croupier leandro = new Croupier("leandro", fichaCroupier);
		Jugador pablo = new Jugador("pablo", fichaJugador);
		Mesa mesaBlackjack = new Mesa(1);

		// System.out.println("---------------------------------------");

		// pablo.pedirCartas(mazo);
		// pablo.pedirCartas(mazo);

		// System.out.println(pablo.getMano());

	}

}
