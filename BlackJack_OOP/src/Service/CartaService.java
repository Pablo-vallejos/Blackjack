package Service;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

import Dominio.Carta;

public class CartaService {
	// probar con armar el mazo aca

	private List<Carta> mazo = new ArrayList<Carta>();

	public List<Carta> crearMazo() {
		String[] palos = { "pica", "corazones", "rombos", "treboles" };

		for (int i = 1; i < 14; i++) {
			for (int j = 0; j < palos.length; j++) {
				mazo.add(new Carta(i, palos[j]));
			}

		}		
		Collections.shuffle(mazo);
		Collections.shuffle(mazo);
		Collections.shuffle(mazo);
		Collections.shuffle(mazo);
		Collections.shuffle(mazo);
		Collections.shuffle(mazo);		
		
		return mazo;

	}

	public Carta pedirCarta() {

		Random rnd = new Random();

		int indiceCartaDelMazo = rnd.nextInt(mazo.size());

		Carta carta = mazo.get(indiceCartaDelMazo);

		mazo.remove(indiceCartaDelMazo);

		return carta;

	}

	public int sumarCartas(List<Carta> cartasJugador) {

		int puntos = 0;

		for (Carta carta : cartasJugador) {

			puntos = puntos + carta.getNumero();

			// System.out.println(carta.getNumero() + " " + carta.getPalo());

		}
		return puntos;

	}

}
