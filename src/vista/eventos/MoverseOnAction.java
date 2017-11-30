package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoPoly;
import modelo.Jugador;
import vista.Juego;
import vista.SectorDado;

public class MoverseOnAction implements EventHandler<ActionEvent> {

	Juego juego;
	AlgoPoly unAlgoPoly;
	//Jugador jugadorActual;
	
	public MoverseOnAction(AlgoPoly unAlgoPoly,Juego juego) {
		this.unAlgoPoly = unAlgoPoly;
		this.juego = juego;
		//jugadorActual= unAlgoPoly.getJugadorActual();
	}
	
	@Override
	public void handle(ActionEvent event) {
		int numeroDado= unAlgoPoly.getJugadorActual().getNumeroDelDado();
		unAlgoPoly.getJugadorActual().moverse(numeroDado);
		
		//juego.update();
	}

}
