package tpProgramacionV2;

import javax.swing.JOptionPane;

import java.util.Random;

public class FinalIntroProgramacion {

	public static void main(String[] args) {

		// blackjack

		int cartas[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
		// jugador
		int carta1Jugador, carta2Jugador, cartaAuxiliarJugador = 0, totalCartasJugador = 0, cartaRandom;
		// maquina
		int carta1Maquina, carta2Maquina, cartaAuxiliarMaquina, totalCartasMaquina = 0;

		int numeroRondas;
		Random carta = new Random();
		String otraCarta;
		int modoJuego;
		int juegoLibre = 0;
		String modoLibre = "";

		int seleccionModo = 0;
		// contadores
		int contadorVictoria = 0, contadorDerrota = 0, contadorEmpate = 0, contadorTotal = 0;

		JOptionPane.showMessageDialog(null, "Bienvenido al Blackjack para empezar a jugar selecciona el modo: "
				+ " JUEGO LIBRE o JUEGO POR RONDAS");

		while (seleccionModo == 0) {
			modoJuego = Integer.parseInt(JOptionPane.showInputDialog("1 para JUEGO LIBRE / 2 para JUEGO POR RONDAS"));

			switch (modoJuego) {

			case 1:
				juegoLibre++;
				seleccionModo++;
				JOptionPane.showMessageDialog(null, "elegiste el modo libre");
				break;
			case 2:
				seleccionModo++;
				JOptionPane.showMessageDialog(null, "elegiste el modo por rondas");
				break;
			default:
				JOptionPane.showMessageDialog(null, "no elegiste ningun modo");
			}

		} // eligo el modo de juego

		if (juegoLibre == 1) {

			while (!modoLibre.equalsIgnoreCase("n")) {
				JOptionPane.showMessageDialog(null, "tus cartas son ");

				cartaRandom = carta.nextInt(cartas.length);
				carta1Jugador = cartas[cartaRandom];
				cartaRandom = carta.nextInt(cartas.length);
				carta2Jugador = cartas[cartaRandom];

				JOptionPane.showMessageDialog(null,
						"la carta 1 es:  " + carta1Jugador + " | la carta 2 es " + carta2Jugador);

				totalCartasJugador = carta1Jugador + carta2Jugador;
				JOptionPane.showMessageDialog(null, "total de la mano " + totalCartasJugador);

				if (totalCartasJugador == 21) {
					JOptionPane.showMessageDialog(null, "BlackJack");

				} else if (totalCartasJugador > 21) {
					JOptionPane.showMessageDialog(null, "perdiste ");

				} else if (totalCartasJugador < 21) {

					otraCarta = JOptionPane.showInputDialog("queres otra carta? S para si || N para no ");

					while ((!otraCarta.equalsIgnoreCase("n"))) {

						cartaRandom = carta.nextInt(cartas.length);
						cartaAuxiliarJugador = cartas[cartaRandom];
						totalCartasJugador = totalCartasJugador + cartaAuxiliarJugador;

						JOptionPane.showMessageDialog(null, "recibiste " + cartaAuxiliarJugador);
						JOptionPane.showMessageDialog(null, " carta 1  " + carta1Jugador + " | carta 2 es "
								+ carta2Jugador + " | la carta auxiliar es " + cartaAuxiliarJugador);
						JOptionPane.showMessageDialog(null, "el total de tus es cartas " + totalCartasJugador);

						if (totalCartasJugador > 21) {

							JOptionPane.showMessageDialog(null, "te pasaste de 21, perdiste");

							otraCarta = "n";

						} else {
							otraCarta = JOptionPane.showInputDialog("queres otra carta? S para si || N para no");
						}

					}

					// turno maquina

					JOptionPane.showMessageDialog(null, "le toca a la maquina ");

					cartaRandom = carta.nextInt(cartas.length);
					carta1Maquina = cartas[cartaRandom];
					cartaRandom = carta.nextInt(cartas.length);
					carta2Maquina = cartas[cartaRandom];

					totalCartasMaquina = carta1Maquina + carta2Maquina;

					JOptionPane.showMessageDialog(null,
							" las cartas de la maquina son " + carta1Maquina + " " + carta2Maquina);
					System.out.println("el total de tus es cartas " + totalCartasJugador);

					if (totalCartasMaquina < 15) {
						cartaRandom = carta.nextInt(cartas.length);
						cartaAuxiliarMaquina = cartas[cartaRandom];
						totalCartasMaquina = totalCartasMaquina + cartaAuxiliarMaquina;

						JOptionPane.showMessageDialog(null, "la maquina recibio " + cartaAuxiliarMaquina);
						JOptionPane.showMessageDialog(null,
								"la carta 1 de la maquina es  " + carta1Maquina + " y la carta 2 de la maquina es "
										+ carta2Maquina + " la carta auxiliar de la maquina es "
										+ cartaAuxiliarMaquina);
						JOptionPane.showMessageDialog(null,
								"el total de las cartas de la maquina es " + totalCartasMaquina);

					} else if (totalCartasMaquina >= 15 && totalCartasMaquina <= 21) {

						JOptionPane.showMessageDialog(null, "la maquina se queda con " + totalCartasMaquina);

					} else {
						JOptionPane.showMessageDialog(null, "la maquina se paso " + totalCartasMaquina);
						JOptionPane.showMessageDialog(null, "el jugador gana ");
					}

				}
				contadorTotal++;

				if (((totalCartasJugador > 21) && (totalCartasMaquina > 21))
						|| (totalCartasJugador == totalCartasMaquina)) {
					contadorEmpate++;
				} else if ((totalCartasJugador > totalCartasMaquina) && totalCartasJugador < 22) {
					contadorVictoria++;
				} else {
					contadorDerrota++;
				}

				modoLibre = JOptionPane.showInputDialog("otra tirada? S para si || N para no");

			}

			// fin modo libre
		} else {
			numeroRondas = Integer.parseInt(JOptionPane.showInputDialog("cuantas rondas queres jugar?"));

			contadorTotal = numeroRondas;

			for (int i = 0; i < numeroRondas; i++) {

				JOptionPane.showMessageDialog(null, "Ronda numero " + (i + 1));

				cartaRandom = carta.nextInt(cartas.length);
				carta1Jugador = cartas[cartaRandom];
				cartaRandom = carta.nextInt(cartas.length);
				carta2Jugador = cartas[cartaRandom];

				JOptionPane.showMessageDialog(null,
						"la carta 1 es:  " + carta1Jugador + " | la carta 2 es " + carta2Jugador);

				totalCartasJugador = carta1Jugador + carta2Jugador;
				JOptionPane.showMessageDialog(null, "total de la mano " + totalCartasJugador);

				if (totalCartasJugador == 21) {
					JOptionPane.showMessageDialog(null, "BlackJack");

				} else if (totalCartasJugador > 21) {
					JOptionPane.showMessageDialog(null, "perdiste ");

				} else if (totalCartasJugador < 21) {

					otraCarta = JOptionPane.showInputDialog("queres otra carta? S para si || N para no ");

					while ((!otraCarta.equalsIgnoreCase("n"))) {

						cartaRandom = carta.nextInt(cartas.length);
						cartaAuxiliarJugador = cartas[cartaRandom];
						totalCartasJugador = totalCartasJugador + cartaAuxiliarJugador;

						JOptionPane.showMessageDialog(null, "recibiste " + cartaAuxiliarJugador);
						JOptionPane.showMessageDialog(null, " carta 1  " + carta1Jugador + " | carta 2 es "
								+ carta2Jugador + " | la carta auxiliar es " + cartaAuxiliarJugador);
						JOptionPane.showMessageDialog(null, "el total de tus es cartas " + totalCartasJugador);

						if (totalCartasJugador > 21) {

							JOptionPane.showMessageDialog(null, "te pasaste de 21, perdiste");

							otraCarta = "n";

						} else {
							otraCarta = JOptionPane.showInputDialog("queres otra carta? S para si || N para no");
						}

					}

					// turno maquina

					JOptionPane.showMessageDialog(null, "le toca a la maquina ");

					cartaRandom = carta.nextInt(cartas.length);
					carta1Maquina = cartas[cartaRandom];
					cartaRandom = carta.nextInt(cartas.length);
					carta2Maquina = cartas[cartaRandom];

					totalCartasMaquina = carta1Maquina + carta2Maquina;

					JOptionPane.showMessageDialog(null,
							" las cartas de la maquina son " + carta1Maquina + " " + carta2Maquina);
					System.out.println("el total de tus es cartas " + totalCartasJugador);

					if (totalCartasMaquina < 15) {
						cartaRandom = carta.nextInt(cartas.length);
						cartaAuxiliarMaquina = cartas[cartaRandom];
						totalCartasMaquina = totalCartasMaquina + cartaAuxiliarMaquina;

						JOptionPane.showMessageDialog(null, "la maquina recibio " + cartaAuxiliarMaquina);
						JOptionPane.showMessageDialog(null,
								"la carta 1 de la maquina es  " + carta1Maquina + " y la carta 2 de la maquina es "
										+ carta2Maquina + " la carta auxiliar de la maquina es "
										+ cartaAuxiliarMaquina);
						JOptionPane.showMessageDialog(null,
								"el total de las cartas de la maquina es " + totalCartasMaquina);

					} else if (totalCartasMaquina >= 15 && totalCartasMaquina <= 21) {

						JOptionPane.showMessageDialog(null, "la maquina se queda con " + totalCartasMaquina);

					} else {
						JOptionPane.showMessageDialog(null, "la maquina se paso " + totalCartasMaquina);
						JOptionPane.showMessageDialog(null, "el jugador gana ");
					}

				}
				if (((totalCartasJugador > 21) && (totalCartasMaquina > 21))
						|| (totalCartasJugador == totalCartasMaquina)) {
					contadorEmpate++;
				} else if ((totalCartasJugador > totalCartasMaquina) && totalCartasJugador < 22) {
					contadorVictoria++;
				} else {
					contadorDerrota++;
				}

			}

		} // fin de rondas

		// Contadores
		JOptionPane.showMessageDialog(null, "Ganaste " + contadorVictoria + " de " + contadorTotal);
		JOptionPane.showMessageDialog(null, "Empataste " + contadorEmpate + " de " + contadorTotal);
		JOptionPane.showMessageDialog(null, "perdiste " + contadorDerrota + " de " + contadorTotal);// fin progremaa

	}

}
