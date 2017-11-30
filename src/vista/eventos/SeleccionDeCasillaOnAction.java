package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import modelo.interfaces.Visitable;
import vista.Juego;

public class SeleccionDeCasillaOnAction implements EventHandler<ActionEvent> {

	private Visitable unaCasilla;
	private Juego juego;

	public SeleccionDeCasillaOnAction(Visitable casillero, Juego juego) {
		this.unaCasilla = casillero;
		this.juego = juego;
	}

	@Override
	public void handle(ActionEvent event) {
		//unaCasilla.loadPanelInfo(juego.getPanelInfo());
		VBox elPanel = juego.getPanelInfo();
		//elPanel.setVisible(false);
		elPanel.getChildren().clear();
		unaCasilla.loadPanelInfo(elPanel);
		
		//juego.getPanelInfo().getChildren().add(new Button("test"));
	}

}
