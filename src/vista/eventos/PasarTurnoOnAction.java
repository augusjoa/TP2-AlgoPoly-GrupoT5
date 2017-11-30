package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import modelo.AlgoPoly;
import vista.SectorDado;

public class PasarTurnoOnAction implements EventHandler<ActionEvent> {

	AlgoPoly unAlgoPoly;
	SectorDado sectorDado;
	Button btnPasarTurno;
	
	public PasarTurnoOnAction(AlgoPoly unAlgoPoly, SectorDado sectorDado, Button btnPasarTurno) {
		this.unAlgoPoly = unAlgoPoly;
		this.sectorDado = sectorDado;
		this.btnPasarTurno = btnPasarTurno;

	}

	@Override
	public void handle(ActionEvent event) {
		unAlgoPoly.avanzarTurno();
		unAlgoPoly.getJugadorActual().iniciarTurno();
		if(unAlgoPoly.getJugadorActual().puedeMoverse()) {
			sectorDado.getBotonTirarDado().setDisable(false);
			btnPasarTurno.setDisable(true);
		}
		
		sectorDado.getTextoDados().setText("");
		
	}

}
