package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import modelo.AlgoPoly;
import vista.Juego;
import vista.PanelJugador;
import vista.SectorDado;

public class PasarTurnoOnAction implements EventHandler<ActionEvent> {

	private Button botonCompra;
	private AlgoPoly partida;
	private Juego juego;
	private SectorDado sectorDado;
	private Button btnPasarTurno;
	private Button botonPagarFianza;
	
	public PasarTurnoOnAction(Juego juego, SectorDado sectorDado, Button btnPasarTurno, PanelJugador panelJugador) {
		this.juego= juego;
		this.partida = juego.partida();
		this.sectorDado = sectorDado;
		this.btnPasarTurno = btnPasarTurno;
		this.juego=juego;
		this.botonCompra = panelJugador.getBotonCompra();
		this.botonPagarFianza=panelJugador.getBotonPagarFianza();
	}

	@Override
	public void handle(ActionEvent event) {
		partida.avanzarTurno();
		if(partida.getJugadorActual().puedeMoverse()) {
			sectorDado.getBotonTirarDado().setDisable(false);
			btnPasarTurno.setDisable(true);
			botonPagarFianza.setDisable(true);
		}else{
			botonPagarFianza.setDisable(false);
			juego.update();
		}
		botonCompra.setDisable(true);
		juego.updateVistaSuperior();
	}
	
}
