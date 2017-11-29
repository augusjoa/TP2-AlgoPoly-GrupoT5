package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoPoly;
import vista.SectorDado;

public class PasarTurnoOnAction implements EventHandler<ActionEvent> {

	AlgoPoly unAlgoPoly;
	SectorDado sectorDado;
	
	public PasarTurnoOnAction(AlgoPoly unAlgoPoly, SectorDado sectorDado) {
		this.unAlgoPoly = unAlgoPoly;
		this.sectorDado = sectorDado;
	}

	@Override
	public void handle(ActionEvent event) {
		System.out.println(unAlgoPoly.getJugadorActual());
		unAlgoPoly.avanzarTurno();
		sectorDado.getBotonTirarDado().setDisable(false);
		sectorDado.getTextoDados().setText("");
		System.out.println(unAlgoPoly.getJugadorActual());
		
	}

}
