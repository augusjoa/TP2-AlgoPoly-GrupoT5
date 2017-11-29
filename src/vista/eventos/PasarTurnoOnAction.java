package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import modelo.AlgoPoly;
import vista.SectorDado;

public class PasarTurnoOnAction implements EventHandler<ActionEvent> {

	AlgoPoly unAlgoPoly;
	SectorDado sectorDado;
	Button unBoton;
	
	public PasarTurnoOnAction(AlgoPoly unAlgoPoly, SectorDado sectorDado, Button esteBoton) {
		this.unAlgoPoly = unAlgoPoly;
		this.sectorDado = sectorDado;
		this.unBoton = esteBoton;
	}

	@Override
	public void handle(ActionEvent event) {
		unAlgoPoly.avanzarTurno();
		sectorDado.getBotonTirarDado().setDisable(false);
		sectorDado.getTextoDados().setText("");
		unBoton.setDisable(true);
		System.out.println(unAlgoPoly.getJugadorActual());
	}

}
