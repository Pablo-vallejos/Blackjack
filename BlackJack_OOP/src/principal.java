import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Dominio.Carta;
import Dominio.Croupier;
import Dominio.Ficha;
import Dominio.Jugador;
import Dominio.MaquinaDeCambio;
import Dominio.Mesa;
import Service.CartaService;
import Service.FichaService;
import Service.MaquinaDeCambioService;

public class principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

/////////////// CREAN LOS SERVICES//////////////
		CartaService cartaService = new CartaService();
		FichaService fichaService = new FichaService();
		MaquinaDeCambioService maquinaDeCambioService = new MaquinaDeCambioService();

		// Creacion del mazo
		List<Carta> mazo = cartaService.crearMazo();

		for (Carta carta : mazo) {

			System.out.println(carta.getNumero() + " " + carta.getPalo());

		}

		////////////////////////////////////////////////
		// Variables
		////////////////////////////////////////////////

		int puntosJugador = 0;
		int puntosCroupier = 0;
		int decisionJugador = 0;
		int apuestaFichas;
		int decisionApostar;
		double plataJugadorFinal = 0;
		int plataJugadorInicial;
		int valorCambio = 1;

		///////////////////////////////////////////////
		// Creacion del jugador, croupier, mesa y fichas
		///////////////////////////////////////////////

		Jugador pablo = new Jugador("pablo");
		Croupier leandro = new Croupier("leandro");
		Mesa mesaBlackjack = new Mesa(1);
		MaquinaDeCambio maquinaDeCambio = new MaquinaDeCambio(10000, valorCambio);

		System.out.println("-------------------------------------------------- \n"
				+ "----------------Empieza el juego------------------ \n"
				+ "-------------------------------------------------- ");

		//////////////////////////////////////////////////////////////////////////
		mesaBlackjack.setCroupier(leandro);
		mesaBlackjack.setJugador(pablo);

		System.out.println("-------------------------------------------------- ");

		System.out.println("El valor de Cambio es " + valorCambio);

		plataJugadorInicial = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la plata inicial del jugador"));

		maquinaDeCambioService.cambiarPlataXFichas(plataJugadorInicial, plataJugadorInicial);
		Ficha fichasJugador = new Ficha(maquinaDeCambioService.cambiarPlataXFichas(plataJugadorInicial, valorCambio));
		Ficha fichasCroupier = new Ficha(fichasJugador.getCantidad());

		System.out.println("Recibiste " + fichasJugador.getCantidad());

		decisionApostar = Integer.parseInt(JOptionPane.showInputDialog("Queres apostar? \n " + "1 >> SI \n 2 >> NO "));

		while (decisionApostar != 2) {

			apuestaFichas = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la cantidad de fichas a apostar"));

			if (apuestaFichas <= fichasJugador.getCantidad()) {

				fichasJugador.setApuesta(apuestaFichas);
				System.out.println("El jugador apuesta " + fichasJugador.getApuesta());

				fichasJugador.setCantidad(
						fichaService.apostarFichasJugador(fichasJugador.getCantidad(), fichasJugador.getApuesta()));
				System.out.println("Al jugador le quedan " + fichasJugador.getCantidad());

				// el croupier iguala la apuesta
				fichasCroupier.setApuesta(apuestaFichas);
				System.out.println("El Croupier apuesta " + fichasCroupier.getApuesta());

				fichasCroupier.setCantidad(
						fichaService.apostarFichasCroupier(fichasCroupier.getCantidad(), fichasCroupier.getApuesta()));
				System.out.println("Al Croupier le quedan " + fichasCroupier.getCantidad());

				////////////////////
				// juega el jugador
				///////////////////

				List<Carta> cartasJugador = new ArrayList<Carta>();

				Carta manoJugador = cartaService.pedirCarta();
				cartasJugador.add(manoJugador);
				manoJugador = cartaService.pedirCarta();
				cartasJugador.add(manoJugador);

				System.out.println("Las cartas del jugador son: ");

				for (Carta carta : cartasJugador) {
					System.out.println(carta.getNumero() + " " + carta.getPalo());

				}

				puntosJugador = cartaService.sumarCartas(cartasJugador);

				System.out.println("Los puntos del jugador son: " + puntosJugador);

				System.out.println("----------------------------------------------------");

				if (puntosJugador > 21) {

					fichasCroupier.setCantidad(fichasCroupier.getCantidad()
							+ fichaService.ganarApuesta(fichasJugador.getApuesta(), fichasCroupier.getApuesta()));

					System.out.println("Perdiste tus cartas dan mas de 21 " + leandro.getNombre() + " total de fichas "
							+ fichasCroupier.getCantidad());

					System.out.println("----------------------------------------------------");

				} else if (puntosJugador == 21) {

					fichasJugador.setCantidad(fichasJugador.getCantidad()
							+ fichaService.ganarApuesta(fichasJugador.getApuesta(), fichasCroupier.getApuesta()));

					System.out.println("BLACKJACK!!!!!! \n total de fichas " + fichasJugador.getCantidad());

					System.out.println("----------------------------------------------------");

				} else {

					decisionJugador = Integer.parseInt(JOptionPane
							.showInputDialog("Que deseas hacer? \n " + "1 >> pedir cartas \n 2 >> dejar de pedir "));

					while (decisionJugador != 2) {

						if (decisionJugador == 1) {

							////////////////////////

							// BUG ACA

							///////////////////////////////////

							manoJugador = cartaService.pedirCarta();
							cartasJugador.add(manoJugador);
							System.out.println("recibiste " + manoJugador.getNumero() + " " + manoJugador.getPalo());

							System.out.println("Las cartas del jugador son: ");

							for (Carta carta : cartasJugador) {
								System.out.println(carta.getNumero() + " " + carta.getPalo());

							}
							puntosJugador = cartaService.sumarCartas(cartasJugador);

							System.out.println("dejaste de pedir cartas, tus puntos son: " + puntosJugador);

							System.out.println("----------------------------------------------------");

							if (puntosJugador > 21) {

								System.out.println(" PERDISTE \n te pasaste de 21 ");

								fichasCroupier.setCantidad(fichasCroupier.getCantidad() + fichaService
										.ganarApuesta(fichasJugador.getApuesta(), fichasCroupier.getApuesta()));

								System.out.println("Perdiste tus cartas dan mas de 21 " + leandro.getNombre()
										+ " total de fichas " + fichasCroupier.getCantidad());

								decisionJugador = 2;
							} else {
								decisionJugador = Integer.parseInt(JOptionPane.showInputDialog(
										"Que deseas hacer? \n " + "1 >> pedir cartas \n 2 >> dejar de pedir "));

							}

						} else if (decisionJugador == 2) {

							for (Carta carta : cartasJugador) {
								System.out.println(carta.getNumero() + " " + carta.getPalo());

							}
							puntosJugador = cartaService.sumarCartas(cartasJugador);

							System.out.println("Los puntos del jugador son: " + puntosJugador);

							decisionJugador = 2;

						} else {

							decisionJugador = Integer.parseInt(JOptionPane.showInputDialog(
									"Que deseas hacer? \n " + "1 >> pedir cartas \n 2 >> dejar de pedir"));

						}
					}
					// juega cropuier

					if (puntosJugador < 22) {

						List<Carta> cartasCroupier = new ArrayList<Carta>();
						Carta manoCroupier = cartaService.pedirCarta();
						cartasCroupier.add(manoCroupier);
						manoCroupier = cartaService.pedirCarta();
						cartasCroupier.add(manoCroupier);

						puntosCroupier = cartaService.sumarCartas(cartasCroupier);

						System.out.println("Los puntos del croupier son: " + puntosCroupier);

						//////////////////////////////////////////////////////

						if (puntosCroupier <= 15) {
							manoCroupier = cartaService.pedirCarta();
							cartasCroupier.add(manoCroupier);

							System.out.println("Las cartas del croupier son: ");

							for (Carta carta : cartasCroupier) {
								System.out.println(carta.getNumero() + " " + carta.getPalo());

							}
							puntosCroupier = cartaService.sumarCartas(cartasCroupier);

							System.out.println("Los puntos del croupier son: " + puntosCroupier);

							System.out.println("-------------------------------------------------");

						} else if (puntosCroupier > 16 && puntosCroupier <= 21) {

							cartaService.sumarCartas(cartasCroupier);

							System.out.println("Las cartas del croupier son: ");

							for (Carta carta : cartasCroupier) {
								System.out.println(carta.getNumero() + " " + carta.getPalo());

							}
							puntosCroupier = cartaService.sumarCartas(cartasCroupier);

							System.out.println("Los puntos del croupier son: " + puntosCroupier);

							System.out.println("-------------------------------------------------");

						} else {

							fichasJugador.setCantidad(fichasJugador.getCantidad() + fichaService
									.ganarApuesta(fichasJugador.getApuesta(), fichasCroupier.getApuesta()));

							System.out.println("Gana el jugador " + pablo.getNombre()
									+ " la cantidad de fichas totales son:\n " + fichasJugador.getCantidad());

							System.out.println("-------------------------------------------------");

						}

					}

					if (puntosJugador >= puntosCroupier && puntosJugador < 22) {

						fichasJugador.setCantidad(fichasJugador.getCantidad()
								+ fichaService.ganarApuesta(fichasJugador.getApuesta(), fichasCroupier.getApuesta()));

						System.out.println("Gana el jugador " + pablo.getNombre()
								+ " la cantidad de fichas totales son:\n " + fichasJugador.getCantidad());

						System.out.println("-------------------------------------------------");

					}

					if (puntosJugador < puntosCroupier && puntosCroupier < 22) {

						fichasCroupier.setCantidad(fichasCroupier.getCantidad()
								+ fichaService.ganarApuesta(fichasJugador.getApuesta(), fichasCroupier.getApuesta()));

						System.out.println("Gana el Croupier " + leandro.getNombre()
								+ " la cantidad de fichas totales son:\n " + fichasCroupier.getCantidad());

						System.out.println("-------------------------------------------------");

					}

				}

			} else {

				System.out.println("La apuesta es mayor a la cantidad de fichas");
			}

			decisionApostar = Integer
					.parseInt(JOptionPane.showInputDialog("Queres apostar? \n " + "1 >> SI \n 2 >> NO "));
		}

		System.out.println("Antes de irte cambia las fichas por plata ");

		plataJugadorFinal = maquinaDeCambioService.cambiarPlataXFichas(fichasJugador.getCantidad(), 1);

		maquinaDeCambio.setCantidadPlata(maquinaDeCambio.getCantidadPlata() - plataJugadorFinal);

		System.out.println("A la maquina le queda " + maquinaDeCambio.getCantidadPlata());

		System.out.println("El jugador se fue con $" + plataJugadorFinal);
	}

}
