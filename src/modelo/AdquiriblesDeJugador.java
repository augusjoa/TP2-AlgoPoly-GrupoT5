package modelo;

import java.util.Collection;
import java.util.HashSet;

import modelo.casillas.Barrio;


public class AdquiriblesDeJugador {
	//Se tendria que agregar servicios aca
	private Collection <Barrio> barrios = new HashSet<Barrio>();
	

	public void comprar(Barrio unbarrio) {
		this.barrios.add(unbarrio);
	}
	
	public int getCantidadTotalDeAdquiribles() {
		int total = this.barrios.size();
		for (Barrio i : this.barrios ) { 
			total += i.getCantidadDeEdificios();	
		}
		return total;
	}
	
	
}
