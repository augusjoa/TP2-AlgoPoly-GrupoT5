package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoPoly;
import vista.Juego;


public class MoverseOnAction implements EventHandler<ActionEvent> {

	Juego juego;
	AlgoPoly unAlgoPoly;

	
	public MoverseOnAction(AlgoPoly unAlgoPoly,Juego juego) {
		this.unAlgoPoly = unAlgoPoly;
		this.juego = juego;

	}
	
	@Override
	public void handle(ActionEvent event) {
		int numeroDado= unAlgoPoly.getJugadorActual().getNumeroDelDado();
		unAlgoPoly.getJugadorActual().moverse(numeroDado);
		juego.update();

	}

}
