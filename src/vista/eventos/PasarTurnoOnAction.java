package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import modelo.AlgoPoly;
import vista.SectorDado;

public class PasarTurnoOnAction implements EventHandler<ActionEvent> {

	AlgoPoly unAlgoPoly;
	SectorDado sectorDado;
	Button btnMoverse;
	Label numeroJugador;
	Button btnPasarTurno;
	
	public PasarTurnoOnAction(AlgoPoly unAlgoPoly, SectorDado sectorDado, Button btnPasarTurno,  Label numeroJugador) {
		this.unAlgoPoly = unAlgoPoly;
		this.sectorDado = sectorDado;
		this.numeroJugador = numeroJugador;
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
		actualizarLabelTurno();
		sectorDado.getTextoDados().setText("");

		
	}
	
	private void actualizarLabelTurno(){
		int n= unAlgoPoly.getJugadorActual().getNumeroDelJugador();
		System.out.println("prox jug: "+n);
		numeroJugador.setText("Turno del Jugador: "+ Integer.toString(n));

	}

}
