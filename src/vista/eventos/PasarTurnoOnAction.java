package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import modelo.AlgoPoly;
import vista.Juego;
import vista.SectorDado;

public class PasarTurnoOnAction implements EventHandler<ActionEvent> {

	AlgoPoly partida;
	Juego juego;
	SectorDado sectorDado;
	Button btnPasarTurno;
	Label numeroJugador;
	Label dineroDelJugador;
	Button botonPagarFianza;
	
	public PasarTurnoOnAction(Juego juego, SectorDado sectorDado, Button btnPasarTurno,  Label numeroJugador, Label dineroDelJugador, Button botonPagarFianza) {
		this.juego= juego;
		this.partida = juego.partida();
		this.sectorDado = sectorDado;
		this.numeroJugador = numeroJugador;
		this.btnPasarTurno = btnPasarTurno;
		this.dineroDelJugador = dineroDelJugador;
		this.juego=juego;
		this.botonPagarFianza=botonPagarFianza;
	}

	@Override
	public void handle(ActionEvent event) {
		partida.avanzarTurno();
		partida.getJugadorActual().iniciarTurno();
		if(partida.getJugadorActual().puedeMoverse()) {
			sectorDado.getBotonTirarDado().setDisable(false);
			btnPasarTurno.setDisable(true);
			botonPagarFianza.setDisable(true);
		}
		else if(!partida.getJugadorActual().puedeMoverse()){
			botonPagarFianza.setDisable(false);
			juego.update();
		}
		juego.updateVista();
	}
	

}
