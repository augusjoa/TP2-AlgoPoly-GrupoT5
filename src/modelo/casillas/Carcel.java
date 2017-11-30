package modelo.casillas;


import modelo.Dinero;
import modelo.Jugador;
import modelo.interfaces.Visitable;

public class Carcel implements Visitable{
	private Dinero valorDeLaFianza = new Dinero(45000);
	private String nombre = "Carcel";
	

	public void cobrarFianza(Jugador jugador){
			jugador.getDinero().sustraerDinero(valorDeLaFianza);
			jugador.liberar();

	}
	
	public int getValorDeLaFianza(){
		return valorDeLaFianza.getValor();
	}
	
	@Override
	public String getNombre(){
		return nombre;
	}
	
	@Override
	public void esVisitadoPorJugador(Jugador jugador) {
		jugador.encarcelar();
	}
	
}
