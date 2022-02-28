package Service;

public class MaquinaDeCambioService {

	
	public int cambiarPlataXFichas(int fichas,int valorCambio) {
		
		
		int fichasTotal = 0;
		
		fichasTotal = fichas / valorCambio;
		
		
		
		return fichasTotal;
		
	}
	
	public double cambiarFichasXPlata(int plata, double valorCambio) {
		
		
		double plataTotal = 0;
		
		plataTotal = plata * valorCambio;
		
		return plataTotal;
		
	}
	
	
	
}
