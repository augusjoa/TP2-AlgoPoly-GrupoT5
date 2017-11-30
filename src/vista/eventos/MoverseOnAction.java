package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import modelo.AlgoPoly;
import modelo.Jugador;
import vista.Juego;
import vista.SectorDado;

public class MoverseOnAction implements EventHandler<ActionEvent> {

	Juego juego;
	AlgoPoly unAlgoPoly;
	Button btnMoverse;
	
	public MoverseOnAction(AlgoPoly unAlgoPoly,Juego juego,Button btnMoverse) {
		this.unAlgoPoly = unAlgoPoly;
		this.juego = juego;
		this.btnMoverse = btnMoverse;
		
	}
	
	@Override
	public void handle(ActionEvent event) {
		int numeroDado= unAlgoPoly.getJugadorActual().getNumeroDelDado();
		unAlgoPoly.getJugadorActual().moverse(numeroDado);
		btnMoverse.setDisable(true);
		juego.update();
	}

}
